/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;

// line 40 "model.ump"
// line 156 "model.ump"
public class Coupon
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Coupon Attributes
  private int couponID;
  private int userID;
  private Date offerEndDate;

  //Coupon Associations
  private User user;
  private Offer offer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Coupon(int aCouponID, int aUserID, Date aOfferEndDate, User aUser, Offer aOffer)
  {
    couponID = aCouponID;
    userID = aUserID;
    offerEndDate = aOfferEndDate;
    boolean didAddUser = setUser(aUser);
    if (!didAddUser)
    {
      throw new RuntimeException("Unable to create coupon due to user. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aOffer == null || aOffer.getCoupon() != null)
    {
      throw new RuntimeException("Unable to create Coupon due to aOffer. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    offer = aOffer;
  }

  public Coupon(int aCouponID, int aUserID, Date aOfferEndDate, User aUser, int aOfferIdForOffer, int aProviderIdForOffer, String aOfferTypeForOffer, int aDiscountPercentageForOffer, int aMaxDeductibleAmtForOffer, Date aValidForUptoForOffer, int aRewardPointsForOffer, Provider aProviderForOffer)
  {
    couponID = aCouponID;
    userID = aUserID;
    offerEndDate = aOfferEndDate;
    boolean didAddUser = setUser(aUser);
    if (!didAddUser)
    {
      throw new RuntimeException("Unable to create coupon due to user. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    offer = new Offer(aOfferIdForOffer, aProviderIdForOffer, aOfferTypeForOffer, aDiscountPercentageForOffer, aMaxDeductibleAmtForOffer, aValidForUptoForOffer, aRewardPointsForOffer, this, aProviderForOffer);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCouponID(int aCouponID)
  {
    boolean wasSet = false;
    couponID = aCouponID;
    wasSet = true;
    return wasSet;
  }

  public boolean setUserID(int aUserID)
  {
    boolean wasSet = false;
    userID = aUserID;
    wasSet = true;
    return wasSet;
  }

  public boolean setOfferEndDate(Date aOfferEndDate)
  {
    boolean wasSet = false;
    offerEndDate = aOfferEndDate;
    wasSet = true;
    return wasSet;
  }

  public int getCouponID()
  {
    return couponID;
  }

  public int getUserID()
  {
    return userID;
  }

  public Date getOfferEndDate()
  {
    return offerEndDate;
  }
  /* Code from template association_GetOne */
  public User getUser()
  {
    return user;
  }
  /* Code from template association_GetOne */
  public Offer getOffer()
  {
    return offer;
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
      existingUser.removeCoupon(this);
    }
    user.addCoupon(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    User placeholderUser = user;
    this.user = null;
    if(placeholderUser != null)
    {
      placeholderUser.removeCoupon(this);
    }
    Offer existingOffer = offer;
    offer = null;
    if (existingOffer != null)
    {
      existingOffer.delete();
    }
  }

  // line 45 "model.ump"
  public int getCoupon(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "couponID" + ":" + getCouponID()+ "," +
            "userID" + ":" + getUserID()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "offerEndDate" + "=" + (getOfferEndDate() != null ? !getOfferEndDate().equals(this)  ? getOfferEndDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "user = "+(getUser()!=null?Integer.toHexString(System.identityHashCode(getUser())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "offer = "+(getOffer()!=null?Integer.toHexString(System.identityHashCode(getOffer())):"null");
  }
}