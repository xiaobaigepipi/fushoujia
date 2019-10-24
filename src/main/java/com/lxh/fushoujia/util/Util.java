package com.lxh.fushoujia.util;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
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

}
