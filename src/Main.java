import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");

        Runner1 runner1 = new Runner1();
        runner1.start();

        Runner1 runner2 = new Runner1();
        runner2.start();

        SynchronizationVolatile bs = new SynchronizationVolatile();
        bs.start();


        Thread t1 = new Thread(new Runner2());
        t1.start();


        new SynchronisationSynchronized();

       /*  System.out.println("Press return key to stop BasicSynchronization Thread");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();*/

        bs.stopThread();

        new Worker().work();


        new ThreadPools();
        new CountdownLatches();


        new ProducerConsumer();

    }
}
