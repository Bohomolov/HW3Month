package practices.binance.model;

public class CryptoModel {
    private final String stream;

    private final Data data;

    public CryptoModel(String stream, Data data) {
        this.stream = stream;
        this.data = data;
    }

    public String getStream() {
        return stream;
    }

    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ModelCripta{" +
                "stream='" + stream + '\'' +
                ", data=" + data +
                '}';
    }
}
