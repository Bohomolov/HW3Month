package practices.binance.client;

import com.google.gson.Gson;
import practices.binance.model.CryptoModel;
import practices.binance.pool.Pool;

import javax.websocket.*;
import java.net.URI;
import java.util.List;

@ClientEndpoint
public class BinanceClient {
    private final Pool pool = new Pool();
    private final Gson gson = new Gson();

    public BinanceClient(URI endpointURI) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<CryptoModel> getCurrencyPairsFromPool() {
        return pool.getCurrencyPairs();
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        pool.addToCurrencyPairs(gson.fromJson(message, CryptoModel.class));
    }
}
