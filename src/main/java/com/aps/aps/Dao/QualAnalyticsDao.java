package com.aps.aps.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aps.aps.Models.QualAnalytics;


public class QualAnalyticsDao {
    public QualAnalyticsDao() {
        super();
   }

   Connection con = new ConnectionFactory().criaConexao();
   
   public String insertQualAnalytics(QualAnalytics qualAnalytics) {
       
       try (
           CallableStatement p =  con.prepareCall("{CALL insertQualAnalytics(?,?,?,?,?,?,?)}")){
           p.setInt(1, qualAnalytics.getIdactivity());
           p.setInt(2, qualAnalytics.getIdcruduser());
           p.setInt(3, qualAnalytics.getUrlstatus());
           p.setInt(4, qualAnalytics.getQuestao1status());
           p.setInt(5, qualAnalytics.getQuestao2status());
           p.setInt(6, qualAnalytics.getQuestao3status());
           p.setInt(7, qualAnalytics.getAttempty());
           p.execute();
          
           
       } catch (SQLException ex) {
           Logger.getLogger(ConfigActivityDao.class.getName()).log(Level.SEVERE, null, ex);
           //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
       }
       return "Erro";
   }

   public String updateQualAnalytics(QualAnalytics qualAnalytics) {
       
       try (
           CallableStatement p =  con.prepareCall("{CALL updateQualAnalytics(?,?,?,?,?,?,?)}")){
           p.setInt(1, qualAnalytics.getIdactivity());
           p.setInt(2, qualAnalytics.getIdcruduser());
           p.setInt(3, qualAnalytics.getUrlstatus());
           p.setInt(4, qualAnalytics.getQuestao1status());
           p.setInt(5, qualAnalytics.getQuestao2status());
           p.setInt(6, qualAnalytics.getQuestao3status());
           p.setInt(7, qualAnalytics.getAttempty());
           p.execute();
          
           
       } catch (SQLException ex) {
           Logger.getLogger(ConfigActivityDao.class.getName()).log(Level.SEVERE, null, ex);
           //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
       }
       return "Erro";
   }

