/**
 * Created by Ja on 22/10/2015.
 */

// second way of creating new thread
class Runner2 implements Runnable{

    @Override
    public void run() {

        for (int i =0; i<10; i++){
            System.out.println("Runner2" +i);
            try{
                Thread.sleep(200);

            }catch (InterruptedException e){

                e.printStackTrace();
            }

        }

    }

}
