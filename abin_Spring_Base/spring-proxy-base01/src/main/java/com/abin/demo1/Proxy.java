package com.abin.demo1;

public class Proxy implements Rent{

    private Host host;

    @Override
    public void rent() {
        adjust();
        host.rent();
        fare();
    }

    private void fare(){
        System.out.println(">>>Proxy.fare()<<<");
    }

    private void adjust(){
        System.out.println(">>>Proxy.adjust()<<<");
    }

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

}
