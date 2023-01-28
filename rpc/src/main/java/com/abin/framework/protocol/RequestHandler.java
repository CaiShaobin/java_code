package com.abin.framework.protocol;

import com.abin.framework.register.LocalRegister;
import io.netty.channel.ChannelHandlerContext;

import java.lang.reflect.Method;

public class RequestHandler implements ChannelHandler {

    @Override
    public void handler(ChannelHandlerContext ctx, Invocation invocation) throws Exception {


        Class serviceImpl = LocalRegister.get(invocation.getInterfaceName());

        Method method = serviceImpl.getMethod(invocation.getMethodName(),invocation.getParamTypes());

        Object result = method.invoke(serviceImpl.newInstance(), invocation.getParams());

        System.out.println(result);
        ctx.writeAndFlush("Netty:" + result);


    }
}
