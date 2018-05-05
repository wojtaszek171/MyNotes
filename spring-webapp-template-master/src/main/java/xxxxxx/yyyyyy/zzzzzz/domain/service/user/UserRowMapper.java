package xxxxxx.yyyyyy.zzzzzz.domain.service.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import xxxxxx.yyyyyy.zzzzzz.domain.model.User;

public class UserRowMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        User user = new User();
        user.setName(resultSet.getString(1));
        user.setEmail(resultSet.getString(2));
        user.setPassword(resultSet.getString(2));

        return user;
    }



}
