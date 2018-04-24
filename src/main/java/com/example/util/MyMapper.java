package com.example.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author jack
 * @date 2018/4/24  17:26
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T>{
    //该接口不能被扫描到，否则会出错
}
