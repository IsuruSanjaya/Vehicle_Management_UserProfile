<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
.card{
background: rgb(255,228,240);
background: radial-gradient(circle, rgba(255,228,240,1) 0%, rgba(131,198,255,1) 100%);

}

body{

background: rgb(170,12,213);
background: radial-gradient(circle, rgba(170,12,213,0.7175070711878502) 0%, rgba(135,159,255,1) 100%);

}
</style>
</head>
<body>

 <div class="container col-md-5">
		<div class="card">
		<div class="inbox">
			<div class="card-body">
			<h2>User Registration</h2>
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						
						
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>
				<form>

				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Mobile No</label> <input 
						value="<c:out value='${user.mobileNo}' />" class="form-control"
						name="mobileNo" required="required" type="tel" pattern="07[1,2,5,6,7,8][0-9]{7}" maxlength="10">
				</fieldset>
				<fieldset class="form-group">
					<label> Address</label> <input type="text"
						value="<c:out value='${user.address}' />" class="form-control"
						name="address" required="required">
				</fieldset>
						<fieldset class="form-group">
					<label> Date</label> <input type="date"
						value="<c:out value='${user.date}' />" class="form-control"
						name="date" required="required" >
				</fieldset>
				<fieldset class="form-group">
					<label>Vehicle No</label> <input type="text"
						value="<c:out value='${user.vehicleNo}' />" class="form-control"
						name="vehicleNo" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Vehicle Type</label> <input type="text"
						value="<c:out value='${user.vehicleType}'  />" class="form-control"
						name="vehicleType" required="required" >
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
		</div>
	</div>


</body>
</html>