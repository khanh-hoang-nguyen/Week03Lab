/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pandawr
 */
@WebServlet(name = "ArithmeticCalculatorServlet", urlPatterns = {"/arithmetic"})
public class ArithmeticCalculatorServlet extends HttpServlet {
    
    private static String result ="---";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("result", result);
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String first = request.getParameter("first");
        String second = request.getParameter("second");
        
        request.setAttribute("first", first);
        request.setAttribute("second", second);

        String button = request.getParameter("button");

        try {
            
            if (first == null || first.equals("") || second == null || second.equals("")) {
                result = "invalid";
                // set an attribute for a message
                request.setAttribute("result", result);
            } else {
                int firstNum = Integer.parseInt(first);
                int secondNum = Integer.parseInt(second);
                int ans = 0;

                if (button.equals("add")) {
                    ans = firstNum + secondNum;
                } else if (button.equals("subtract")) {
                    ans = firstNum - secondNum;
                } else if (button.equals("multiply")) {
                    ans = firstNum * secondNum;
                } else if (button.equals("modulus")) {
                    ans = firstNum % secondNum;
                } else {
                    result = "invalid";
                }
                result = "" + ans;
                request.setAttribute("result", result);
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                    .forward(request, response);

        } catch (NumberFormatException numE) {
            request.setAttribute("result", "invalid");
        } catch (Exception e) {
            request.setAttribute("result", "invalid");
        }
        
        // show the page again when exception causes
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                    .forward(request, response);
    }

}
