package vn.phatbee.ltwebst2.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String username;
    private String email;
    private String fullname;
    private String password;
    private String images;
    private int roleid;
    private String phone;
    private Date date;
    private String code;

    public UserModel() {
        super();
    }

    public UserModel(String username, String email, String fullname, String password, String images, int roleid,
                     String phone, Date date) {
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.images = images;
        this.roleid = roleid;
        this.phone = phone;
        this.date = date;
    }

    public UserModel(int id, String username, String email, String fullname, String password, String images, int roleid,
                     String phone, Date date) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.images = images;
        this.roleid = roleid;
        this.phone = phone;
        this.date = date;
    }

    public UserModel(String username, String email, String fullname, String password, int roleid, String code) {
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.roleid = roleid;
        this.code = code;
    }

    public UserModel(String username, String email, String fullname, String code) {
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", images='" + images + '\'' +
                ", roleid=" + roleid +
                ", phone='" + phone + '\'' +
                ", date=" + date +
                '}';
    }


}
