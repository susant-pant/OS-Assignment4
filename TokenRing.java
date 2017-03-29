import java.util.*;

public class TokenRing {
    public static TokenRingAgent[] agentArray;
    public Token token0;
    public int counter = 0;

    TokenRing() {
        agentArray = new TokenRingAgent[10];

        token0 = new Token(counter);
    }

    public void initTRA(int id){
        agentArray[id].setActive(true);
    }

    public void passToken() {
        counter = (counter + 1) % 10;
        agentArray[counter].receiveToken();
    }
}