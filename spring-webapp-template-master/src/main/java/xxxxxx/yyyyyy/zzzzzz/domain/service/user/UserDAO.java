package xxxxxx.yyyyyy.zzzzzz.domain.service.user;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import xxxxxx.yyyyyy.zzzzzz.domain.model.User;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

public class UserDAO {

    @Autowired
    private JdbcTemplate jdbctemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbctemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    public void insert(User user){
        String sqlinsert ="INSERT INTO user (USER_NAME, USER_EMAIL, USER_PASSWORD, CREATED_AT, UPDATED_AT)"
                + " VALUES (?, ?, MD5(?),?,?)";
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        Date date = DateTime.now().toDate();
        getJdbcTemplate().update(sqlinsert,new Object[]{name,email,password,date,date});

    }

    public List<User> selectAll(){
        String selectAllSql = "SELECT * FROM STUDENT;";

        return jdbctemplate.query(selectAllSql, new UserRowMapper());
    }

}
