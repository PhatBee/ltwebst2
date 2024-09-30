package vn.phatbee.ltwebst2.dao.impl;

import vn.phatbee.ltwebst2.configs.DBConnectSQL;
import vn.phatbee.ltwebst2.dao.ICategoryDao;
import vn.phatbee.ltwebst2.models.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<CategoryModel> findAll() {
        String sql = "select * from categories";
        List<CategoryModel> list = new ArrayList<>();
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                list.add(category);
            }
            conn.close();
            ps.close();
            rs.close();
            return list;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public CategoryModel findById(int id) {
        String sql = "select * from categories where categoryid = ?";
        CategoryModel category = new CategoryModel();
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
            }
            conn.close();
            ps.close();
            rs.close();
            return category;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public CategoryModel findByName(String name) {
        String sql = "select * from categories where categoryname = ?";
        CategoryModel category = new CategoryModel();
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
            }
            conn.close();
            ps.close();
            rs.close();
            return category;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(CategoryModel category) {
        String sql = "insert into categories(categoryname,images,status) values(?,?,?)";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(CategoryModel category) {
        String sql = "update categories set categoryname=?,images=?,status=? where categoryid=?";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());
            ps.setInt(4, category.getCategoryid());
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        String sql = "delete from categories where categoryid = ?";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public List<CategoryModel> searchByName(String keyword) {
        String sql = "select * from categories where categoryname like ?";
        List<CategoryModel> list = new ArrayList<>();
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                list.add(category);
            }
            conn.close();
            ps.close();
            rs.close();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateStatus(int id, int status) {
        String sql = "update categories set status=? where categoryid=?";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
            conn.close();
            ps.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
