package week3project;

import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		VirtualPetShelter myShelter = new VirtualPetShelter();

		VirtualPet bear = new VirtualPet("Bear", "black pomeranian", 40, 40, 40);
		bear.giveDescription("is a cute but nervous little guy who needs a lot of love.");

		VirtualPet kali = new VirtualPet("Kali", "tortoise-shell kitty", "is a feisty cat who gets what she wants");

		VirtualPet mrkitty = new VirtualPet("Bill", "20 lb maine coon cat", 75, 50, 35);
		mrkitty.giveDescription("looks like he needs to go on a diet...");

		VirtualPet precious = new VirtualPet("Sue", "white American bulldog", 70, 50, 50);
		precious.giveDescription("is a \"uniquely\" beautiful girl who loves children");

		//default list of pets added to the shelter roster
		myShelter.intake(bear);
		myShelter.intake(kali);
		myShelter.intake(mrkitty);
		myShelter.intake(precious);

		writeLine("Welcome to Paige's Pet Palace!");
		writeLine("- This is a virtual pet shelter - the goal is to care for all of these homeless pets.");
		writeLine("- Caring for the pets is carried out by following the command menu.");
		writeLine("- Keep your pets needs low to keep them happy :)");
		writeLine("- To win this game, you must adopt out all of the pets in the shelter!");
		writeLine("- To place a shelter pet in its forever home, it must be properly socialized.");
		writeLine(
				" - A pet is properly socialized when this level reaches \'5\' (all pets begin with a social level of \'0\').");
		writeLine("Are you ready to love and care for all of these pets? Type yes to begin.");
		String beginOption = input.nextLine();
		if (beginOption.toLowerCase().equals("yes")) {
			writeLine(
					"As caretaker of this shelter, you must care for the pets and play close attention to their individual needs.");
			writeLine("Good luck! (If you wish to quit at any time, simply type \"quit\").");
		} else {
			writeLine("Come back when you are ready to take care of Paige's Pet Palace!");
		}

		// loop will run as long as pets are in the shelter (game ends when all pets are adopted out)
		while (!myShelter.shelterPets.isEmpty()) {
			writeLine("Current pets in Paige's Pet Palace: ");
			writeLine(myShelter.petRoster()); // calls roster method to build the pet/stat menu
			writeLine("What would you like to do with your pets?");
			callMenu();
			String command = input.nextLine();

			// must type "quit" - this prevents accidentally pressing a wrong
			// number and losing your progress
			checkForQuit(command);

			switch (command) {
			case ("1"):
				// decreases hunger for all pets
				myShelter.feedAll();
				break;
			case ("2"):
				// decreases thirst for all pets
				myShelter.waterAll();
				break;
			case ("3"):
				// decreases boredom for all pets
				myShelter.playWithAll();
				break;
			case ("4"):
				// play with a pet individually - this is the only way to build
				// the social level, also decreases boredom for that individual
				// pet
				writeLine(
						"You've chosen to play with a pet individually. ");
				System.out.println(myShelter);
				writeLine("Type the name of the pet you want to play with individually: ");

				String individualPet = input.nextLine();

				myShelter.playWith(individualPet.toLowerCase());
				break;
			case ("5"):
				// adopt out option - pet must have a social level of 5 or
				// greater to be adopted out
				writeLine(
						"You have chosen to adopt out one of your pets! ");
				System.out.println(myShelter);
				writeLine("Type the name of the pet you want to send to its forever home: ");

				String adoptPet = input.nextLine();
				writeLine(myShelter.adoptOut(adoptPet.toLowerCase()));

				break;
			case ("6"):
				// intakes a new pet - constructor accepts the three user inputs
				// of name, type, and description
				writeLine("A new pet! How exciting!");
				writeLine("Please give your pet a name: ");

				String newPet = input.nextLine();
				writeLine("Please provide the pet's breed (i.e. golden retriever, tabby  cat, etc.): ");

				String newType = input.nextLine();
				writeLine("Now give " + newPet + " a short description (about one sentence.): ");

				String newDescrip = input.nextLine();

				VirtualPet a = new VirtualPet(newPet, newType, newDescrip);
				myShelter.intake(a);
				writeLine("You have succesfully added " + a + " to the shelter!");
				break;
			}
			// increases need levels for all pets
			myShelter.tick();
		}

		input.close();

		writeLine("You have sucessfully adopted out all of the pets! Congrats!");
	}

	public static void writeLine(String message) {
		System.out.println(message);
	}

	public static void callMenu() {
		writeLine(
				"These are the commands to take care of your pets \n -to execute the command simply type the number listed next to the command:");
		writeLine("1. Feed all the pets (decreases hunger)");
		writeLine("2. Water all the pets (decreases thirst)");
		writeLine("3. Play with all the pets (decreases boredom)");
		writeLine("4. Select an individual pet to play with one-on-one (decreases boredom and boosts social level)");
		writeLine("5. Adopt out a pet to their forever home.");
		writeLine("6. Intake a new pet into the shelter.");
	}

	public static void checkForQuit(String input) {
		if (input.equalsIgnoreCase("quit")) {
			writeLine("The shelter will miss you! Goodbye.");
			System.exit(0);
		}
	}

}
