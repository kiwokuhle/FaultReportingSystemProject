/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FaultReporting;

import java.sql.*;

/**
 *
 * @author 212104756
 */
public class Residence {
    private String rezName;
    private int roomNo;
    private String faultDescription;
    private Date date;
    private int id;

    public Residence(String rezName, int roomNo, String faultDescription, Date date,int id) {
        this.rezName = rezName;
        this.roomNo = roomNo;
        this.faultDescription = faultDescription;
        this.date = date;
        this.id=id;
    }

    public Residence() {
    }

    public String getRezName() {
        return rezName;
    }

    public void setRezName(String rezName) {
        this.rezName = rezName;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
}
