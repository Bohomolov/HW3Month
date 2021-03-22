package practices.binance.pool;

import practices.binance.model.CryptoModel;

import java.util.LinkedList;
import java.util.List;

public class Pool {
    private volatile List<CryptoModel> currencyPairs = new LinkedList<>();

    public synchronized List<CryptoModel> getCurrencyPairs() {
        return new LinkedList<>(currencyPairs);
    }

    public synchronized boolean addToCurrencyPairs(CryptoModel cryptoModel) {
        return currencyPairs.add(cryptoModel);
    }
}
