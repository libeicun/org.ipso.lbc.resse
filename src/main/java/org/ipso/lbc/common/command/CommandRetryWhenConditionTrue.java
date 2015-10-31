/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.command;
import org.ipso.lbc.common.condition.ICondition;
/**
 * 信息：李倍存 创建于 2015-08-16 21:43。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class CommandRetryWhenConditionTrue extends CommandWithRetries {

    private ICondition condition = new DefaultCondition();
    private Boolean failed;

    public void addCondition(ICondition condition){
        this.condition = condition;
    }
    public CommandRetryWhenConditionTrue(IReceiver receiver, Integer retryCount, String taskStr) {
        super(receiver, retryCount, taskStr);
    }

    @Override
    protected Boolean failed() {
        return failed;
    }

    @Override
    protected Object reason() {
        return condition.info();
    }

    @Override
    protected Object once(IReceiver receiver, Object params) {
        Object o = receiver.action(params);
        failed = condition.decide();
        return o;
    }




    private class DefaultCondition implements ICondition{
        @Override
        public Boolean decide() {
            return true;
        }
        @Override
        public Object info(){
            return "默认失败条件。该提示不应出现，若您看到该提示，请检查程序逻辑。";
        }
    }
}
