package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
    private final Socket socket;
    private final ArrayList<Server> users;
    private final PrintWriter out;
    private final BufferedReader in;

    public Server(Socket clientSocket, ArrayList<Server> users) throws IOException {
        this.socket = clientSocket;
        this.users = users;
        out = new PrintWriter(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = in.readLine();
                if (msg == null || msg.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(msg);
                sendToAllConnect(msg);
                out.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendToAllConnect(String input) {
        for (Server serverReal : users) {
            serverReal.out.println(input);
        }
    }
}