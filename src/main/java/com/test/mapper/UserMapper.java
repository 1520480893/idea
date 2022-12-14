package com.test.mapper;

import com.test.model.User;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(User user);
}