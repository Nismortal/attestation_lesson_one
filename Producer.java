import java.util.concurrent.BlockingQueue;

record Producer(BlockingQueue<String> blockingQueue) implements Runnable {

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Producer-> Страдание");
                blockingQueue.put("Страдание");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Producer thread interrupted.");
            }
        }
    }
}