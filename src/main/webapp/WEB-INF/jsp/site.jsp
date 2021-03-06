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
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Xiaoman</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="/show">Home</a></li>
            <li><a href="/plan/list">Plan</a></li>
            <li><a href="#contact">Contact</a></li>
<!--             <li class="dropdown"> -->
<!--               <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a> -->
<!--               <ul class="dropdown-menu"> -->
<!--                 <li><a href="#">Action</a></li> -->
<!--                 <li><a href="#">Another action</a></li> -->
<!--                 <li><a href="#">Something else here</a></li> -->
<!--                 <li role="separator" class="divider"></li> -->
<!--                 <li class="dropdown-header">Nav header</li> -->
<!--                 <li><a href="#">Separated link</a></li> -->
<!--                 <li><a href="#">One more separated link</a></li> -->
<!--               </ul> -->
<!--             </li> -->
          </ul>
        </div>
      </div>
    </nav>
    
    
    <div class="container theme-showcase" role="main">
    
	    <div class="jumbotron">
	       <h1>我的地铁签</h1>
	       <p>我建立的一个地铁标签，自己从输入框里面录入，然后抽签把上面的内容抽出来，嘎嘎，自己玩的！</p>
	     </div>
    
    	<div class="page-header">
	        <h1  class="row-apart">地铁签</h1>
	        
	        <form class="navbar-form row-apart" action="/subway" method="post">
	            <div class="form-group">
	              <input type="text" name="name" id="name" placeholder="填入新的地铁站" class="form-control">
	            </div>
	            <button type="submit" class="btn btn-success">提交</button>
	            
	            <button type="button" onclick="clearContent();" class="btn btn-success">清除</button>
	        </form>
	    </div>
	    
	    <div class="div-line">
		    <c:forEach items="${data}" var="item" varStatus="status">
		    	<c:if test="${status.first}">
		    		<h1 class="row-apart">
		    	</c:if>
		    	<c:if test="${status.index % 6 == 0 }"><span class="label label-default">${item.name}</span></c:if>
		    	<c:if test="${status.index % 6 == 1 }"><span class="label label-primary">${item.name}</span></c:if>
		    	<c:if test="${status.index % 6 == 2 }"><span class="label label-success">${item.name}</span></c:if>
		    	<c:if test="${status.index % 6 == 3 }"><span class="label label-info">${item.name}</span></c:if>
		    	<c:if test="${status.index % 6 == 4 }"><span class="label label-warning">${item.name}</span></c:if>
		    	<c:if test="${status.index % 6 == 5 }"><span class="label label-danger">${item.name}</span>
		    		<c:if test="${status.last}">
			    		</h1>
			    	</c:if>
			    	<c:if test="${! status.last}">
			    		</h1><h1 class="row-apart">
			    	</c:if>
		    	</c:if>
		    </c:forEach>
	    </div>
	    
	    <div style="div-line">
<!-- 		    <div class="progress"> -->
<!-- 		        <div class="progress-bar progress-bar-success" style="width: 15%"><span class="sr-only">15% Complete (success)</span></div> -->
<!-- 		        <div class="progress-bar progress-bar-warning" style="width: 25%"><span class="sr-only">25% Complete (warning)</span></div> -->
<!-- 		        <div class="progress-bar progress-bar-primary" style="width: 60%"><span class="sr-only">60% Complete (danger)</span></div> -->
<!-- 		    </div> -->
	        <h1  class="row-apart">抽签</h1>
	        <button type="button" onclick="ballot();" class="btn btn-success">天灵灵，地灵灵</button>
	    </div>
	    
	    <div style="padding-top: 30px;">
	    	<h1>我的抽签结果，木哈哈：
	    		<span class="label label-success" id="ballatValue" hidden="true"></span>
	    	</h1>
	    </div>
	    
	    
	    <div class="page-header" style="padding-top: 30px;">
	        <h3>备注：</h3>
	    </div>
	    <div class="well">
        	<p>一个小工具，自己玩一玩</p>
      </div>
    </div>
    
</body>
</html>


