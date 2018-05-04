package com.example.service.impl;

import com.example.entity.Film;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jack
 * @date 2018/5/3 0003 15:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmServiceImplTest {
    @Autowired
    FilmServiceImpl service;

    @Test
    public void getFilmsByPage() throws Exception {
        PageInfo<Film> pageInfo = service.getFilmsByPage(1,2);
        System.out.println("总记录数pageInfo.getTotal()----"+pageInfo.getTotal());
        System.out.println("总页数pageInfo.getPages()----"+pageInfo.getPages());
        List<Film> list = pageInfo.getList();
        for (Film film : list) {
            System.out.println(film.toString());
        }


    }

}