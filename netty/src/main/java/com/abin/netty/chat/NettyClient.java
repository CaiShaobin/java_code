package com.abin.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
    public static void main(String[] args) throws Exception {

        //客户端需要一个事件循环组
        NioEventLoopGroup gro = new NioEventLoopGroup();
        try {
            //创建客户端启动对象
            //注意客户端使用的不是 ServerBootstrap 而是 Bootstrap
            Bootstrap bootstrap = new Bootstrap();

            //设置相关参数
            bootstrap.group(gro) //设置线程组
                    .channel(NioSocketChannel.class) // 使用 NioSocketChannel 作为客户端的通道实现
                    .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    //加入处理器
                    socketChannel.pipeline().addLast(new NettyClientHandler());
                }
            });
            System.out.println("netty client start...");
            //启动客户端去连接服务器端
            ChannelFuture connect = bootstrap.connect("127.0.0.1", 9000);
            //对关闭通道进行监听
            connect.channel().closeFuture().sync();
        } finally {
            gro.shutdownGracefully();
        }

    }
}
