package com.lxh.fushoujia.util;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @program: fushoujia
 * @description:关于文件处理的工具
 * @author: Mr.Wang
 * @create: 2019-10-12 18:34
 **/

public class Util {

    //判断文件是否存在
    //filePath  文件路径
    //fileName 文件名
    public static boolean checkFileExist(String filePath, String fileName) {
        File file = new File(filePath, fileName);
        System.out.println(file.getAbsolutePath());
        if (file.exists()) {
            return true;
        }
        return false;
    }
    /*
    设置图片文件为jpg格式
    * f 为file文件
    * */
    public static BufferedImage changeJpg(File f) {
        try {
            Image i = Toolkit.getDefaultToolkit().createImage(f.getAbsolutePath());
            PixelGrabber pg = new PixelGrabber(i, 0, 0, -1, -1, true);
            pg.grabPixels();
            int width = pg.getWidth(), height = pg.getHeight();
            final int[] RGB_MASKS = { 0xFF0000, 0xFF00, 0xFF };
            final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);
            DataBuffer buffer = new DataBufferInt((int[]) pg.getPixels(), pg.getWidth() * pg.getHeight());
            WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
            BufferedImage img = new BufferedImage(RGB_OPAQUE, raster, false, null);
            return img;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /*
     * @Author 辉
     * @Description //TODO
     * @Date 15:35 2019/10/28
     * @Param [code]前台传入中文参数
     * @return java.lang.String
     **/
    public static String decode(String code) {
        if (code == null || code.length() <= 0 || code == "null") {
            //System.out.println("isNull");
            return null;
        }
        try {
            code = URLDecoder.decode(code, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return code;
    }
    /*
     * @Author 辉
     * @Description //TODO 按顺序生成编号
     * @Date 16:13 2019/10/28
     * @Param [previousCode: 查找数据库后最后一个编号, start：编号前缀]
     * @return java.lang.String
     **/
    public static String getCode(String previousCode, String start) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
        String code = sf.format(date);
        String data = previousCode;
        int newYear = Calendar.getInstance().get(Calendar.YEAR);
        int newMonth = Calendar.getInstance().get(Calendar.MONTH ) +1;
        int year = newYear;
        int month = newMonth;
        int number = 0;
        if (data == null || data.length() == 0 || data.length() < 13) {
            code = start + code + "001";
        } else {
            year = Integer.parseInt(data.substring(2, 6));
            month = Integer.parseInt(data.substring(6, 8));
            number = Integer.parseInt(data.substring(8));
            if (newYear > year || newMonth > month) {
                code = start + code + "001";
            } else {
                number += 1;
                String numbers = null;
                if (number < 10) {
                    numbers = "00" + number;
                } else if (number < 100 && number >=10){
                    numbers = "0"+ number;
                } else {
                    numbers = String.valueOf(number);
                }
                code = start + code + numbers;
            }
        }
        return code;
    }

    /**
     * @param resp
     * @param name         文件真实名字
     * @param downloadName 文件下载时名字
     */
    public static File download(HttpServletResponse resp, String name, String downloadName, HttpServletRequest request) {
        String fileName = null;
        try {
            fileName = new String(downloadName.getBytes("GBK"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ///home/tomcat/apache-tomcat-9.0.1/files
        //String realPath = "D:\\web\\fushoujia\\src\\static\\img\\contract";
        String realPath = request.getServletContext().getRealPath("/src/static/img/user");
//        String realPath=File.separator+"home"+File.separator+"tomcat"+File.separator+"apache-tomcat-9.0.1"+File.separator+"files";
        String path = realPath + File.separator + "24.png";
        System.out.println(path);
        File file = new File(path);
        if (file.exists()) {
            System.out.println("存在");
        }
        resp.reset();
        String origin = request.getHeader("Origin");
        if(StringUtils.isNotBlank(origin)) {
            resp.setHeader("Access-Control-Allow-Origin", origin);
        }
        resp.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setContentType("application/octet-stream");
        resp.setCharacterEncoding("utf-8");
        resp.setContentLength((int) file.length());
        resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = resp.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

}
