package com.abin.service;

import com.abin.annotation.LogInfo;
import com.abin.convert.SaveOrderConvert;
import com.abin.convert.UpdateOrderConvert;
import com.abin.pojo.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @LogInfo(desc = "创建订单", convert = SaveOrderConvert.class)
    public boolean saveOrder(Order order){
        System.out.println("创建订单：" + order.getId());
        return true;
    };

    @LogInfo(desc = "更新订单", convert = UpdateOrderConvert.class)
    public boolean updateOrder(Order order){
        System.out.println("更新订单：" + order.getId());
        return true;
    }
}
