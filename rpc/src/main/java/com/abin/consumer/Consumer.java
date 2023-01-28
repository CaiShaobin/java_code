package com.abin.consumer;


import com.abin.framework.protocol.Invocation;
import com.abin.framework.proxy.ProxyFactory;
import com.abin.provider.api.HelloServeice;

public class Consumer {

    public static void main(String[] args) {
        Invocation invocation = new Invocation(HelloServeice.class.getName(), "sayHello", new Class[]{String.class}, new Object[]{"厉不厉害你彬哥"});

//        NettyClient nettyClient = new NettyClient();
//        String result = nettyClient.send("127.0.0.1", 8081, invocation);
//        System.out.println(result);

        HelloServeice helloServeice = (HelloServeice) ProxyFactory.getProxy(HelloServeice.class);
        for (int i = 0; i < 10; i++) {
            String res = helloServeice.sayHello("厉不厉害你彬哥");
            System.out.println(res);
        }
    }
}
