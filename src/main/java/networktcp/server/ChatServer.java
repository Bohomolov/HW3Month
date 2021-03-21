package networktcp.server;

import networktcp.network.TCPConnection;
import networktcp.network.TCPConnectionListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ChatServer implements TCPConnectionListener {
    public static void main(String[] args) {
        new ChatServer();
    }

    private final ArrayList<TCPConnection> connections = new ArrayList<>();

    private ChatServer() {
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            while (true) {
                try {
                    new TCPConnection(this, serverSocket.accept());
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public synchronized void onConnectionReady(TCPConnection tcpConnection) {
        System.out.println("conn");
        connections.add(tcpConnection);
        sendToAllConnections("Client connected: " + tcpConnection);
    }

    @Override
    public synchronized void onReceiveString(TCPConnection tcpConnection, String massage) {
        System.out.println(massage);
        sendToAllConnections(massage);
    }

    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        connections.remove(tcpConnection);
        sendToAllConnections("Client disconnected" + tcpConnection);
    }

    @Override
    public synchronized void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println(e);
    }

    private void sendToAllConnections(String msg) {
        System.out.println(msg);
        System.out.println("send all massage");
        int size = connections.size();
        for (int i = 0; i < size; i++) {
            connections.get(i).sendMassage(msg);
        }
    }
}
