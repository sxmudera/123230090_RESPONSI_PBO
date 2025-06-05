/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
/**
 *
 * @author Lab Informatika
 */
public class ConnectDB {
    public static Connection getConnection(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/parkir?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String un = "root";
        String pw = "";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, un, pw);
            System.out.println("Berhasil menghubungkan ke database");
        }catch(ClassNotFoundException | SQLException e){
            System.err.println("Gagal menghubungkan ke database");
        }
        return conn;
    }
}
