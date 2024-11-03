package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class App 
{

    public static void main( String[] args ) {

        TruckService truckService  = new TruckService();
        Truck tata =  new Truck("TATA","2019",1000,"Rajesh");
        Truck volvo =  new Truck("VOLVO","2023",1000,"Akash");
        Truck eicher =  new Truck("EICHER","2022",1000,"Harshit");

        // adding data in database
        truckService.addTruck(tata);
        truckService.addTruck(volvo);
        truckService.addTruck(eicher);

        // fetch
        Truck truck = truckService.getTruckById(1);
        System.out.println("Truck data:" + truck);

        // updating truck data

        truck.setDriverName("Ramesh");
        truckService.updateTruck(truck);
        System.out.println("Updated truck data: " + truckService.getTruckById(1));

        // get all truck data
        List<Truck> allTrucks = truckService.getAllTrucks();
        System.out.println("All trucks in DB: ");
        for(Truck truck1 : allTrucks){
            System.out.println(truck1);
        }

        // delete truck data
        truckService.deleteTruck(2);
        System.out.println("Data deleted by id: " + 2);

        allTrucks=truckService.getAllTrucks();
        System.out.println("All trucks after all operations :");
        System.out.println(allTrucks);

        }
    }



