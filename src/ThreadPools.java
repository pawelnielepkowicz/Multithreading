import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ja on 23/10/2015.
 */


class Processor implements Runnable{
    private int id;

    Processor(int id){

        this.id=id;

    }

    @Override
    public void run() {

        System.out.println("ThreadPools starting " + id);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("ThreadPools finished " + id);

    }
}

public class ThreadPools {
    ThreadPools(){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i<5; i++){
            executor.submit(new Processor(i));
        }
        executor.shutdown();

        try{
            executor.awaitTermination(15, TimeUnit.SECONDS); //shuts down theese threads after max 15 seconds
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void init(){


    }
}
