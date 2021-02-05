import java.util.*;

class Player{
	private PlayerKind kind;
	private float money;
	private ArrayList<Float> moneyOverTime;
    private Random random = new Random();
	private int red, green, blue;
	private HashSet<Integer> playerNums;
	private static final int numsPerLotto = 5;

	public Player(PlayerKind pK, float startFunds) {
		kind = pK;
		money = startFunds;
		moneyOverTime = new ArrayList<Float>();
		moneyOverTime.add(startFunds);
		red = random.nextInt(100);
		green = random.nextInt(100);
		blue = random.nextInt(100);
		if (kind == PlayerKind.WELL_PAID) red += 100;
		else blue += 100;
	}

	public int getR() { return red; }
	public int getG() { return green; }
	public int getB() { return blue; }
	public float getMoney() { return money; }
	public void addMoney(float money) { this.money += money; }
	public PlayerKind getKind() { return kind; }
	public ArrayList<Float> getFunds() { return moneyOverTime; }

	public void updateMoneyEachYear() {
		moneyOverTime.add(money);
	}

	public void generateNewNums(){
		playerNums = new HashSet<>();
		while (playerNums.size()<numsPerLotto) playerNums.add(random.nextInt(43));
	}

	public HashSet<Integer> getLotNums(){
		return playerNums;
	}


}
