package com.example.controller;

import com.example.entity.Film;
import com.example.service.impl.FilmServiceImpl;
import com.example.util.Constant;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String countris(ModelMap map){
        /**
         * 问题:模板代码
         */
        List<String> countries = filmService.getDistinctedCountry();
        List<String> directors = filmService.getDistinctedDirector();
        List<String> genres = filmService.getDistinctedGenre();
        map.addAttribute("countries",countries);
        map.addAttribute("directors",directors);
        map.addAttribute("genres",genres);

        return "index";
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
    public List<Film> getFilmsByNav(String country, String director, String genre){
        return filmService.getFilmsByNav(country, director, genre);
    }

    @RequestMapping(value = "/getFilmsByPage",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<Film> getFilmsByPage(Integer currPage){
        System.out.println("currPage:"+currPage);
        return filmService.getFilmsByPage(currPage,Constant.PAGE_SIZE);
    }
}
