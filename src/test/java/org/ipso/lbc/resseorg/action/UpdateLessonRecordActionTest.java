/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.action;

import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateLessonRecordActionTest {

    @org.junit.Test
    public void testExecute() throws Exception {
        UpdateLessonRecordAction action = new UpdateLessonRecordAction();
        action.setInfo("");
        action.setMinutes(0);
        action.setTimes(0);
        action.execute();
    }

    @Test
    public void testApprove() throws Exception {
        UpdateLessonRecordAction action = new UpdateLessonRecordAction();
        action.setName("李倍存");
        action.execute();
    }
}