package com.nice.service;
import	java.util.List;
import com.nice.pojo.User;


/**
 * @author ningh
 */
public interface JdbcTmplUserService {


    public User getUser(Long id);

    public List<User> findUsers(String userName,String note);

    public Integer insertUser(User user);

    public Integer updateUser(User user);

    public int deleteUser(Long idd);

}
