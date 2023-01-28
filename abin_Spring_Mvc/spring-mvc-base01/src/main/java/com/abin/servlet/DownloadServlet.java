package com.abin.servlet;

import jdk.internal.util.xml.impl.Input;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取下载路径
        String filePath = "D:\\Java_Code\\java_code\\abin_Spring_Mvc\\out\\artifacts\\spring_mvc_base01_war_exploded\\WEB-INF\\88204485_p0_master1200.jpg";
        // 2.文件名
        String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
        // 3.响应头 Content-Disposition:attachment:filename=
        resp.setHeader("Content-Disposition","attachment;filename=" + fileName);
        // 4.输入流
        int len = 0;
        FileInputStream in = new FileInputStream(filePath);
        // 5.缓冲区
        byte[] bytes = new byte[1024];
        // 6.获取OutputStream
        ServletOutputStream outputStream = resp.getOutputStream();
        // 7.将FileOutputStream流写入buffer缓冲区
        while ((len = in.read(bytes)) > 0){
            outputStream.write(bytes,0,len);
        }

        in.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
