/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.action;

import org.ipso.lbc.common.action.CommonAjaxAction;
import org.ipso.lbc.common.exception.handler.ExceptionInfoPrintingHelper;
import org.ipso.lbc.common.utils.ResourcePathHelper;
import java.io.File;

/**
 * 信息：李倍存 创建于 2015/12/21 9:44。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class CaptureAction extends CommonAjaxAction {
    public CaptureAction() {
    }

    public String getPath() {
        return path;
    }

    public String getWarning() {
        return warning;
    }

    private String warning;
    private String path;
    @Override
    protected void setWarningInfo(String info) {
        warning = info;
    }

    @Override
    public String execute() throws Exception {
        try {
//            VideoRecorder recorder = VideoRecorder.INSTANCE;
//            Image image = recorder.capture();
//            path = ImageUtils.save(image, ResourcePathHelper.getAbsolutePath("TEMP/"), new SimpleDateFormat("yyyyMMdd-hhMMss").format(new Date()) + ".JPG");
            File file = new File("F:\\Portable\\apache-tomcat-7.0.62\\webapps\\resse-1.1\\TEMP\\flag.flag");
            file.createNewFile();
            path = ResourcePathHelper.getAbsolutePath("../../TEMP/") + "UNNAMED.JPG";

        }catch (Exception e){
            return warn(ExceptionInfoPrintingHelper.getStackTraceInfo(e));
        }
        return SUCCESS;
    }
}
