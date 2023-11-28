/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;
import java.util.*;

// line 124 "model.ump"
// line 186 "model.ump"
public class Ride
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ride Attributes
  private String id;
  private Date date;

  //Ride Associations
  private Vehicle vehicle;
  private List<Pooler> poolers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ride(String aId, Date aDate, Vehicle aVehicle)
  {
    id = aId;
    date = aDate;
    boolean didAddVehicle = setVehicle(aVehicle);
    if (!didAddVehicle)
    {
      throw new RuntimeException("Unable to create ride due to vehicle. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    poolers = new ArrayList<Pooler>();
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

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public Date getDate()
  {
    return date;
  }
  /* Code from template association_GetOne */
  public Vehicle getVehicle()
  {
    return vehicle;
  }
  /* Code from template association_GetMany */
  public Pooler getPooler(int index)
  {
    Pooler aPooler = poolers.get(index);
    return aPooler;
  }

  public List<Pooler> getPoolers()
  {
    List<Pooler> newPoolers = Collections.unmodifiableList(poolers);
    return newPoolers;
  }

  public int numberOfPoolers()
  {
    int number = poolers.size();
    return number;
  }

  public boolean hasPoolers()
  {
    boolean has = poolers.size() > 0;
    return has;
  }

  public int indexOfPooler(Pooler aPooler)
  {
    int index = poolers.indexOf(aPooler);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setVehicle(Vehicle aVehicle)
  {
    boolean wasSet = false;
    if (aVehicle == null)
    {
      return wasSet;
    }

    Vehicle existingVehicle = vehicle;
    vehicle = aVehicle;
    if (existingVehicle != null && !existingVehicle.equals(aVehicle))
    {
      existingVehicle.removeRide(this);
    }
    vehicle.addRide(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfPoolersValid()
  {
    boolean isValid = numberOfPoolers() >= minimumNumberOfPoolers();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPoolers()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPooler(Pooler aPooler)
  {
    boolean wasAdded = false;
    if (poolers.contains(aPooler)) { return false; }
    poolers.add(aPooler);
    if (aPooler.indexOfRide(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPooler.addRide(this);
      if (!wasAdded)
      {
        poolers.remove(aPooler);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removePooler(Pooler aPooler)
  {
    boolean wasRemoved = false;
    if (!poolers.contains(aPooler))
    {
      return wasRemoved;
    }

    if (numberOfPoolers() <= minimumNumberOfPoolers())
    {
      return wasRemoved;
    }

    int oldIndex = poolers.indexOf(aPooler);
    poolers.remove(oldIndex);
    if (aPooler.indexOfRide(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPooler.removeRide(this);
      if (!wasRemoved)
      {
        poolers.add(oldIndex,aPooler);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setPoolers(Pooler... newPoolers)
  {
    boolean wasSet = false;
    ArrayList<Pooler> verifiedPoolers = new ArrayList<Pooler>();
    for (Pooler aPooler : newPoolers)
    {
      if (verifiedPoolers.contains(aPooler))
      {
        continue;
      }
      verifiedPoolers.add(aPooler);
    }

    if (verifiedPoolers.size() != newPoolers.length || verifiedPoolers.size() < minimumNumberOfPoolers())
    {
      return wasSet;
    }

    ArrayList<Pooler> oldPoolers = new ArrayList<Pooler>(poolers);
    poolers.clear();
    for (Pooler aNewPooler : verifiedPoolers)
    {
      poolers.add(aNewPooler);
      if (oldPoolers.contains(aNewPooler))
      {
        oldPoolers.remove(aNewPooler);
      }
      else
      {
        aNewPooler.addRide(this);
      }
    }

    for (Pooler anOldPooler : oldPoolers)
    {
      anOldPooler.removeRide(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPoolerAt(Pooler aPooler, int index)
  {  
    boolean wasAdded = false;
    if(addPooler(aPooler))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPoolers()) { index = numberOfPoolers() - 1; }
      poolers.remove(aPooler);
      poolers.add(index, aPooler);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePoolerAt(Pooler aPooler, int index)
  {
    boolean wasAdded = false;
    if(poolers.contains(aPooler))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPoolers()) { index = numberOfPoolers() - 1; }
      poolers.remove(aPooler);
      poolers.add(index, aPooler);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPoolerAt(aPooler, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Vehicle placeholderVehicle = vehicle;
    this.vehicle = null;
    if(placeholderVehicle != null)
    {
      placeholderVehicle.removeRide(this);
    }
    ArrayList<Pooler> copyOfPoolers = new ArrayList<Pooler>(poolers);
    poolers.clear();
    for(Pooler aPooler : copyOfPoolers)
    {
      if (aPooler.numberOfRides() <= Pooler.minimumNumberOfRides())
      {
        aPooler.delete();
      }
      else
      {
        aPooler.removeRide(this);
      }
    }
  }

  // line 128 "model.ump"
  public void addRide(){
    
  }

  // line 129 "model.ump"
  public void addPooler(Pooler pooler){
    
  }

  // line 130 "model.ump"
  public int calculateRewardPoints(){
    
  }

  // line 131 "model.ump"
  public float displayReducedCO2(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "vehicle = "+(getVehicle()!=null?Integer.toHexString(System.identityHashCode(getVehicle())):"null");
  }
}