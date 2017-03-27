<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <link rel=icon href=/Content/AssetsBS3/img/favicon.ico>-->
<link href="/unclesu/img/favicon.ico" rel="SHORTCUT ICON">
<link href="/unclesu/css/bootstrap.css" rel=stylesheet>
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
				<li><a data-toggle="tab" href="#"><span
						class="glyphicon glyphicon-user"></span>Admin</a></li>
				<li><a data-toggle="tab" href="#"
					class="glyphicon glyphicon-log-out">Log out</a></li>

			</ul>
		</div>
	</div>
</nav>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>