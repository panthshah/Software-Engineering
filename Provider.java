/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 71 "model.ump"
// line 166 "model.ump"
public class Provider
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Provider Attributes
  private int providerID;
  private String name;
  private String email;
  private int GSTIN;
  private String address;

  //Provider Associations
  private List<Offer> offers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Provider(int aProviderID, String aName, String aEmail, int aGSTIN, String aAddress)
  {
    providerID = aProviderID;
    name = aName;
    email = aEmail;
    GSTIN = aGSTIN;
    address = aAddress;
    offers = new ArrayList<Offer>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setProviderID(int aProviderID)
  {
    boolean wasSet = false;
    providerID = aProviderID;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public boolean setGSTIN(int aGSTIN)
  {
    boolean wasSet = false;
    GSTIN = aGSTIN;
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

  public int getProviderID()
  {
    return providerID;
  }

  public String getName()
  {
    return name;
  }

  public String getEmail()
  {
    return email;
  }

  public int getGSTIN()
  {
    return GSTIN;
  }

  public String getAddress()
  {
    return address;
  }
  /* Code from template association_GetMany */
  public Offer getOffer(int index)
  {
    Offer aOffer = offers.get(index);
    return aOffer;
  }

  public List<Offer> getOffers()
  {
    List<Offer> newOffers = Collections.unmodifiableList(offers);
    return newOffers;
  }

  public int numberOfOffers()
  {
    int number = offers.size();
    return number;
  }

  public boolean hasOffers()
  {
    boolean has = offers.size() > 0;
    return has;
  }

  public int indexOfOffer(Offer aOffer)
  {
    int index = offers.indexOf(aOffer);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOffers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Offer addOffer(int aOfferId, int aProviderId, String aOfferType, int aDiscountPercentage, int aMaxDeductibleAmt, Date aValidForUpto, int aRewardPoints, Coupon aCoupon)
  {
    return new Offer(aOfferId, aProviderId, aOfferType, aDiscountPercentage, aMaxDeductibleAmt, aValidForUpto, aRewardPoints, aCoupon, this);
  }

  public boolean addOffer(Offer aOffer)
  {
    boolean wasAdded = false;
    if (offers.contains(aOffer)) { return false; }
    Provider existingProvider = aOffer.getProvider();
    boolean isNewProvider = existingProvider != null && !this.equals(existingProvider);
    if (isNewProvider)
    {
      aOffer.setProvider(this);
    }
    else
    {
      offers.add(aOffer);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOffer(Offer aOffer)
  {
    boolean wasRemoved = false;
    //Unable to remove aOffer, as it must always have a provider
    if (!this.equals(aOffer.getProvider()))
    {
      offers.remove(aOffer);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOfferAt(Offer aOffer, int index)
  {  
    boolean wasAdded = false;
    if(addOffer(aOffer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOffers()) { index = numberOfOffers() - 1; }
      offers.remove(aOffer);
      offers.add(index, aOffer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOfferAt(Offer aOffer, int index)
  {
    boolean wasAdded = false;
    if(offers.contains(aOffer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOffers()) { index = numberOfOffers() - 1; }
      offers.remove(aOffer);
      offers.add(index, aOffer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOfferAt(aOffer, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=offers.size(); i > 0; i--)
    {
      Offer aOffer = offers.get(i - 1);
      aOffer.delete();
    }
  }

  // line 78 "model.ump"
  public void getOfferDetails(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "providerID" + ":" + getProviderID()+ "," +
            "name" + ":" + getName()+ "," +
            "email" + ":" + getEmail()+ "," +
            "GSTIN" + ":" + getGSTIN()+ "," +
            "address" + ":" + getAddress()+ "]";
  }
}