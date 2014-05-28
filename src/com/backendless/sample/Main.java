package com.backendless.sample;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;

import java.util.ArrayList;

public class Main
{
  public static void main( String[] args ) throws Throwable
  {
    Backendless.initApp( "PUT-YOUR-APP-ID-HERE", "PUT-YOUR-SECRET-KEY-HERE", "v1" );

    //setupData();

    /**** loading a collection of objects ****/
    // basicDataLoad();

    /**** single-step relations load ****/
    //loadAllOrdersWithAllRelations();

    /**** two-step relations load ****/
    //loadRelations();

    /**** child to parent lookup relations load ****/
    //loadOrderItemsWithQuery();


    //loadOrdersWithDepth();
  }

  private static void basicDataLoad()
  {
    BackendlessCollection<Order> orders = Backendless.Data.of( Order.class ).find();

    for( Order order : orders.getCurrentPage() )
      System.out.println( order );
  }

  private static void loadRelations() throws Throwable
  {
    Order firstOrder = Backendless.Data.of( Order.class ).findFirst();
    System.out.println( "Order before relation is loaded - " + firstOrder );

    ArrayList<String> relationProps = new ArrayList<String>();
    relationProps.add( "items" );
    relationProps.add( "items.manufacturer" );
    Backendless.Data.of( Order.class ).loadRelations( firstOrder, relationProps );

    System.out.println( "Order after relation is loaded - " + firstOrder );
  }

private static void loadOrderItemsWithQuery() throws Throwable
{
  Order firstOrder = Backendless.Data.of( Order.class ).findFirst();
  String queryString = "Order[items].objectId = '" + firstOrder.getObjectId() + "' and price > 400";
  BackendlessDataQuery query = new BackendlessDataQuery( queryString );
  BackendlessCollection<OrderItem> orderItems = Backendless.Data.of( OrderItem.class ).find( query );

  for( OrderItem orderItem : orderItems.getCurrentPage() )
    System.out.println( orderItem );
}

  private static void loadAllOrdersWithAllRelations()
  {
    BackendlessDataQuery query = new BackendlessDataQuery();
    QueryOptions queryOptions = new QueryOptions();
    queryOptions.addRelated( "items" );
    queryOptions.addRelated( "items.manufacturer" );
    query.setQueryOptions( queryOptions );
    BackendlessCollection<Order> orders = Backendless.Data.of( Order.class ).find( query );

    for( Order order : orders.getCurrentPage() )
      System.out.println( order );
  }

  private static void loadOrdersWithDepth()
  {
    BackendlessDataQuery query = new BackendlessDataQuery();
    QueryOptions queryOptions = new QueryOptions();
    queryOptions.setRelationsDepth( 2 );
    query.setQueryOptions( queryOptions );
    BackendlessCollection<Order> orders = Backendless.Data.of( Order.class ).find( query );

    for( Order order : orders.getCurrentPage() )
      System.out.println( order );
  }

  private static void setupData() throws Throwable
  {
    Manufacturer microsoft = new Manufacturer();
    microsoft.setName( "Microsoft" );
    microsoft.setCity( "Redmond" );

    OrderItem orderItem1 = new OrderItem();
    orderItem1.setItemName( "XBOX One" );
    orderItem1.setPrice( 399 );
    orderItem1.setManufacturer( microsoft );

    OrderItem orderItem2 = new OrderItem();
    orderItem2.setItemName( "Surface Pro" );
    orderItem2.setPrice( 899 );
    orderItem2.setManufacturer( microsoft );

    Order order = new Order();
    order.setName( "Birthday present" );
    order.addItem( orderItem1 );
    order.addItem( orderItem2 );

    Backendless.Data.of( Order.class ).save( order );

    Manufacturer apple = new Manufacturer();
    apple.setName( "Apple" );
    apple.setCity( "Cupertino" );

    OrderItem macbook = new OrderItem();
    macbook.setItemName( "MacBook" );
    macbook.setPrice( 1200 );
    macbook.setManufacturer( apple );

    OrderItem iphone = new OrderItem();
    iphone.setItemName( "iPhone" );
    iphone.setPrice( 599 );
    iphone.setManufacturer( apple );

    Order appleStuff = new Order();
    appleStuff.setName( "Order for office" );
    appleStuff.addItem( macbook );
    appleStuff.addItem( iphone );

    Backendless.Data.of( Order.class ).save( appleStuff );
  }
}
