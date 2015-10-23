import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ja on 23/10/2015.
 */

class ProcessorLatch implements  Runnable{

    private CountDownLatch latch; // thread save counter

    ProcessorLatch(CountDownLatch latch){

        this.latch=latch;

    }

    @Override
    public void run() {
        System.out.println("ProcessorLatch started " + System.currentTimeMillis());
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        latch.countDown();
    }
}


public class CountdownLatches {

    CountdownLatches(){

        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i<5; i++){
            executor.submit(new ProcessorLatch(latch));
        }
        try{
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("ProcessorLatch finished " + System.currentTimeMillis());

    }

}
