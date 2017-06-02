package week3project;

import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		VirtualPetShelter myShelter = new VirtualPetShelter();

		VirtualPet bear = new VirtualPet("Bear", "black pomeranian", 40, 40, 40);
		bear.giveDescription(" is a cute but nervous little guy who needs a lot of love.");

		VirtualPet kali = new VirtualPet("Kali", "tortoise-shell kitty");
		kali.giveDescription(" is a feisty cat who gets what she wants");

		VirtualPet mrkitty = new VirtualPet("Bill", "20 lb maine coon cat", 75, 50, 35);
		mrkitty.giveDescription(" looks like he needs to go on a diet...");

		VirtualPet precious = new VirtualPet("Sue", "white American bulldog", 70, 50, 50);
		precious.giveDescription(" is a \"uniquely\" beautiful girl who loves children");

		myShelter.intake(bear);
		myShelter.intake(kali);
		myShelter.intake(mrkitty);
		myShelter.intake(precious);
		//
		writeLine("Welcome to Paige's Pet Palace!");
		writeLine("Here is a list of the current pets in this shelter and their current stats:");
		writeLine(myShelter.petRoster());

		writeLine("Are you ready to love and care for all of these pets? Type yes to begin.");
		String beginOption = input.nextLine();
		if (beginOption.toLowerCase().equals("yes")) {

			writeLine(
					"As caretaker of this shelter, you must care for the pets and play close attention to their individual needs.");
			writeLine("");
			callMenu();
		}

		do {
			writeLine("What would you like to do with your pets?");
			String command = input.nextLine();

			// checkForQuit - write this method;

			if (command.toLowerCase().equals("roster")) {
				writeLine(myShelter.petRoster());
			} else {
				switch (command) {
				case ("1"):
					myShelter.feedAll();
					break;
				case ("2"):
					myShelter.waterAll();
					break;
				case ("3"):
					myShelter.playWithAll();
					break;
				case ("4"):
					writeLine(
							"You've chosen to play with a pet individually. Here are all of the current pets in the shelter and their descriptions: ");
					writeLine(myShelter.petDescriptions());
					writeLine("Type the name of the pet you want to play with individually: ");
					String individualPet = input.nextLine();
					myShelter.playWith(individualPet);
					break;
				case ("5"):
					writeLine("Okay, which pet would you like to adopt out?");
				case ("6"):
					writeLine("A new pet! How exciting!");
					writeLine("Please give your pet a name");
					writeLine("Please give your pet a description");
				}

			}
			myShelter.tick();
			writeLine(myShelter.petRoster());
		

		} while (!myShelter.shelterPets.isEmpty());
	}

	public static void writeLine(String message) {
		System.out.println(message);
	}

	public static void callMenu() {
		writeLine(
				"These are the commands to take care of your pets \n -to execute the command simply type the number listed next to the command:");
		writeLine("1. Feed all the pets (decreases hunger)");
		writeLine("2. Water all the pets (decreases thirst");
		writeLine("3. Play with all the pets (decreases boredom)");
		writeLine("4. Select an individual pet to play with one-on-one");
		writeLine("5. Adopt out a pet to their forever home.");
		writeLine("6. Intake a new pet into the shelter.");
	}

}
