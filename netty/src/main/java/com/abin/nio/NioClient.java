package com.abin.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioClient {

    private Selector selector;

    public static void main(String[] args) throws IOException {
        NioClient nioClient = new NioClient();
        nioClient.init("127.0.0.1",9000);
    }

    private void init(String host, int port) throws IOException {

        SocketChannel open = SocketChannel.open();
        open.configureBlocking(false);

        selector = Selector.open();
        open.connect(new InetSocketAddress(host,port));
        open.register(selector, SelectionKey.OP_CONNECT);
    }

    public void connect() throws IOException {
        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                iterator.remove();
                if (next.isConnectable()){
                    SocketChannel channel = (SocketChannel) next.channel();
                    if (channel.isConnectionPending()){
                        channel.finishConnect();
                    }
                    channel.configureBlocking(false);
                    ByteBuffer wrap = ByteBuffer.wrap("HelloServer".getBytes());
                    channel.write(wrap);
                    channel.register(this.selector,SelectionKey.OP_READ);
                }else if (next.isReadable()){
                    read(next);
                }
            }
        }
    }

    private void read(SelectionKey next) throws IOException {
        SocketChannel channel = (SocketChannel) next.channel();

        ByteBuffer buff = ByteBuffer.allocate(1024);
        int len = channel.read(buff);
        if (len != -1){
            System.out.println("客户端收到信息：" + new String(buff.array(),0,len));
        }
    }

}
