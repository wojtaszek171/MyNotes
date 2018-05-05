package xxxxxx.yyyyyy.zzzzzz.domain.service.user;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Board;
import xxxxxx.yyyyyy.zzzzzz.domain.model.User;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        String selectAllSql = "SELECT * FROM user;";

        return jdbctemplate.query(selectAllSql, new UserRowMapper());
    }

    public Integer getUserIdByName(String username){
        String selectSql = "SELECT USER_ID FROM user WHERE USER_NAME=?";
        Integer id =0;
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(selectSql,username);
        for (Map row : rows) {
            id= (Integer) row.get("USER_ID");
        }

        return id;
    }


    public String getCurrentUserName() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        return username;
    }
}
