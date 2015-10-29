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
<!-- <link rel="stylesheet" type="text/css" href="/assets/css/common.css" /> -->

<script type="text/javascript"
	src="/assets/js/js_lib/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/assets/js/js_lib/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap-table.css" />
<script type="text/javascript" src="/assets/js/js_lib/bootstrap-table.js"></script>
<style type="text/css">

/************************************************************************************
STRUCTURE
*************************************************************************************/
* {
	box-sizing: border-box
}
</style>

</head>

<!-- 参数： -->
<!-- data?limit=50&offset=100&search=&sort=name&order=desc -->
<!-- 返回 -->
<!-- {
  "total": 800,
  "rows": [
    {
      "id": 0,
      "name": "Item 0",
      "price": "$0"
    },
    {
      "id": 1,
      "name": "Item 1",
      "price": "$1"
    }]
  } 
-->


<body>
	<!-- <table data-url="http://wenzhixin.net.cn/examples/bootstrap_table/data" data-height="1400"
		data-side-pagination="server" data-pagination="true"
		data-page-list="[5, 10, 20, 50, 100, 200]" data-search="true">
		<thead>
			<tr>
				<th data-field="state" data-checkbox="true"></th>
				<th data-field="id" data-align="right" data-sortable="true">Item
					ID</th>
				<th data-field="name" data-align="center" data-sortable="true">Item
					Name</th>
				<th data-field="price" data-sortable="true">Item Price</th>
			</tr>
		</thead>
	</table> -->


	<table id="table" data-url="http://localhost:8080/article/data" data-side-pagination="server" data-pagination="true" data-search="true" data-toggle="table">
		<thead>
			<tr>
				<th data-field="state" data-checkbox="true"></th>
				<th data-field="id" data-align="right" data-sortable="true">Item
					ID</th>
				<th data-field="name" data-align="center" data-sortable="true">Item
					Name</th>
				<th data-field="price" data-sortable="true">Item Price</th>
			</tr>
		</thead>
	</table>


	<script type="text/javascript">
	/* $('#table').bootstrapTable({
	    url: 'http://localhost:8080/article/data'
	}); */
	</script>

</body>
</html>