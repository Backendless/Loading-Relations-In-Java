package com.backendless.sample;

public class OrderItem
{
  private String itemName;
  private double price;
  private Manufacturer manufacturer;

  public String getItemName()
  {
    return itemName;
  }

  public void setItemName( String itemName )
  {
    this.itemName = itemName;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice( double price )
  {
    this.price = price;
  }

  public Manufacturer getManufacturer()
  {
    return manufacturer;
  }

  public void setManufacturer( Manufacturer manufacturer )
  {
    this.manufacturer = manufacturer;
  }

  @Override
  public String toString()
  {
    return "OrderItem{" +
            "itemName='" + itemName + '\'' +
            ", price=" + price +
            ", manufacturer=" + manufacturer +
            '}';
  }
}
