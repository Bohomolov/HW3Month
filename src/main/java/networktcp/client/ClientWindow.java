package networktcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientWindow {
    public static void main(String[] args) {
        try {
            Socket clientSocket =  new Socket("localhost", 3081);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
