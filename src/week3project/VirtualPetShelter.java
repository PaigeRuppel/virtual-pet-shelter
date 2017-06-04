package week3project;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> shelterPets = new HashMap<>();

	// provides column headers for menu and calls ind roster lines from
	// VirtualPet to build pet roster/stats
	public String petRoster() {
		String menu = "Name     \t | \t Hunger  \t | \t Thirst  \t | \t Boredom \t | \t Social \n --------------------------------------------------------------------------";
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

	public VirtualPet getCurrentPets() {
		return shelterPets.get(shelterPets);
	}

	public void intakeUser(VirtualPet pet) {
		shelterPets.put(pet.getName(), pet);
	}

	public String adoptOut(String pet) {
		String message = " ";
		if (getPet(pet.toLowerCase()).hasSocialized()) {
			shelterPets.remove(pet);
			message = "You have sucessfully placed " + getPet(pet).getName() + " in their forever home!";
		} else {
			message = getPet(pet).getName() + " has not been socialized enough to find a forever home. Try playing with"
					+ getPet(pet).getName() + "individually to boost their social stats.";
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

	public String playWith(String pet) {
		String message = "You have succesfully raised the social level of " + getPet(pet).name + " by 1! ";
		getPet(pet).playInd();
		return message;
	}

	// a lot of trial and error with this method - eventually consulted
	// stackoverflow and found how to iterate over a set and remove a value
	// using Iterator
	boolean hasDied() {

		boolean deathOccurred = false;

		Iterator<Map.Entry<String, VirtualPet>> it = shelterPets.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, VirtualPet> entry = it.next();
			if (entry.getValue().isDead()) {
				it.remove();
				deathOccurred = true;
			}
		}
		// nested if/else within this boolean method - tried to make it
		// return a string, but could not get it to return the correct
		// message - this is probably messier than it should be
		if (deathOccurred && shelterPets.isEmpty()) {
			System.out.println(
					"The shelter is empty because your last pet has died!!! The ASPCA has been notified of your whereabouts.");
			System.exit(0);
		} else if (deathOccurred) {
			System.out.println("One or more of your pets has died! Pay closer attention to their needs!");
		} else {
			System.out.println("Continue closely monitoring the needs of your pets!");
		}
		return deathOccurred;
	}

	// duplicated the logic from hasDied() above to check on hunger, thirst, and
	// boredom
	// had it working with an enhanced for loop, but it was glitchy, found that
	// this was a better way
	// again, couldn't get it to return the right message as a return type
	// string..
	public boolean areHungry() {
		boolean hunger = false;
		Iterator<Map.Entry<String, VirtualPet>> it = shelterPets.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, VirtualPet> entry = it.next();
			if (entry.getValue().isHungry()) {
				hunger = true;
				System.out.println("One or more of your pets is getting hungry...");
				break;
			}
		}
		return hunger;
	}

	public boolean areThirsty() {
		boolean thirst = false;
		Iterator<Map.Entry<String, VirtualPet>> it = shelterPets.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, VirtualPet> entry = it.next();
			if (entry.getValue().isThirsty()) {
				thirst = true;
				System.out.println("One or more of your pets is getting thirsty...");
				break;
			}
		}
		return thirst;
	}

	public boolean areBored() {
		boolean bored = false;
		Iterator<Map.Entry<String, VirtualPet>> it = shelterPets.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, VirtualPet> entry = it.next();
			if (entry.getValue().isBored()) {
				bored = true;
				System.out.println("One or more of your pets is getting bored...");
				break;
			}
		}
		return bored;
	}

	public void tick() {
		for (VirtualPet current : shelterPets.values()) {
			current.hunger = current.hunger + 5;
			current.thirst = current.thirst + 5;
			current.boredom = current.boredom + 5;
		}
	}
}