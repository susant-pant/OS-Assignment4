import java.util.*;

public class Main {
    public static BroadcastSystem bsMain = new BroadcastSystem();
    public static TokenRing trMain = new TokenRing();

    Main() {
        Thread[] t = new Thread[10];
        for (int id = 0; id < 10; id++) {
            Processor p = new Processor(bsMain, trMain, id);
            trMain.agentArray[id] = p.tokenRingAgent;
            trMain.initTRA(id);

            t[id] = new Thread(p);
        }

        trMain.agentArray[0].receiveToken();

        for (int i = 0; i < 10; i++) {
            t[i].start();
        }
    }

    public static void main(String[] args){
        Main m = new Main();
    }
}