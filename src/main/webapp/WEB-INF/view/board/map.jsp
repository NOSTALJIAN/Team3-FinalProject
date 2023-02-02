<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>키워드로 장소검색하고 목록으로 표출하기</title>
        <link rel="stylesheet" href="/css/map.css" />
    </head>
    <body>
        <div class="map_wrap">
            <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
            
            <div id="menu_wrap" class="bg_white">
                <div class="option">
                    <div>
                        키워드 : <input type="text" value="${b.bLocation} ${b.category}" id="keyword" size="15">
                        <form onsubmit="searchPlaces(); return false;">
                            <button type="submit">검색하기</button> 
                        </form>
                    </div>
                </div>
                <hr>
                <ul id="placesList"></ul>
                <div id="pagination"></div>
            </div>
        </div>
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b30795709f9886ba7811a12d6d84d653&libraries=services"></script>
        <script src="/js/map.js"></script>
        
    </body>
</html>