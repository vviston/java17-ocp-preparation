package cz.ronko.multithreading;

// we can also extend Thread but then we cannot extend any other method
public class MultithreadThingRunnable implements Runnable {

    private final int threadNumber;

    public MultithreadThingRunnable (int threadNumber) {
        this.threadNumber = threadNumber;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " from thread: " + threadNumber);
            // if one thread dies other will continue to process normally
            /*if (threadNumber == 3) {
                throw new RuntimeException();
            }*/
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getThreadNumber() {
        return threadNumber;
    }
}
