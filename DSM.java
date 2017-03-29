import java.util.*;

public class DSM implements Runnable {
    public LocalMemory localMem;
    public BroadcastAgent agent;
    
    DSM(BroadcastSystem bs, int id){
		localMem = new LocalMemory();
		bs.agentArray[id] = new BroadcastAgent(localMem, bs, id);
        agent = bs.agentArray[id];
	}

    public int load(int arrayNum, int index){
        return localMem.load(arrayNum, index);
    }
    
    public void store(int arrayNum, int index, int value) {
        agent.broadcast(arrayNum, index, value);
    }

    public void run() {/*not being used*/}
}
