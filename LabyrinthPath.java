import java.util.Scanner;

public class LabyrinthPath {
    private PathNode firstLocation; 

    private static class PathNode {
        String locationName;
        PathNode nextLocation;

        public PathNode(String locationName) {
            this.locationName = locationName;
            this.nextLocation = null;
        }
    }


    public LabyrinthPath() {
        firstLocation = null;
    }

    
    public void appendLocation(String locationName) {
        PathNode newPlace = new PathNode(locationName);
        if (firstLocation == null) {
            firstLocation = newPlace;
        } else {
            PathNode current = firstLocation;
            while (current.nextLocation != null) {
                current = current.nextLocation;
            }
            current.nextLocation = newPlace;
        }
        System.out.println("Location added: " + locationName);
    }

    public void removeLastPlace() {
        if (firstLocation == null) {
            System.out.println("The path is empty. Nothing to remove.");
            return;
        }

        if (firstLocation.nextLocation == null) {
            System.out.println("Removing only location: " + firstLocation.locationName);
            firstLocation = null;
            return;
        }

        PathNode current = firstLocation;
        while (current.nextLocation.nextLocation != null) {
            current = current.nextLocation;
        }
        System.out.println("Removing last location: " + current.nextLocation.locationName);
        current.nextLocation = null;
    }

    public boolean hasLoop() {
        if (firstLocation == null || firstLocation.nextLocation == null) {
            return false;
        }

        PathNode slowPointer = firstLocation;
        PathNode fastPointer = firstLocation;

        while (fastPointer != null && fastPointer.nextLocation != null) {
            slowPointer = slowPointer.nextLocation;
            fastPointer = fastPointer.nextLocation.nextLocation;

            if (slowPointer == fastPointer) {
                return true;  
            }
        }
        return false;
    }

    public void showPath() {
        if (firstLocation == null) {
            System.out.println("No locations in the path.");
            return;
        }

        PathNode current = firstLocation;
        System.out.print("Current Path: ");
        while (current != null) {
            System.out.print(current.locationName + " -> ");
            current = current.nextLocation;
        }
        System.out.println("END");
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LabyrinthPath path = new LabyrinthPath();
        boolean runProgram = true;

        while (runProgram) {
            System.out.println("\n--- Labyrinth Path Menu ---");
            System.out.println("1. Add Location");
            System.out.println("2. Remove Last Location");
            System.out.println("3. Check if Path Has Loop");
            System.out.println("4. Display Path");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the location to add: ");
                    String location = input.nextLine();
                    path.appendLocation(location);
                    break;

                case 2:
                    path.removeLastPlace();
                    break;

                case 3:
                    if (path.hasLoop()) {
                        System.out.println("Loop detected in the path.");
                    } else {
                        System.out.println("No loop detected in the path.");
                    }
                    break;

                case 4:
                    path.showPath();
                    break;

                case 5:
                    runProgram = false;
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        input.close();
    }
}
