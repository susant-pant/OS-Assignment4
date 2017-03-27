import java.util.*;

public class BroadcastAgent {
    BroadcastSystem bs = new BroadcastSystem();

    public void broadcast(String message){
        bs.transmit();
    }
    public void receive(){}
}