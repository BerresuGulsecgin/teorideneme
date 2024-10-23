package org.berre.repository;

import java.sql.*;
import java.util.Optional;

public class ConnectionProvider {
    private final String vtAd="Java12SatisV1";
    private final String username="postgres";
    private final String password ="1234";
    private final String connectionAdres = "jdbc:postgresql://localhost:5432/"+vtAd;

    Connection connection;


    private boolean openConnection(){
        try {
            connection = DriverManager.getConnection(connectionAdres,username,password);
            return true;
        } catch (SQLException e) {
            return false;
        }

    }
    private void closeConnection(){
        try {
            if (!connection.isClosed())
                connection.close();

        } catch (SQLException e) {
            System.out.println("close connection metodunda hata "+e);
        }

    }

    public boolean myExecuteUpdate(String Query){
        if(openConnection()){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query);
                preparedStatement.executeUpdate();//insert, delete,update için
                closeConnection();
                return true;

            } catch (SQLException e) {
                closeConnection();
            }

        }
        return false;
    }
    public Optional<ResultSet> getAllData(String Query){
        if (openConnection()){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query);
                ResultSet resultSet = preparedStatement.executeQuery(); //select için
                closeConnection();
                return Optional.of(resultSet);
            } catch (SQLException e) {
                closeConnection();
            }
        }
        return Optional.empty();
    }

}
