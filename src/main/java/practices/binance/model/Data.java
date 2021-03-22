package practices.binance.model;

public class Data {
    private final String s;
    private final long u;
    private final double b;
    private final double B;
    private final double a;
    private final double A;

    public Data(long u, String s, double b, double B, double a, double A) {
        this.u = u;
        this.s = s;
        this.b = b;
        this.B = B;
        this.a = a;
        this.A = A;
    }

    public long getU() {
        return u;
    }

    public String getS() {
        return s;
    }

    public double getB() {
        return b;
    }

    public double getA() {
        return a;
    }

    @Override
    public String toString() {
        return "Data{" +
                "u=" + u +
                ", s='" + s + '\'' +
                ", b=" + b +
                ", B=" + B +
                ", a=" + a +
                ", A=" + A +
                '}';
    }
}
