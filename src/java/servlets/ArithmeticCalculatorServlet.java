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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String first = request.getParameter("first");
        String second = request.getParameter("second");

        String button = request.getParameter("button");
        String result = "---";

        // validation: if the parameters don't exist or are empty, show the first page again
        if (first == null || first.equals("") || second == null || second.equals("")) {
            result = "invalid";
            // set an attribute for a message
            request.setAttribute("result", result);
        } else {
            int firstNum = Integer.parseInt(first);
            int secondNum = Integer.parseInt(second);
            double ans = 0;

            if (button.equals("add")) {
                ans = firstNum + secondNum;
                result = "" + ans;
            } else if (button.equals("subtract")) {
                ans = firstNum - secondNum;
                result = "" + ans;
            } else if (button.equals("multiply")) {
                ans = firstNum * secondNum;
                result = "" + ans;
            } else if (button.equals("modulus")) {
                ans = firstNum % secondNum;
                result = "" + ans;
            } else {
                result = "invalid";
            }
            request.setAttribute("result", result);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }

}
