package vn.phatbee.ltwebst2.controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.phatbee.ltwebst2.entity.Category;
import vn.phatbee.ltwebst2.entity.Video;
import vn.phatbee.ltwebst2.services.IVideoService;
import vn.phatbee.ltwebst2.services.impl.VideoServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/videos", "/admin/video/add","/admin/video/insert"})
public class VideoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IVideoService vidService = new VideoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI();
        if (url.contains("/admin/videos")){
            List<Video> list = vidService.findAll();
            req.setAttribute("listvideo", list);
            req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
        }
        else if (url.contains("/admin/video/add")){
            req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI();
        if (url.contains("/admin/video/insert")){
            // Lấy dữ liệu từ form
            int categoryid = Integer.parseInt(req.getParameter("categoryid"));
            String description = req.getParameter("description");
            String poster = req.getParameter("poster");
            String title = req.getParameter("title");
            int views = Integer.parseInt(req.getParameter("views"));
            int active = Integer.parseInt(req.getParameter("active"));

            Category category = new Category();

            // Đưa dữ liệu vào model
            Video video = new Video();
            video.setDescription(description);
            video.setTitle(title);
            video.setViews(views);
            video.setActive(active);

            // Gọi phương thức insert và truyền model vào


        }

    }
}
