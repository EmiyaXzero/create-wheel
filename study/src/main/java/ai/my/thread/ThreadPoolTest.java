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
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool =  new ThreadPoolExecutor(2, 10,
                10000, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(50));
        for(int i = 0 ;i<60;i++){
            Thread thread = new ThreadPoolTest().new MyThread();
            pool.execute(thread);
        }
        while (pool.getQueue().size()>0){
            log.error("当前线程池大小"+pool.getPoolSize()+"当前线程请求队列大小"+pool.getQueue().size());
            Thread.sleep(1000);
        }
        Thread.sleep(20000);
        log.error("当前线程池大小"+pool.getPoolSize()+"当前线程请求队列大小"+pool.getQueue().size());
        pool.shutdown();
    }


    class MyThread extends Thread{
        @Override
        public void run(){
            log.error(Thread.currentThread().getName() + ".............");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.error(Thread.currentThread().getName() + ".............Sleep结束");
        }
    }
}
