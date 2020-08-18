package ai.my.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author shanghang
 * @title: MyRecursiveTask
 * @projectName create-wheel
 * @description: MyRecursiveTask
 * @date 2020/8/18-20:13
 */
@Slf4j
public class MyRecursiveTask extends RecursiveTask<Long> {
    private long workLoad = 0;

    public MyRecursiveTask(){

    }

    public MyRecursiveTask(Long workLoad){
        this.workLoad = workLoad;
    }

    @Override
    protected Long compute() {
        if(this.workLoad>16){
            log.error("workLoad超过16了，开始拆分--------------");
            List<MyRecursiveTask> myRecursiveTaskList = new ArrayList<>();
            myRecursiveTaskList.addAll(createTasks());
            for (RecursiveTask recursiveTask : myRecursiveTaskList){
                recursiveTask.fork();
            }
            long result = 0;
            for (RecursiveTask recursiveTask : myRecursiveTaskList){
                result += (Long)recursiveTask.join();
            }
            return result;
        }else {
            log.error("处理结果:"+this.workLoad);
            return this.workLoad*3;
        }
    }

    private List<MyRecursiveTask> createTasks() {
        List<MyRecursiveTask> myRecursiveTaskList = new ArrayList<>();
        myRecursiveTaskList.add(new MyRecursiveTask(this.workLoad/2));
        myRecursiveTaskList.add(new MyRecursiveTask(this.workLoad/2));
        return myRecursiveTaskList;
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        long result = forkJoinPool.invoke(new MyRecursiveTask(128L));
        log.error(result+"");
    }
}
