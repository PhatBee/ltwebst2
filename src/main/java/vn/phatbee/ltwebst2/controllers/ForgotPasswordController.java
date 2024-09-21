package vn.phatbee.ltwebst2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.phatbee.ltwebst2.models.UserModel;
import vn.phatbee.ltwebst2.services.IUserService;
import vn.phatbee.ltwebst2.services.impl.UserService;
import vn.phatbee.ltwebst2.utils.Constant;

import java.io.IOException;

@WebServlet(urlPatterns = "/forgot-password")
public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IUserService service = new UserService();
    String alertMsg="";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String username = req.getParameter("username");

        if(service.checkExistEmail(email) && service.checkExistUsername(username)){
            req.setAttribute("email", email);
            req.setAttribute("username", username);
            req.getRequestDispatcher("views/reset-pass.jsp").forward(req, resp);
        }
        else{
            alertMsg = "Thông tin không tồn tại, vui lòng kiểm tra lại";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("views/forgot-pass.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/forgot-pass.jsp").forward(req, resp);
    }
}
