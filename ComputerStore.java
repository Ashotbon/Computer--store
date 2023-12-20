//Assignment1
//Ashot Harutyunyan

package Assignment1;

import java.util.Scanner;

public class ComputerStore {

	public static void main(String[] args) {
		int maxComputers = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("===============Welcome to Your Computer Store===============\n");

		do {
			try {
				System.out.print("Enter the maximum number of computers your store can contain: ");
				maxComputers = scanner.nextInt();
				if (maxComputers <= 0) {
					System.out.print("Please enter positive number. \n");
				}
			} catch (Exception e) {
				System.out.print("Exception " + e + " occured. Please enter a positive integer. \n");
			}

			scanner.nextLine();

		} while (maxComputers <= 0);

		Computer[] inventory = new Computer[maxComputers];
		int choice = 0;
		do {
			displayMainMenu();

			do {
				try {
					System.out.print("What do you want to do? ");
					choice = scanner.nextInt();
					if (choice <= 0 || choice > 5) {
						System.out.print("Please enter positive integer between 1-5. \n");
					}
				} catch (Exception e) {
					System.out.print("Exception " + e + " occured. Please enter a positive integer between 1-5 . \n");
				}

				scanner.nextLine();

			} while (choice <= 0 || choice > 5);

			switch (choice) {
			case 1:

				addComputer(inventory, scanner);
				break;
			case 2:

				displayAllComputers(inventory, scanner);
				break;
			case 3:

				findComputersBy(inventory, scanner);
				break;
			case 4:

				findCheaperThan(inventory, scanner);
				break;
			case 5:

				System.out.println("Exiting the Computer Store. Thank you!");
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 5.");
			}
		} while (choice != 5);

		scanner.close();
	}

	private static void displayMainMenu() {
		System.out.println("What do you want to do?");
		System.out.println("1. Enter new computers (password required)");
		System.out.println("2. Change information of a computer (password required)");
		System.out.println("3. Display all computers by a specific brand");
		System.out.println("4. Display all computers under a certain price.");
		System.out.println("5. Quit");
	}

	private static Computer createComputer(Scanner scanner) {
		System.out.print("Enter brand: ");
		String brand = scanner.nextLine();
		System.out.print("Enter model: ");
		String model = scanner.nextLine();

		double price = 0;

		do {
			try {
				System.out.print("Enter price: ");
				price = scanner.nextDouble();

				if (price <= 0) {
					System.out.print("Please enter positive number. \n");

				}
			} catch (Exception e) {
				System.out.print("Exception " + e + " occured. Please enter a positive integer. \n");
			}

			scanner.nextLine();

		} while (price <= 0);

		return new Computer(brand, model, price);
	}

	private static void addComputer(Computer[] inventory, Scanner scanner) {
		final String PASSWORD = "password";
		final int MAX_PASSWORD_TRIES = 3;

		System.out.println("Adding a Computer to the inventory...");

		for (int tries = 1; tries <= MAX_PASSWORD_TRIES; tries++) {
			System.out.print("Enter password (Attempt " + tries + "/" + MAX_PASSWORD_TRIES + "): ");
			String enteredPassword = scanner.nextLine();

			if (enteredPassword.equals(PASSWORD)) {
				System.out.print("Enter the number of computers to add: ");
				int numComputersToAdd = scanner.nextInt();
				scanner.nextLine();

				if (numComputersToAdd <= (inventory.length - Computer.getNumOfComp())) {

					for (int i = 0; i < numComputersToAdd; i++) {

						System.out.println("Adding comps");
						inventory[Computer.getNumOfComp()] = createComputer(scanner);
					}
					return;
				} else {
					System.out.println("There is not enough space to add " + numComputersToAdd + " computers.");
					System.out.println(
							"You can only add " + (inventory.length - Computer.getNumOfComp()) + " more computers.");
					return;
				}

			} else {
				System.out.println("Incorrect password. Please try again.");
			}

		}
	}

	private static void displayAllComputers(Computer[] inventory, Scanner scanner) {

		final String PASSWORD = "password";
		final int MAX_PASSWORD_TRIES = 3;

		for (int tries = 1; tries <= MAX_PASSWORD_TRIES; tries++) {
			System.out.print("Enter password (Attempt " + tries + "/" + MAX_PASSWORD_TRIES + "): ");
			String enteredPassword = scanner.nextLine();

			if (enteredPassword.equals(PASSWORD)) {
				System.out.print("Which computer number you wish to update");
				int compNum = scanner.nextInt();
				scanner.nextLine();
				System.out.print(inventory[compNum - 1] + "kkkkkkk");
				if (inventory[compNum - 1] != null) {
					inventory[compNum - 1].toString();
				}

			} else {
				System.out.println("Incorrect password. Please try again.");
			}

		}
	}

	private static void findComputersBy(Computer[] inventory, Scanner scanner) {
		System.out.println("Enter a brand name: ");

		String brandToSearch = scanner.nextLine();
		boolean found = false;

		System.out.println("\nSearching for Computers with Brand: " + brandToSearch);
		for (Computer computer : inventory) {
			if (computer != null && computer.getBrand().equalsIgnoreCase(brandToSearch)) {
				System.out.println(computer);
				found = true;
			}
		}

		if (!found) {
			System.out.println("No computers found with the specified brand: " + brandToSearch);
		}
	}

	private static void findCheaperThan(Computer[] inventory, Scanner scanner) {

		
		double value = 0;
		boolean found = false;
		
	

		do {
			try {
				System.out.println("Enter value:");
				value = scanner.nextDouble();

				if (value <= 0) {
					System.out.print("Please enter positive number. \n");

				}
			} catch (Exception e) {
				System.out.print("Exception " + e + " occured. Please enter a positive number. \n");
			}

			scanner.nextLine();

		} while (value <= 0);

		System.out.println("\nSearching for Computers cheaper than: " + value);
		for (Computer computer : inventory) {
			if (computer != null && value > computer.getPrice()) {
				System.out.println(computer);
				found = true;
			}
		}

		if (!found) {
			System.out.println("No computers cheaper than " + value + " found: ");
		}
	}

}
