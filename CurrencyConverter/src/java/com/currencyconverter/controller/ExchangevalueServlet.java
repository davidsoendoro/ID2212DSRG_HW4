/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.currencyconverter.controller;

import com.currencyconverter.model.CurrencyFacade;
import com.currencyconverter.model.ExchangevalueFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author davidsoendoro
 */
@WebServlet(name = "ExchangevalueServlet", urlPatterns = {"/exchangevalue", "/index"})
public class ExchangevalueServlet extends HttpServlet {
    
    @EJB
    private CurrencyFacade currencyFacade;
    
    @EJB
    private ExchangevalueFacade exchangevalueFacade;

    @Override
    public void init() throws ServletException {

        // store category list in servlet context
        getServletContext().setAttribute("currencies", currencyFacade.findAll());
        getServletContext().setAttribute("exchangevalues", exchangevalueFacade.findAll());
    }
    
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
        String userPath = request.getServletPath();
        
        // use RequestDispatcher to forward request internally
//        String url = "/WEB-INF/jsp" + userPath + ".jsp";
        String url = "/WEB-INF/jsp/index.jsp";

        if (userPath.equals("/exchangevalue")) {
            String fromCode = request.getParameter("fromCode");
            String toCode = request.getParameter("toCode");
            String fromAmount = request.getParameter("fromAmount");
            
            double fromAmountDouble = Double.valueOf(fromAmount);
            double exchangevalue = 1.0;
            
            if(!fromCode.equals(toCode))
                exchangevalue = exchangevalueFacade.getExchangevalue(fromCode, toCode);
            
            request.setAttribute("toAmount", fromAmountDouble + " " + fromCode +
                    " = " + fromAmountDouble * exchangevalue + " " + toCode);
        }
        
        request.getRequestDispatcher(url).forward(request, response);
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
