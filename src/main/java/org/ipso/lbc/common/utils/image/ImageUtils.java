/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.utils.image;

import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.media.jai.codec.BMPEncodeParam;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.JPEGEncodeParam;
import org.ipso.lbc.common.exception.AppUnCheckException;
import org.ipso.lbc.common.utils.ResourcePathHelper;


import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 信息：李倍存 创建于 2015/12/20 22:59。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class ImageUtils {
    public static String save(Image image, String path){
        FileOutputStream out;
        try {
            out =new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            throw new AppUnCheckException(e);
        }
        ImageEncoder encoder = ImageCodec.createImageEncoder("JPEG", out, new JPEGEncodeParam());
        try {
            encoder.encode((RenderedImage)image);
        } catch (IOException e) {
            throw new AppUnCheckException(e);
        }
        try {
            out.close();
        } catch (IOException e) {
            throw new AppUnCheckException(e);
        }

        return path;
    }
    public static String save(Image image, String dir, String fileName){
        return save(image, ResourcePathHelper.getAbsolutePath(dir) + fileName);
    }
}
