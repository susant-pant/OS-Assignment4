import java.util.*;

public class DSM implements Runnable {
    LocalMemory mem = new LocalMemory();
    BroadcastAgent agent = new BroadcastAgent();

    public int load(int index){
        return mem.load(index);
    }
    public void store(int index, int value) {
        mem.store(index, value);
        agent.broadcast("Updating value of array index %d with value %d", index, value);
    }

    public void run() {}
}