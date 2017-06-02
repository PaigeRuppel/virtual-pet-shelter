package week3project;

public class VirtualPet {

	String name;
	String type;
	String description;
	int hunger;
	int thirst;
	int boredom;

	public VirtualPet(String name, String type) {
		this.name = name;
		this.type = type;
		hunger = 50;
		thirst = 60;
		boredom = 55;

	}

	public VirtualPet(String name, String breed, int hunger, int thirst, int boredom) {
		this.name = name;
		this.type = breed;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}

	public String giveDescription(String description) {
		this.description = description;
		return this.description;
	}

	public String indPetStats() {

		return name  + "\t\t | \t " + hunger + "\t\t\t | \t " + thirst + "\t\t | \t " + boredom;
	}

	@Override
	public String toString() {
		return name + " the " + type + description;
	}

	public String getName() {
		return name;
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

	void giveFood() {
		hunger = hunger - 20;
	}

	void giveWater() {
		thirst = thirst - 20;
	}

	void playWith() {
		boredom = boredom - 20;
	}
}
