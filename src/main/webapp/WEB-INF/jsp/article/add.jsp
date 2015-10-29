<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../common.jsp"%>
<style type="text/css">
        .invest_page{
            width: 90%;
            margin: 0 auto;
        }

        .i_content_text{
            width: 80%;
            height: 30px;
        }

        .i_content_button{
            margin-top: 30px;
            height: 40px;
            width: 50%;
            font-size: 25px;
        }
    </style>
</head>
<body>
<div class="invest_page">
    <div class="i_header">
        <h1>文章干货</h1>
    </div>
    <div class="i_content">
        <form action="/article/add" method="post" enctype="multipart/form-data">

            <input class="i_content_text" name="artile_url" id="artile_url" value="" type="text" placeholder="干货地址" />
            <button class="i_content_button" type="submit" >提交解析</button>
        </form>
    </div>
    <div class="i_footer">
    </div>
</div>
</body>
</html>
</body>
</html>


