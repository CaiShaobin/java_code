package com.abin.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class RefreshServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 每3秒刷新一次
        resp.setHeader("Refresh","3");
        // 内存中创建图片
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        // 笔
        Graphics2D g = ((Graphics2D) image.getGraphics());
        // 画
        g.setColor(Color.white);// 白色背景
        g.setFont(new Font(null,Font.BOLD,20));// 黑体，20
        g.drawString(getRandom(),0,20);

        // 以图片形式打开请求
        resp.setContentType("image/jpg");
        // 不缓冲
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        // 写图片
        boolean write = ImageIO.write(image, "jpg", resp.getOutputStream());

    }

    private String getRandom(){
        Random random = new Random();
        String num = random.nextInt(999999) + "";
        StringBuffer sb = new StringBuffer(num);
        while (sb.length() < 6){
            sb.append("0");
        }
        return sb.toString();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
