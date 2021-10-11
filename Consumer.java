import java.util.concurrent.BlockingQueue;

record Consumer(BlockingQueue<String> blockingQueue) implements Runnable {

    public void run() {
        while (true) {
            try {
                System.out.println("Consumer-> " + blockingQueue.take());
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Consumer thread interrupted.");
            }
        }
    }
}
