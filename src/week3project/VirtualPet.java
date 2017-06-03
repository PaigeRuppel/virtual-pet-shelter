package week3project;

public class VirtualPet {

	String name;
	String type;
	String description;
	int hunger;
	int thirst;
	int boredom;
	int social;

	// all constructors set social to 0 upon creation of a new VirtualPet
	// constructor that only accepts  name and type
	public VirtualPet(String name, String type) {
		this.name = name;
		this.type = type;
		hunger = 50;
		thirst = 60;
		boredom = 55;
		social = 0;
	}

	// constructor that accepts name, type and description
	public VirtualPet(String name, String type, String description) {
		this.name = name;
		this.type = type;
		this.description = description;
		hunger = 50;
		thirst = 60;
		boredom = 55;
		social = 0;
	}

	// constructor that accepts name, type, and need levels
	public VirtualPet(String name, String type, int hunger, int thirst, int boredom) {
		this.name = name;
		this.type = type;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
		social = 0;
	}

	// giveDescription method if not included as part of construction
	public String giveDescription(String description) {
		this.description = description;
		return this.description;
	}

	// individual roster/stat line for all pets
	public String indPetStats() {
		return name + "\t\t | \t " + hunger + "\t\t\t | \t " + thirst + "\t\t | \t " + boredom + "\t\t\t | \t "
				+ social;
	}

	@Override
	public String toString() {
		return name + " the " + type + " " + description;
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

	// all VirtualPet need levels are confined within the range of 0-100
	void giveFood() {
		hunger = hunger - 20;
		if (hunger < 0) {
			hunger = 0;
		}
		if (hunger < 0) {
			hunger = 0;
		}
	}

	void giveWater() {
		thirst = thirst - 20;
		if (thirst < 0) {
			thirst = 0;
		}
		if (thirst < 0) {
			thirst = 0;
		}
	}

	void playWith() {
		boredom = boredom - 20;
		if (boredom < 0) {
			boredom = 0;
		}
		if (boredom > 100) {
			boredom = 100;
		}
	}

	void playInd() {
		boredom = boredom - 20;
		social = social + 1;

		if (boredom < 0) {
			boredom = 0;
		}
		if (boredom > 100) {
			boredom = 100;
		}
	}

	boolean hasSocialized() {
		return social >= 5;
	}

}


// (note for stretch //class hungry pet extends virtual pet)
