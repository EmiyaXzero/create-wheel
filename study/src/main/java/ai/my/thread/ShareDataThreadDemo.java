package ai.my.thread;

/**
 * @author shanghang
 * @title: ShareDataThreadDemo
 * @projectName create-wheel
 * @description: 共享多线程实例
 * @date 2020/8/15-15:55
 */
public class ShareDataThreadDemo implements Runnable{
    private ShareData shareData;

    ShareDataThreadDemo(ShareData shareData){
        this.shareData = shareData;
    }

    @Override
    public void run() {
        this.shareData.add();
    }


    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        ShareDataThreadDemo shareDataThreadDemo = new ShareDataThreadDemo(shareData);
        for (int i = 0;i<40;i++){
            Thread t = new Thread(shareDataThreadDemo,"Thread"+i);
            t.start();
        }
    }
}

