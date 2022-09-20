package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pandawr
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get the two parameters from the POST request
        String age = request.getParameter("age");

        // validation: if the parameters don't exist or are empty, show the first page again
        if (age == null || age.equals("")) {
            // set an attribute for a message
            request.setAttribute("message", "Please enter your age");
        } else {
            int theAge = Integer.parseInt(age);
            
            if (theAge >= 0 && theAge <= 150) {
                theAge = theAge + 1;
                String result = "Your age next birthday will be " + theAge;
                request.setAttribute("message", result);
            } else if (theAge < 0 || theAge > 150) {
                request.setAttribute("message", "You must give your current age.");
            } 
            else {
                request.setAttribute("message", "You must enter a number.");
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

}
