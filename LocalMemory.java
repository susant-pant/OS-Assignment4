import java.util.*;

public class LocalMemory {
    public int[] flag; //arrayNum 0
    public int[] turn; //arrayNum 1
    
    LocalMemory() {
		flag = new int[10];
		turn = new int[10];
		for (int i = 0; i < 10; i++){
			flag[i] = -1;
			turn[i] = 0;
		}
	}

    public int load(int arrayNum, int index) {
		if(arrayNum == 0){
			return flag[index];
		}
        else { return turn[index]; }
    }
    
    public void store(int arrayNum, int index, int value) {
		if(arrayNum == 0){
			flag[index] = value;
		}
        else if(arrayNum == 1){
			turn[index] = value;
		}
    }
}
