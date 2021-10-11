public class Message implements Runnable {
    private int time;
    public Timer ch;
    public static boolean fin=false;
    public boolean flag=true;
    Message(int time, Timer ch) {
        this.time=time;
        this.ch=ch;
    }
    public void waitForTime() {
        while(true){
            synchronized (ch) {
                try{
                    while (flag)
                        ch.wait();
                    if (fin) return;
                    if(ch.time%this.time==0)
                    {
                        System.out.println("Thread: "+this.time);
                        flag=true;
                    }
                    flag=true;
                }
                catch(InterruptedException e) {}
            }}
    }
    public void run()  {
        waitForTime();
        System.out.println("The end");
    }
}