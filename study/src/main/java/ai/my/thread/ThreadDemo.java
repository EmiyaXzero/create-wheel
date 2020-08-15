package ai.my.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shanghang
 * @title: ThreadDemo
 * @projectName create-wheel
 * @description: 多线程例子
 * @date 2020/8/15-15:35
 */
@Slf4j
public class ThreadDemo implements Runnable{
    private static ThreadLocal threadLocal = new ThreadLocal();
    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        log.error("线程名"+currentThreadName);
        threadLocal.set(currentThreadName);
        log.error("线程名 "+currentThreadName+threadLocal.get()+" first");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.error("线程名 "+currentThreadName+threadLocal.get()+" second");
    }


    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        for (int i = 0 ;i<10;i++){
            Thread t = new Thread(threadDemo,"thread"+i);
            t.start();
        }
    }
}
