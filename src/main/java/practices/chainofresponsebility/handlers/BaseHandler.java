package practices.chainofresponsebility.handlers;

public abstract class BaseHandler {

    private BaseHandler next;

    public BaseHandler linkWith(BaseHandler next) {
        this.next = next;
        return next;
    }


    public abstract boolean check(String email, String password);

    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
