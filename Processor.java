import java.util.*;

public class Processor implements Runnable {
    public DSM dsm;
    public int processID;
    
	Processor (BroadcastSystem bs, int id){
		dsm = new DSM(bs, id);
		processID = id;
	}

    public void run() {
        boolean exists = false;
		for (int k = 0; k < 8; k++) {
			dsm.store(0, processID, k);
			dsm.store(1, k, processID);
			do {
				exists = false;
				for (int j = 0; j < 10; j++) {
					if (j != processID) {
						if((dsm.load(0, j)) >= k) {
							exists = true;
                            try{Thread.sleep(1);}catch(Exception e){}
							break;
						}
					}
				}
			} while (exists && (dsm.load(1, k) == processID));
		}
        System.out.printf("Process %d: In critical section\n", processID);
        for(int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            System.out.printf("Process %d: Still in critical section\n", processID);
        }
		dsm.store(0, processID, -1);
        System.out.printf("Process %d: Exiting critical section\n", processID);
	}
}
