package com.email.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.email.entity.User;
import com.email.mapper.UserMapper;
import com.email.service.IUserService;
import com.email.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(String account, String password) {
        User user = userMapper.select(account);
        if(user == null)
            return Result.fail("用户不存在");
        else{
            if (!password.equals(user.getPassword())) {
                return Result.fail("用户密码错误");
            }
        }
        return Result.ok(user);
    }
}
