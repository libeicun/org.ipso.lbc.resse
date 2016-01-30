/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.utils.image;


import org.ipso.lbc.common.exception.AppUnCheckException;
import org.ipso.lbc.common.utils.ResourcePathHelper;

import javax.media.*;
import javax.media.cdm.CaptureDeviceManager;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 信息：李倍存 创建于 2015/12/20 10:19。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class VideoRecorder {

    String CAPTURE_NAME = "vfw:Microsoft WDM Image Capture (Win32):0";
    String LOCATOR_NAME = "vfw://0";
    private MediaLocator mediaLocator;
    private Player player;
    public static VideoRecorder INSTANCE = new VideoRecorder();
    private VideoRecorder() {
        CaptureDeviceInfo captureDeviceInfo = CaptureDeviceManager.getDevice(CAPTURE_NAME);
        mediaLocator = captureDeviceInfo.getLocator();
       }
    public Image capture(){
        createPlayer();
        startPlayer();
        FrameGrabbingControl fgc=(FrameGrabbingControl)player.getControl("javax.media.control.FrameGrabbingControl");
        Buffer buffer=fgc.grabFrame();
        BufferToImage bufferToImage=new BufferToImage((VideoFormat)buffer.getFormat());
        closePlayer();
        return bufferToImage.createImage(buffer);

    }
    private Player createPlayer(){
        try {
            player = Manager.createRealizedPlayer(mediaLocator);
        } catch (IOException e) {
            throw new AppUnCheckException(e);
        } catch (NoPlayerException e) {
            throw new AppUnCheckException(e);
        } catch (CannotRealizeException e) {
            throw new AppUnCheckException(e);
        }
        return player;
    }
    private Player startPlayer(){
        player.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new AppUnCheckException(e);
        }
        return player;
    }
    private void closePlayer(){
        player.close();
    }
    private void stopPlayer(){
        player.stop();
    }


    public static void main(String[] args){

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Loop(), new Date(), 500);
        while (true);

    }


    private static class Loop extends TimerTask{

        @Override
        public void run() {
            if (needToCapture()){
                System.err.println("检测到目标内存页更新 - " + new SimpleDateFormat("yyyy-MM-dd hh:MM:ss").format(new Date()));
                System.out.print("    开始处理 ...\n");
                VideoRecorder videoRecorder = VideoRecorder.INSTANCE;
                Image image = videoRecorder.capture();
                ImageUtils.save(image, "F:\\Portable\\apache-tomcat-7.0.62\\webapps\\resse-1.1\\TEMP\\UNNAMED.JPG");
                System.out.print("    完成\n");
            }
        }
        private boolean needToCapture(){
            File file = new File("F:\\Portable\\apache-tomcat-7.0.62\\webapps\\resse-1.1\\TEMP\\flag.flag");
            if (file.exists()){
                file.delete();
                return true;
            }else {
                return false;
            }
        }
    }




}
