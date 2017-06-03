package week3project;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VirtualPetShelter {

	Map<String, VirtualPet> shelterPets = new HashMap<>();

	public String petRoster() {
		String menu = "Name     \t | \t Hunger  \t | \t Thirst  \t | \t Boredom \n ------------------------------------------------------------";
		String menuLine = "";

		for (VirtualPet entry : shelterPets.values()) {
			menuLine = entry.indPetStats();
			menu = menu + "\n" + menuLine;
		}
		return menu;
	}

	public String petDescriptions() {
		String description = "Here are your current pets: \n";
		for (VirtualPet current : shelterPets.values()) {
			description = description + current.toString() + "\n";
		}
		return description;
	}

	public void intake(VirtualPet pet) {
		shelterPets.put(pet.getName().toLowerCase(), pet);
	}

	public void userIntake(VirtualPet pet) {
		shelterPets.put(pet.getName(), pet);
	}
	public void adoptOut(String pet) {
		
		shelterPets.remove(pet);
		System.out.println(pet + "has found their forever home!");
	}

	public void feedAll() {
		for (VirtualPet current : shelterPets.values()) {
			current.giveFood();
		}
	}

	public void waterAll() {
		for (VirtualPet current : shelterPets.values()) {
			current.giveWater();
		}
	}

	public void playWithAll() {
		for (VirtualPet current : shelterPets.values()) {
			current.playWith();
		}
	}

	public void playWith(String pet) {
		for (VirtualPet current : shelterPets.values()) {
			if (shelterPets.containsKey(pet)) {
				current.playWith();
			} // convert key to lowercase
		}
	}

	public void tick() {
		for (VirtualPet current : shelterPets.values()) {
			current.hunger = current.hunger + 5;
			current.thirst = current.thirst + 5;
			current.boredom = current.boredom + 5;
		}
	}
}