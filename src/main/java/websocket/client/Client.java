package websocket.client;


import javax.websocket.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

@ClientEndpoint
public class Client {
    private static Session userSession = null;

    public Client(URI endpointURI) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @OnOpen
    public void onOpen(Session userSession) {
        System.out.println("New ws connection");
        Client.userSession = userSession;
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println(message);
    }

    @OnClose
    public void onClose(Session session) {
    }

    public static void main(String[] args) throws URISyntaxException {
        Client client = new Client(new URI("ws://localhost:8088/"));
        while (true) {
            Scanner scanner = new Scanner(System.in);
            userSession.getAsyncRemote().sendText(scanner.nextLine());
        }
    }
}