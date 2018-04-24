package com.example.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通用接口
 * @author jack
 * @date 2018/4/24  19:12
 */
@Service
public interface IService<T> {
    T getByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> getByExample(Object example);


}
