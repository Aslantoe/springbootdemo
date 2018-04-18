$(document).ready(function(){
    $(".dropdown-menu li").click(function() {
        var param = $(this).children("a").text();
        var str = $(this).parent().parent().children(".dropdown-toggle").text();
        var temp = '';
        if ('地区' === str){ temp = 'country' }
        if ('导演' === str){ temp = 'director'}
        if ('类型' === str){ temp = 'genre'}

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
                            alert(item.filmScore);
                            str += ( "            <div class=\"col-md-3\">\n" +
                                "                <div class=\"thumbnail\">\n" +
                                "                    <a id=\"img\">\n" +
                                "                       <img src=\" "+item.filmGallery+" \" alt=\" "+item.filmCnName+" \" style=\"height: 345px;width: 100%\">\n" +
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
                }
            }
        });

    });
});

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
                        "                    <a id=\"img\">\n" +
                        "                       <img src=\" "+item.filmGallery+" \" alt=\" "+item.filmCnName+" \" style=\"height: 345px;width: 100%\">\n" +
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

            }else{
                alert("没有找到相关影片！");
            }
        },

    });
}





