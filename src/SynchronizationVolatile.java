/**
 * Created by Ja on 23/10/2015.
 */
public class SynchronizationVolatile extends Thread {

    // volatile - prevents thread from caching running variable
    private volatile boolean running = true;

    public void run(){

        while(running){

            System.out.println("Synchronization");
            try{

                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }

    }

    public void stopThread(){

        running=false;
    }

}
