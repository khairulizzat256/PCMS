package project.DButil;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;


import project.PCMS.Model.SharingSession;

@Repository
public class bookingsharingsessionDao {
    

    public int create(SharingSession sharingsession) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String sql = "INSERT INTO `bookingsharing`(fullname,phoneNo,time,date,address,details) values(?,?,?,?,?,?)";
        Object args[] = {sharingsession.getfullname(), sharingsession.getphoneNo(), sharingsession.getdate(), sharingsession.gettime(), sharingsession.getaddress(), sharingsession.getdetail() };
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
