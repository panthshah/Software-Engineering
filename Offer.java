/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;

// line 54 "model.ump"
// line 161 "model.ump"
public class Offer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Offer Attributes
  private int offerId;
  private int providerId;
  private String offerType;
  private int discountPercentage;
  private int maxDeductibleAmt;
  private Date validForUpto;
  private int rewardPoints;

  //Offer Associations
  private Coupon coupon;
  private Provider provider;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Offer(int aOfferId, int aProviderId, String aOfferType, int aDiscountPercentage, int aMaxDeductibleAmt, Date aValidForUpto, int aRewardPoints, Coupon aCoupon, Provider aProvider)
  {
    offerId = aOfferId;
    providerId = aProviderId;
    offerType = aOfferType;
    discountPercentage = aDiscountPercentage;
    maxDeductibleAmt = aMaxDeductibleAmt;
    validForUpto = aValidForUpto;
    rewardPoints = aRewardPoints;
    if (aCoupon == null || aCoupon.getOffer() != null)
    {
      throw new RuntimeException("Unable to create Offer due to aCoupon. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    coupon = aCoupon;
    boolean didAddProvider = setProvider(aProvider);
    if (!didAddProvider)
    {
      throw new RuntimeException("Unable to create offer due to provider. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public Offer(int aOfferId, int aProviderId, String aOfferType, int aDiscountPercentage, int aMaxDeductibleAmt, Date aValidForUpto, int aRewardPoints, int aCouponIDForCoupon, int aUserIDForCoupon, Date aOfferEndDateForCoupon, User aUserForCoupon, Provider aProvider)
  {
    offerId = aOfferId;
    providerId = aProviderId;
    offerType = aOfferType;
    discountPercentage = aDiscountPercentage;
    maxDeductibleAmt = aMaxDeductibleAmt;
    validForUpto = aValidForUpto;
    rewardPoints = aRewardPoints;
    coupon = new Coupon(aCouponIDForCoupon, aUserIDForCoupon, aOfferEndDateForCoupon, aUserForCoupon, this);
    boolean didAddProvider = setProvider(aProvider);
    if (!didAddProvider)
    {
      throw new RuntimeException("Unable to create offer due to provider. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOfferId(int aOfferId)
  {
    boolean wasSet = false;
    offerId = aOfferId;
    wasSet = true;
    return wasSet;
  }

  public boolean setProviderId(int aProviderId)
  {
    boolean wasSet = false;
    providerId = aProviderId;
    wasSet = true;
    return wasSet;
  }

  public boolean setOfferType(String aOfferType)
  {
    boolean wasSet = false;
    offerType = aOfferType;
    wasSet = true;
    return wasSet;
  }

  public boolean setDiscountPercentage(int aDiscountPercentage)
  {
    boolean wasSet = false;
    discountPercentage = aDiscountPercentage;
    wasSet = true;
    return wasSet;
  }

  public boolean setMaxDeductibleAmt(int aMaxDeductibleAmt)
  {
    boolean wasSet = false;
    maxDeductibleAmt = aMaxDeductibleAmt;
    wasSet = true;
    return wasSet;
  }

  public boolean setValidForUpto(Date aValidForUpto)
  {
    boolean wasSet = false;
    validForUpto = aValidForUpto;
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

  public int getOfferId()
  {
    return offerId;
  }

  public int getProviderId()
  {
    return providerId;
  }

  public String getOfferType()
  {
    return offerType;
  }

  public int getDiscountPercentage()
  {
    return discountPercentage;
  }

  public int getMaxDeductibleAmt()
  {
    return maxDeductibleAmt;
  }

  public Date getValidForUpto()
  {
    return validForUpto;
  }

  public int getRewardPoints()
  {
    return rewardPoints;
  }
  /* Code from template association_GetOne */
  public Coupon getCoupon()
  {
    return coupon;
  }
  /* Code from template association_GetOne */
  public Provider getProvider()
  {
    return provider;
  }
  /* Code from template association_SetOneToMany */
  public boolean setProvider(Provider aProvider)
  {
    boolean wasSet = false;
    if (aProvider == null)
    {
      return wasSet;
    }

    Provider existingProvider = provider;
    provider = aProvider;
    if (existingProvider != null && !existingProvider.equals(aProvider))
    {
      existingProvider.removeOffer(this);
    }
    provider.addOffer(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Coupon existingCoupon = coupon;
    coupon = null;
    if (existingCoupon != null)
    {
      existingCoupon.delete();
    }
    Provider placeholderProvider = provider;
    this.provider = null;
    if(placeholderProvider != null)
    {
      placeholderProvider.removeOffer(this);
    }
  }

  // line 63 "model.ump"
  public void getOffer(){
    
  }

  // line 64 "model.ump"
  public int getCouponCode(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "offerId" + ":" + getOfferId()+ "," +
            "providerId" + ":" + getProviderId()+ "," +
            "offerType" + ":" + getOfferType()+ "," +
            "discountPercentage" + ":" + getDiscountPercentage()+ "," +
            "maxDeductibleAmt" + ":" + getMaxDeductibleAmt()+ "," +
            "rewardPoints" + ":" + getRewardPoints()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "validForUpto" + "=" + (getValidForUpto() != null ? !getValidForUpto().equals(this)  ? getValidForUpto().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "coupon = "+(getCoupon()!=null?Integer.toHexString(System.identityHashCode(getCoupon())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "provider = "+(getProvider()!=null?Integer.toHexString(System.identityHashCode(getProvider())):"null");
  }
}