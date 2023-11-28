/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 111 "model.ump"
// line 181 "model.ump"
public class Pooler
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Pooler Attributes
  private String id;
  private List<Double> startLocation;
  private Date startTime;
  private List<Double> destinationLocation;
  private Date destinationTime;
  private int rewardPoints;

  //Pooler Associations
  private List<Ride> rides;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Pooler(String aId, Date aStartTime, Date aDestinationTime, int aRewardPoints)
  {
    id = aId;
    startLocation = new ArrayList<Double>();
    startTime = aStartTime;
    destinationLocation = new ArrayList<Double>();
    destinationTime = aDestinationTime;
    rewardPoints = aRewardPoints;
    rides = new ArrayList<Ride>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetMany */
  public boolean addStartLocation(Double aStartLocation)
  {
    boolean wasAdded = false;
    wasAdded = startLocation.add(aStartLocation);
    return wasAdded;
  }

  public boolean removeStartLocation(Double aStartLocation)
  {
    boolean wasRemoved = false;
    wasRemoved = startLocation.remove(aStartLocation);
    return wasRemoved;
  }

  public boolean setStartTime(Date aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetMany */
  public boolean addDestinationLocation(Double aDestinationLocation)
  {
    boolean wasAdded = false;
    wasAdded = destinationLocation.add(aDestinationLocation);
    return wasAdded;
  }

  public boolean removeDestinationLocation(Double aDestinationLocation)
  {
    boolean wasRemoved = false;
    wasRemoved = destinationLocation.remove(aDestinationLocation);
    return wasRemoved;
  }

  public boolean setDestinationTime(Date aDestinationTime)
  {
    boolean wasSet = false;
    destinationTime = aDestinationTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setRewardPoints(int aRewardPoints)
  {
    boolean wasSet = false;
    rewardPoints = aRewardPoints;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }
  /* Code from template attribute_GetMany */
  public Double getStartLocation(int index)
  {
    Double aStartLocation = startLocation.get(index);
    return aStartLocation;
  }

  public Double[] getStartLocation()
  {
    Double[] newStartLocation = startLocation.toArray(new Double[startLocation.size()]);
    return newStartLocation;
  }

  public int numberOfStartLocation()
  {
    int number = startLocation.size();
    return number;
  }

  public boolean hasStartLocation()
  {
    boolean has = startLocation.size() > 0;
    return has;
  }

  public int indexOfStartLocation(Double aStartLocation)
  {
    int index = startLocation.indexOf(aStartLocation);
    return index;
  }

  public Date getStartTime()
  {
    return startTime;
  }
  /* Code from template attribute_GetMany */
  public Double getDestinationLocation(int index)
  {
    Double aDestinationLocation = destinationLocation.get(index);
    return aDestinationLocation;
  }

  public Double[] getDestinationLocation()
  {
    Double[] newDestinationLocation = destinationLocation.toArray(new Double[destinationLocation.size()]);
    return newDestinationLocation;
  }

  public int numberOfDestinationLocation()
  {
    int number = destinationLocation.size();
    return number;
  }

  public boolean hasDestinationLocation()
  {
    boolean has = destinationLocation.size() > 0;
    return has;
  }

  public int indexOfDestinationLocation(Double aDestinationLocation)
  {
    int index = destinationLocation.indexOf(aDestinationLocation);
    return index;
  }

  public Date getDestinationTime()
  {
    return destinationTime;
  }

  public int getRewardPoints()
  {
    return rewardPoints;
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
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfRidesValid()
  {
    boolean isValid = numberOfRides() >= minimumNumberOfRides();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRides()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addRide(Ride aRide)
  {
    boolean wasAdded = false;
    if (rides.contains(aRide)) { return false; }
    rides.add(aRide);
    if (aRide.indexOfPooler(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRide.addPooler(this);
      if (!wasAdded)
      {
        rides.remove(aRide);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeRide(Ride aRide)
  {
    boolean wasRemoved = false;
    if (!rides.contains(aRide))
    {
      return wasRemoved;
    }

    if (numberOfRides() <= minimumNumberOfRides())
    {
      return wasRemoved;
    }

    int oldIndex = rides.indexOf(aRide);
    rides.remove(oldIndex);
    if (aRide.indexOfPooler(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRide.removePooler(this);
      if (!wasRemoved)
      {
        rides.add(oldIndex,aRide);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setRides(Ride... newRides)
  {
    boolean wasSet = false;
    ArrayList<Ride> verifiedRides = new ArrayList<Ride>();
    for (Ride aRide : newRides)
    {
      if (verifiedRides.contains(aRide))
      {
        continue;
      }
      verifiedRides.add(aRide);
    }

    if (verifiedRides.size() != newRides.length || verifiedRides.size() < minimumNumberOfRides())
    {
      return wasSet;
    }

    ArrayList<Ride> oldRides = new ArrayList<Ride>(rides);
    rides.clear();
    for (Ride aNewRide : verifiedRides)
    {
      rides.add(aNewRide);
      if (oldRides.contains(aNewRide))
      {
        oldRides.remove(aNewRide);
      }
      else
      {
        aNewRide.addPooler(this);
      }
    }

    for (Ride anOldRide : oldRides)
    {
      anOldRide.removePooler(this);
    }
    wasSet = true;
    return wasSet;
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
    ArrayList<Ride> copyOfRides = new ArrayList<Ride>(rides);
    rides.clear();
    for(Ride aRide : copyOfRides)
    {
      if (aRide.numberOfPoolers() <= Ride.minimumNumberOfPoolers())
      {
        aRide.delete();
      }
      else
      {
        aRide.removePooler(this);
      }
    }
  }

  // line 119 "model.ump"
  public void addPooler(){
    
  }

  // line 120 "model.ump"
  public void updateRewardPoints(){
    
  }

  // line 121 "model.ump"
  public void transferRewardPoints(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "rewardPoints" + ":" + getRewardPoints()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startTime" + "=" + (getStartTime() != null ? !getStartTime().equals(this)  ? getStartTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "destinationTime" + "=" + (getDestinationTime() != null ? !getDestinationTime().equals(this)  ? getDestinationTime().toString().replaceAll("  ","    ") : "this" : "null");
  }
}