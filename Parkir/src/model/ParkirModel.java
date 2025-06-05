/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.*;
import java.util.*;

/**
 *
 * @author Lab Informatika
 */
public class ParkirModel {
    private Connection conn;
    
    public ParkirModel(){
        conn = ConnectDB.getConnection();
    }
    
    private int totalBiaya(int durasi){
        int total = 0;
        if(durasi < 4){
            total = durasi * 5000;
        }else if (durasi > 4){
            total = durasi *2000;
        }
        return total;
    }
    
    public void addParkir(String namaP, String plat, String merk, int durasi){
        String query = "INSERT INTO kendaraan (nama_pemilik, plat, merk, durasi, total_biaya) VALUES (?, ?, ?, ?, ?)";
        
        try(PreparedStatement st = conn.prepareStatement(query)){
          int total = totalBiaya(durasi);
          
          st.setString(1, namaP);
          st.setString(2, plat);
          st.setString(3, merk);
          st.setInt(4, durasi);
          st.setInt(5, total);
          
          st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<Object[]> getParkir(){
        List<Object[]>data = new ArrayList<>();
        String query = "SELECT * FROM kendaraan";
        try(Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)){
            while(rs.next()){
                Object[] row = new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama_pemilik"),
                    rs.getString("plat"),
                    rs.getString("merk"),
                    rs.getInt("durasi"),
                    rs.getInt("total_biaya")
                };
                data.add(row);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
   
        return data;
    }
    
    public void deleteParkir(int id){
        String query = "DELETE FROM parkir WHERE id = ?";
        
        try(PreparedStatement st = conn.prepareStatement(query)){         
          st.setInt(1, id);
          st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void editParkir(int id, String namaP, String plat, String merk, int durasi){
        String query = "UPDATE parkir SET nama_pemilik = ?, plat = ?, merk = ?, durasi = ?, total_bayar = ? WHERE id = ?";
        
        try(PreparedStatement st = conn.prepareStatement(query)){
          int total = totalBiaya(durasi);
          
          st.setString(1, namaP);
          st.setString(2, plat);
          st.setString(3, merk);
          st.setInt(4, durasi);
          st.setInt(5, total);
          st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
