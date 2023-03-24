package cz.ronko.multithreading;

public class Multithreading {

    public static void main(String[] args) {
        // with "implements Runnable" we need to manually create Thread and
        // assign the Runnable object inside
        for (int i = 0; i <= 3; i++) {
            MultithreadThingRunnable myThing = new MultithreadThingRunnable(i);
            Thread thread = new Thread(myThing);
            thread.start();
            try {
                // waits for this thread to die (let this thread do all it's work first, let it die and continue in processing)
                if (myThing.getThreadNumber() == 0) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // main thread exception - others still continue to work
        throw new RuntimeException();

        /*// here we can directly call start() on the Thread object
        for (int i = 0; i <=3; i++) {
            MultithreadThingThread myThing = new MultithreadThingThread(i);
            myThing.start();
        }*/


    }

}
