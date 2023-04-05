
import java.util.*; 

/**
 * The Library class is a subclass of the Building class, and it adds specifics about the building concerning it being a library. 
 */
public class Library extends Building {

  private Hashtable<String, Boolean> collection; 
  private boolean hasElevator; 

  /**
   * Default Constructor 
   */
  public Library(){
    this("<unknown>", "<unknown>", 1, true); 
  }

  /**
   * Overloaded constructor for just the hasElevator object. 
   * @param collection Collection of books in the library. . 
   */
  public Library(Hashtable collection){
    this(); 
    this.collection = collection; 
  }

  /**
   * Overloaded Constructor for just the number of floors. 
   * @param nFloors number of floors in the building. 
   */
  public Library(int nFloors){
    this(); 
    this.nFloors = nFloors; 
  }

  /**
   * Constructor for the Library Class and clarifies that building is the super class.
   * @param name The name of the building.
   * @param address The address. 
   * @param nFloors How many floors there are. 
   */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address,nFloors); 
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator; 
      System.out.println("You have built a library: 📖");
    }

    /**
     * Accessor for hasElevator Object
     * @return True or False depending on if there is an elevator ornot. 
     */
    public boolean hasElevator(){
        return(this.hasElevator); 
    }

    /**
     * Checks to make sure that if trying to go to a floor it is a valid floor number and the person is in the building. Prints out statement saying what floor number the person in on of the building. 
     * @param floorNum The desired floor number that someone wants to go to. 
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /**
     * If there is an elevator, the person goes to the desired floor immediately. If there is no elevator, the person can only go up one floor at a time. 
     * @param floorNum The floor number that the person wants to go to. 
     */
    public void goUp(int floorNum) {
        if (this.hasElevator = true){
            this.goToFloor(this.activeFloor = floorNum);
        }
        if (this.hasElevator = false){
            this.goToFloor(this.activeFloor + 1); 
        }
    }

    /**
     * If there is an elevator, the person goes to the desired floor immediately. If there is no elevator, the person can only go down one floor at a time. 
     * @param floorNum The floor number that the person wants to go to. 
     */
    public void goDown(int floorNum) {
        if (this.hasElevator = true){
            this.goToFloor(this.activeFloor = floorNum); 
        }
        if (this.hasElevator = false){
            this.goToFloor(this.activeFloor -1); 
        }
        
    }

    /**
     * Updates the hashtable of the book collection when a title is put on.
     * @param title The title of the book. 
     */
    public void addTitle(String title) {
      this.collection.put(title, true); 
    }

    /**
     * Updates the hashtable of the book collection when a book is checked out of the library.
     * @param title The title of the book. 
     * @return The String version of the updated hashtable of the book collection when a book is removed permanently from the collection. 
     */
    public String removeTitle(String title) {
       this.collection.remove(title); 
       return(this.collection.toString())
       ; 

    }

    /**
     * Updates the value to false for the corresponding key to signify that a book has been checked out of the collection.
     * @param title The book being checked out. 
     */
    public void checkOut(String title){
      this.collection.replace(title, true, false); 
    }

    /**
     * Updates the value to true for the corresponding key to signify that a book has been returned to the collection.
     * @param title The title of the book being returned.
     */
    public void returnBook(String title){
      this.collection.replace(title, false, true); 
    }

    /**
     * Checks to see if the book is in the library collection.
     * @param title The title of the book. 
     * @return The boolean value if the title is in the collection at all (checked out or currently in the collection). 
     */
    public boolean containsTitle(String title){
      return(this.collection.contains(title)); 
    }

    /**
     * Checks to see if a book is checked out or not. 
     * @param title The title of the book. 
     * @return The boolean value for the key.
     */
    public boolean isAvailable(String title) {
      return(this.collection.get(title)); 
    }

    /**
     * Prints out the collection list.
     */
    public void printCollection(){
      System.out.println(this.collection); 
    }

    /**
     * Overridden method that describes what methods from the parent class building apply to this subclass., 
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    /**
     * Overloaded method that returns information about the name of the building, how many floors there are, and the address. 
     * @param name the name of the building. 
     * @param nFloors how many floors there are. 
     * @param address the address of the building. 
     * @return The string version of the information. 
     */
    public String toString(String name, int nFloors, String address) {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }



    /**
     * Main method/creates new instance of the Library class. 
     * @param args name, address, nFloors, and hasElevator
     */
    public static void main(String[] args) {
      new Library("Public Lib", "Happy Street", 3, true);
    }
  
  }
