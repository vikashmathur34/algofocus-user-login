/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vikash kumar
 */
public class Connect_db {
    Connection cn=null;
    public Connection getConnection(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
    
    }
    catch(ClassNotFoundException|SQLException e){
    System.out.println(e.toString());
    }
    return cn;
    }

    }
