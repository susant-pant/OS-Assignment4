import java.util.*;

public class DSM implements Runnable {
    public LocalMemory localMem;
    public BroadcastAgent broadcastAgent;
    public TokenRingAgent tokenRingAgent;
    
    DSM(BroadcastSystem bs, TokenRingAgent tra, int id){
		localMem = new LocalMemory();
		bs.agentArray[id] = new BroadcastAgent(localMem, bs, id);
        broadcastAgent = bs.agentArray[id];
        tokenRingAgent = tra;
	}

    public int load(int arrayNum, int index){
        return localMem.load(arrayNum, index);
    }
    
    public void store(int arrayNum, int index, int value) {
        while (!tokenRingAgent.hasToken0) {
            try{Thread.sleep(100);}catch(Exception e){}
        }
        broadcastAgent.broadcast(arrayNum, index, value);
    }

    public void run() {/*not being used*/}
}
