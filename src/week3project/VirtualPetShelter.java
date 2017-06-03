package week3project;

import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> shelterPets = new HashMap<String, VirtualPet>();

	// provides column headers for menu and calls ind roster lines from VirtualPet to build pet roster/stats
	public String petRoster() {
		String menu =  "Name     \t | \t Hunger  \t | \t Thirst  \t | \t Boredom \t | \t Social \n --------------------------------------------------------------------------";
		String menuLine = "";

		for (VirtualPet entry : shelterPets.values()) {
			menuLine = entry.indPetStats();
			menu = menu + "\n" + menuLine;
		}
		return menu;
	}
	
	
	@Override
	public String toString() {
		String description = "Here are your current pets: \n";
		for (VirtualPet current : shelterPets.values()) {
			description = description + current.toString() + "\n";
		}
		return description;
	}

	public void intake(VirtualPet pet) {
		shelterPets.put(pet.getName().toLowerCase(), pet);
	}

	public VirtualPet getPet(String name) {
		return shelterPets.get(name.toLowerCase());
	}

	public void intakeUser(VirtualPet pet) {
		shelterPets.put(pet.getName(), pet);
	}

	public String adoptOut(String pet) {
		pet = pet.toLowerCase();
		String message = " ";
		if (getPet(pet).hasSocialized()) {
			shelterPets.remove(pet);
			message = "You have sucessfully placed a pet in their forever home!";
		} else {
			message = getPet(pet).getName()
					+ " has not been socialized enough to find a forever home. Try playing with them individually to boost their social stats.";
		}
		return message;
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
		getPet(pet).playInd();
	}

	public void tick() {
		for (VirtualPet current : shelterPets.values()) {
			current.hunger = current.hunger + 5;
			current.thirst = current.thirst + 5;
			current.boredom = current.boredom + 5;
		}
	}
}