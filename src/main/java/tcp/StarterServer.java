package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StarterServer {
    public static Socket clientSocket;
    private static ServerSocket server;
    private static ArrayList<Server> list = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(8080);
        while (true) {
            System.out.println("Server: start");
            clientSocket = server.accept();
            System.out.println("Server: new connection " + clientSocket.getLocalSocketAddress());
            Server serverReal = new Server(clientSocket, list);
            list.add(serverReal);
            pool.execute(serverReal);
        }
    }
}
