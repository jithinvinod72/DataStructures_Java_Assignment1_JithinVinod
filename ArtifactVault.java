import java.util.Arrays;
import java.util.Scanner;

public class ArtifactVault {
    private String[] artifacts;
    private int size;

    public ArtifactVault(int size) {
        this.artifacts = new String[size];  
        this.size = size;
    }

    public String addArtifact(String artifact) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i] == null) {
                artifacts[i] = artifact;
                return artifact + " added.";
            }
        }
        return "Vault is full!";
    }

    public String removeArtifact(String artifactName) {
        for (int i = 0; i < size; i++) {
            if (artifactName.equals(artifacts[i])) {
                artifacts[i] = null;
                return artifactName + " removed.";
            }
        }
        return artifactName + " not found.";
    }

    public String linearSearch(String artifactName) {
        for (String artifact : artifacts) {
            if (artifactName.equals(artifact)) {
                return artifactName + " found!";
            }
        }
        return artifactName + " not found.";
    }

    public String binarySearch(String artifactName) {
        int nonNullCount = 0;
        for (String artifact : artifacts) {
            if (artifact != null) {
                nonNullCount++;
            }
        }

        String[] sortedArtifacts = new String[nonNullCount];
        int index = 0;

        
        for (String artifact : artifacts) {
            if (artifact != null) {
                sortedArtifacts[index++] = artifact;
            }
        }
    
        Arrays.sort(sortedArtifacts);
    
        int left = 0;
        int right = sortedArtifacts.length - 1;
    
        while (left <= right) {
            int middle = (left + right) / 2;
            int comparison = sortedArtifacts[middle].compareTo(artifactName);
    
            if (comparison == 0) {
                return artifactName + " found!";
            } else if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
    
        return artifactName + " not found.";
    }
    

    public void displayArtifacts() {
        System.out.println("------------------------------------");
        System.out.println("Current artifacts in the vault:");
        for (String artifact : artifacts) {
            if (artifact != null) {
                System.out.println(artifact);
            }
        }
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the artifact vault: ");
        int size = scanner.nextInt();
        ArtifactVault vault = new ArtifactVault(size);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add an artifact");
            System.out.println("2. Remove an artifact");
            System.out.println("3. Linear search for an artifact");
            System.out.println("4. Binary search for an artifact");
            System.out.println("5. Display all artifacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("------------------------------------");
                    System.out.print("Enter artifact name to add: ");
                    String artifactToAdd = scanner.nextLine();
                    System.out.println(vault.addArtifact(artifactToAdd));
                    System.out.println("------------------------------------");
                    break;

                case 2:
                    System.out.println("------------------------------------");
                    System.out.print("Enter artifact name to remove: ");
                    String artifactToRemove = scanner.nextLine();
                    System.out.println(vault.removeArtifact(artifactToRemove));
                    System.out.println("------------------------------------");
                    break;

                case 3:
                    System.out.println("------------------------------------");
                    System.out.print("Enter artifact name to search (linear): ");
                    String artifactToSearchLinear = scanner.nextLine();
                    System.out.println(vault.linearSearch(artifactToSearchLinear));
                    System.out.println("------------------------------------");
                    break;

                case 4:
                    System.out.println("------------------------------------");
                    System.out.print("Enter artifact name to search (binary): ");
                    String artifactToSearchBinary = scanner.nextLine();
                    System.out.println(vault.binarySearch(artifactToSearchBinary));
                    break;

                case 5:
                    vault.displayArtifacts();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
