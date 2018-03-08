package cn.lxy.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.dbutils.QueryRunner;

import cn.lxy.po.Course;
import cn.lxy.po.Discuss;
import cn.lxy.po.Student;
import cn.lxy.utils.ConnectDb;
import cn.lxy.utils.GetDateAndTime;

@ServerEndpoint("/discuss/{userId}") //该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。类似Servlet的注解mapping。无需在web.xml中配置。
public class DiscussSocket {
    // 用来存放每个客户端对应的ChatAnnotation对象，实现服务端与单一客户端通信的话，使用Map来存放，其中Key可以为用户标识，hashtable比hashmap线程安全
    private static Map<String, DiscussSocket> webSocketMap = new Hashtable<String, DiscussSocket>();
    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
	private GetDateAndTime getDateAndTime = new GetDateAndTime();
    /**
     * 连接建立成功调用的方法 
     * @param session
     * 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam(value="userId") String userId, Session session) {
    	//
        this.session = session;
        webSocketMap.put(userId, this);//加入map中
        System.out.println(userId+"连接加入！当前在线人数为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam(value="userId") String userId) {
    	//
    }
    /**
     * 收到客户端消息后调用的方法
     * 
     * @param message
     *            客户端发送过来的消息
     * @param session
     *            可选的参数
     * @throws Exception 
     */
    @OnMessage
    public void onMessage(@PathParam(value="userId") String userId, String message, Session session) throws Exception {
//        System.out.println("来自客户端---------"+userId+"的消息:" + message);
        // 群发消息
        String[] infos = message.split("-");//课程id-学生id-讨论内容 
        String time = "";
        Connection conn = null;
        try {
            //新建QueryRunner对象
            QueryRunner qr = new QueryRunner();
            //执行的Sql语句
            String sql = "insert into Discuss (course_id,student_id,time,content) values (?,?,?,?)";
            //参数，可以使用Object数组，也可以直接写
            time = getDateAndTime.getNowTime();
            Object[] params = {infos[0],infos[1],time,infos[2]};
            //执行Update，返回受影响的记录
            conn = ConnectDb.Connect();
            qr.update(conn,sql, params);
            conn.close();
        } catch (SQLException ex) {
        	conn.close();
        }
        for (Map.Entry<String, DiscussSocket> entry : webSocketMap.entrySet()) {
            DiscussSocket item = entry.getValue();
            try {
            	message = infos[3] + "-" + infos[4] + "-" + time + "-" + infos[2] + "-" + infos[1] + "-" + infos[0];//message:学生姓名-学生头像url-评论时间-评论内容
                item.sendMessage(message);              
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 发生错误时调用
     * 
     * @param session
     * @param error
     */
    @OnError
    public void onError(@PathParam(value="userId") String userId, Session session, Throwable error) {
    	;
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * 
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
    public static synchronized int getOnlineCount() {
        return webSocketMap.size();
    }
    
}
