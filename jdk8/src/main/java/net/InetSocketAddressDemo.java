package net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class InetSocketAddressDemo {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 2181;
        InetSocketAddress unresolved = InetSocketAddress.createUnresolved(host, port);
        InetAddress address = unresolved.getAddress();
        System.out.println(unresolved);
        System.out.println("address = " + address);
        System.out.println("unresolved.isUnresolved() = " + unresolved.isUnresolved());
        System.out.println("unresolved.getHostName() = " + unresolved.getHostName());
        System.out.println("unresolved.getAddress() = " + unresolved.getAddress());


        SocketChannel sock = SocketChannel.open();
        sock.configureBlocking(false);
        sock.socket().setSoLinger(false, -1);
        sock.socket().setTcpNoDelay(true);

        boolean connect = sock.connect(unresolved);
        System.out.println("connect = " + connect);
    }

}
