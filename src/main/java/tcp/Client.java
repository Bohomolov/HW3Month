package tcp;

import java.io.*;
import java.net.Socket;

public class Client {
    private final String host = "localhost";
    private final int port = 8080;
    private Socket socket;
    private OutputStreamWriter streamWriter;
    private BufferedWriter out;
    private BufferedReader reader;

    public void run() throws IOException {
        try {
            socket = new Socket(host, port);
            streamWriter = new OutputStreamWriter(socket.getOutputStream());
            out = new BufferedWriter(streamWriter);
            reader = new BufferedReader(new InputStreamReader(System.in));

            ServerConnection serverConnection = new ServerConnection(socket);
            System.out.println("Connection success");

            Thread thread = new Thread(serverConnection);
            thread.start();

            while (true) {
                String message = reader.readLine();
                if (message == null || message.equalsIgnoreCase("exit")) {
                    break;
                }
                out.write(message + "\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            out.close();
            streamWriter.close();
            socket.close();
        }
    }
}
