package vn.phatbee.ltwebst2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.phatbee.ltwebst2.models.UserModel;
import vn.phatbee.ltwebst2.services.IUserService;
import vn.phatbee.ltwebst2.services.impl.UserService;
import vn.phatbee.ltwebst2.utils.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static vn.phatbee.ltwebst2.utils.Constant.UPLOAD_DIRECTORY;


@WebServlet(urlPatterns = "/profile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IUserService service = new UserService();
    UserModel user = new UserModel();

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return Constant.DEFAULT_FILENAME;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/web/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath = File.separator + UPLOAD_DIRECTORY; //upload vào thư mục bất kỳ
        //String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY; //upload vào
        // thư mục project

        String username = req.getParameter("username");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists())
            uploadDir.mkdir();
        try {
            String fileName = "";
            for (Part part : req.getParts()) {
                String partName = part.getName();
                if(partName.equals("image")){
                    fileName = getFileName(part);
                    part.write(uploadPath + File.separator + fileName);
                }
            }

            req.setAttribute("message", "File " + fileName + " has uploaded successfully!");

            // Cap nhat database
            user.setUsername(username);
            user.setImages(fileName);
            service.updateProfile(user);

        } catch (FileNotFoundException fne) {
            req.setAttribute("message", "There was an error: " + fne.getMessage());
        }
        getServletContext().getRequestDispatcher("/views/web/profile.jsp").forward(req, resp);


    }
}
