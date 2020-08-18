package ai.my.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author shanghang
 * @title: MyRecursiveAction
 * @projectName create-wheel
 * @description: MyRecursiveAction
 * @date 2020/8/18-19:52
 */
@Slf4j
public class MyRecursiveAction extends RecursiveAction {
    private long workLoad = 0;

    public MyRecursiveAction(){

    }
    public MyRecursiveAction(long workLoad){
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {
        if(this.workLoad>16){
            log.error("开始拆分workLoad,当前workLoad数量:"+this.workLoad);
            List<MyRecursiveAction> subTasks = new ArrayList<>();
            subTasks.addAll(createSubtasks());
            for(RecursiveAction recursiveAction : subTasks){
                recursiveAction.fork();
            }
        }else {
            //进行业务操作
            log.error("Doing workLoad myself"+this.workLoad);
        }
    }

    private Collection<? extends MyRecursiveAction> createSubtasks() {
        List<MyRecursiveAction> subTasks = new ArrayList<>();
        MyRecursiveAction task1 = new MyRecursiveAction(this.workLoad/2);
        MyRecursiveAction task2 = new MyRecursiveAction(this.workLoad/2);
        subTasks.add(task1);
        subTasks.add(task2);
        return  subTasks;
    }


    public static void main(String[] args) {
        //创建一个并行为4的forkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        MyRecursiveAction recursiveAction = new MyRecursiveAction(24);
        forkJoinPool.invoke(recursiveAction);
    }

}
