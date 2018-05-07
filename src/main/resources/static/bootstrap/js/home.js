"use strict";
$(document).ready(function () {
   $(".navbar-brand").click(function () {
       window.location.reload();
   });
});

function getFilmsByNav(param,temp) {
    $.ajax({
        async:false,
        type:"POST",
        url:"getFilmsByNav",
        data:{[temp]:param},
        dataType:"json",
        success:function (data) {
            if (!jQuery.isEmptyObject(data)){
                /*显示DIV*/
                $("#getFilms").attr("style","visibility:visible");
                var str = "";
                $.each(data,function (i,item) {
                    str += ( "      <div class=\"col-md-3\">\n" +
                        "                <div class=\"thumbnail\">\n" +
                        "                    <a href='#' >\n" +
                        "                     <img class=\"galleryNav\" src=\""+item.filmGallery+"\" alt=\""+item.filmCnName+"\" style=\"height: 345px;width: 100%\">\n" +
                        "                    </a>\n" +
                        "                    <div class=\"caption\">\n" +
                        "                        <h3>"+item.filmCnName+"</h3>\n" +
                        "                        <p style=\"text-overflow:ellipsis\">"+item.filmIntroduction.substr(0,42)+"...</p>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>"
                    ) ;
                });
                $("#getFilms-row").html(str);
                /*隐藏轮播图和影视列表*/
                $("#carousel").attr("style","visibility:hidden");
                $("#gallery").attr("style","visibility:hidden");
                $("#pageContainer").attr("style","visibility:hidden");
            }
        }
    });

    $(".galleryNav").click(function () {
       var filmName = $(this).attr("alt");
       console.log(filmName);
       getFilmInfoByFilmName(filmName);
    });
}

/*点击导航条检索*/
$(document).ready(function(){
    $(".dropdown-menu li").click(function() {

        var param = $(this).children("a").text();
        var str = $(this).parent().parent().children(".dropdown-toggle").text();
        var temp = '';
        if ('地区' === str){ temp = 'country' }
        if ('导演' === str){ temp = 'director'}
        if ('类型' === str){ temp = 'genre'}

        getFilmsByNav(param,temp);

    });
});

/*输入搜索*/
function getVagueFilm() {
    var searchContent = $("#search").val();
    $.ajax({
        async:false,
        type: "POST",
        url: "getVagueFilms",
        data:{name:searchContent},
        dataType:"json",
        success:function(data){
            if(!jQuery.isEmptyObject(data)){
                /*显示DIV*/
                $("#getFilms").attr("style","visibility:visible");
                var str = "";
                $.each(data,function (i,item) {
                    str += ( "            <div class=\"col-md-3\">\n" +
                        "                <div class=\"thumbnail\">\n" +
                        "                    <a href='#' id=\"img\">\n" +
                        "                       <img class=\"gallerySearch\" src=\""+item.filmGallery+"\" alt=\""+item.filmCnName+"\" style=\"height: 345px;width: 100%\">\n" +
                        "                    </a>\n" +
                        "                    <div class=\"caption\">\n" +
                        "                        <h3>"+item.filmCnName+"</h3>\n" +
                        "                        <p style=\"text-overflow:ellipsis\">"+item.filmIntroduction.substr(0,42)+"...</p>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>"
                    ) ;

                });
                $("#getFilms-row").html(str);
                /*隐藏轮播图和影视列表*/
                $("#carousel").attr("style","visibility:hidden");
                $("#gallery").attr("style","visibility:hidden");
                $("#pageContainer").attr("style","visibility:hidden");

            }else{
                alert("没有找到相关影片！");
            }
        }

    });
    $(".gallerySearch").click(function () {
       var filmName = $(this).attr("alt");
       console.log(filmName);
       getFilmInfoByFilmName(filmName);
    });

}


/*点击轮播图*/
$(document).ready(function () {
    $(".poster").click(function () {
        var filmName = $(this).attr("alt");
        getFilmInfoByFilmName(filmName);
    });
});

/*根据电影名获取电影信息*/
function getFilmInfoByFilmName(filmName) {
    $.ajax({
        async:false,
        type: "POST",
        url: "getVagueFilms",
        data:{name:filmName},
        dataType:"json",
        success:function(data){
            console.log('AJAX--->'+data);
            if(!jQuery.isEmptyObject(data)){
                /*显示DIV*/
                $("#filmInfo").attr("style","visibility:visible");
                /*隐藏轮播图和影视列表*/
                $("#carousel").attr("style","display:none");
                $("#gallery").attr("style","display:none");
                $("#pageContainer").attr("style","display:none");
                $("#getFilms").attr("style","display:none");
                var str = "";
                var filmCnName = "";
                var introduction = "";
                $.each(data,function (i,item) {
                    console.log(item);
                    str += ("  <div class=\"col-md-6 col-md-offset-1 fl-img\">\n" +
                        "            <a class=\"imglink\" href=\"#\" target=\"_blank\"><img src=\""+item.filmGallery+"\" /></a>\n" +
                        "        </div>\n" +
                        "        <div class=\"col-md-6 fl-info\">\n" +
                        "            <ul>\n" +
                        "                <li class=\"ib\"><span>中文名：</span><strong>"+item.filmCnName+"</strong></li>\n" +
                        "                <li class=\"ib\"><span>英文名：</span><strong>"+item.filmEnName+"</strong></li>\n" +
                        "                <li class=\"ib\"><span>地区：</span><strong>"+item.filmCountry+"</strong></li>\n" +
                        "                <li class=\"ib\"><span>片长：</span><strong>"+item.filmMins+"</strong></li>\n" +
                        "                <li class=\"ib\"><span>语  言：</span><strong>"+item.filmLanguage+"</strong></li>\n" +
                        "                <li class=\"ib\"><span>上映日期：</span><strong>"+item.releaseDate.substring(0,10)+"</strong></li>\n" +
                        "                <li class=\"ib\"><span>豆瓣评分：</span><strong>"+item.filmScore+"</strong></li>\n" +
                        "                <li class=\"ib\"><span>类型：</span><strong>"+item.filmGenre+"</strong></li>\n" +
                        "                <li id=\"director\"><span>导演：</span>"+item.filmDirector+"</li>\n" +
                        "                <li id=\"actor\"><span>主演：</span>"+item.filmActor+"</li>\n" +
                        "                <a id=\"favorite\">添加到我的收藏</a>\n" +
                        "            </ul>\n" +
                        "        </div>");
                    filmCnName = item.filmCnName;
                    introduction = item.filmIntroduction;
                });
                $(".brieftitle").html(filmCnName+"的剧情简介.....");
                $(".con span").html(introduction.substring(0,200));
                $("#filmInfo-detail").html(str);
            }
        },

    });
}




