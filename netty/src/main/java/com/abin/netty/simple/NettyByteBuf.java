package com.abin.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class NettyByteBuf {
    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.buffer(1);
        System.out.println("byteBuf=" + buffer);
        //byteBuf=UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf(ridx: 0, widx: 0, cap: 1)

        for (int i = 0; i < 8; i++) {
            buffer.writeByte(i);
        }
        System.out.println("byteBuf=" + buffer);
        //byteBuf=UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf(ridx: 0, widx: 8, cap: 64)

        for (int i = 0; i < 5; i++) {
            System.out.println(buffer.getByte(i));
        }
        System.out.println("byteBuf=" + buffer);
        //byteBuf=UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf(ridx: 0, widx: 8, cap: 64)

        for (int i = 0; i < 5; i++) {
            System.out.println(buffer.readByte());
        }
        System.out.println("byteBuf=" + buffer);
        //byteBuf=UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf(ridx: 5, widx: 8, cap: 64)

        ByteBuf byteBuf = Unpooled.copiedBuffer("hello,abin!", CharsetUtil.UTF_8);
        if (byteBuf.hasArray()){
            byte[] array = byteBuf.array();
            System.out.println(new String(array,CharsetUtil.UTF_8));
            System.out.println("byteBuf=" + byteBuf);
            //byteBuf=UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf(ridx: 0, widx: 11, cap: 64)

            System.out.println(byteBuf.getByte(0));
            // h - 104
            int i = byteBuf.readableBytes();
            System.out.println("len="+i);
            //len=11

            for (int i1 = 0; i1 < i; i1++) {
                System.out.println(byteBuf.getByte(i1));
            }

            System.out.println(byteBuf.getCharSequence(0,6,CharsetUtil.UTF_8));
            // hello,
            System.out.println(byteBuf.getCharSequence(6,6,CharsetUtil.UTF_8));
            // abin!
        }
    }
}
