<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Event Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<style>
body{

background: rgb(170,12,213);
background: radial-gradient(circle, rgba(170,12,213,0.7175070711878502) 0%, rgba(135,159,255,1) 100%);

}

.tablet {
	background: rgb(238, 174, 202);
	background: radial-gradient(circle, rgba(238, 174, 202, 1) 0%,
		rgba(148, 187, 233, 1) 100%);
	 border: 1px solid;
  padding: 10px;
  box-shadow: 5px 5px 8px 5px black;
	padding: 5px;
}

.styled {
	border: 0;
	line-height: 2.5;
	padding: 0 20px;
	font-size: 1rem;
	text-align: center;
	color: #fff;
	text-shadow: 1px 1px 1px #000;
	border-radius: 10px;
	background-color: white;
	background-image: linear-gradient(to top left, rgba(0, 0, 0, .2),
		rgba(0, 0, 0, .2) 30%, rgba(0, 0, 0, 0));
	box-shadow: inset 2px 2px 3px rgba(255, 255, 255, .6), inset -2px -2px
		3px rgba(0, 0, 0, .6);
}

.styled:hover {
	background-color: rgba(255, 0, 0, 1);
}

.styled:active {
	box-shadow: inset -2px -2px 3px rgba(255, 255, 255, .6), inset 2px 2px
		3px rgba(0, 0, 0, .6);
}

.text2 {
	font-size: 20px;
}

h3 {
	font-size: 40px;
	font-family: "Times New Roman", Times, serif;
}

</style>
</head>
<body>

	<br>


	<div class="row">

		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<div class="tablet">
				<h3 class="text-center">User Profile</h3>
				<hr>

				<br>
				<table class="table table-bordered">

					<tbody>
						<!--   for (Todo todo: todos) {  -->
						<c:forEach var="user" items="${listUser}">


							<tr>

								<td class="text2">User ID</td>
								<td class="text2">${user.id}</td>

							</tr>
							<tr>
								<td class="text2">User Name</td>
								<td class="text2">${user.name}</td>
							</tr>
							<tr>
								<td class="text2">User Mobile Number</td>
								<td class="text2">${user.mobileNo}</td>
							</tr>
							<tr>
								<td class="text2">User Address</td>
								<td class="text2">${user.address}</td>
							</tr>
							<tr>
								<td class="text2">Date:</td>
								<td class="text2">${user.date}</td>
							</tr>
							<tr>
								<td class="text2">User Vehicle Number:</td>
								<td class="text2">${user.vehicleNo}</td>
							</tr>
							<tr>
								<td class="text2">User Vehicle Type:</td>
								<td class="text2">${user.vehicleType}</td>
							</tr>

							<center>
								<button type="submit" class="favorite styled">
									<a href="edit?id=<c:out value='${user.id}' />">Edit</a>
								</button>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<button type="submit" class="favorite styled">
									<a href="delete?id=<c:out value='${user.id}' />">Delete</a>
							</center>
							</button>
						</c:forEach>
						<!-- } -->
					</tbody>

				</table>
			</div>
		</div>
	</div>
</body>
</html>
