package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnection implements Runnable {
    private final Socket server;
    private BufferedReader in;

    public ServerConnection(Socket socket) throws IOException {
        server = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            while (true) {
                String message = in.readLine();
                if (message == null) {
                    break;
                }
                System.out.println("Message: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}