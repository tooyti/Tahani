package com.example.datauser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DNB {
    private static final String ip="DESKTOP-U6CVKHO\\SQLEXPRESS";
    private static final String port="1433";
    private static final String DN="DBuser";
    private static final String username="DESKTOP-U6CVKHO\\96655";
    private static final String password="";
    private static final String CLASS="net.sourceforge.jtds.jdbc.Driver";
    private static final String url="jdbc:jtdc:sqlserver://"+ ip+ ":" +port + "/"+DN;
private Connection connection=null;
    public boolean Insert (String i, String y) {
    boolean result = false;
    try {
        Class.forName(CLASS);
        connection = DriverManager.getConnection(url,username,password);
        if (connection != null) {
            Statement statement = connection.createStatement();
            result = statement.execute("INSERT INTO sign up values ('" + i + "','" + y + "')");
            result = true;
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }

        return result;
    }
public boolean Check(String i){
    boolean result=false;
    try {
        Class.forName(CLASS);
        try {
        connection =DriverManager.getConnection(url);
        if (connection!=null){
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from sign up where Username='"+i+"' ");
            while (resultSet.next()){
                result=true;
            }
        }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return result;
}
}


