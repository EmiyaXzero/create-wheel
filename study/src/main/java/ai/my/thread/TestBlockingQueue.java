package ai.my.thread;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shanghang
 * @title: TestBlockingQueue
 * @projectName create-wheel
 * @description: 阻塞队列测试
 * @date 2020/8/20-14:17
 */
@Slf4j
public class TestBlockingQueue {
    static long randomTime(){
        return (long)Math.random()*1000;
    }


    public static void main(String[] args) {
        //阻塞队列100
        final BlockingQueue<File> queue = new LinkedBlockingQueue<>(100);
        //线程池
        final ExecutorService service = new ThreadPoolExecutor(5,5,0,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10));

        final File file = new File("F:\\JavaLib");

        final File exitFile = new File("");

        //读个数
        final AtomicInteger rc = new AtomicInteger();

        //写个数
        final AtomicInteger wc = new AtomicInteger();
        //读线程
        Runnable read = new Runnable() {
            @Override
            public void run() {
                scanFile(file);
                scanFile(exitFile);
            }

            private void scanFile(File file) {
                if(file.isDirectory()){
                    File[] files = file.listFiles(new FileFilter() {
                        @Override
                        public boolean accept(File pathname) {
                            return pathname.isDirectory() || pathname.getPath().endsWith(".java");
                        }
                    });
                    for (File tempFile : files){
                        scanFile(tempFile);
                    }
                }else {
                    //读个数+1
                   int index = rc.incrementAndGet();
                    log.error("Read0:  RC次数"+index+"文件路径: "+file.getPath());
                    try {
                        queue.put(file);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        service.submit(read);

        //4个写线程
        for (int i = 0; i < 4; i++) {
            final int No = i;
            Runnable write = new Runnable() {
                String threadName = "Writer"+No;
                @Override
                public void run() {
                    while(true){
                        try{
                            Thread.sleep(randomTime());
                            int index = wc.incrementAndGet();
                            File file = queue.take();
                            //队列无对象
                            if(file == exitFile){
                                //再次添加标记，防止其他线程正常退出
                                queue.put(exitFile);
                                break;
                            }
                            log.error(threadName+":"+index+" "+file.getPath());
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            };
            service.submit(write);
        }

       // service.shutdown();
    }
}
