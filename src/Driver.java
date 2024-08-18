// Carlos Bracho

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    // Creating Monkey and Dog Lists
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {
        // Creating Scanner Object
        Scanner scanner = new Scanner(System.in);

        initializeDogList();
        initializeMonkeyList();

        // While loop for Menu display and input validation
        while (true) {
            displayMenu();
            String optionChoice = scanner.nextLine().toLowerCase();

            switch (optionChoice) {
                // Case 1: Input new dog
                case "1":
                    intakeNewDog(scanner);
                    break;

                // Case 2: Intake a new monkey
                case "2":
                    intakeNewMonkey(scanner);
                    break;

                // Case 3: Reserve an animal
                case "3":
                    reserveAnimal(scanner);
                    break;

                // Case 4: Print a list of all dogs
                case "4":
                    printAnimals(/*"dog"*/);
                    break;

                // Case 5: Print a list of all monkeys
                case "5":
                    printAnimals(/*"monkey"*/);
                    break;

                // Case 6: Print a list of all animals that are not reserved
                case "6":
                    printAnimals(/*"available"*/);
                    break;

                // Quit application:
                case "q":
                    System.out.println("Exiting application...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Method for printing the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "in service", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Camille", "Squirrel monkey", "female", "5", "30.2", "10-12-2022", "Venezuela", "in service", false, "United States", 0.32, 1.13, 1.12);
        Monkey monkey2 = new Monkey("Coco", "Guenon", "female", "4", "4.0", "04-20-2021", "Kenya", "Phase I", false, "United States", 35.0, 45.0, 55.0);

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
    }

    // OPTION 1 IN MENU "Intake a new dog"
    public static void intakeNewDog(Scanner scanner) {

        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Adding the rest of the attributes to the new dog
        // Using "try" and "catch" for error management
        try {
            System.out.println("What is the dog's breed?");
            String breed = scanner.nextLine();

            System.out.println("What is the dog's gender?");
            String gender = scanner.nextLine();

            System.out.println("What is the dog's age?");
            String age = scanner.nextLine();

            System.out.println("What is the dog's weight?");
            String weight = scanner.nextLine();

            System.out.println("What is the dog's acquisition date (MM/DD/YYYY)?");
            String acquisitionDate = scanner.nextLine();

            System.out.println("What is the dog's acquisition country?");
            String acquisitionCountry = scanner.nextLine();

            System.out.println("What is the dog's training status?");
            String trainingStatus = scanner.nextLine();

            System.out.println("Is the dog reserved? (true/false)");
            boolean reserved = scanner.nextBoolean();
            scanner.nextLine(); // Consume newline

            System.out.println("What is the dog's in-service country?");
            String inServiceCountry = scanner.nextLine();

            // Creating new Dog object
            Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate,
                    acquisitionCountry, trainingStatus, reserved, inServiceCountry);

            // Adding the new dog to the dog list (dogList)
            dogList.add(newDog);

            System.out.println("New dog added successfully!");

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please try again.");
        }
    }

    // OPTION 2 IN MENU "Intake a new monkey"
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();

        for(Monkey monkey: monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; //returns to menu
                }
        }

        // Adding the rest of the attributes to the new monkey
        // Using "try" and "catch" for error management
        try {
            // Code to input only allowed Monkey species
            System.out.println("Enter specie:");
            String species = scanner.nextLine();
            if (!species.equalsIgnoreCase("Capuchin") && !species.equalsIgnoreCase("Guenon") &&
                    !species.equalsIgnoreCase("Macaque") && !species.equalsIgnoreCase("Marmoset") &&
                    !species.equalsIgnoreCase("Squirrel monkey") && !species.equalsIgnoreCase("Tamarin")) {
                System.out.println("Invalid species. Eligible species are Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin.");
                return; // Returns to menu
            }

            System.out.println("Enter gender:");
            String gender = scanner.nextLine();

            System.out.println("Enter age:");
            String age = scanner.nextLine();

            System.out.println("Enter weight:");
            String weight = scanner.nextLine();

            System.out.println("Enter acquisition date:");
            String acquisitionDate = scanner.nextLine();

            System.out.println("Enter acquisition country:");
            String acquisitionCountry = scanner.nextLine();

            System.out.println("Enter training status:");
            String trainingStatus = scanner.nextLine();

            System.out.println("Enter in service country:");
            String inServiceCountry = scanner.nextLine();

            System.out.println("Enter tail length:");
            double tailLength = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter height:");
            double height = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter body length:");
            double bodyLength = Double.parseDouble(scanner.nextLine());

            System.out.println("Is the monkey reserved? (true/false)");
            boolean reserved = scanner.nextBoolean();
            scanner.nextLine(); // Consume newline

            // Initiating a new monkey and adding it to the monkey list
            Monkey newMonkey = new Monkey(name, species, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength);
            monkeyList.add(newMonkey);
            System.out.println("New monkey added successfully.");

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please try again.");
        }

    }


    // OPTION 3 IN MENU "Reserve Animal"
    public static void reserveAnimal(Scanner scanner) {
        // Asking user for animal type and in service country
        System.out.println("What is the animal type? Dog or Monkey?");
        String animalType = scanner.nextLine();
        System.out.println("What is the animal's in service country?");
        String inServiceCountry = scanner.nextLine();

        // Checking if Monkey is available for reservation
        boolean reservation = false;
        if (animalType.equalsIgnoreCase("Monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry) &&
                        monkey.getReserved() == false &&
                        monkey.getTrainingStatus().equals("in service")) {  // Corrected here
                    monkey.setReserved(true);
                    System.out.println("You have reserved " + monkey.getName());
                    reservation = true;
                    return;
                }
            }
            if (reservation == false) {
                System.out.println("There are no Monkeys available to reserve at this service location.");
            }
        }

        // Checking if Dog is available for reservation
        if (animalType.equalsIgnoreCase("Dog")) {
            for (Dog dog : dogList) {
                if (dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry) &&
                        dog.getReserved() == false &&
                        dog.getTrainingStatus().equals("in service")) {  // Corrected here
                    dog.setReserved(true);
                    System.out.println("You have reserved " + dog.getName());
                    reservation = true;
                    return;
                }
            }
            if (reservation == false) {
                System.out.println("No Dog is available to reserve at this service location.");
            }
        }
    }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
    public static void printAnimals() {
        System.out.println("The method printAnimals needs to be implemented");

    }
}

