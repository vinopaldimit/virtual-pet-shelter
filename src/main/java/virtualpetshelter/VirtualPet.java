package virtualpetshelter;

public class VirtualPet {
	int hunger = 0;
	int thirst = 0;
	int boredom = 0;

	String appearance = " ^  ^\n(=·.·=)S";
	String desc = "A little kitty cat!";
	String name = "Kitty";

	public VirtualPet(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public VirtualPet(String name, String desc, int hunger, int thirst, int boredom) {
		this.name = name;
		this.desc = desc;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}

	public boolean tick(int ticks) {
		for (int i = 0; i < ticks; i++) {
			hunger++;
			thirst++;
			boredom++;
			
			randomizeTickChange();

			hunger = stayInLimits(hunger);
			thirst = stayInLimits(thirst);
			boredom = stayInLimits(boredom);
		}

		// checks if cat is going to rampage
		//TODO not currently being used
		int maxed = 0;
		if (hunger == 50) {
			maxed++;
		}
		if (thirst == 50) {
			maxed++;
		}
		if (boredom == 50) {
			maxed++;
		}

		if (maxed >= 2) {
			return true;
		}
		return false;
	}

	private void randomizeTickChange() {
		int randomStatChange = (int) (Math.random()*6+1);
		if(randomStatChange==1) {
			hunger += 2;
		} else if(randomStatChange==2) {
			thirst += 2;
		} else if(randomStatChange==3) {
			boredom += 2;
		}
	}

	public void feed() {
		hunger -= 15;
		thirst += 5;
	}

	public void play() {
		boredom -= 15;
		hunger += 5;
		thirst += 5;
	}

	public void giveWater() {
		thirst -= 15;
	}

	public int stayInLimits(int number) {
		if (number > 50) {
			return 50;
		}
		if (number < 0) {
			return 0;
		}
		return number;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getBoredom() {
		return boredom;
	}
}
