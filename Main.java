public class Main {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();

        Runnable timeOne = new Message(7, timer);
        Runnable timeTwo = new Message(5, timer);
        //Runnable timeThree = new Message(1, timer);

        new Thread(timeOne, "timeOne").start();
        new Thread(timeTwo, "timeTwo").start();
        //new Thread(timeThree, "timeThree").start();
        timer.timeCount((Message) timeOne, (Message) timeTwo, 30);
    }

}
