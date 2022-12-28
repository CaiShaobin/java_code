package com.abin.convert;

import com.abin.pojo.Log;
import com.abin.pojo.UpdateOrder;

public class UpdateOrderConvert implements OrderConvert<UpdateOrder>{

    @Override
    public Log convert(UpdateOrder order) {
        Log log = new Log();
        log.setOrderId(order.getId());
        return log;
    }
}
