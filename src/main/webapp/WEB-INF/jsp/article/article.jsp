<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../common.jsp"%>
<title>${article.title};</title>
<style type="text/css">

/************************************************************************************
STRUCTURE
*************************************************************************************/
.cb-header {
	color: #000000;
	font-size: 26px;
}

.cb-article {
	width: 95%;
	height: auto;
	padding: 10px 0 10px 0;
	position: relative;
	font-size: 100%;
	margin: 0 auto;
	text-align: left;
	overflow: hidden;
	font: 1.2em/1.5em arial,sans-serif
}

.cb-article h1 {
	font-size: 26px;
	text-align: center;
}

.cb-article h2 {
	font-size: 26px;
	text-align: center;
	margin: 10px 0 0 0
}

.cb-article .post-date {
	margin: 10px 0 10px 0;
	text-align: center;
}

.cb-article .post-image {
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

.cb-article img{
	width: 100%;
	height: auto;
	margin : 0 auto
}

</style>


</head>
<body>

	<!-- 	<nav class="cb-header"></nav>-->
	<div class="cb-article">
		<h2 style="text-align: left;">${article.title}</h2>
		<section style="text-align: left;" class="post-date" datetime="2011-05-08">
			<fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd" /> 
			创吧社区
			
			<c:if test="${article.source == 1}">
				虎嗅
			</c:if>
			<c:if test="${article.source == 2}">
				并发编程
			</c:if>
			<c:if test="${article.source == 3}">
				36kr
			</c:if>
		</section>
		<c:if test="${article.image != null}">
			<c:if test="${article.source == 2 || article.source == 3}">
				<img class="post-image" src="${article.image}">
			</c:if>
		</c:if>
		

		<p>${article.content}</p>

	</div>

	<footer class="cb-footer">
		<h4>更多悬赏和互联网资讯请关注 “创吧社区” 公众号</h4>
		<img class="gzh" src="/assets/images/gzh.jpg">
	</footer>
</body>
</html>
</body>
</html>


