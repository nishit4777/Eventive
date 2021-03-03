package bootcamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;

@WebServlet("/signupvalidation")
public class signupvalidation extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out=res.getWriter();
        String OwnerName=req.getParameter("name").trim();
        //String PhoneNum=req.getParameter("phone").trim();
        String Email=req.getParameter("email");
        String Password=req.getParameter("psw");
        //String RePassword=req.getParameter("repass");
        Boolean CheckName=Pattern.matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",OwnerName);
       // Boolean CheckPhone=Pattern.matches("^[2-9]{1}[0-9]{9}$",PhoneNum);
        Boolean CheckEmail=Pattern.matches("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",Email);
        Boolean CheckPassword=Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",Password);
                                           //  ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$
        if(OwnerName.isEmpty()){
           // System.out.println("Owner name can't be empty");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Name is required');");
            out.println("location='signup.html';");
            out.println("</script>");
        }
        else if(CheckName==false){
           // System.out.print("Enter a Proper Name");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Name does not meet the requirements');");
            out.println("location='signup.html';");
            out.println("</script>");
        }
        else if(CheckEmail==false){
           // System.out.print("Enter a Proper Emailid");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Enter a Proper Emailid');");
            out.println("location='signup.html';");
            out.println("</script>");
        }
        //else if(PhoneNum.isEmpty()){
       //     System.out.println("Phone Number is empty");
      //  }
       // else if(CheckPhone==false){
       //     System.out.println("Enter a Valid phone Number");
       // }
        else if(Password.isEmpty()) {
        	out.println("<script type=\"text/javascript\">");
            out.println("alert('password is required');");
            out.println("location='signup.html';");
            out.println("</script>");
        }
        else if(CheckPassword==false){
        	out.println("<script type=\"text/javascript\">");
            out.println("alert('password does not meet the requirements');");
            out.println("location='signup.html';");
            out.println("</script>");
        }
       // else if(Password.equals(RePassword)==false){
        //    System.out.println("Retype the password properly");
       // }
        else{
           // RequestDispatcher rd=req.getRequestDispatcher("signup");
            //rd.forward(req,res);
        	RequestDispatcher r=req.getRequestDispatcher("insertsignup");
        	r.forward(req, res);
        	System.out.print("HELLOO");
        	
        }


    }
}