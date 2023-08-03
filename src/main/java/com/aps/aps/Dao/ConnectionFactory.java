package com.aps.aps.Dao;
import com.aps.aps.Interface.connectDB;

import java.sql.*;

public class ConnectionFactory implements connectDB{
    public ConnectionFactory() {
        super();
   }
  
   @Override
   public Connection criaConexao() {
   String url = "jdbc:postgresql://dpg-ciuknatiuiedpv0j13mg-a:5432/cruduser";
       String user = "cruduser_user";
       String password = "aj8Ie4dVj3SieQpGVEGQPgHuLf0zbfbs";

       /*String url = "jdbc:postgresql://dpg-ciuknatiuiedpv0j13mg-a.oregon-postgres.render.com:5432/cruduser";
       String user = "cruduser_user";
       String password = "aj8Ie4dVj3SieQpGVEGQPgHuLf0zbfbs"; */

       Connection conetar = null;
       try {
           conetar = (Connection) DriverManager.getConnection(url, user, password);
           System.out.println("Conectado com sucesso!");
       } catch (SQLException ex) {
           //Logger.getLogger(FabricaDeConexao.class.getName()).log(Level.SEVERE, null, ex);
       }
       return conetar;

   }
    
}
