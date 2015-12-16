package controle;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
private static final long serialVersionUID = 1L;
@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    // gets the session if it exists
    HttpSession session = request.getSession(false);
    try {
      response.setContentType("text/html");
      PrintWriter writer = response.getWriter();
      writer.println("<html><body>");
      // If you are not in a session - you are not logged in
      if (session == null) {
        writer.println("<script>window.location = '/LocarWeb/';</script>");
      } else {
        writer.println("Thank you, you are already logged in");
        writer.println("<p>name=" + session.getAttribute("username") + " pass=" + session.getAttribute("password") + "</p>");
        
      }
      // Write html for a new login 
      writer.println("<p><a href=\"/LocarWeb/login.html\">Return" +
                     "</a> to login page</p>");
      writer.println("</body></html>");
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
