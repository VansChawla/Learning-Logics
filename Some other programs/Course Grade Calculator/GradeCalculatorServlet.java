import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GradeCalculatorServlet extends HttpServlet {
    
    // We use doPost because the form method is "post"
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Retrieve Data from the Request
        String roll = request.getParameter("roll");
        String name = request.getParameter("name");
        
        // Parse the marks (Handle exceptions in a real app, but kept simple here)
        int m1 = Integer.parseInt(request.getParameter("mark1"));
        int m2 = Integer.parseInt(request.getParameter("mark2"));
        int m3 = Integer.parseInt(request.getParameter("mark3"));

        // 2. Perform Calculations
        int total = m1 + m2 + m3;
        double average = total / 3.0;
        
        // Optional: Calculate a grade based on average
        String grade;
        if (average >= 90) grade = "A";
        else if (average >= 75) grade = "B";
        else if (average >= 50) grade = "C";
        else grade = "F";

        // 3. Generate the HTML Response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Grade Summary</title></head>");
        out.println("<body>");
        
        out.println("<h2 style='color:blue;'>Student Performance Report</h2>");
        
        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr><th>Roll Number</th><td>" + roll + "</td></tr>");
        out.println("<tr><th>Name</th><td>" + name + "</td></tr>");
        out.println("<tr><th>Marks (Sub 1, 2, 3)</th><td>" + m1 + ", " + m2 + ", " + m3 + "</td></tr>");
        out.println("<tr><th>Total Score</th><td>" + total + " / 300</td></tr>");
        out.println("<tr><th>Average</th><td>" + String.format("%.2f", average) + "</td></tr>");
        out.println("<tr><th>Final Grade</th><td><b>" + grade + "</b></td></tr>");
        out.println("</table>");
        
        out.println("<br><a href='index.html'>Calculate Another</a>");
        
        out.println("</body>");
        out.println("</html>");
    }
}
