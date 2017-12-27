package cn.lxy.action;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat/{userId}") // ��ע������ָ��һ��URI���ͻ��˿���ͨ�����URI�����ӵ�WebSocket������Servlet��ע��mapping��������web.xml�����á�
public class ChatAnnotation {
    // �������ÿ���ͻ��˶�Ӧ��ChatAnnotation����ʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ���ʹ��Map����ţ�����Key����Ϊ�û���ʶ��hashtable��hashmap�̰߳�ȫ
    private static Map<String, ChatAnnotation> webSocketMap = new Hashtable<String, ChatAnnotation>();
    // ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
    private Session session;

    /**
     * ���ӽ����ɹ����õķ���
     * 
     * @param session
     *            ��ѡ�Ĳ�����sessionΪ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
     */
    @OnOpen
    public void onOpen(@PathParam(value="userId") String userId, Session session) {
        this.session = session;
        webSocketMap.put(userId, this);//����map��
        System.out.println(userId+"---���Ӽ��룡��ǰ��������Ϊ" + getOnlineCount());
    }

    /**
     * ���ӹرյ��õķ���
     */
    @OnClose
    public void onClose(@PathParam(value="userId") String userId) {
        webSocketMap.remove(userId);
        System.out.println(userId+"�ر����ӣ���ǰ��������Ϊ" + getOnlineCount());
    }

    /**
     * �յ��ͻ�����Ϣ����õķ���
     * 
     * @param message
     *            �ͻ��˷��͹�������Ϣ
     * @param session
     *            ��ѡ�Ĳ���
     */
    @OnMessage
    public void onMessage(@PathParam(value="userId") String userId, String message, Session session) {
        System.out.println("���Կͻ���---------"+userId+"����Ϣ:" + message);
        // Ⱥ����Ϣ
        for (Map.Entry<String, ChatAnnotation> entry : webSocketMap.entrySet()) {
            ChatAnnotation item = entry.getValue();
            try {
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
        System.out.println(userId+"��������");
        error.printStackTrace();
    }

    /**
     * ������������漸��������һ����û����ע�⣬�Ǹ����Լ���Ҫ��ӵķ�����
     * 
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        // this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return webSocketMap.size();
    }
}
