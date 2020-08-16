package ai.my.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shanghang
 * @title: ThreadStateDemo
 * @projectName create-wheel
 * @description: 线程状态demo
 * @date 2020/8/16-15:44
 */
@Slf4j
public class ThreadStateDemo {
    static int j = 0;
    public static void main(String[] args) throws InterruptedException {
        doBySys();
    }
    public static void doBySys(){
        for (int i = 0 ;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    j++;
                    log.error(Thread.currentThread().getName()+"----"+j);
                }
            }).start();
        }


    }



    public static void doByLog() throws InterruptedException {
        log.error("#############第一种状态新建->运行->终止########################");
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                Thread currentThread = Thread.currentThread();
                log.error("thread1线程当前的状态是"+currentThread.getState());
                log.error("thread1线程启动了");
            }
        };
        log.error("start之前thread1的状态"+thread1.getState());
        thread1.start();
        log.error("start之后thread1的状态"+thread1.getState());

        Thread.sleep(2000);
        log.error("等待2s之后thread1的状态"+thread1.getState());


        log.error("#############第二种状态新建->运行-->等待->终止########################");
        Thread thread2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(1500);
                log.error("thread2线程当前的状态是"+Thread.currentThread().getState());
                log.error("thread2线程启动了");
            }
        });
        log.error("start之前thread2的状态"+thread2.getState());
        thread2.start();
        log.error("start之后thread2的状态"+thread2.getState());
        // 等待200毫秒，再看状态
        Thread.sleep(200);
        log.error("等待200毫秒，再看thread2当前状态：" + thread2.getState());
        // 再等待3秒，让thread2执行完毕，再看状态
        Thread.sleep(3000L);
        log.error("等待3秒，再看thread2当前状态：" + thread2.getState());

        log.error("#############第三种状态新建->运行-->等待->终止########################");
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ThreadStateDemo.class){
                    log.error("thread3线程当前的状态是"+Thread.currentThread().getState());
                    log.error("thread3线程启动了");
                }
            }
        });
        synchronized (ThreadStateDemo.class){
            log.error("start之前thread3的状态"+thread3.getState());
            thread3.start();
            log.error("start之后thread3的状态"+thread3.getState());
            Thread.sleep(200);
            log.error("sleep 200之后thread3的状态"+thread3.getState());
        }
        log.error("同步块跑完了thread3的状态"+thread3.getState());
        Thread.sleep(2000);
        log.error("同步块跑完了sleep 2000 thread3的状态"+thread3.getState());
    }
}
