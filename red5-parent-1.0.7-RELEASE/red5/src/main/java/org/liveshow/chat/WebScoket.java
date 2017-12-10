package org.liveshow.chat;

/**
 * Created by Cjn on 2017/11/27.
 */

import org.liveshow.chat.content.GetHttpSessionConfigurator;
import org.liveshow.service.resolver.ResolverFactory;
import org.liveshow.surveillant.RoomPopularity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/WebScoket/{roomId}" , configurator = GetHttpSessionConfigurator.class)
public class WebScoket {
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的danmakuChat对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<WebScoket> webSocketSet = new CopyOnWriteArraySet<WebScoket>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //标识
    private int roomId;
    
    private HttpSession httpSession;
    @Autowired
    private ResolverFactory resolverFactory;
    
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebScoket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebScoket.onlineCount--;
    }

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam("roomId") int roomId , Session session,EndpointConfig config){
        this.session = session;
        this.roomId = roomId;
        this.httpSession =(HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount() + "roomId:" + roomId);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        RoomPopularity roomPopularity = RoomPopularity.getInstance();
        roomPopularity.getRoomIdAndPopularity().get(this.roomId).deletepopulartyNow();
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * 
     */
    @OnMessage
    public void onMessage(String message) {
        System.out.println("来自客户端的消息:" + message);
        resolverFactory.doAction(message,this);
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
    }

    public CopyOnWriteArraySet<WebScoket> getWebSocketSet() {
        return webSocketSet;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Session getSession() {
        return session;
    }

    public HttpSession getHttpSession() {
        return httpSession;
    }
}

