package networktcp.network;

public interface TCPConnectionListener {
    void onConnectionReady(TCPConnection tcpConnection);

    void onReceiveString(TCPConnection tcpConnection, String massage);

    void onDisconnect(TCPConnection tcpConnection);

    void onException(TCPConnection tcpConnection, Exception e);
}
