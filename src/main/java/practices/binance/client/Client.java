package practices.binance.client;

import java.net.URI;
import java.net.URISyntaxException;

public class Client {
    private static final String URI_BINANCE = "wss://stream.binance.com:9443/stream?streams=bnbbtc@bookTicker/ethbtc@bookTicker/xrpeth@bookTicker/bnbusdt@bookTicker/ltcbtc@bookTicker";

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        BinanceClient binanceClient = new BinanceClient(new URI(URI_BINANCE));
        while (true) {
            System.out.println(binanceClient.getCurrencyPairsFromPool().size());
            Thread.sleep(10000);
        }
    }
}
