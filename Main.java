import java.util.*;

public class Main {
    public static BroadcastSystem bsMain = new BroadcastSystem();

    Main() {
        Thread[] t = new Thread[10];
        for (int id = 0; id < 10; id++) {
            t[id] = new Thread(new Processor(bsMain, id));
        }
        for (int i = 0; i < 10; i++) {
            t[i].start();
        }
    }

    public static void main(String[] args){
        Main m = new Main();
    }
}