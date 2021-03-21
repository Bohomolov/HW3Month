package practices.chainofresponsebility.handlers;

import practices.chainofresponsebility.server.Server;

public class UserExistHandler extends BaseHandler {
    private Server server;

    public UserExistHandler(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}

