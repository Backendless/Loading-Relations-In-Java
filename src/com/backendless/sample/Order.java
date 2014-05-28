package com.backendless.sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order
{
  private String objectId;
  private String name;
  private List<OrderItem> items;
  private Date created;
  private Date updated;

  public String getObjectId()
  {
    return objectId;
  }

  public void setObjectId( String objectId )
  {
    this.objectId = objectId;
  }

  public Date getUpdated()
  {
    return updated;
  }

  public void setUpdated( Date updated )
  {
    this.updated = updated;
  }

  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public void addItem( OrderItem item )
  {
    if( items == null )
      items = new ArrayList<OrderItem>();

    items.add( item );
  }

  public List<OrderItem> getItems()
  {
    return items;
  }

  public void setItems( List<OrderItem> items )
  {
    this.items = items;
  }

  public Date getCreated()
  {
    return created;
  }

  public void setCreated( Date created )
  {
    this.created = created;
  }

  @Override
  public String toString()
  {
    return "Order{" +
            "name='" + name + '\'' +
            ", items=" + items +
            ", created=" + created +
            ", updated=" + updated +
            '}';
  }
}
