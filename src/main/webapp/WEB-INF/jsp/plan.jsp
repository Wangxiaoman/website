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

.bs-callout-info {
	border-left-color: #1b809e;
}

.bs-callout {
	padding: 20px;
	margin: 20px 0;
	border: 1px solid #eee;
	border-left-width: 5px;
	border-radius: 3px;
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
			<h1 onclick="backPlan();">
				我的计划列表</a>
			</h1>
		</div>

		<div class="page-header">

			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">计划列表</div>

				<!-- Table -->
				<table class="table table-expandable">
					<!-- 				<table class="table"> -->
					<thead>
						<tr class="tb_header">
							<th>计划名称</th>
							<th>备注</th>
							<th>计划开始时间</th>
							<th>计划结束时间</th>
							<th>耗资(元)</th>
							<th>创建时间</th>
							<th>创建者</th>
							<th>状态</th>
							<th>操作</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${plans}" var="obj">
							<tr>
								<td style="vertical-align: middle; text-align: center;">${obj.name }</td>
								<td style="vertical-align: middle; text-align: center;">${obj.content }</td>
								<td style="vertical-align: middle; text-align: center;">${obj.beginTime }</td>
								<td style="vertical-align: middle; text-align: center;">${obj.endTime }</td>
								<td style="vertical-align: middle; text-align: center;">${obj.money }</td>
								<td style="vertical-align: middle; text-align: center;"><fmt:formatDate
										value="${obj.createTime}" pattern="yyyy-MM-dd" /></td>
								<td style="vertical-align: middle; text-align: center;">${obj.userName == 1?'晓满':'大傻' }</td>
								<td style="vertical-align: middle; text-align: center;"><c:if
										test="${obj.status == 0}">
											未开始
										</c:if> <c:if test="${obj.status == 1}">
											已经开始
										</c:if> <c:if test="${obj.status == 2}">
											结束
										</c:if></td>
								<td><c:if test="${obj.status == 0}">
										<a class="op" href="/plan/status?id=${obj.id}&status=1"
											style="color: #2ac1f2">开始</a>
										<a class="op" href="/plan/status?id=${obj.id}&status=2"
											style="color: #2ac1f2">完成</a>
									</c:if> <c:if test="${obj.status == 1}">
										<a class="op" href="/web/plan/status?id=${obj.id}&status=2"
											style="color: #2ac1f2">完成</a>
									</c:if> <a class="op" href="/plan/toItemSave?planId=${obj.id}"
									style="color: #2ac1f2">新增详情</a></td>
							</tr>
							<tr>
								<td colspan="9"><c:forEach items="${obj.planItems}"
										var="planItem">
										<div class="bs-callout bs-callout-info">
											<h4 style="color: #000000; display: inline">名称：${planItem.name }</h4>
											<p>开销： ${planItem.money }元</p>
											<p>
												时间：
												<fmt:formatDate value="${planItem.createTime}"
													pattern="yyyy-MM-dd" />
											</p>
											<p>详情： ${planItem.content }</p>
										</div>
									</c:forEach>
									<c:if test="${obj.currentMoney > 0}">
										<h3>实际消费总和：${obj.currentMoney}</h3>
									</c:if>
								</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
			<button type="button" class="btn btn-default btn-lg"
				onclick="toSave('${parentId}')">
				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
				创建计划
			</button>
		</div>

	</div>

</body>
<script type="text/javascript">
	function toSave(parentId){
		window.location.href = "/plan/toSave?parentId="+parentId;
	}
	
	function backPlan(){
		window.location.href = "/plan/list";
	}
	
	$(function () { $('#collapseOne').collapse('hide')});
</script>
</html>


