/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FaultReporting;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 212104756
 */
@WebServlet(name = "UpdateResidenceServlet", urlPatterns = {"/UpdateResidenceServlet"})
public class UpdateResidenceServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rezName=request.getParameter("residenceName");
        String roomN=request.getParameter("roomNo");
        String faultDescription=request.getParameter("faultDescription");
        String date=request.getParameter("date");
        String idm=request.getParameter("id");
        ArrayList<String> errors=new ArrayList<String>();
        DAO dao=null;
        String dispatch="editResidence.jsp";
        int id=Integer.parseInt(idm);
        int roomNo=Integer.parseInt(roomN);
        
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date dateobj = new Date(0);
        java.sql.Date sqlDate = new java.sql.Date(dateobj.getTime());
     
        try
        {
            if(rezName==null || rezName.length()==0)
            {
                errors.add("rezName is required.");
            }
            if(roomN==null || roomN.length()==0)
            {
                errors.add("roomN is required.");
            }
            if(faultDescription==null || faultDescription.length()==0)
            {
                errors.add("faultDescription is required.");
            }
            if(dateobj==null)
            {
                errors.add("date is required.");
            }
            
            if(idm==null|| idm.length()==0)
            {
                errors.add(" id is required.");
            }
            
            if(errors.isEmpty()){
                Residence newResidence=new Residence(rezName,roomNo,faultDescription,dateobj,id);
                dao=new DAO();
                boolean isAdded=dao.updateResidence(newResidence);
                if(isAdded)
                {
                    request.setAttribute("successMsg", " Residence named " + rezName+ " " +roomNo+ " " +faultDescription+ " " +date+ " " +id+" " + " updated ");
                    dispatch="listResidence.jsp";
                
                }
                else
                {
                    errors.add("Residence not updated");
                     request.setAttribute("errorList", errors);
                }
    
            }
            else
            {
                request.setAttribute("errorList", errors);
            }
            
           
            
        }catch(Exception ex){
            errors.add("ERROR:"+ex.getMessage());
             request.setAttribute("errorList", errors);
            ex.printStackTrace();
        }
        finally
        {}
        RequestDispatcher rd=request.getRequestDispatcher(dispatch); 
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
