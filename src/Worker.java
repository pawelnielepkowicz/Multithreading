import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ja on 23/10/2015.
 */
public class Worker {

    private Random randomInt = new Random();

    private Object lock1 = new Object();
    private Object lock2 = new Object();


    private List<Integer> listInt1 = new ArrayList<Integer>();
    private List<Integer> listInt2 = new ArrayList<Integer>();


// two threads working simultaneously, on different lock objects, super fast and safe!
    public  void stageOne() {

        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listInt1.add(randomInt.nextInt(50));
        }
    }


    public synchronized void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listInt2.add(randomInt.nextInt(50));
        }
    }


    public  void process() {

        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }

    }


    public void work() {

        System.out.println("Worker started working :)");

        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Worker did its job in: " + (end - start) + " miliseconds");
        System.out.println("listInt1.size(): " + listInt1.size());
        System.out.println("listInt2.size(): " + listInt2.size());
    }

}