  public List<QualAnalytics>  getQualAnalytics() {
     List<QualAnalytics> ul=new ArrayList<>();
       try(
        Statement statement = con.createStatement()) {
            
            String sql = "SELECT * FROM qualanalytics, cruduser WHERE qualanalytics.idcruduser = cruduser.idcruduser order by cruduser.idcruduser";
            ResultSet res = statement.executeQuery(sql);
            
            while (res.next()) {
               QualAnalytics u=new QualAnalytics();
               u.setIdactivity(res.getInt(1));
               u.setIdcruduser(res.getInt(2));
               u.setUrlstatus(res.getInt(3));
               u.setQuestao1status(res.getInt(4));
               u.setQuestao2status(res.getInt(5));
               u.setQuestao3status(res.getInt(6));
               u.setQuestao4status(res.getInt(7));
               u.setQuestao5status(res.getInt(8));
               u.setQuestao6status(res.getInt(9));
               u.setQuestao7status(res.getInt(10));
               u.setQuestao8status(res.getInt(11));
               u.setQuestao9status(res.getInt(12));
               u.setQuestao10status(res.getInt(13));
               u.setNome(res.getString(16));
               u.setAttempty(res.getInt(7));
               
               ul.add(u);
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
           //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
       }
       return ul;
   }

   public String saveUrlstatus(int iduser,int valor) {
   
    try {
        
        PreparedStatement ps = null;
       
        String sql = "update qualanalytics set urlstatus=? where idactivity=1 and idcruduser=?";
        ps = (PreparedStatement) con.prepareStatement(sql);
        
        ps.setInt(1, valor);
        ps.setInt(2, iduser);
        ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    return "update successfull";
}

public String saveQ1status(int iduser,int valor) {
  
    try {
        
        PreparedStatement ps = null;
       
        String sql = "update qualanalytics set questao1status=? where idactivity=1 and idcruduser=?";
        ps = (PreparedStatement) con.prepareStatement(sql);
        
        ps.setInt(1, valor);
        ps.setInt(2, iduser);
        ps.executeUpdate();
        
        
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
    }
    return "Erro";
}

public String saveQ2status(int iduser,int valor) {
  
    try {
        
        PreparedStatement ps = null;
       
        String sql = "update qualanalytics set questao2status=? where idactivity=1 and idcruduser=?";
        ps = (PreparedStatement) con.prepareStatement(sql);
        
        ps.setInt(1, valor);
        ps.setInt(2, iduser);
        ps.executeUpdate();
        
        
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
    }
    return "Erro";
}

public String saveQ3status(int iduser,int valor) {
  
    try {
        
        PreparedStatement ps = null;
       
        String sql = "update qualanalytics set questao3status=? where idactivity=1 and idcruduser=?";
        ps = (PreparedStatement) con.prepareStatement(sql);
        
        ps.setInt(1, valor);
        ps.setInt(2, iduser);
        ps.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
    }
    return "Erro";
}

public String saveQ4status(int iduser,int valor) {
  
    try {
        
        PreparedStatement ps = null;
       
        String sql = "update qualanalytics set questao4status=? where idactivity=1 and idcruduser=?";
        ps = (PreparedStatement) con.prepareStatement(sql);
        
        ps.setInt(1, valor);
        ps.setInt(2, iduser);
        ps.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
    }
    return "Erro";
}

public String saveQ5status(int iduser,int valor) {
  
    try {
        
        PreparedStatement ps = null;
       
        String sql = "update qualanalytics set questao5status=? where idactivity=1 and idcruduser=?";
        ps = (PreparedStatement) con.prepareStatement(sql);
        
        ps.setInt(1, valor);
        ps.setInt(2, iduser);
        ps.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
    }
    return "Erro";
}


public String saveQ6status(int iduser,int valor) {
  
    try {
        
        PreparedStatement ps = null;
       
        String sql = "update qualanalytics set questao6status=? where idactivity=1 and idcruduser=?";
        ps = (PreparedStatement) con.prepareStatement(sql);
        
        ps.setInt(1, valor);
        ps.setInt(2, iduser);
        ps.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
    }
    return "Erro";
}

public String saveQ7status(int iduser,int valor) {
  
    try {
        
        PreparedStatement ps = null;
       
        String sql = "update qualanalytics set questao7status=? where idactivity=1 and idcruduser=?";
        ps = (PreparedStatement) con.prepareStatement(sql);
        
        ps.setInt(1, valor);
        ps.setInt(2, iduser);
        ps.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
    }
    return "Erro";
}

public String saveQ8status(int iduser,int valor) {
  
    try {
        
        PreparedStatement ps = null;
       
        String sql = "update qualanalytics set questao8status=? where idactivity=1 and idcruduser=?";
        ps = (PreparedStatement) con.prepareStatement(sql);
        
        ps.setInt(1, valor);
        ps.setInt(2, iduser);
        ps.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
    }
    return "Erro";
}


public String saveQ9status(int iduser,int valor) {
  
    try {
        
        PreparedStatement ps = null;
       
        String sql = "update qualanalytics set questao9status=? where idactivity=1 and idcruduser=?";
        ps = (PreparedStatement) con.prepareStatement(sql);
        
        ps.setInt(1, valor);
        ps.setInt(2, iduser);
        ps.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
    }
    return "Erro";
}


public String saveQ10status(int iduser,int valor) {
  
    try {
        
        PreparedStatement ps = null;
       
        String sql = "update qualanalytics set questao10status=? where idactivity=1 and idcruduser=?";
        ps = (PreparedStatement) con.prepareStatement(sql);
        
        ps.setInt(1, valor);
        ps.setInt(2, iduser);
        ps.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        //JOptionPane.showMessageDialog(null, "ocorreu erro no acto da pesquisa!");
    }
    return "Erro";
}


}
