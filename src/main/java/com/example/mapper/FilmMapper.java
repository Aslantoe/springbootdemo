package com.example.mapper;

import com.example.entity.Film;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/13 0013 17:12
 */
public interface FilmMapper {

    /**
     * 获取去重复后影片的地区
     * @return 地区集合
     */
    @Select("SELECT DISTINCT f.film_country FROM filminfo f")
    @Results({@Result(property = "filmCountry",column = "film_country")})
    List<String> getDistinctedCountry();

    /**
     * 获取去重复后的导演
     * @return 导演集合
     */
    @Select("SELECT DISTINCT f.film_director FROM filminfo f")
    @Results({@Result(property = "filmDirector",column = "film_director")})
    List<String> getDistinctedDirector();

    /**
     * 获取去重复后的影片类型
     * @return 类型集合
     */
    @Select("SELECT DISTINCT f.film_genre FROM filminfo f")
    @Results({@Result(property = "filmGenre",column = "film_genre")})
    List<String> getDistinctedGenre();

    /**
     * 模糊查询
     * @param name 电影名
     * @return 电影
     */
    @Select("SELECT * " +
            "FROM filminfo f where f.film_cnname LIKE CONCAT('%',#{name},'%') ")
    @Results({@Result(property = "filmCnName",column = "film_cnname"),
              @Result(property = "filmEnName",column = "film_enname"),
              @Result(property = "filmPoster",column = "film_poster"),
              @Result(property = "filmGallery",column = "film_gallery"),
              @Result(property = "filmDirector",column = "film_director"),
              @Result(property = "filmActor",column = "film_actor"),
              @Result(property = "filmGenre",column = "film_genre"),
              @Result(property = "filmCountry",column = "film_country"),
              @Result(property = "filmLanguage",column = "film_language"),
              @Result(property = "releaseDate",column = "film_releasedate"),
              @Result(property = "filmMins",column = "film_mins"),
              @Result(property = "filmIntroduction",column = "film_introduction"),
              @Result(property = "filmScore",column = "film_score"),
              @Result(property = "filmLink",column = "film_link")
    })
    List<Film> getVagueFilms(@Param("name") String name);


    /**
     * 导航栏点击下拉列表获取电影
     * @param country 国家
     * @param director 导演
     * @param genre 类型
     * @return 电影集合
     */
    @Select("<script> " +
            "SELECT * " +
            "FROM filminfo f" +
            " <where> " +
            " <if test=\"country != null\">AND f.film_country=#{country}</if> " +
            " <if test=\"director != null\">AND f.film_director=#{director}</if> " +
            " <if test=\"genre != null\">AND f.film_genre=#{genre}</if> " +
            " </where> " +
            " </script> ")

    @Results({@Result(property = "filmCnName",column = "film_cnname"),
           // @Result(property = "filmEnName",column = "film_enname"),
           // @Result(property = "filmPoster",column = "film_poster"),
            @Result(property = "filmGallery",column = "film_gallery"),
            @Result(property = "filmDirector",column = "film_director"),
           // @Result(property = "filmActor",column = "film_actor"),
            @Result(property = "filmGenre",column = "film_genre"),
            @Result(property = "filmCountry",column = "film_country"),
           // @Result(property = "filmLanguage",column = "film_language"),
           // @Result(property = "releaseDate",column = "film_releasedate"),
           // @Result(property = "filmMins",column = "film_mins"),
            @Result(property = "filmIntroduction",column = "film_introduction"),
           // @Result(property = "filmScore",column = "film_score"),
           // @Result(property = "filmLink",column = "film_link")
    })
    List<Film> getFilmsByNav(@Param("country") String country,
                             @Param("director") String director,
                             @Param("genre") String genre);

    @Select("SELECT * " +
            "FROM filminfo order by film_id")
    @Results({@Result(property = "filmCnName",column = "film_cnname"),
           // @Result(property = "filmEnName",column = "film_enname"),
           // @Result(property = "filmPoster",column = "film_poster"),
            @Result(property = "filmGallery",column = "film_gallery"),
           // @Result(property = "filmDirector",column = "film_director"),
           // @Result(property = "filmActor",column = "film_actor"),
           // @Result(property = "filmGenre",column = "film_genre"),
           // @Result(property = "filmCountry",column = "film_country"),
           // @Result(property = "filmLanguage",column = "film_language"),
           // @Result(property = "releaseDate",column = "film_releasedate"),
           // @Result(property = "filmMins",column = "film_mins"),
            @Result(property = "filmIntroduction",column = "film_introduction"),
          //  @Result(property = "filmScore",column = "film_score"),
           // @Result(property = "filmLink",column = "film_link")
    })
    List<Film> findFilmsByPage();

}
