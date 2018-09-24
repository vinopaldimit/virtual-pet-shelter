package virtualpetshelter;

import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the cat shelter!\n");
		// set up
		Scanner in = new Scanner(System.in);
		VirtualPetShelter shelter = new VirtualPetShelter();
		shelter.admitPet(new VirtualPet("Missy", "A mischievous looking calico."));
		shelter.admitPet(new VirtualPet("Bailey", "A black cat luxuriating in the sun."));
		shelter.admitPet(new VirtualPet("Marvin the Destroyer",
				"He sits in the corner, meows crackling like static. It looks like his eyes are glowing red..."));
		shelter.admitPet(new VirtualPet("Bill", "A shy calico."));

		// game loop
		String choice;
		do {
			shelter.tick(2);
			
			showAllPets(shelter);
			
			// menu
			System.out.println("What would you like to do?\n");
			System.out.println("1. Feed the pets");
			System.out.println("2. Water the pets");
			System.out.println("3. Play with a pet");
			System.out.println("4. Adopt a pet");
			System.out.println("5. Admit a pet");
			System.out.println("6. Quit");

			choice = in.nextLine();

			switch (choice) {
			case "1":
				System.out.println("You feed them.\n");
				shelter.feedPets();
				break;
			case "2":
				System.out.println("You give them water.\n");
				shelter.waterPets();
				break;
			case "3":
				System.out.println("Which would you like to play with?");
				choice = in.nextLine();
				shelter.playWith(choice);
				System.out.println("You play with " + choice + ". So much fun!\n");
				break;
			case "4":
				System.out.println("Which would you like to adopt?");
				choice = in.nextLine();
				shelter.adopt(choice);
				System.out.println("Congrats on your new pet " + choice + "!\n");
				break;
			case "5":
				System.out.println("What is the cat's name?");
				String newName = in.nextLine();
				System.out.println("Describe the cat.");
				String newDesc = in.nextLine();
				shelter.admitPet(new VirtualPet(newName, newDesc));
				System.out.println("Thank you for bringing this cat to the shelter.\n");
				break;
			default:
				break;
			}
		} while (!choice.equals("6"));
		
		System.out.println("Thanks for stopping by.");
		
		in.close();
	}

	private static void showAllPets(VirtualPetShelter shelter) {
		for(VirtualPet current : shelter.pets.values()) {
			System.out.println(current.getName() + " - " + current.getDesc());
			System.out.println("\tHunger: " + current.getHunger() + " Thirst: " + current.getThirst() + " Boredom: " + current.getBoredom() + "\n");
		}
	}

}
