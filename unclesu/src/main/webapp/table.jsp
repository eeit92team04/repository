<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>table</title>
</head>
<jsp:include page="navigation.jsp" />
<body>
	<div class=container>
		<div class=jumbotron>
			<div class="row">
				<div class="col-md-4" data-toggle="modal" data-target="#table"
					style="background-color: blue; height: 180px; text-align: center;">
					<h1>1桌</h1>
				</div>
				<div class="col-md-4 col-md-offset-4">
					<button type="button" class="btn btn-primary btn-lg"
						data-toggle="modal" data-target="#table"
						style="height: 180px; width: 180px;">2桌</button>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<button type="button" class="btn btn-primary btn-lg"
						data-toggle="modal" data-target="#table"
						style="height: 180px; width: 180px;">3桌</button>
				</div>
				<div class="col-md-4 col-md-offset-4">
					<button type="button" class="btn btn-primary btn-lg"
						data-toggle="modal" data-target="#table"
						style="height: 180px; width: 180px;">4桌</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="table" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">桌子</h4>
				</div>
				<div class="modal-body">
					<a href=""><button type="button" class="btn btn-primary btn-lg">點餐</button></a>
					<a href=""><button type="button" class="btn btn-primary btn-lg">結帳</button></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>