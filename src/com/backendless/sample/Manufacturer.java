package com.backendless.sample;

public class Manufacturer
{
  private String name;
  private String city;

  public String getCity()
  {
    return city;
  }

  public void setCity( String city )
  {
    this.city = city;
  }

  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  @Override
  public String toString()
  {
    return "Manufacturer{" +
            "name='" + name + '\'' +
            ", city='" + city + '\'' +
            '}';
  }
}
