package com.aps.aps.Dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aps.aps.Models.Campo;
import com.aps.aps.Models.ConfigActivity;
import com.aps.aps.Models.Registry;



public class ConfigActivityDao {
   
    public ConfigActivityDao() {
        super();
   }

   Connection con=new ConnectionFactory().criaConexao();
   
   public String insertConfigActivity(ConfigActivity configActivity) {
       
       try {
           CallableStatement p = (CallableStatement) con.prepareCall("{CALL insertConfigActivity(?,?,?,?,?,?,?,?)}");
           p.setString(1, configActivity.getUrlpdf());
           p.setString(2, configActivity.getUrlpdfstatus());
           p.setString(3, configActivity.getQuestao1());
           p.setString(4, configActivity.getQuestao1status());
           p.setString(5, configActivity.getQuestao2());
           p.setString(6, configActivity.getQuestao2status());
           p.setString(7, configActivity.getQuestao3());
           p.setString(8, configActivity.getQuestao3status());
           
           p.executeQuery();
           /*if (res.next()){
               
               return "Actividade configurada com sucesso";
           }*/
           
       } catch (SQLException ex) {
           Logger.getLogger(ConfigActivityDao.class.getName()).log(Level.SEVERE, null, ex);
           //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
       }
       return "Erro";
   }

    public String insertConfigActivity2(Registry r) {
       try {
           CallableStatement p = (CallableStatement) con.prepareCall("{CALL insertConfigActivity(?,?,?,?,?,?,?,?)}");
           for(Campo c:r.getJson_params_url())
          // p.setString(a++, c.);
           
           p.executeQuery();
          
           
       } catch (SQLException ex) {
           Logger.getLogger(ConfigActivityDao.class.getName()).log(Level.SEVERE, null, ex);
           //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
       }
       return "Erro";
   }


  public List<ConfigActivity>  getConfigActivity() {
     List<ConfigActivity> ul=new ArrayList<>();
       try (
           CallableStatement p = con.prepareCall("{CALL listarConfigActivity()}")){
           
           
           ResultSet res = p.executeQuery();
           while (res.next()){
               ConfigActivity u=new ConfigActivity();
               u.setIdActivity(res.getInt(1));
               u.setUrlpdf(res.getString(2));
               u.setUrlpdfstatus(res.getString(3));
               u.setQuestao1(res.getString(4));
               u.setQuestao1status(res.getString(5));
                u.setQuestao2(res.getString(6));
               u.setQuestao2status(res.getString(7));
                u.setQuestao3(res.getString(8));
               u.setQuestao3status(res.getString(9));
               
               ul.add(u);
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ConfigActivityDao.class.getName()).log(Level.SEVERE, null, ex);
           //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
       }
       return ul;
   }

  public boolean  createActivityTable() {
     
       try {
        Statement stmt = (Statement) con.createStatement();
        String sql = "CREATE TABLE configactivity " +
             "(idconfigactivity SERIAL PRIMARY KEY)"; 

        stmt.executeUpdate(sql);
        return true;
           
       } catch (SQLException ex) {
           Logger.getLogger(ConfigActivityDao.class.getName()).log(Level.SEVERE, null, ex);
          
       }
       return false;
   }

   public boolean  dropActivityTable() {
     
       try {
        Statement stmt = (Statement) con.createStatement();
        String sql = "drop table configactivity"; 

        stmt.executeUpdate(sql);
        return true;
           
       } catch (SQLException ex) {
           Logger.getLogger(ConfigActivityDao.class.getName()).log(Level.SEVERE, null, ex);
          
       }
       return false;
   }


public boolean updateTable(Registry r) {
    try {
        Statement stmt = (Statement) con.createStatement();
        for(Campo c:r.getJson_params_url()){
        String sql = "alter table configactivity add "+c.getName()+" text";
       
        stmt.executeUpdate(sql);
        }
        return true;
           
       } catch (SQLException ex) {
           Logger.getLogger(ConfigActivityDao.class.getName()).log(Level.SEVERE, null, ex);
          
       }
       return false;
}

public boolean activeCofigActivictyRow() {
    try {
        Statement stmt = (Statement) con.createStatement();
       
        String urlpdfValue = "www"; 
        
        String sql = "INSERT INTO configactivity (urlpdf) VALUES ('" + urlpdfValue + "')";
           
        stmt.executeUpdate(sql);
        
        return true;
           
       } catch (SQLException ex) {
           Logger.getLogger(ConfigActivityDao.class.getName()).log(Level.SEVERE, null, ex);
          
       }
       return false;
}

public boolean updateActivictyColumn(String val,String col) {
    try {
        
        PreparedStatement ps = null;
       
        String sql = "update configactivity set "+val+"=? where idconfigactivity=?";
        ps = (PreparedStatement) con.prepareStatement(sql);
        
        ps.setString(1, col);
        ps.setInt(2, 1);
        ps.executeUpdate();
        return true;
           
       } catch (SQLException ex) {
           Logger.getLogger(ConfigActivityDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
}

public ConfigActivity  getActivity(int r) {
    ConfigActivity u=new ConfigActivity();
   
    String sql = "select * from configactivity";
    
    try (
        Statement statement = con.createStatement();
        ResultSet res = statement.executeQuery(sql)){

           while (res.next()){
               
               if(r>1)
               u.setIdActivity(res.getInt(1));
               

               if(r>=2){
               u.setUrlpdf(res.getString(2));
               u.setUrlpdfstatus(res.getString(3));
               }
               r-=2;
              
               if(r>=2){
               u.setQuestao1(res.getString(4));
               u.setQuestao1status(res.getString(5));
               }
               r-=2;

               if(r>=2){
               u.setQuestao2(res.getString(6));
               u.setQuestao2status(res.getString(7));
               }

               r-=2;
               
               if(r>=2){
               u.setQuestao3(res.getString(8));
               u.setQuestao3status(res.getString(9));
               }
               r-=2;

               if(r>=2){
               u.setQuestao4(res.getString(10));
               u.setQuestao4status(res.getString(11));
               }
               r-=2;

               if(r>=5){
               u.setQuestao5(res.getString(12));
               u.setQuestao5status(res.getString(13));
               }
               r-=2;

               if(r>=6){
               u.setQuestao6(res.getString(14));
               u.setQuestao6status(res.getString(15));
               }
               r-=2;

               if(r>=7){
               u.setQuestao7(res.getString(16));
               u.setQuestao7status(res.getString(17));
               }
               r-=2;

               if(r>=8){
               u.setQuestao8(res.getString(18));
               u.setQuestao8status(res.getString(19));
               }
               r-=2;

               if(r>=9){
               u.setQuestao9(res.getString(20));
               u.setQuestao9status(res.getString(21));
               }
               r-=2;

               if(r>=10){
               u.setQuestao10(res.getString(22));
               u.setQuestao10status(res.getString(23));
               }
               
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ConfigActivityDao.class.getName()).log(Level.SEVERE, null, ex);
           //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
       }
       return u;
   }

}
