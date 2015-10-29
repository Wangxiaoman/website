<%@page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>TEST</title>
<link rel="stylesheet" type="text/css" href="./threenoodles.css" />

<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
	
}

#pagecontent {
	width: 980px;
	height: 100%;
	margin: 0 auto;
}


#content{
	clear: both;
	border-radius : 8px;
}
.carticle{
	width: 90%;
	padding : 20px 20px 0 30px;
	box-sizing:border-box;
	border-radius : 8px;
	margin: 0 auto;
}

.ca-title {
	margin: 0 auto;
}
.ca-title p{
	margin: 10px 0 10px 0;
	font: italic 80% Times, serif
}

.ca-img{
	margin: 10px 0 10px 0;
	padding: 0
}
.ca-content{
	font: 13px/30px Times, serif
}

.clinks{
	width: 100%;
	height: 200px;
	background-color: #fff;
	padding: 20px 20px 0 20px;
	box-sizing : border-box;
	margin: 0 0 30px 0;
	border-radius : 8px;
}

.larticles li{
	list-style: none;
	height: 35px;
	border-top: 1px solid #CCCCCC;
	margin: 10px 0 0 0;
	padding: 15px 0 0 0;
	box-sizing : border-box
}
.larticles li a{
	text-decoration: none
}

</style>

</head>
<body>

	<div id="pagecontent">
		<div id="content">
			<article class="carticle">
				<header class="ca-title">
					<h1>${article.title}</h1>
					<p>${article.createTime}</p>
				</header>
				<figure class="ca-img">
					<img alt="" src="${article.image}">
				</figure>

				<p class="ca-content">${article.content}</p>
			</article>

		</div>

	</div>

</body>
</html>
