package vn.phatbee.ltwebst2.dao.impl;

import vn.phatbee.ltwebst2.configs.DBConnectSQL;
import vn.phatbee.ltwebst2.dao.IUserDao;
import vn.phatbee.ltwebst2.models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DBConnectSQL implements IUserDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<UserModel> findAll() {
        String sql = "select * from users";
        List<UserModel> list = new ArrayList<UserModel>(); // Tạo List de truyền du lieu
        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new UserModel(rs.getInt("id"), rs.getString("username"),
                        rs.getString("email"), rs.getString("fullname"),
                        rs.getString("password"), rs.getString("images"),
                        rs.getInt("roleid"), rs.getString("phone"),
                        rs.getDate("date")));
            }
            return list;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserModel findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            UserModel userModel = new UserModel();
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                userModel.setId(rs.getInt("id"));
                userModel.setUsername(rs.getString("username"));
                userModel.setEmail(rs.getString("email"));
                userModel.setFullname(rs.getString("fullname"));
                userModel.setPassword(rs.getString("password"));
                userModel.setImages(rs.getString("images"));
                userModel.setRoleid(rs.getInt("roleid"));
                userModel.setPhone(rs.getString("phone"));
                userModel.setDate(rs.getDate("date"));
            }
            return userModel;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void insert(UserModel user) {
        String sql = "insert into users (username, email, fullname, password, images, roleid, phone, date) " +
                "values(?,?,?,?,?,?,?,?)";
        try {

            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getImages());
            ps.setInt(6, user.getRoleid());
            ps.setString(7, user.getPhone());
            ps.setDate(8, user.getDate());
            ps.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public UserModel findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ? ";
        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullname"));
                user.setPassword(rs.getString("password"));
                user.setImages(rs.getString("images"));
                user.setRoleid(Integer.parseInt(rs.getString("roleid")));
                user.setPhone(rs.getString("phone"));
                user.setDate(rs.getDate("date"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkExistUsername(String username) {
        boolean duplicate = false;
        String query = "select * from users where username = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                duplicate = true;
            }
            ps.close();
            conn.close();

        } catch (Exception e) {}
        return duplicate;
    }

    @Override
    public boolean checkExistEmail(String email) {
        boolean duplicate = false;
        String query = "select * from users where email = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                duplicate = true;
            }
            ps.close();
            conn.close();

        } catch (Exception e) {}
        return duplicate;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        boolean duplicate = false;
        String query = "select * from users where phone = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            while (rs.next()) {
                duplicate = true;
            }
            ps.close();
            conn.close();

        } catch (Exception e) {}
        return duplicate;
    }

    public static void main(String[] args) {
        UserDaoImpl dao = new UserDaoImpl();
        UserModel user2 = dao.findById(1);
        System.out.println (user2);
/*
        try {
            dao.insert(new UserModel("tama", "mytamhuynhmmt@gmail.com", "Tama OwO",
                    "24092004", "null", 2, "0926525911",
                    new Date(new SimpleDateFormat("dd/MM/yyyy").parse("17/09/2024").getTime())));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
*/


        List<UserModel> list = dao.findAll();
        for (UserModel user : list) {
            System.out.println(user);
        }
    }

}
