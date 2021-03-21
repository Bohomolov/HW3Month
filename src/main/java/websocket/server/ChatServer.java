package websocket.server;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import websocket.websocket.WebSocketProvider;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8088);
        HandlerList handlerList = new HandlerList();
        server.setHandler(handlerList);
        handlerList.addHandler(new WebSocketProvider());
        server.start();
        server.join();
    }
}
