package vn.phatbee.ltwebst2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.phatbee.ltwebst2.services.IUserService;
import vn.phatbee.ltwebst2.services.impl.UserService;
import vn.phatbee.ltwebst2.utils.Constant;

import java.io.IOException;

@WebServlet(urlPatterns = "/reset-password")
public class ResetPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IUserService service = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String newPassword = req.getParameter("newPassword");
        String confirmPassword = req.getParameter("confirmPassword");
        String alertMsg = "";

        if (!newPassword.equals(confirmPassword)) {
            alertMsg = "Vui lòng xác nhận lại mật khẩu";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("views/reset-pass.jsp").forward(req, resp);
            return;
        }

        boolean isSuccess = service.updatePassword(username, newPassword);
        if (isSuccess) {
            req.setAttribute("alert", alertMsg);
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            alertMsg = "System error!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("views/reset-pass.jsp").forward(req, resp);
        }

    }
}
