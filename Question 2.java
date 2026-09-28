import java.util.Scanner;

// interfaces are fine
interface IConsole {
    String getConsoleType();
    String getStore();
    int getTotalSales();
}

// TODO: fix spelling if needed, but Consoles works fine for now
abstract class Consoles implements IConsole {
    // fields 
    private String consoleType; // took out final just in case we need to mutate later, though we prob don't
    private String store;
    private int totalSales;

    public Consoles(String consoleType, String store, int totalSales) {
        this.consoleType = consoleType;
        this.store = store;
        this.totalSales = totalSales;
    }

    public String getConsoleType() {
        return consoleType;
    }

    public String getStore() {
        return store;
    }

    public int getTotalSales() {
        return totalSales;
    }
}

// extending the abstract class, pretty straightforward
class ConsoleSale extends Consoles {
    public ConsoleSale(String consoleType, String store, int totalSales) {
        super(consoleType, store, totalSales);
    }
    
    // maybe add a print method here later? leaving it for now
}

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // standard scanner variable name

        System.out.println("Select a console device type:");
        System.out.println("1. PlayStation");
        System.out.println("2. Xbox");
        System.out.println("3. Nintendo Switch");
        
        System.out.print("Enter choice (1-3): ");
        int choice = sc.nextInt();
        sc.nextLine(); // clear the newline buffer.

        String chosenConsole = ""; // init with empty string to avoid uninitialized variable errors
        
        if (choice == 1) {
            chosenConsole = "PlayStation";
        } else if (choice == 2) {
            chosenConsole = "Xbox";
        } else if (choice == 3) {
            chosenConsole = "Nintendo Switch";
        } else {
            // switched the switch-case to if-else because sometimes it just reads easier.
            System.out.println("Invalid choice man... exiting.");
            sc.close();
            return;
        }

        System.out.print("Enter store name: ");
        String storeName = sc.nextLine();
        
        System.out.print("Enter total number of sales: ");
        int salesNum = sc.nextInt();

        // create the object using our own inheritance structure
        IConsole saleItem = new ConsoleSale(chosenConsole, storeName, salesNum);
        
        // printing out results block
        System.out.println("\n--- Summary ---");
        System.out.println("Console device: " + saleItem.getConsoleType());
        System.out.println("Store: " + saleItem.getStore());
        System.out.println("Total sales: " + saleItem.getTotalSales());
        
        sc.close();
    }
}