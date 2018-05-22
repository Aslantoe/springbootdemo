package com.example.film.controller;

import com.example.manager.entity.Film;
import com.example.manager.service.impl.FilmServiceImpl;
import com.example.util.Constant;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/14 0014 14:31
 */
@Controller
public class FilmController {
    @Autowired
    private FilmServiceImpl filmService;

    @RequestMapping(value = "/player",method = RequestMethod.GET)
    public String player(String filmEnName,String filmCnName,Model model){
        model.addAttribute("filmCnName",filmCnName);
        model.addAttribute("filmEnName",filmEnName);
        System.out.println("player-------->"+filmCnName+"__"+filmEnName);
        return "player/filmplayer";
    }

    @RequestMapping(value = "/index_film",method = RequestMethod.GET)
    public String nav(ModelMap map){
        /**
         * 问题:模板代码
         */
        List<String> areas = filmService.getDistinctedArea();
        List<String> directors = filmService.getDistinctedDirector();
        List<String> genres = filmService.getDistinctedGenre();
        map.addAttribute("areas",areas);
        map.addAttribute("directors",directors);
        map.addAttribute("genres",genres);

        return "index_film";
    }

    @RequestMapping(value = "/getVagueFilms",method = RequestMethod.POST)
    @ResponseBody
    public List<Film> getVagueFilms(String name) {
        System.out.println("===============" + name);
        if ("".equals(name) || name == null ) {
            return null;
        }else{
            return filmService.getVagueFilms(name);
        }
    }

    @RequestMapping(value = "/getFilmsByNav",method = RequestMethod.POST)
    @ResponseBody
    public List<Film> getFilmsByNav(String area, String director, String genre){
        return filmService.getFilmsByNav(area, director, genre);
    }

    @RequestMapping(value = "/getFilmsByPage",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<Film> getFilmsByPage(Integer currPage){
        System.out.println("currPage:"+currPage);
        return filmService.getFilmsByPage(currPage,Constant.PAGE_SIZE);
    }
}
