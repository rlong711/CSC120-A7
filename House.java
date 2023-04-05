import java.util.*; 

/**
 * The class House is a subclass of the Building class, and it adds specfics to the building that it would uniquely have a house. 
 */
public class House extends Building {
  
  private ArrayList<String> residents; 
  private boolean hasDiningRoom; 
  private boolean hasElevator; 

  /**
   * Default Constructor 
   */
  public House(){
    this("unkown", "unkown", 1, true, false); 
  }

  /**
   * Overloaded constructor
   * @param hasDiningRoom True or False depending on if there is a dining room or not. 
   */
  public House(Boolean hasDiningRoom){
    this(); 
    this.hasDiningRoom = hasDiningRoom; 
  }



  /**
   * Constructor for the House Class. 
   * @param name Name of the building (from the super class Building).
   * @param address The address of the building (from the super class Building.)
   * @param hasDiningRoom Boolean value for wheter the house has a dining room or not.
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name,address,nFloors); 
    this.hasDiningRoom = hasDiningRoom; 
    this.residents = new ArrayList<String>();
    this.hasElevator = hasElevator; 
    System.out.println("You have built a house: 🏠");
  }
  
  
  /**
   * Accessor for hasElevator 
   * @return True/False depending on if there is an elevator or not
   */
  public boolean hasElevator() {
    return(this.hasElevator); 
  }

  /**
   * Returns the floor that someone is on
   * @param floorNum The desired floor number
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
     * Goes up to desired floor. If there's an elevator you can simultaneously go to the different floor, but if there is no elevator it can only increase by one. 
     * @param floorNum Desired floor number the person wants to go to. 
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
     * Goes down to the desired floor. If there's an elevator you can simultaneously go to the desired floor, but if there is no floor, it can only go down by one. 
     * @param floorNum Desired floor number the person wants to go to. 
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
   * Accessor for wheter or not the house has a dining room or not. 
   * @return Boolean Value for if there is a dining room or not. 
   */
  public boolean hasDiningRoom() {
    return(this.hasDiningRoom); 
  }; 

  /**
   * Accessor for the number of residents in the house. 
   * @return Integer for the number of residents. 
   */
  public int nResidents() {
    return(this.residents.size()); 
  }; 

  /**
   * Adds the resident's name to the Array List of residents. 
   * @param name The name of the resident moving in. 
   */
  public void moveIn(String name) {
    this.residents.add(name); 
  }

  /**
   * Removes the resident's name from the Array List of residents. 
   * @param name The name of the resident moving out. 
   * @return The updated Array List of current residents after one is removed. 
   */
  public String moveOut(String name) {
    this.residents.remove(name);
    StringBuffer sb = new StringBuffer(); 
    for (String s : residents) {
      sb.append(s); 
      sb.append(" ");
    }
    String residentsString = sb.toString();  
    return (residentsString); 
  }

  /**
   * Returns boolean value for wheter or not the person is a resident and in the Array List of residents.
   * @param person The person who is either a resident or not. 
   * @return The boolean value for if the resident's name is in the Array List of residents.
   */
  public boolean isResident(String person){
    return(this.residents.contains(person)); 
  } 

  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
}

/**
 * Overloaded method
 * @param name name of the house. 
 * @param nFloors how many floors the house has. 
 * @param address address of the house. 
 * @return String in the form of a sentence describing the name, number of floors, and address. 
 */
public String toString(String name, int nFloors, String address) {
    return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
}


  /**
   * Main method that calls a new instance of the House Class. 
   * @param args The name of the building, the address of the building, and how many floors there are. 
   */
  public static void main(String[] args) {
    new House("The Plaza", "161 21st", 2, true, false);
  }

}
