package com.nice.service.impl;

import com.nice.enumeration.SexEnum;
import com.nice.pojo.User;
import com.nice.service.JdbcTmplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author ningh
 */
@Service
public class JdbcTmplUserServiceImpl implements JdbcTmplUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 获取映射关系
     * @return
     */
    private RowMapper<User> getUserMapper() {
        RowMapper<User> userRowMapper = (ResultSet rs,int rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            Integer sexId = rs.getInt("sex");
            SexEnum sex = SexEnum.getEnumById(sexId);
            user.setSex(sex);
            user.setNote(rs.getString("note"));
            return user;
        };
        return userRowMapper;
    }

    /**
     * 获取对象
     * @param id 用户id
     * @return  用户实体类
     */
    @Override
    public User getUser(Long id) {
        //执行的SQL
        String sql = "select id,user_name,sex,note from t_user where id = ?";
        //参数
        Object[] params = new Object [] {id};
        User user = jdbcTemplate.queryForObject(sql,params,getUserMapper());
        return user;
    }

    /**
     * 查询用户列表
     * @param userName
     * @param note
     * @return
     */
    @Override
    public List<User> findUsers(String userName, String note) {
        //执行的sql
        String sql = "select id,user_name,sex,note from t_user "
                +"where user_name like concat('%',?,'%') and note like concat('%',?,'%')";
        //参数
        Object[] params = new Object[]{userName,note};
        //使用匿名类实现
        List<User> userList = jdbcTemplate.query(sql,params,getUserMapper());
        return userList;
    }

    /**
     * 插入数据库
     * @param user 用户实体类
     * @return
     */
    @Override
    public Integer insertUser(User user) {
        String sql = "insert into t_user(user_name,sex,note) values(?,?,?)";
        return jdbcTemplate.update(sql,user.getUserName(),user.getSex().getId(),user.getNote());
    }

    @Override
    public Integer updateUser(User user) {
        //执行的SQL
        String sql = "update t_user set user_name = ?,sex = ?, note = ? where id = ?";
        return jdbcTemplate.update(sql,user.getUserName(),user.getSex().getId(),user.getNote(),user.getId());
    }

    @Override
    public int deleteUser(Long idd) {
        return 0;
    }
}
