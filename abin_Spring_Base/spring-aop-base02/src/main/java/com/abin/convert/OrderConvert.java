package com.abin.convert;

import com.abin.pojo.Log;

public interface OrderConvert<T> {

    Log convert(T t);
}
