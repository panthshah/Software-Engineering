/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 2 "model.ump"
// line 143 "model.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String userId;
  private String firstName;
  private String middleName;
  private String lastName;
  private String emailID;
  private String password;
  private int contactNumber;
  private int aadharCardNumber;
  private int drivingLicenseNumber;
  private String address;
  private int emergencyContactNumber;
  private int rewardPoints;

  //User Associations
  private List<Vehicle> vehicles;
  private List<Transaction> transactions;
  private List<Coupon> coupons;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aUserId, String aFirstName, String aMiddleName, String aLastName, String aEmailID, String aPassword, int aContactNumber, int aAadharCardNumber, int aDrivingLicenseNumber, String aAddress, int aEmergencyContactNumber, int aRewardPoints)
  {
    userId = aUserId;
    firstName = aFirstName;
    middleName = aMiddleName;
    lastName = aLastName;
    emailID = aEmailID;
    password = aPassword;
    contactNumber = aContactNumber;
    aadharCardNumber = aAadharCardNumber;
    drivingLicenseNumber = aDrivingLicenseNumber;
    address = aAddress;
    emergencyContactNumber = aEmergencyContactNumber;
    rewardPoints = aRewardPoints;
    vehicles = new ArrayList<Vehicle>();
    transactions = new ArrayList<Transaction>();
    coupons = new ArrayList<Coupon>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUserId(String aUserId)
  {
    boolean wasSet = false;
    userId = aUserId;
    wasSet = true;
    return wasSet;
  }

  public boolean setFirstName(String aFirstName)
  {
    boolean wasSet = false;
    firstName = aFirstName;
    wasSet = true;
    return wasSet;
  }

  public boolean setMiddleName(String aMiddleName)
  {
    boolean wasSet = false;
    middleName = aMiddleName;
    wasSet = true;
    return wasSet;
  }

  public boolean setLastName(String aLastName)
  {
    boolean wasSet = false;
    lastName = aLastName;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmailID(String aEmailID)
  {
    boolean wasSet = false;
    emailID = aEmailID;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public boolean setContactNumber(int aContactNumber)
  {
    boolean wasSet = false;
    contactNumber = aContactNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setAadharCardNumber(int aAadharCardNumber)
  {
    boolean wasSet = false;
    aadharCardNumber = aAadharCardNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setDrivingLicenseNumber(int aDrivingLicenseNumber)
  {
    boolean wasSet = false;
    drivingLicenseNumber = aDrivingLicenseNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmergencyContactNumber(int aEmergencyContactNumber)
  {
    boolean wasSet = false;
    emergencyContactNumber = aEmergencyContactNumber;
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

  public String getUserId()
  {
    return userId;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getMiddleName()
  {
    return middleName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getEmailID()
  {
    return emailID;
  }

  public String getPassword()
  {
    return password;
  }

  public int getContactNumber()
  {
    return contactNumber;
  }

  public int getAadharCardNumber()
  {
    return aadharCardNumber;
  }

  public int getDrivingLicenseNumber()
  {
    return drivingLicenseNumber;
  }

  public String getAddress()
  {
    return address;
  }

  public int getEmergencyContactNumber()
  {
    return emergencyContactNumber;
  }

  public int getRewardPoints()
  {
    return rewardPoints;
  }
  /* Code from template association_GetMany */
  public Vehicle getVehicle(int index)
  {
    Vehicle aVehicle = vehicles.get(index);
    return aVehicle;
  }

  public List<Vehicle> getVehicles()
  {
    List<Vehicle> newVehicles = Collections.unmodifiableList(vehicles);
    return newVehicles;
  }

  public int numberOfVehicles()
  {
    int number = vehicles.size();
    return number;
  }

  public boolean hasVehicles()
  {
    boolean has = vehicles.size() > 0;
    return has;
  }

  public int indexOfVehicle(Vehicle aVehicle)
  {
    int index = vehicles.indexOf(aVehicle);
    return index;
  }
  /* Code from template association_GetMany */
  public Transaction getTransaction(int index)
  {
    Transaction aTransaction = transactions.get(index);
    return aTransaction;
  }

  public List<Transaction> getTransactions()
  {
    List<Transaction> newTransactions = Collections.unmodifiableList(transactions);
    return newTransactions;
  }

  public int numberOfTransactions()
  {
    int number = transactions.size();
    return number;
  }

  public boolean hasTransactions()
  {
    boolean has = transactions.size() > 0;
    return has;
  }

  public int indexOfTransaction(Transaction aTransaction)
  {
    int index = transactions.indexOf(aTransaction);
    return index;
  }
  /* Code from template association_GetMany */
  public Coupon getCoupon(int index)
  {
    Coupon aCoupon = coupons.get(index);
    return aCoupon;
  }

  public List<Coupon> getCoupons()
  {
    List<Coupon> newCoupons = Collections.unmodifiableList(coupons);
    return newCoupons;
  }

  public int numberOfCoupons()
  {
    int number = coupons.size();
    return number;
  }

  public boolean hasCoupons()
  {
    boolean has = coupons.size() > 0;
    return has;
  }

  public int indexOfCoupon(Coupon aCoupon)
  {
    int index = coupons.indexOf(aCoupon);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfVehicles()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Vehicle addVehicle(int aRegistrationNumber, int aInsuranceNumber, int aOwnerId, String aVehicleType, int aMileage)
  {
    return new Vehicle(aRegistrationNumber, aInsuranceNumber, aOwnerId, aVehicleType, aMileage, this);
  }

  public boolean addVehicle(Vehicle aVehicle)
  {
    boolean wasAdded = false;
    if (vehicles.contains(aVehicle)) { return false; }
    User existingUser = aVehicle.getUser();
    boolean isNewUser = existingUser != null && !this.equals(existingUser);
    if (isNewUser)
    {
      aVehicle.setUser(this);
    }
    else
    {
      vehicles.add(aVehicle);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVehicle(Vehicle aVehicle)
  {
    boolean wasRemoved = false;
    //Unable to remove aVehicle, as it must always have a user
    if (!this.equals(aVehicle.getUser()))
    {
      vehicles.remove(aVehicle);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addVehicleAt(Vehicle aVehicle, int index)
  {  
    boolean wasAdded = false;
    if(addVehicle(aVehicle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVehicles()) { index = numberOfVehicles() - 1; }
      vehicles.remove(aVehicle);
      vehicles.add(index, aVehicle);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVehicleAt(Vehicle aVehicle, int index)
  {
    boolean wasAdded = false;
    if(vehicles.contains(aVehicle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVehicles()) { index = numberOfVehicles() - 1; }
      vehicles.remove(aVehicle);
      vehicles.add(index, aVehicle);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVehicleAt(aVehicle, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTransactions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Transaction addTransaction(String aTransactionID, String aUserId, int aRewardPurchased, int aAmountPaid, Date aDatetime)
  {
    return new Transaction(aTransactionID, aUserId, aRewardPurchased, aAmountPaid, aDatetime, this);
  }

  public boolean addTransaction(Transaction aTransaction)
  {
    boolean wasAdded = false;
    if (transactions.contains(aTransaction)) { return false; }
    User existingUser = aTransaction.getUser();
    boolean isNewUser = existingUser != null && !this.equals(existingUser);
    if (isNewUser)
    {
      aTransaction.setUser(this);
    }
    else
    {
      transactions.add(aTransaction);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTransaction(Transaction aTransaction)
  {
    boolean wasRemoved = false;
    //Unable to remove aTransaction, as it must always have a user
    if (!this.equals(aTransaction.getUser()))
    {
      transactions.remove(aTransaction);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTransactionAt(Transaction aTransaction, int index)
  {  
    boolean wasAdded = false;
    if(addTransaction(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTransactionAt(Transaction aTransaction, int index)
  {
    boolean wasAdded = false;
    if(transactions.contains(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTransactionAt(aTransaction, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCoupons()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Coupon addCoupon(int aCouponID, int aUserID, Date aOfferEndDate, Offer aOffer)
  {
    return new Coupon(aCouponID, aUserID, aOfferEndDate, this, aOffer);
  }

  public boolean addCoupon(Coupon aCoupon)
  {
    boolean wasAdded = false;
    if (coupons.contains(aCoupon)) { return false; }
    User existingUser = aCoupon.getUser();
    boolean isNewUser = existingUser != null && !this.equals(existingUser);
    if (isNewUser)
    {
      aCoupon.setUser(this);
    }
    else
    {
      coupons.add(aCoupon);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCoupon(Coupon aCoupon)
  {
    boolean wasRemoved = false;
    //Unable to remove aCoupon, as it must always have a user
    if (!this.equals(aCoupon.getUser()))
    {
      coupons.remove(aCoupon);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCouponAt(Coupon aCoupon, int index)
  {  
    boolean wasAdded = false;
    if(addCoupon(aCoupon))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCoupons()) { index = numberOfCoupons() - 1; }
      coupons.remove(aCoupon);
      coupons.add(index, aCoupon);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCouponAt(Coupon aCoupon, int index)
  {
    boolean wasAdded = false;
    if(coupons.contains(aCoupon))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCoupons()) { index = numberOfCoupons() - 1; }
      coupons.remove(aCoupon);
      coupons.add(index, aCoupon);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCouponAt(aCoupon, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=vehicles.size(); i > 0; i--)
    {
      Vehicle aVehicle = vehicles.get(i - 1);
      aVehicle.delete();
    }
    for(int i=transactions.size(); i > 0; i--)
    {
      Transaction aTransaction = transactions.get(i - 1);
      aTransaction.delete();
    }
    for(int i=coupons.size(); i > 0; i--)
    {
      Coupon aCoupon = coupons.get(i - 1);
      aCoupon.delete();
    }
  }

  // line 18 "model.ump"
  public void addUser(){
    
  }

  // line 19 "model.ump"
  public void updateDetails(){
    
  }

  // line 20 "model.ump"
  public int purchaseRewardPoints(){
    
  }

  // line 21 "model.ump"
  public int redeemRewardPoints(){
    
  }

  // line 22 "model.ump"
  public HashMap getUserStats(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "userId" + ":" + getUserId()+ "," +
            "firstName" + ":" + getFirstName()+ "," +
            "middleName" + ":" + getMiddleName()+ "," +
            "lastName" + ":" + getLastName()+ "," +
            "emailID" + ":" + getEmailID()+ "," +
            "password" + ":" + getPassword()+ "," +
            "contactNumber" + ":" + getContactNumber()+ "," +
            "aadharCardNumber" + ":" + getAadharCardNumber()+ "," +
            "drivingLicenseNumber" + ":" + getDrivingLicenseNumber()+ "," +
            "address" + ":" + getAddress()+ "," +
            "emergencyContactNumber" + ":" + getEmergencyContactNumber()+ "," +
            "rewardPoints" + ":" + getRewardPoints()+ "]";
  }
}