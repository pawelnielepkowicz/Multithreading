/**
 * Created by Ja on 22/10/2015.
 */
// first way of creating new thread
public class Runner1 extends Thread {

    @Override
    public void run() {

        for (int i =0; i<10; i++){
            System.out.println("Runner1" + i);
            try{
                Thread.sleep(200);

            }catch (InterruptedException e){

                e.printStackTrace();
            }

        }

    }
}
