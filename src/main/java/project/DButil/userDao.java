package project.DButil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import project.PCMS.Model.user;

@Repository
public class userDao {
    

    public int create(user user) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String sql = "INSERT INTO `user`(username,fullname,phoneNo,password) values(?,?,?,?)";
        Object args[] = {user.getusername(),user.getfullname(), user.getphoneNo(), user.getpassword() };
        int row = jdbcTemplate.update(sql, args);
        return row;
    }


    public DataSource getDataSource() {
        DataSource dataSource = null;

        String url="jdbc:mysql://localhost:3306/pcms";
        String username="root";
        String password="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dataSource = new DriverManagerDataSource(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
    
        }
        return dataSource;
    }
}
