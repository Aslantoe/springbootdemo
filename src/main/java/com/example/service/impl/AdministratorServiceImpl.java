package com.example.service.impl;

import com.example.entity.Administrator;
import com.example.mapper.AdministratorMapper;
import com.example.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/12 0012 17:02
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper mapper;

    @Override
    public List<Administrator> getAllAdministrator() {
        return mapper.getAllAdministrator();
    }
}
