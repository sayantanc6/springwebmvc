<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <title>Login Form</title>
<html lang="en" dir="ltr">
<head>
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" type="text/css"/>
	  <link rel="stylesheet" href="<spring:theme code="styleSheet"/>" type="text/css"/>
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<!-- 	  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/additional-methods.js"></script> -->
</head>
<body>
	<spring:message code="login.placeholder.username" var="login.placeholder.username" /> 
	<spring:message code="login.placeholder.password" var="login.placeholder.password" />
    <div class="container">
        <div class="rows">
			<div class="col-sm-6">
			Language : <a href="?language=en"><spring:message code="link.translate.english" text="English" /></a>  |  <a id="hindi" href="?language=hi"><spring:message code="link.translate.hindi" text="हिंदी" /></a><BR />
			Theme : <a href="?theme=cerulean"><spring:message code="link.theme.cerulean" text="cerulean" /></a>  |  <a href="?theme=Darkly"><spring:message code="link.theme.Darkly" text="Darkly" /></a>
				<form name="formdemo" method="post" id="form" novalidate="novalidate" enctype = "multipart/form-data">
					<div class="form-group">
						<label for="username"><spring:message code="login.label.username" text="username" /></label>
						<input type="text" name="username" id= "username" placeholder="${login.placeholder.username}" class="form-control" required />
					</div>

					<div class="form-group">
						<label for="password" ><spring:message code="login.label.password" text="Password"/></label>
						<input id="password" type="password"  name="password"  placeholder="${login.placeholder.password}" class="form-control" required />
					</div>
					
<%-- 					<div class="form-group">
						<label for="file"><spring:message code="login.label.file" text="file"/></label>
						<input type="file" id="file" name="file" class="required" accept="application/pdf">
					</div> --%>
					
					<button type="submit" id ="submit" class="btn btn-primary"><spring:message code="login.controls.submit" text="Submit" /></button>
					<button type="button" class="btn btn-primary" onclick="location.href='printAllUsers'"><spring:message code="login.controls.ShowAll" text="ShowAllUsers" /></button>
					
				</form>
			</div>
        </div>
    </div>
</body>
<script>
$(document).ready(function()
{
	var map = {};
	var formData;
	
		$("#form").validate({
			rules: {
				username:{
					required: true,
					minlength: 3,
					maxlength: 10
				},
				password: {
					required: true,
					minlength: 5
				}
// 				agree: "required"
			}
		});
		
		$("#submit").click(function(){
			if($("#form").valid()){
			
				$.ajax({
					type: 'post',
					url: "addNewUser",
					data: alert(JSON.stringify(createMap())),
					contentType: 'application/json',
					dataType : 'json',
					success : function(xxx){
						alert(xxx);
					},
					error : function(e){
						alert("Request failed: " + JSON.stringify(e));
					}
				});
			  
				function createMap(){
					$("form input").each(function(){
						if($(this).val() != null){
							var key = $(this).attr("name");
							var value = $(this).val();
							map[key] = value;
						}
					});
					return map;
				}

			}
		});
});

</script>
</html>