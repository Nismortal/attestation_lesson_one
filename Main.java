import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

        Thread producer = new Thread(new Producer(blockingQueue));

        Thread consumer = new Thread(new Consumer(blockingQueue));

        producer.start();
        consumer.start();
        while (producer.isAlive()) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ignored) {
            }
        }
        System.exit(0);

    }
}
