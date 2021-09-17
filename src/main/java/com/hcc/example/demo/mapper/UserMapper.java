package com.hcc.example.demo.mapper;

import com.hcc.example.demo.vo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper{

    User Sel(int id);

}
