package com.abin.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[ 客户端 ]" + channel.remoteAddress() + "上线了" + sdf.format(new Date()) + "\n");
        channelGroup.add(channel);
        System.out.println(ctx.channel().remoteAddress() + "上线了" + "\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[ 客户端 ]" + channel.remoteAddress() + "下线了" + "\n");
        System.out.println(ctx.channel().remoteAddress() + "下线了" + "\n");
        System.out.println("channnelGroup size=" + channelGroup.size());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        Channel channel = channelHandlerContext.channel();
        channelGroup.forEach(ch -> {
            if (channel != ch){
                ch.writeAndFlush("[ 客户端 ]" + channel.remoteAddress() + "发送了消息：" + s + "\n");
            }else {
                ch.writeAndFlush("[ 自己 ]发送了消息：" + s + "\n" );
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
