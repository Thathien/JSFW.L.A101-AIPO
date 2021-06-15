<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>Index</title>
<!-- <link rel="stylesheet" href="./resources/Boostrap/css/bootstrap.min.css"> -->
<%@ include file="./resources/Head.jsp"%>
</head>

<body>
	<%@ include file="./resources/Header.jsp"%>
	<div class="container bg-transparent mt-5">
		<div class="row pt-4">
			<%@ include file="./resources/Navbar.jsp"%>
			 <div class="col-md-9 border-0">
                <p class="h1 ">Login</p>
                <div class="col-md-12 ">
                
                <form:form modelAttribute="loginDTO" action="login" method="post">
<%--                 	<form action="" class=""> --%>
	                    <div class="row">
	                        <div class="form-group col-md-6">
	                            <label for="exampleFormControlTextarea1">UserName</label>
	                            <form:input path="username" cssClass="form-control" type="text"/>
	                           <form:errors path="username" cssClass="text-danger"></form:errors>
<!-- 	                            <input type="text" class="form-control" id=""> -->
	                        </div>
	                    </div>
	                    <div class="row">
	                        <div class="form-group col-md-6">
	                            <label for="exampleFormControlTextarea1">Password</label>
	                             <form:input path="pass" cssClass="form-control" type="password"/>
	                             <form:errors path="pass" cssClass="text-danger"></form:errors>
<!-- 	                            <input type="password" class="form-control" id=""> -->
	                        </div>
	                    </div>
	                    <div class="row">
	                        <div class="form-group d-inline col-md-6">
	                            <input class="form-check-input d-inline " type="checkbox" name="iscorect" id="iscorecta" value="option1">
	                            <label class="form-check-label" for="exampleRadios1">
	                              remember
	                            </label>
	                        </div>
	                    </div>
	                    <c:if test="${ not empty error}">
             			<span class="text-danger" id="password-eror">${error}</span>	
             			<br/>
                	</c:if>
             	
             	
				<form:button type="submit" class="btn btn-primary">Đăng nhập</form:button>
<%--                		 </form> --%>
               		 </form:form>
               		 
                </div>
            </div>
		</div>
	</div>
</body>
</html>