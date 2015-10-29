<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=device-dpi" />

<link rel="stylesheet" type="text/css"
	href="/assets/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/common.css" />

<script type="text/javascript"
	src="/assets/js/js_lib/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/assets/js/js_lib/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/assets/js/js_lib/bootstrap-paginator.js"></script>
<style type="text/css">

/************************************************************************************
STRUCTURE
*************************************************************************************/
.cb-header {
	color: #000000;
	font-size: 26px;
}

.cb-body {
	width: 95%;
	height: auto;
	padding: 4em 0 1em 0;
	position: relative;
	font-size: 100%;
	margin: 0 auto;
	text-align: center;
	overflow: hidden;
}

.cb-body h1 {
	font-size: 26px;
	text-align: center;
}

.cb-body h2 {
	font-size: 26px;
	text-align: center;
	color: #FF0033;
	margin: 10px 0 0 0
}

.cb-body .post-date {
	margin: 10px 0 10px 0;
	text-align: center;
}

.cb-body .post-image {
	margin: 10px 0 10px 0;
	text-align: center;
	max-width: 95%;
	height: auto;
	overflow: hidden
}

.cb-footer {
	width: 95%;
	height: auto;
	position: relative;
	font-size: 100%;
	margin: 0 auto;
	margin-top: 30px;
	text-align: center;
	overflow: hidden;
}

.cb-footer h4 {
	color: #00CC33
}

.cb-footer .gzh {
	margin: 10px 0 10px 0;
	text-align: center;
	max-width: 50%;
	height: auto;
	overflow: hidden
}
</style>

</head>

<body>

	<!-- 	<nav class="cb-header"></nav>-->
	<div class="cb-body">
		<h1>${article.title}</h1>
		<h2>￥5000</h2>
		<section class="post-date" datetime="2011-05-08">
			${article.createTime} <em>微信：</em>创吧社区
		</section>

		<img class="post-image" src="${article.image}">

		<p>${article.content}</p>


	</div>

	<footer class="cb-footer">
		<h4>更多悬赏和互联网资讯请关注 “创吧社区” 公众号</h4>
		<img class="gzh" src="/assets/images/temp/gzh.jpg">
	</footer>
</body>
</html>