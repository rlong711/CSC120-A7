/* This is a stub for the Cafe class */
/**
 * The class Cafe represents a subclass of the Building Class. It adds specifics about the building since it a specialized building (a cafe). 
 */
public class Cafe extends Building {

    private int nCoffeeOunces; 
    private int nSugarPackets; 
    private int nCreams;
    private int nCups; 

    /**
     * Default Constructor 
     */
    public Cafe(){
        this("<unknown>", "<unknown>", 1, 200, 200, 50, 30); 
    }

    /**
     * Overloaded constructor for the amount of coffee ounces.
     * @param nCoffeOunces the amount of coffee in the inventory in ounces. 
     */
    public Cafe(int nCoffeOunces){
        this(); 
        this.nCoffeeOunces = nCoffeeOunces; 
    }


    /**
     * Constructor for the Cafe class and assigns the super class. 
     * @param name The name of the place. 
     * @param address The address for the building/cafe. 
     * @param nFloors How many floors there are. 
     * @param nCoffeOunces Ounces of coffee remaining in inventory.
     * @param nSugarPackets Number of sugar packets remaining in inventory.
     * @param nCreams Number of creams in the inventory.
     * @param nCups Number of cups remaining in the inventory.
     */
    public Cafe(String name, String address, int nFloors, int nCoffeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name,address,nFloors); 
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets; 
        this.nCreams = nCreams; 
        this.nCups = nCups;  

        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Updates the inventory of the cafe when a coffee is sold.
     * @param size The size in ounces of coffee used to make the coffee. 
     * @param nSugarPackets This is the amount of sugar packets used for the coffee that was sold.  
     * @param nCreams This is the amount of cream used for the coffee that was sold.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        this.nCoffeeOunces -= size; 
        this.nSugarPackets -= nSugarPackets; 
        this.nCreams -= nCreams; 
    }

    /**
     * Restocks the cafe inventory. 
     * @param nCoffeeOunces The amount of coffee in ounces that restocks the existing inventory. 
     * @param nSugarPackets The amount of sugar packets that restocks the existing inventory.
     * @param nCups The amount of cups used to restock the cafe's existing inventory. 
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCups){
        this.nCoffeeOunces += nCoffeeOunces; 
        this.nSugarPackets += nSugarPackets; 
        this.nCups += nCups; 
    }

    /**
     * Shows the methods from the parent class that appies to this subclass (cafe). 
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit()");
    }

    /**
     * Overloaded method. 
     * @param name the name of the cafe.
     * @param address the address of the cafe. 
     * @return converts infromation about the name and address of the cafe to a string. 
     */
    public String toString(String name, String address) {
        return this.name + " is a " + "building located at " + this.address + ".";
    }
    
    /**
     * This is the main method and creates a new instance/calls methods of the Cafe class. 
     * @param args The name of the building, the address, how many floors there are, how many ounces of coffee are in the inventory, how many creams are in the inventory, how many cups are in the inventory.
     */
    public static void main(String[] args) {
        new Cafe("The Plaza", "Happy Way", 1, 20, 20, 20, 20);
    }
    
}

