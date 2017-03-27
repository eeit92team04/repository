<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <link rel=icon href=/Content/AssetsBS3/img/favicon.ico>-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="<c:url value="img/favicon.ico" />" rel="SHORTCUT ICON">
<link href="<c:url value="css/bootstrap.css" />" rel=stylesheet>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">打卡</button>

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
							<input type="email" class="form-control" id="inputEmail3"
								placeholder="請輸入員工編號">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密碼</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="inputPassword3"
								placeholder="請輸入密碼">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">打卡</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
<script src="<c:url value="js/jquery-3.1.1.min.js" />"></script>
<script src="<c:url value="js/bootstrap.min.js" />"></script>
</html>