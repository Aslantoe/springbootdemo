package com.example.service.impl;

import com.example.entity.Film;
import com.example.mapper.FilmMapper;
import com.example.service.FilmService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/14 0014 14:25
 */
@Service
public class FilmServiceImpl implements FilmService {
    /**
     * 存在问题:每次打开首页都要到数据库查询，消耗资源
     */
    @Autowired
    private FilmMapper mapper;

    @Override
    public List<String> getDistinctedCountry() {
        return mapper.getDistinctedCountry();
    }

    @Override
    public List<String> getDistinctedDirector() {
        return mapper.getDistinctedDirector();
    }

    @Override
    public List<String> getDistinctedGenre() {
        return mapper.getDistinctedGenre();
    }

    @Override
    public List<Film> getVagueFilms(String name) {
        return mapper.getVagueFilms(name);
    }

    @Override
    public List<Film> getFilmsByNav(String country, String director, String genre) {
        return mapper.getFilmsByNav(country,director,genre);
    }


    @Override
    public PageInfo<Film> getFilmsByPage(Integer currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Film> filmList = mapper.findFilmsByPage();
        return new PageInfo<>(filmList);
    }


}
