package ai.my.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;


/**
 * @author shanghang
 * @title: ThreadPoolTest
 * @projectName create-wheel
 * @description: 线程池测试
 * @date 2020/8/15-16:19
 */
@Slf4j
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService pool =  new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10));
        for(int i = 0 ;i<5;i++){
            Thread thread = new ThreadPoolTest().new MyThread();
            pool.execute(thread);
        }
        pool.shutdown();
    }


    class MyThread extends Thread{
        @Override
        public void run(){
            log.error(Thread.currentThread().getName() + ".............");
        }
    }
}
