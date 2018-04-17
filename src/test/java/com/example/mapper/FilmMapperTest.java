package com.example.mapper;

import com.example.entity.Film;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jack
 * @date 2018/4/13 0013 17:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmMapperTest {

    @Autowired
    private FilmMapper mapper;

    @Test
    public void getVagueCountry() throws Exception {
        List<Film> list = mapper.getVagueFilms("星");
        System.out.println("****************");
        for (Film film : list) {
            System.out.println(film.toString());

        }
    }

    @Test
    public void getDistinctedCountry() throws Exception {
        List<String> list = mapper.getDistinctedCountry();
        for (String s : list) {
            System.out.println(s);
        }
    }
    @Test
    public void getDistinctedDirector() throws Exception {
        List<String> list = mapper.getDistinctedDirector();
        for (String s : list) {
            System.out.println(s);
        }
    }
    @Test
    public void getDistinctedGenre() throws Exception {
        List<String> list = mapper.getDistinctedGenre();
        for (String s : list) {
            System.out.println(s);
        }
    }

}