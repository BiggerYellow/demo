package com.hcc.example.demo.service.impl;

import com.hcc.example.demo.mapper.UserMapper;
import com.hcc.example.demo.service.DemoService;
import com.hcc.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User getInfo(int flag, int id) {
//        User user = userMapper.Sel(id);
        return null;
    }
}
