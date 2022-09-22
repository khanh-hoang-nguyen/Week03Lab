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
    
    private static String message = "You must enter a number.";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String age = request.getParameter("age");
        request.setAttribute("age", age);

        try {
            
            if (age == null || age.equals("")) {
                // set an attribute for a message
                request.setAttribute("message", message);
            } else {
                int theAge = Integer.parseInt(age);

                if (theAge >= 0 && theAge <= 150) {
                    theAge = theAge + 1;
                    message = "Your age next birthday will be " + theAge;
                } else if (theAge < 0 || theAge > 150) {
                    message = "You must give your current age.";
                }
                request.setAttribute("message", message);
            }

            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                    .forward(request, response);

        } catch (NumberFormatException numE) {
            request.setAttribute("message", message);
        } catch (Exception e) {
            request.setAttribute("message", message);
        }
        
        // show the page again when exception causes
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

}
