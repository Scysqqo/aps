package com.aps.aps.Dao;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aps.aps.Models.User;

public class UserDao {
   
    public UserDao() {
        super();
   }

   

   Connection con = new ConnectionFactory().criaConexao();
   
   
   
   public String insertUser(User u) {
       
       
     
       try {
           CallableStatement p = (CallableStatement) con.prepareCall("{CALL insertCrudUser(?,?,?,?,?)}");
           p.setString(1, u.getNome());
           p.setString(2, u.getUtilizador());
           p.setString(3, u.getSenha());
           p.setString(4, u.getDataN());
           p.setString(5, u.getOcupacao());
           
           ResultSet res = p.executeQuery();
           if (res.next()){
               
               return "inserido com sucesso";
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
           //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
       }
       return "Erro";
   }

   public List<User>  gettUser() {
     List<User> ul=new ArrayList<>();
       try {
           CallableStatement p = (CallableStatement) con.prepareCall("{CALL listarUtilizador()}");
           
           
           ResultSet res = p.executeQuery();
           while (res.next()){
               User u=new User();
               u.setId(res.getInt(1));
               u.setNome(res.getString(2));
               u.setUtilizador(res.getString(3));
               u.setSenha(res.getString(4));
               u.setDataN(res.getString(5));
               u.setOcupacao(res.getString(6));
               ul.add(u);
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
           //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
       }
       return ul;
   }


    public int  login(int id) {
     try {
           CallableStatement p = (CallableStatement) con.prepareCall("{CALL login(?)}");
           p.setInt(1, id);
           
           ResultSet res = p.executeQuery();
           while (res.next()){
               
               return 1;
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
           //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
       }
       return 0;
   }

}
