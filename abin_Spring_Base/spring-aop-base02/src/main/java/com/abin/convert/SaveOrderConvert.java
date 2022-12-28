package com.abin.convert;

import com.abin.pojo.Log;
import com.abin.pojo.SaveOrder;

public class SaveOrderConvert implements OrderConvert<SaveOrder> {

    @Override
    public Log convert(SaveOrder order) {
        Log log = new Log();
        log.setOrderId(order.getId());
        return log;
    }
}
