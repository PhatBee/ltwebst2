package vn.phatbee.ltwebst2.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.phatbee.ltwebst2.models.UserModel;

import java.io.IOException;

@WebFilter(urlPatterns = {"/manager/*"})
public class ManagerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("account");
        UserModel user = (UserModel) obj;

        if (user != null && user.getRoleid() == 3) {
            chain.doFilter(request, response);
            return;
        } else {
            res.sendRedirect(req.getContextPath() + "/logout");
        }
    }
}
