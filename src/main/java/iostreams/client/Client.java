package iostreams.client;

import iostreams.controller.Controller;

public class Client {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.execute(false, false);
    }
}
