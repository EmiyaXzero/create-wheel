package ai.my.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author shanghang
 * @title: ArrayBlockingQueueDemo
 * @projectName create-wheel
 * @description: ArrayBlockingQueueDemo
 * @date 2020/8/16-15:15
 */
@Slf4j
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue(3);
        for (int i = 0;i<2;i++){
            new Thread(){
                @SneakyThrows
                @Override
                public void run(){
                    while (true){
                        Thread.sleep((long) (Math.random()*1000));
                        log.error(Thread.currentThread().getName()+"线程添加数据,队列长度"+blockingQueue.size());
                        //add会出现异常,put会出现阻塞
                        blockingQueue.add(1);
                        blockingQueue.put(1);
                        log.error(Thread.currentThread().getName()+"线程添加数据结束,队列长度"+blockingQueue.size());
                    }
                }
            }.start();
        }


        new Thread(){
            @SneakyThrows
            @Override
            public void run(){
                while (true){
                    Thread.sleep(100);
                    log.error(Thread.currentThread().getName()+"线程读取数据,队列长度"+blockingQueue.size());
                    blockingQueue.poll();
                    log.error(Thread.currentThread().getName()+"线程读取数据结束,队列长度"+blockingQueue.size());
                }
            }
        }.start();
    }
}
