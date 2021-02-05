import java.util.HashSet;
import java.util.Random;

public class Game {
    private HashSet<Integer> winningLotNumbers;
    private Random random = new Random();
    private static final int numsPerLotto = 5;

    public void winningLotNumber(){
        winningLotNumbers = new HashSet<>();
        while (winningLotNumbers.size()<numsPerLotto) winningLotNumbers.add(random.nextInt(43));
    }

    public int getMatchingNum(Player p){
        int ans =0;
        for(int i = 0; i<numsPerLotto; i++) if(winningLotNumbers.contains(p.getLotNums().toArray()[i])) ans+=1;
        return ans;
    }

    public float monetaryGain(Player p){
        final int num = getMatchingNum(p);
        if(num == 2) return 1f;
        if(num == 3) return 10.86f;
        if(num == 4) return 197.53f;
        if(num == 5) return 212534.83f;
        return -1f;
    }
}
