package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TruckService {

    public void addTruck(Truck truck){

        String sql = "insert into truck (name,model,capacity,driver_name) values(?,?,?,?)";

        try{

            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriverName());

//            int update = preparedStatement.executeUpdate();
//            System.out.println("Row inserted" + update);


        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public Truck getTruckId(int id){

        String sql = "Select * from truck where id = ?";

        Truck truck = null;

        try {

            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriverName(resultSet.getString("driver_name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return truck;
    }




}
