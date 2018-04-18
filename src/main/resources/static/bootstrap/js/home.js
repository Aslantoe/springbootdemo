$(document).ready(function(){
    $(".dropdown-menu li").click(function() {
        alert($(this).children("a").text());

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





