/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author P90
 */
public class Conexion {
    String url = "jdbc:mysql://localhost/bd_safaroam";
    String user = "root";
    String pass = "";
    Connection con = null;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            if (con!=null) {
                
            }
        } catch (Exception e) {
        }
    }
}
