/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;

// line 25 "model.ump"
// line 151 "model.ump"
public class Transaction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transaction Attributes
  private String transactionID;
  private String userId;
  private int rewardPurchased;
  private int amountPaid;
  private Date datetime;

  //Transaction Associations
  private User user;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(String aTransactionID, String aUserId, int aRewardPurchased, int aAmountPaid, Date aDatetime, User aUser)
  {
    transactionID = aTransactionID;
    userId = aUserId;
    rewardPurchased = aRewardPurchased;
    amountPaid = aAmountPaid;
    datetime = aDatetime;
    boolean didAddUser = setUser(aUser);
    if (!didAddUser)
    {
      throw new RuntimeException("Unable to create transaction due to user. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTransactionID(String aTransactionID)
  {
    boolean wasSet = false;
    transactionID = aTransactionID;
    wasSet = true;
    return wasSet;
  }

  public boolean setUserId(String aUserId)
  {
    boolean wasSet = false;
    userId = aUserId;
    wasSet = true;
    return wasSet;
  }

  public boolean setRewardPurchased(int aRewardPurchased)
  {
    boolean wasSet = false;
    rewardPurchased = aRewardPurchased;
    wasSet = true;
    return wasSet;
  }

  public boolean setAmountPaid(int aAmountPaid)
  {
    boolean wasSet = false;
    amountPaid = aAmountPaid;
    wasSet = true;
    return wasSet;
  }

  public boolean setDatetime(Date aDatetime)
  {
    boolean wasSet = false;
    datetime = aDatetime;
    wasSet = true;
    return wasSet;
  }

  public String getTransactionID()
  {
    return transactionID;
  }

  public String getUserId()
  {
    return userId;
  }

  public int getRewardPurchased()
  {
    return rewardPurchased;
  }

  public int getAmountPaid()
  {
    return amountPaid;
  }

  public Date getDatetime()
  {
    return datetime;
  }
  /* Code from template association_GetOne */
  public User getUser()
  {
    return user;
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
      existingUser.removeTransaction(this);
    }
    user.addTransaction(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    User placeholderUser = user;
    this.user = null;
    if(placeholderUser != null)
    {
      placeholderUser.removeTransaction(this);
    }
  }

  // line 32 "model.ump"
  public void displayTransactionDetails(){
    
  }

  // line 33 "model.ump"
  public void redeemPoints(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "transactionID" + ":" + getTransactionID()+ "," +
            "userId" + ":" + getUserId()+ "," +
            "rewardPurchased" + ":" + getRewardPurchased()+ "," +
            "amountPaid" + ":" + getAmountPaid()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "datetime" + "=" + (getDatetime() != null ? !getDatetime().equals(this)  ? getDatetime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "user = "+(getUser()!=null?Integer.toHexString(System.identityHashCode(getUser())):"null");
  }
}