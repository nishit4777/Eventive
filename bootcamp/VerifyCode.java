package bootcamp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VerifyCode")
public class VerifyCode extends HttpServlet {

    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String code = request.getParameter("authcode");
            if(code.equals(EmailSendingServlet.hello)){
                out.println("Verification Done");
            }else{
                out.println("Incorrect verification code");
            }
            
        }
        catch(Exception e) {
        	e.printStackTrace();
        	System.out.print("helloworld\n");
        }
    }

}