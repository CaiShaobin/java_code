package com.abin.framework.protocol;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class NettyClient {

    public NettyClientHandler client = null;

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public void start(String hostName,Integer port){
        client = new NettyClientHandler();

        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY,true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast("decoder",new ObjectDecoder(ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
                        pipeline.addLast("encoder",new ObjectEncoder());
                        pipeline.addLast("handler",client);
                    }
                });

        try {
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8081).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String send(String hostName,Integer port,Invocation invocation){
        if (client == null){
            start(hostName,port);
        }
        client.setInvocation(invocation);

        try {
            Future future = executorService.submit(client);
            return (String) future.get(3,SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}
