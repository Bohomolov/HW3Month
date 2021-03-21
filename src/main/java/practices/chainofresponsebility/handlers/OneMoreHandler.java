package practices.chainofresponsebility.handlers;

public class OneMoreHandler extends BaseHandler {

    @Override
    public boolean check(String email, String password) {
        System.out.println("Handle email & password");
        return false;
    }
}
