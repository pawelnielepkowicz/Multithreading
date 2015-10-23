/**
 * Created by Ja on 23/10/2015.
 */
public class SynchronisationSynchronized {

    private int counter = 0; // atomic integer

    public synchronized void incrementCounter(){
        counter++;

    }


    public SynchronisationSynchronized(){

        System.out.println("SynchronisationSynchronized counter: " + counter);
        makeSomeThreads();
    }
    public void makeSomeThreads(){
        Thread t1 = new Thread(new Runnable() {

            public void run() {
                for(int i = 0; i<10000;i++){
                    incrementCounter();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {

            public void run() {
                for(int i = 0; i<10000;i++){
                    incrementCounter();
                }
            }
        });
        t1.start();
        t2.start();
        try {
           t1.join();
            t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("SynchronisationSynchronized counter: " + counter);

    }





}


