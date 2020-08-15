package ai.my.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shanghang
 * @title: ShareData
 * @projectName create-wheel
 * @description: 共享变量
 * @date 2020/8/15-15:58
 */
@Slf4j
class ShareData {
    private int current = 0;
    private final int target = 30;
    public synchronized void add(){
        if(current <=target){
            current++;
        }
        log.error(current+" "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
    }
}
