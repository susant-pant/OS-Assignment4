import java.util.*;

public class BroadcastAgent {
	public LocalMemory localMem;
	public static BroadcastSystem bsMain;
    public int bsIndex;
    
    BroadcastAgent(LocalMemory mem, BroadcastSystem bs, int id) {
		localMem = mem;
		bsMain = bs;
        bsIndex = id;
	}

    public void broadcast(int arrayNum, int index, int value){
        bsMain.transmit(arrayNum, index, value);
    }
    
    public void receive(int arrayNum, int index, int value) {
		localMem.store(arrayNum, index, value);
	}
}
