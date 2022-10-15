package com.abin.netty.heartbeat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Random;

public class HeartBeatClient {

    public static void main(String[] args) throws Exception{
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("decoder",new StringDecoder());
                            pipeline.addLast("encoder",new StringEncoder());
                            pipeline.addLast(new HeartBeatClientHandler());
                        }
                    });
            System.out.println("netty client start...");
            Channel channel = bootstrap.connect("127.0.0.1", 9000).sync().channel();
            String text = "Heartbeat Packet";
            Random random = new Random();
            while (channel.isActive()){
                int num = random.nextInt(8);
                Thread.sleep(num * 1000);
                channel.writeAndFlush(text);
            }
        } finally {
            eventExecutors.shutdownGracefully();
        }
    }

    static class HeartBeatClientHandler extends SimpleChannelInboundHandler<String>{
        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
            System.out.println("client received :" + s);
            if (s != null && s.equals("idle close")){
                System.out.println("server closed,client will be close");
                channelHandlerContext.channel().closeFuture();
            }
        }
    }
}
