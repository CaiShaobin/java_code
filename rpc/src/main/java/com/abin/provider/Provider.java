package com.abin.provider;

import com.abin.framework.URL;
import com.abin.framework.protocol.NettyServer;
import com.abin.framework.register.LocalRegister;
import com.abin.framework.register.ZookeeperRegister;
import com.abin.provider.api.HelloServeice;
import com.abin.provider.impl.HelloServiceImpl;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Provider {

    public static void main(String[] args) throws UnknownHostException {

        String interfaceName = HelloServeice.class.getName();
        URL url = new URL(InetAddress.getLocalHost().getHostAddress(), 8081);

        LocalRegister.register(interfaceName, HelloServiceImpl.class);
        ZookeeperRegister.regist(interfaceName,url);

        NettyServer nettyServer = new NettyServer();
        nettyServer.start(url.getHostname(),url.getPort());

        System.out.println(String.format("success,成功暴露%s服务，地址为%s",interfaceName,url.toString()));

        while (true){

        }
    }
}
