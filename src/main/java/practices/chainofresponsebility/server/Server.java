package practices.chainofresponsebility.server;

import practices.chainofresponsebility.handlers.BaseHandler;

import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<String, String> users = new HashMap<>();
    private BaseHandler baseHandler;

    public void setBaseHandler(BaseHandler baseHandler) {
        this.baseHandler = baseHandler;
    }

    public boolean logIn(String email, String password) {
        if (baseHandler.check(email, password)) {
            System.out.println("Authorization have been successful!");
            return true;
        }
        return false;
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}
