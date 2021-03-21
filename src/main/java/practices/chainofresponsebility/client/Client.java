package practices.chainofresponsebility.client;

import practices.chainofresponsebility.handlers.BaseHandler;
import practices.chainofresponsebility.handlers.LimitConnectionHandler;
import practices.chainofresponsebility.handlers.OneMoreHandler;
import practices.chainofresponsebility.handlers.UserExistHandler;
import practices.chainofresponsebility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        BaseHandler baseHandler = new LimitConnectionHandler(2);
        baseHandler.linkWith(new UserExistHandler(server))
                   .linkWith(new OneMoreHandler());

        server.setBaseHandler(baseHandler);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}
