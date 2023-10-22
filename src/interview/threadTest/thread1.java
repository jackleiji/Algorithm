package interview.threadTest;

public class thread1 {
    //构造2个线程，同步i除非定义在同一个函数体内，
    //不然需要考虑线程间的通讯问题
    public static void main(String[] args) {
        Communication comm1 = new Communication();
        Thread t1 = new Thread(comm1);
        Thread t2 = new Thread(comm1);

        t1.start();
        t2.start();

    }
}
class Communication implements Runnable{
    int i=0;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                notify();
                if(i<=100){
                    System.out.println(Thread.currentThread().getName()+":"+i++);
                }else break;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}