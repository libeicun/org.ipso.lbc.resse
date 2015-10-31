/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.utils.python;

import com.sun.xml.fastinfoset.util.CharArray;
import org.ipso.lbc.common.exception.CmdInvokeFailedException;
import org.ipso.lbc.common.exception.CrossInvokeErrorException;
import org.ipso.lbc.common.exception.OperationTimeoutException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 李倍存 创建于 2015-05-12 16:17。电邮 1174751315@qq.com。
 */
public class PythonProcessHelper {
    public PythonProcessHelper() {
    }
    private PrintStream printStream;
    private String scriptPath;
    private String paramString="";

    public void setPrintStream(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void setScriptPath(String scriptPath) {
        this.scriptPath = scriptPath;
    }

    public void setTimeOut(Integer second){
        this.ms = second * 1000;

    }
    public void setTimeOutMs(Integer ms){
        this.ms = ms;

    }
    public void addParameters(String... parameters){
        for (int i = 0; i < parameters.length; i++) {
            paramString+=" "+parameters[i];
        }
    }

    public String getCommandLine(){
        return "python " + scriptPath+paramString;
    }


    private Process pr;
    private Timer timer = new Timer();
    private Boolean forceExit ;
    /**
     * 超时时间（毫秒），默认为1小时。
     */
    private Integer ms = 1 * 60 * 60 * 1000;
    /**
     * Invoke a python script through windows command line with parameters.
     * @throws org.ipso.lbc.common.exception.CmdInvokeFailedException,org.ipso.lbc.common.exception.CrossInvokeErrorException When and only when the python script execute a "print '*ERROR*'"(pattern), we believe that there is an error or exception occurs in the python script and cannot be handled, then we throw a CrossInvokeErrorException; If we cannot execute a command through the windows command line at all, we throw a CmdInvokeFailedException.
     */
    public void process() throws CmdInvokeFailedException,CrossInvokeErrorException {
        forceExit = false;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                pr.destroy();
                forceExit = true ;
            }
        }, ms);

        String printStrings = "";
        try {
            Boolean cannotInvokeCmd;//indicate that whether the target command line cannot be invoke
            Boolean pythonProcessError;//if the python script prints 'ERROR', set true
            String cmd="python " + scriptPath+paramString;

            //该函数是无阻塞的。
            pr = Runtime.getRuntime().exec(cmd);
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            //该循环直到python脚本返回或超时才会退出。
            while (true) {
                if((line = in.readLine()) != null){
                    printStrings += line;
                } else {
                    if (forceExit){
                        timer.cancel();
                        throw new OperationTimeoutException("Python script hasn't return before time out: " + ms /1000 + "s.");
                    }
                    break;
                }
            }


            in.close();
            pr.waitFor();
            String ERROR1 = "ERR",ERROR2="Err";
            pythonProcessError = printStrings.contains(new CharArray(ERROR1.toCharArray(),0,ERROR1.length(),true)) ||
                    printStrings.contains(new CharArray(ERROR2.toCharArray(),0,ERROR2.length(),true));

            cannotInvokeCmd = printStrings.equals("");

            if (cannotInvokeCmd){
                throw new CmdInvokeFailedException("Failed to invoke command line: "+cmd+".");
            }
            if (pythonProcessError){
                throw new CrossInvokeErrorException("ERROR occurs when executing python script "+scriptPath+" .\nStdOut:\n"+printStrings);
            }
            success(printStrings);

        } catch (IOException e) {
            failed(printStrings);
            throw new CmdInvokeFailedException(e);
        } catch (InterruptedException e) {
            failed(printStrings);
            throw new CmdInvokeFailedException(e);
        }
    }




    private void success(String str){
        if (printStream==null) {
            printStream = System.out;
        }
        printStream.println(str);
    }
    private void failed(String str){
        if (printStream==null) {
            printStream = System.err;
        }
        printStream.println(str);
    }
}
