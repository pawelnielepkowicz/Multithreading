import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Ja on 23/10/2015.
 */
public class ProducerConsumer {

    ProducerConsumer() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               try{
                   producer();
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    consumer();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();


            t1.join();
            t2.join();



    }



    // thread safe FIFO queue
    private static BlockingQueue<Integer> myQue = new ArrayBlockingQueue<Integer>(10);

    private  static void producer() throws InterruptedException{

        Random random = new Random();

        while (true){
            System.out.println("producer: just put new stuff to the myQueue" + myQue.size());
            myQue.put(random.nextInt(100)); // (0-99)
        }
    }

    private static void consumer() throws  InterruptedException{

        Random random = new Random();

        while (true){
            try {
                Thread.sleep(100);

                if (random.nextInt(10) == 0){ // on average once every 1,5 seconds this will take of from myQueue
                    Integer value = myQue.take();
                    System.out.println("Taken Value: " + value + "myQueue size is: " + myQue.size());

                }

            } catch (InterruptedException e) {
                e.printStackTrace();


            }
        }

    }


}
