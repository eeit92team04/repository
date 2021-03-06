<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <link rel=icon href=/Content/AssetsBS3/img/favicon.ico>-->
<link href="<c:url value="img/favicon.ico" />" rel="SHORTCUT ICON">
<link href="<c:url value="css/bootstrap.css" />" rel=stylesheet>
<nav class="navbar navbar-default navbar-fixed-top" role=navigation>
	<button type=button class="navbar-toggle collapsed"
		data-toggle=collapse data-target=#navbar aria-expanded=false
		aria-controls=navbar>
		<span class=sr-only>Toggle navigation</span> <span class=icon-bar></span>
		<span class=icon-bar></span> <span class=icon-bar></span>
	</button>
	<div class=container>
		<div class=navbar-header>
			<a class=navbar-brand href="">Uncle Su</a>
		</div>
		<div id=navbar class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class=dropdown><a href="" class=dropdown-toggle
					data-toggle=dropdown role=button aria-expanded=false>營業相關 <span
						class=caret></span>
				</a>
					<ul class=dropdown-menu role=menu>
						<li class=divider>
						<li class=dropdown-header>分類顯示
						<li><a href=#>菜口</a>
						<li><a href=#>吧檯</a>
						<li><a href=#>披薩</a>
						<li><a href=#>炸物</a>
						<li class=divider>
						<li class=dropdown-header>餐桌控制
						<li><a href=#>訂位</a>
						<li><a href=#>桌況</a>
					</ul>
				<li class=dropdown><a href=# class=dropdown-toggle
					data-toggle=dropdown role=button aria-expanded=false>管理相關 <span
						class=caret></span>
				</a>
					<ul class=dropdown-menu role=menu>
						<li><a href=#>盤點</a>
						<li><a href=#>叫貨</a>
						<li><a href=#>進貨</a>
						<li><a href=#>員工</a>
						<li><a href=#>班表</a>
						<li><a href=#>菜單</a>
						<li><a href=#>雜支</a>
						<li><a href=#>當日營收</a>
					</ul>
				<li class=dropdown><a href=# class=dropdown-toggle
					data-toggle=dropdown role=button aria-expanded=false>統計相關 <span
						class=caret></span>
				</a>
					<ul class=dropdown-menu role=menu>
						<li><a href=#>日統計報表</a>
						<li><a href=#>月統計報表</a>
						<li><a href=#>月產品銷售報表</a>
						<li><a href=#>月成本報表</a>
					</ul>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" class="glyphicon glyphicon-user">Admin</a></li>
				<li><a href="#" class="glyphicon glyphicon-log-out">Log out</a></li>
				<li><button type="button" class="btn btn-primary btn-lg"
						data-toggle="modal" data-target="#myModal">打卡</button></li>
			</ul>
		</div>
	</div>
</nav>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">員工打卡</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">員工編號</label>
						<div class="col-sm-10">
							<input class="form-control" id="empid"
								placeholder="請輸入員工編號">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密碼</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="emppassword"
								placeholder="請輸入密碼">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default" id="onduty">上班</button>
							<button type="submit" class="btn btn-default" id="offduty">下班</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	window.onload = function() {
		var btn = document.getElementById("onduty");
		var btn1 = document.getElementById("offduty");
		var xhr = new XMLHttpRequest();
		btn.onclick = myclick;
		btn1.onclick = myclick;
		function myclick() {
			//alert(this.id);
			if (xhr != null) {
				xhr.onreadystatechange = showtimefunc;
				xhr.open("GET", "", true);
				xhr.send();
			} else {
				div1.innerHTML = "你的瀏覽器不支援AJAX<br>";
			}
		}
		function showtimefunc() {
			//console.log(xhr.readyState);
			if (xhr.readyState == 4 && xhr.status == 200) {
				alert(this);
			}
		}
	}
</script>
<script src="<c:url value="js/jquery-3.1.1.min.js" />"></script>
<script src="<c:url value="js/bootstrap.min.js" />"></script>

