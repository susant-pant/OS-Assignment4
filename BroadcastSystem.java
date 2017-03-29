import java.util.*;

public class BroadcastSystem implements Runnable {
    public static BroadcastAgent[] agentArray;
    
    BroadcastSystem() {
        agentArray = new BroadcastAgent[10];
	}

    public void transmit(int arrayNum, int index, int value) {
        for (int i = 0; i < 10; i++) {
			agentArray[i].receive(arrayNum, index, value);
        }
    }

    public void run() {/*not being used*/}
}
