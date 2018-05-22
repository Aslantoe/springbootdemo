package com.example.manager.service;

import com.example.manager.entity.Film;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/14 0014 14:24
 */
public interface FilmService {
    /**
     * 获取影片地区
     * @return 地区集合
     */
    List<String> getDistinctedArea();

    /**
     * 获取影片导演
     * @return 导演集合
     */
    List<String> getDistinctedDirector();

    /**
     * 获取影片类型
     * @return 类型集合
     */
    List<String> getDistinctedGenre();

    /**
     * 电影模糊查询
     * @param name 电影名
     * @return 电影集合
     */
    List<Film> getVagueFilms(String name);

    /**
     *  根据导航栏点击获取电影
     * @param area 地区
     * @param director 导演
     * @param genre 类型
     * @return 电影集合
     */
    List<Film> getFilmsByNav(String area,String director,String genre);

    /**
     * 分页查询
     * @param currentPage 当前页数
     * @param pageSize 每页记录数
     * @return 电影集合
     */
    PageInfo<Film> getFilmsByPage(Integer currentPage, int pageSize);
}
