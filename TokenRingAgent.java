import java.util.*;

public class TokenRingAgent implements Runnable {
    boolean active = false;
    boolean hasToken0 = false;
    TokenRing tokenRing;
    int processID;
//    TokenRingAgent RingPredecessor;
//    TokenRingAgent RingSuccessor;

    TokenRingAgent(int id, TokenRing tr) {
        processID = id;
        tokenRing = tr;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void receiveToken() {
        hasToken0 = true;
    }

    public void passToken() {
        hasToken0 = false;
        tokenRing.passToken();
    }

    public void run() {/*not being used*/}
}