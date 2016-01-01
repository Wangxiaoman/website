<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="common.jsp"%>

<style type="text/css">
body {
	padding-top: 70px;
	padding-bottom: 30px;
}

.theme-dropdown .dropdown-menu {
	position: static;
	display: block;
	margin-bottom: 20px;
}

.theme-showcase>p>.btn {
	margin: 5px 0;
}

.theme-showcase .navbar .container {
	width: auto;
}

.row-apart {
	padding-top: 10px;
	padding-bottom: 10px;
}

.div-line {
	padding-bottom: 9px;
	margin: 40px 0 20px;
	border-bottom: 1px solid #eee;
}
</style>

<script type="text/javascript">
		function clearContent(){
			window.location.href = "/clear";
		}
		
		function ballot(){
			$.ajax({
		         type: "GET",
		         url:"/ballot",
		         success: function(result) {
		        	 if(result){
		        		 $("#ballatValue").attr("hidden",false);
		        		 $("#ballatValue").html(result);
		        	 }
		        }
		     });
		}
	</script>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container" id="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Xiaoman</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/show">Home</a></li>
		            <li class="active"><a href="/plan/list">Plan</a></li>
		            <li><a href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>


	<div class="container theme-showcase">

		<div class="jumbotron">
			<h1>新增计划</h1>
		</div>

		<div class="page-header">

			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">最新计划</div>
				<form id="form" class="form-horizontal" method="post"
					action="/plan/save">
					<input type="hidden" id="parentId" name="parentId"
						value="${parentId}" />
					<div class="form-group">
						<label for="normalText" class="col-sm-2 control-label">名称</label>
						<div class="col-sm-8">
							<input name="name" id="name" class="form-control" type="text"
								placeholder="请输入" />
						</div>
					</div>
					<div class="form-group">
						<label for="normalText" class="col-sm-2 control-label">备注</label>
						<div class="col-sm-8">
							<input name="content" id="content" class="form-control"
								type="text" placeholder="请输入" />
						</div>
					</div>
					<div class="form-group">
						<label for="normalText" class="col-sm-2 control-label">计划开始时间</label>
						<div class="col-sm-8">
							<input name="beginTime" id="beginTime" class="form-control"
								type="text" placeholder="请输入" />
						</div>
					</div>
					<div class="form-group">
						<label for="normalText" class="col-sm-2 control-label">计划结束时间</label>
						<div class="col-sm-8">
							<input name="endTime" id="endTime" class="form-control"
								type="text" placeholder="请输入" />
						</div>
					</div>
					<div class="form-group">
						<label for="normalText" class="col-sm-2 control-label">耗资</label>
						<div class="col-sm-8">
							<input name="money" id="money" class="form-control" type="text"
								placeholder="请输入" />
						</div>
					</div>

					<div style="text-align: center; padding: 20px;">
						<input type="submit" id="save" value="提交" class="btn btn-default" />
					</div>
				</form>

			</div>

		</div>

	</div>

</body>
</html>


