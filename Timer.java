public class Timer {
    public int time=0;
    public void timeCount(Message message, Message message1, int cycle) {
        for (int i=0; i<cycle; i++) {
            synchronized(this) {
                time+=1;
                System.out.println(time);
                if (i==cycle-1) Message.fin=true;
                message.flag=false;
                this.notify();
                message1.flag=false;
                this.notify();
                //message2.flag=false;
                //this.notify();
            }
            try {   Thread.sleep(1000);}
            catch (InterruptedException e) {};
        }
    }

}