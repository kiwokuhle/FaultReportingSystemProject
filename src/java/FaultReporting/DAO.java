/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FaultReporting;

import java.sql.*;
import java.util.*;

/**
 *
 * @author 212104756
 */
public class DAO {
    //connection datavase to java code
    private String driver = "com.mysql.jdbc.Driver";
    //connecting database named fault reporter
    private String url = "jdbc:mysql://localhost:3306/faultrepoter_db";
    private String username = "root";//database username.
    private String password = "root";//database password.
    //constructor for loading drivers of database.
    public DAO() throws ClassNotFoundException{
        Class.forName(driver);
    }//returns connection to a database
    public Connection getConnection() throws Exception{
        Connection connection = 
                DriverManager.getConnection(this.url,this.username,this.password);
        return connection;
    }//closing database connection.
    public void closeConnection() throws Exception {
        
        getConnection().close();
    }
    //method adding fault in residence. 
    public boolean addResidence( Residence residence) throws Exception{
        //checking data passed to the methods.
        if (residence.getId() == 0){
            throw new IllegalArgumentException( "id cannot be null or blank.");
        }
        boolean isInserted = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        //inserting fault to daabase.
        String sql="INSERT INTO residence(id, rezName, roomNO, faultDescription, date)VALUES(?,?,?,?,?)";
        try {
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,residence.getId());
            pstmt.setString(2,residence.getRezName());
            pstmt.setInt(3,residence.getRoomNo());
            pstmt.setString(4,residence.getFaultDescription());
            pstmt.setDate(5,residence.getDate());
            //validate excution status.
            int status=pstmt.executeUpdate();
            System.out.println(status);
            if(status>0){
                isInserted = true;
            }else{
                isInserted = false;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            //close database resourses
            pstmt.close();
            closeConnection();
        }
        return isInserted;
        }

    boolean updateResidence(Residence r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
    public boolean upDateResidence(Residence residence) throws Exception{
        if (residence.getId() == 0)
        {
          throw new IllegalArgumentException("Id cannot be null");
        }
        if (residence .getRezName()==null)
        {
            throw new IllegalArgumentException("rezName cannot be null");
        }
        if(residence .getRoomNo() == 0)
        {
            throw new IllegalArgumentException("roomno cannot be null.");
        }
        if(residence .getFaultDescription() == null)
        {
            throw new IllegalArgumentException("fault description cannot be null");
        }
        if (residence.getDate()==null)
        {
            throw new IllegalArgumentException("date cannot be null");
        }
        
        boolean isUpdated = false;
        Connection conn = null;
          PreparedStatement pstmt = null;
          
          String sql="UPDATE residence SET roomNo=? WHERE id=?";
          
          try
          {
              conn = this.getConnection();
              pstmt = conn.prepareStatement(sql);
              pstmt.setInt(1,residence.getRoomNo());
             pstmt.setInt(2,residence.getId());
             int Status = pstmt.executeUpdate();
            if(Status>0){
                isUpdated = true;
            } else{
                isUpdated = false;
            }
          }
          catch(SQLException ex){
              ex.printStackTrace();
          }
            finally
            {
                pstmt.close();
                    closeConnection();
                    }
            return isUpdated;
             
          
       
    }
    
    public ArrayList<Residence> listALLResidence() throws Exception{
        ArrayList<Residence> list = new ArrayList<Residence>();
         
        Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet results=null;
        String sql="SELECT rezName, roomNo, faultDescription, date, id FROM residence";
        
        try
        {
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            results=pstmt.executeQuery();
            while(results.next())
            {
                Residence r = new Residence (results.getString(1), results.getInt(2), results.getString(3), results.getDate(4),results.getInt(5));
                list.add(r);
                
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        finally
        {
            results.close();
            pstmt.close();
            closeConnection();
            
        }
        return list;
        
   }
    public Residence searchById(int id) throws Exception{
        //validate fields
 
       
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet results = null;
        String slq =" SELECT rezName, roomNo, faultDescription,date,id FROM residence WHERE id=?";
        Residence r = null;
        try 
        {
           
            conn = this.getConnection();
            pstmt = conn.prepareStatement(slq);
            pstmt.setInt(1, id);
            
            results = pstmt.executeQuery();
            if(results.next())
            {
                r = new Residence (results.getString(1), results.getInt(2), results.getString(3), results.getDate(4), results.getInt(5));
                
                
            }
            
        }
        
        finally
        {
            results.close();
            pstmt.close();
            conn.close();
        }
        return r;
}
}
        
       

    
    
    

