package interview.threadTest;

public class threadQ2 {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Consumer consumer  = new Consumer(clerk);
        Productor productor = new Productor(clerk);
        Thread thread1 = new Thread(consumer);
        Thread thread2 = new Thread(productor);
        thread1.start();
        thread2.start();
    }
}
//中间商销售生产产品给消费者
class Clerk{
    private int produce = 0;
    public synchronized void addProduce(){
        produce++;
        if(produce>=20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产者生产了第"+produce+"个产品");
        notifyAll();//开启所有等等线程
    }
    public synchronized void getproduce(){
        System.out.println("消费者消费了第"+produce+"个产品");
        produce--;
        if(produce<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
    }

}



//消费者消费产品
class Consumer implements Runnable{
    Clerk clerk;
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费");
        while (true){
            try {
                Thread.sleep((int) (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduce();
        }
    }
}

//构造生产者线程
class Productor implements Runnable{
    Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产");
        while (true){
            try {
                Thread.sleep((int) (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.getproduce();
        }
    }
}