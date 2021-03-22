package practices.binance.handler;

import practices.binance.model.CryptoModel;

import java.util.List;
import java.util.stream.Collectors;

public class CryptoHandler {
    public List<CryptoModel> getListByStreamName(List<CryptoModel> cryptoModels, String streamName) {
        return cryptoModels
                .stream()
                .filter(s -> s.getStream().equals(streamName))
                .collect(Collectors.toList());
    }

//    public String getMedianValue(List<CryptoModel> cryptoModels) {
//        cryptoModels.stream().;
//    }
}
