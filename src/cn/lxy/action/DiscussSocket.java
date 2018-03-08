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

@ServerEndpoint("/discuss/{userId}") //��ע������ָ��һ��URI���ͻ��˿���ͨ�����URI�����ӵ�WebSocket������Servlet��ע��mapping��������web.xml�����á�
public class DiscussSocket {
    // �������ÿ���ͻ��˶�Ӧ��ChatAnnotation����ʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ���ʹ��Map����ţ�����Key����Ϊ�û���ʶ��hashtable��hashmap�̰߳�ȫ
    private static Map<String, DiscussSocket> webSocketMap = new Hashtable<String, DiscussSocket>();
    // ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
    private Session session;
	private GetDateAndTime getDateAndTime = new GetDateAndTime();
    /**
     * ���ӽ����ɹ����õķ��� 
     * @param session
     * ��ѡ�Ĳ�����sessionΪ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
     */
    @OnOpen
    public void onOpen(@PathParam(value="userId") String userId, Session session) {
    	//
        this.session = session;
        webSocketMap.put(userId, this);//����map��
        System.out.println(userId+"���Ӽ��룡��ǰ��������Ϊ" + getOnlineCount());
    }

    /**
     * ���ӹرյ��õķ���
     */
    @OnClose
    public void onClose(@PathParam(value="userId") String userId) {
    	//
    }
    /**
     * �յ��ͻ�����Ϣ����õķ���
     * 
     * @param message
     *            �ͻ��˷��͹�������Ϣ
     * @param session
     *            ��ѡ�Ĳ���
     * @throws Exception 
     */
    @OnMessage
    public void onMessage(@PathParam(value="userId") String userId, String message, Session session) throws Exception {
//        System.out.println("���Կͻ���---------"+userId+"����Ϣ:" + message);
        // Ⱥ����Ϣ
        String[] infos = message.split("-");//�γ�id-ѧ��id-�������� 
        String time = "";
        Connection conn = null;
        try {
            //�½�QueryRunner����
            QueryRunner qr = new QueryRunner();
            //ִ�е�Sql���
            String sql = "insert into Discuss (course_id,student_id,time,content) values (?,?,?,?)";
            //����������ʹ��Object���飬Ҳ����ֱ��д
            time = getDateAndTime.getNowTime();
            Object[] params = {infos[0],infos[1],time,infos[2]};
            //ִ��Update��������Ӱ��ļ�¼
            conn = ConnectDb.Connect();
            qr.update(conn,sql, params);
            conn.close();
        } catch (SQLException ex) {
        	conn.close();
        }
        for (Map.Entry<String, DiscussSocket> entry : webSocketMap.entrySet()) {
            DiscussSocket item = entry.getValue();
            try {
            	message = infos[3] + "-" + infos[4] + "-" + time + "-" + infos[2] + "-" + infos[1] + "-" + infos[0];//message:ѧ������-ѧ��ͷ��url-����ʱ��-��������
                item.sendMessage(message);              
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * ��������ʱ����
     * 
     * @param session
     * @param error
     */
    @OnError
    public void onError(@PathParam(value="userId") String userId, Session session, Throwable error) {
    	;
    }

    /**
     * ������������漸��������һ����û����ע�⣬�Ǹ����Լ���Ҫ��ӵķ�����
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
