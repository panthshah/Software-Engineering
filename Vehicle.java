/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 95 "model.ump"
// line 176 "model.ump"
public class Vehicle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Vehicle Attributes
  private int registrationNumber;
  private int insuranceNumber;
  private int ownerId;
  private String vehicleType;
  private int mileage;

  //Vehicle Associations
  private User user;
  private List<Ride> rides;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Vehicle(int aRegistrationNumber, int aInsuranceNumber, int aOwnerId, String aVehicleType, int aMileage, User aUser)
  {
    registrationNumber = aRegistrationNumber;
    insuranceNumber = aInsuranceNumber;
    ownerId = aOwnerId;
    vehicleType = aVehicleType;
    mileage = aMileage;
    boolean didAddUser = setUser(aUser);
    if (!didAddUser)
    {
      throw new RuntimeException("Unable to create vehicle due to user. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    rides = new ArrayList<Ride>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRegistrationNumber(int aRegistrationNumber)
  {
    boolean wasSet = false;
    registrationNumber = aRegistrationNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setInsuranceNumber(int aInsuranceNumber)
  {
    boolean wasSet = false;
    insuranceNumber = aInsuranceNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setOwnerId(int aOwnerId)
  {
    boolean wasSet = false;
    ownerId = aOwnerId;
    wasSet = true;
    return wasSet;
  }

  public boolean setVehicleType(String aVehicleType)
  {
    boolean wasSet = false;
    vehicleType = aVehicleType;
    wasSet = true;
    return wasSet;
  }

  public boolean setMileage(int aMileage)
  {
    boolean wasSet = false;
    mileage = aMileage;
    wasSet = true;
    return wasSet;
  }

  public int getRegistrationNumber()
  {
    return registrationNumber;
  }

  public int getInsuranceNumber()
  {
    return insuranceNumber;
  }

  public int getOwnerId()
  {
    return ownerId;
  }

  public String getVehicleType()
  {
    return vehicleType;
  }

  public int getMileage()
  {
    return mileage;
  }
  /* Code from template association_GetOne */
  public User getUser()
  {
    return user;
  }
  /* Code from template association_GetMany */
  public Ride getRide(int index)
  {
    Ride aRide = rides.get(index);
    return aRide;
  }

  public List<Ride> getRides()
  {
    List<Ride> newRides = Collections.unmodifiableList(rides);
    return newRides;
  }

  public int numberOfRides()
  {
    int number = rides.size();
    return number;
  }

  public boolean hasRides()
  {
    boolean has = rides.size() > 0;
    return has;
  }

  public int indexOfRide(Ride aRide)
  {
    int index = rides.indexOf(aRide);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setUser(User aUser)
  {
    boolean wasSet = false;
    if (aUser == null)
    {
      return wasSet;
    }

    User existingUser = user;
    user = aUser;
    if (existingUser != null && !existingUser.equals(aUser))
    {
      existingUser.removeVehicle(this);
    }
    user.addVehicle(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRides()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Ride addRide(String aId, Date aDate)
  {
    return new Ride(aId, aDate, this);
  }

  public boolean addRide(Ride aRide)
  {
    boolean wasAdded = false;
    if (rides.contains(aRide)) { return false; }
    Vehicle existingVehicle = aRide.getVehicle();
    boolean isNewVehicle = existingVehicle != null && !this.equals(existingVehicle);
    if (isNewVehicle)
    {
      aRide.setVehicle(this);
    }
    else
    {
      rides.add(aRide);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRide(Ride aRide)
  {
    boolean wasRemoved = false;
    //Unable to remove aRide, as it must always have a vehicle
    if (!this.equals(aRide.getVehicle()))
    {
      rides.remove(aRide);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRideAt(Ride aRide, int index)
  {  
    boolean wasAdded = false;
    if(addRide(aRide))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRides()) { index = numberOfRides() - 1; }
      rides.remove(aRide);
      rides.add(index, aRide);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRideAt(Ride aRide, int index)
  {
    boolean wasAdded = false;
    if(rides.contains(aRide))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRides()) { index = numberOfRides() - 1; }
      rides.remove(aRide);
      rides.add(index, aRide);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRideAt(aRide, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    User placeholderUser = user;
    this.user = null;
    if(placeholderUser != null)
    {
      placeholderUser.removeVehicle(this);
    }
    for(int i=rides.size(); i > 0; i--)
    {
      Ride aRide = rides.get(i - 1);
      aRide.delete();
    }
  }

  // line 102 "model.ump"
  public void addVehicle(){
    
  }

  // line 103 "model.ump"
  public void updateDetails(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "registrationNumber" + ":" + getRegistrationNumber()+ "," +
            "insuranceNumber" + ":" + getInsuranceNumber()+ "," +
            "ownerId" + ":" + getOwnerId()+ "," +
            "vehicleType" + ":" + getVehicleType()+ "," +
            "mileage" + ":" + getMileage()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "user = "+(getUser()!=null?Integer.toHexString(System.identityHashCode(getUser())):"null");
  }
}