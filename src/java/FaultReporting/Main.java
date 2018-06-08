/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FaultReporting;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 212104756
 */
public class Main {
    public static void main(String [] args){
        try{
         DateFormat df = new SimpleDateFormat("dd/MM/yy");
          Date dateobj = new Date(0);
    
           java.sql.Date sqlDate = new java.sql.Date(dateobj.getTime());
            DAO dao = new DAO();
            Residence r=new Residence("Silimela",14147,"broken window",sqlDate,785);
           boolean test=dao.addResidence(r);
            if(test)
               System.out.println("residence fault Inserted Successfuly");
            else
                System.out.println("Residence Fault Not Inserted");
        }
        catch(Exception ex){
            ex.printStackTrace();
       }
    testUpDateResidence();
    }
    
    public static void testUpDateResidence(){
        try{
           DateFormat df = new SimpleDateFormat("dd/MM/yy");
           Date dateobj = new Date(0);
    
           java.sql.Date sqlDate = new java.sql.Date(dateobj.getTime());
            DAO dao = new DAO();
            
            Residence r=new Residence("chumani",333,"no light bulb",sqlDate,2);
            boolean test=dao.upDateResidence(r);
            if(test)
                System.out.println("Residence Updated Successfully");
            else
                System.out.println("Residence Not Updated");
        }
         catch (Exception ex){
            ex.printStackTrace();
        }
        testUpDateResidence();
          testListResidence();
   
  }
    
public static void testListResidence(){
      try
      {
          DAO dao = new DAO();
          ArrayList<Residence> residenceList=dao.listALLResidence();
          for(Residence r: residenceList){
              System.out.println(r.getRezName()+"\t"+r.getRoomNo()+"\t"+r.getFaultDescription()+"\t"+r.getDate()+"\t"+r.getId());
              
          }
      } 
      
      catch(Exception ex){
          ex.printStackTrace();
      }
      }



}

