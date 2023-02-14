package com.abin.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Reference
    TicketService ticketService;

    @Override
    public String buyTicket() {
        return ticketService.getTicket();
    }
}
