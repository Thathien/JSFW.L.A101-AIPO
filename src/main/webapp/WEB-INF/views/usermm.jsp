<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>User Managerment</title>
<!-- <link rel="stylesheet" href="/resources/Boostrap/css/bootstrap.min.css"> -->
<%@ include file="./resources/Head.jsp"%>
<script type="text/javascript">
$( document ).ready(function() {
	$("#checkAll").click(function (e) {
		if(this.checked){
			$(":checkbox").prop('checked', true);
		}else{
			$(":checkbox").prop('checked', false);
		}
	});	
	$("#remove").click(function (e) {
//  	 	e.preventDefault();
		var listUser = "";
		for(var i=0; i<$(":checkbox:checked").length;i++){
  			if($(":checkbox:checked").eq(i).attr('id') != "checkAll"){
  				listUser+=$(":checkbox:checked").eq(i).attr('id')+",";
  			}
  		}
		if($(":checkbox:checked").length != 0){
			if(confirm("Do you want delete ?")){
				listUser = listUser.replace("flexCheckDefault", "");
				alert(listUser);
				$.ajax({
					url:"/usermm/page/deleteList",
					type: "POST",
					data:{
						listUser:listUser
					},
					success: function(value){
						if(value ==='true'){
							alert("Susscess");
							location.reload();
						}else{
							alert("Wrong");
						}
					}
				});
			}
		}else{
			alert("You have not choose your row delete")
		}
	});
	
	$("#disable").click(function (e) {
//  	 	e.preventDefault();
		var listUser = "";
		for(var i=0; i<$(":checkbox:checked").length;i++){
  			if($(":checkbox:checked").eq(i).attr('id') != "checkAll"){
  				listUser+=$(":checkbox:checked").eq(i).attr('id')+",";
  			}
  		}
		if($(":checkbox:checked").length != 0){
			if(confirm("Do you want delete ?")){
				listUser = listUser.replace("flexCheckDefault", "");
				alert(listUser);
				$.ajax({
					url:"/usermm/page/update",
					type: "POST",
					data:{
						listUser:listUser,
						method : "disable"
					},
					success: function(value){
						if(value ==='true'){
							alert("Susscess");
							location.reload();
						}else{
							alert("Wrong");
						}
					}
				});
			}
		}else{
			alert("You have not choose your row  to disable ")
		}
	});
	
	$("#active").click(function (e) {
//  	 	e.preventDefault();
		var listUser = "";
		for(var i=0; i<$(":checkbox:checked").length;i++){
  			if($(":checkbox:checked").eq(i).attr('id') != "checkAll"){
  				listUser+=$(":checkbox:checked").eq(i).attr('id')+",";
  			}
  		}
		if($(":checkbox:checked").length != 0){
			if(confirm("Do you want delete ?")){
				listUser = listUser.replace("flexCheckDefault", "");
				alert(listUser);
				$.ajax({
					url:"/usermm/page/update",
					type: "POST",
					data:{
						listUser:listUser,
						method : "active"
					},
					success: function(value){
						if(value ==='true'){
							alert("Susscess");
							location.reload();
						}else{
							alert("Wrong");
						}
					}
				});
			}
		}else{
			alert("You have not choose your row  to disable ")
		}
	});
});
</script>
</head>

<body>

	<%@ include file="./resources/Header.jsp"%>
	<div class="container bg-transparent mt-5">
		<div class="row pt-4">
			<%@ include file="./resources/Navbar.jsp"%>
  <div class="col-md-9 border-0">
                <div class="row border-bottom">
                    <a class="nav-link" href="#">User Managerment</a>
                </div>
                <div class="row p-3">
                    <a href="#" class="btn btn-warning float-right text-white" role="button" data-toggle="modal" data-target="#exampleModal"><i class="fa fa-plus"></i> To Add User</a>
                </div>
                <div class="row">
<%--                     <form:form modelAttribute="FormSearch" method="GET"> --%>
<!--                     <div class="col-md-5"> -->
<!-- <!-- 						<input class="form-control" type="text" /> --> -->
<%-- 						<form:input path="key" cssClass="form-control""/> --%>
<!--                     </div> -->
<!--                     <div class="col-md-2"> -->
<!-- <!--                         <a href="#" class="btn btn-outline-secondary " role="button"><i class="fa fa-search"></i> Search</a> --> -->
<%--                    <form:button type="submit" class="btn btn-outline-secondary"> <i class="fa fa-search"></i> Search</form:button> --%>
<!--                     </div> -->
<%--                     </form:form> --%>
                </div>
                <div class="row p-3 ">
                    <a href="#"  id="remove" class="btn btn-outline-danger mr-1" role="button"><i class="fa fa-trash" ></i> Remove</a>
                    <a href="#" id="active" class="btn btn-outline-success mr-1" role="button"><i class="fa fa-toggle-on"></i> To enable</a>
                    <a href="#" id="disable" class="btn btn-outline-warning mr-1" role="button"><i class="fa fa-power-off"></i> To disable</a>
                    <a href="#" class="btn btn-outline-primary mr-1" role="button"><i class="fa fa-exchange"></i> To change order the server</a>
                </div>
                <div class="row">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>
                                    <input type="checkbox" name="" id="checkAll">
                                </th>
                                <th>State</th>
                                <th>Username</th>
                                <th>name</th>
                                <th>Department name</th>
                                <th>Tittle</th>
                            </tr>
                        </thead>
                        <tbody>
							<c:choose>
								<c:when test="${listUser!=null && listUser.size()>0}">
									<c:forEach var="user" items="${listUser}">
										<tr>
			                                <td><input type="checkbox" name="" id="${user.getUserID() }"></td>
			                                <td>
			                                	${user.getPosition().getPositionName()}
			                                </td>
			                                <td>
			                                	${user.getLoginName()}
			                                </td>
			                                <td>     
			                                	${user.getFirstName()}  ${user.getLastName()}
			                                </td>
			                                <td>
			                                	<c:if test="${user.getCompany().getPosts().size()>0}">
			                                		<c:forEach var="item" items="${user.getCompany().getPosts()}">
			                                			<c:out value="${item.getPostName()}"></c:out>
			                                		</c:forEach>
			                                	</c:if>
			                                </td>
			                                <td></td>
		                            	</tr>
									</c:forEach>
								</c:when>
							</c:choose>
                        </tbody>
                    </table>
                    <div class="col-md-12 ">
                        <ul class="pagination float-right">
							
							<c:choose>
							 <c:when test="${page==1}">
							 	<li class="page-item disabled"><a class="page-link" href='<c:url value="/usermm/page/${page-1}"></c:url>'>Previous</a></li>
							 </c:when>
							 <c:otherwise>
							 	<li class="page-item"><a class="page-link" href='<c:url value="/usermm/page/${page-1}"></c:url>'>Previous</a></li>
							 </c:otherwise>
							</c:choose>
							<c:forEach var="i" begin="0" end="${size}">
								<c:choose>
									<c:when test="${page==(i+1)}">	
										<li class="page-item active"><a class="page-link" href='<c:url value="/usermm/page/${i+1}"></c:url>'>${i+1}</a></li> 
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link" href='<c:url value="/usermm/page/${i+1}"></c:url>'>${i+1}</a></li> 
									</c:otherwise>
								</c:choose>
								
							</c:forEach>
							<c:choose>
							 <c:when test="${page-1>=size}">
							 	<li class="page-item disabled"><a class="page-link" href='<c:url value="/usermm/page/${page+1}"></c:url>'>Next</a></li>
							 </c:when>
							 <c:otherwise>
							 	<li class="page-item"><a class="page-link" href='<c:url value="/usermm/page/${page+1}"></c:url>'>Next</a></li>
							 </c:otherwise>
							</c:choose>
                        </ul>
                    </div>
                </div>
                <div class="row p-3 ">
                     <a href="#" class="btn btn-outline-danger mr-1" role="button"><i class="fa fa-trash"></i> Remove</a>
                    <a href="#" class="btn btn-outline-success mr-1" role="button"><i class="fa fa-toggle-on"></i> To enable</a>
                    <a href="#" class="btn btn-outline-warning mr-1" role="button"><i class="fa fa-power-off"></i> To disable</a>
                </div>
                <!-- model -->

                <div class="modal fade  bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Add User</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                            </div>
                             <form:form modelAttribute="UserAdd" method="post" action="adduser">
                            <div class="modal-body ">
                          
<%--                                 <form> --%>
                                    <div class="container-fluid">
                                        <div class="row border-bottom p-2">
                                            <div class="col-md-4">
                                                <div class="row">
                                                    <div class="col-md-8">
                                                        <p class="h6">login Name</p>
                                                    </div>
                                                    <div class="col-md-4 text-danger">
                                                        <i class="fa fa-cog"></i>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="row">
                                                    <div class="col-md-8">
<!--                                                         <input type="text" class="form-control" id=""> -->
                                                        <form:input path="loginName" cssClass="form-control"/>
                                                    </div>
                                                    <div class="col-md-4">
<!--                                                         <p class="text-danger">(AlphaNumberic)</p> -->
                                                        <form:errors path="loginName" cssClass="text-danger"> </form:errors>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row border-bottom p-2">
                                            <div class="col-md-4">
                                                <div class="row">
                                                    <div class="col-md-8">
                                                        <p class="h6">Password</p>
                                                    </div>
                                                    <div class="col-md-4 text-danger">
                                                        <i class="fa fa-cog"></i>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="row">
                                                    <div class="col-md-8">
<!--                                                         <input type="text" class="form-control" id=""> -->
                                                        <form:input path="passWord" cssClass="form-control"/>
                                                    </div>
                                                    <div class="col-md-4">
<!--                                                         <p class="text-danger">()</p> -->
                                                        <form:errors path="passWord"  cssClass="text-danger"></form:errors>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row border-bottom p-2">
                                            <div class="col-md-4">
                                                <div class="row">
                                                    <div class="col-md-8">
                                                        <p class="h6">Password for Cofirm</p>
                                                    </div>
                                                    <div class="col-md-4 text-danger">
                                                        <i class="fa fa-cog"></i>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="row">
                                                    <div class="col-md-8">
                                                        <form:input path="confirmPass" cssClass="form-control"/>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <form:errors path="confirmPass"  cssClass="text-danger"></form:errors>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row border-bottom p-2">
                                            <div class="col-md-4">
                                                <div class="row">
                                                    <div class="col-md-8">
                                                        <p class="h6">Name</p>
                                                    </div>
                                                    <div class="col-md-4 text-danger">
                                                        <i class="fa fa-cog"></i>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="row">
                                                    <div class="col-md-5">
                                                        <form:input path="fName" cssClass="form-control"/>
                                                    </div>
                                                    <div class="col-md-5">
                                                       <form:input path="lName" cssClass="form-control"/>
                                                    </div>
                                                    <div class="col-md-2">
                                                       <form:errors path="fName"  cssClass="text-danger"></form:errors>
                                                        <form:errors path="lName"  cssClass="text-danger"></form:errors>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row border-bottom p-2">
                                        <div class="col-md-4">
                                            <div class="row">
                                                <div class="col-md-8">
                                                    <p class="h6">Name (Furaga)</p>
                                                </div>
                                                <div class="col-md-4 text-danger">
                                                    <i class="fa fa-cog"></i>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="row">
                                                <div class="col-md-5">
                                                   <form:input path="fNameKana" cssClass="form-control"/>
                                                </div>
                                                <div class="col-md-5">
                                                   <form:input path="lNameKana" cssClass="form-control"/>
                                                </div>
                                                <div class="col-md-2">
                                                    <form:errors path="fNameKana"  cssClass="text-danger"></form:errors>
                                                    <form:errors path="lNameKana"  cssClass="text-danger"></form:errors>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row border-bottom p-2">
                                        <div class="col-md-4">
                                            <div class="row">
                                                <div class="col-md-8">
                                                    <p class="h6">Mail address</p>
                                                </div>
                                                <div class="col-md-4 text-danger">
                                                    <i class="fa fa-cog"></i>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="row">
                                                <div class="col-md-8">
                                                    <form:input path="email" cssClass="form-control"/>
                                                </div>
                                                <div class="col-md-4">
                                                     <form:errors path="email"  cssClass="text-danger"></form:errors>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row border-bottom p-2">
                                        <div class="col-md-4">
                                            <div class="row">

                                                <p class="h6">Telephone number (outside line)</p>

                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="row">
                                                <div class="col-md-3">
                                                     <form:input path="numOutSide1" cssClass="form-control"/>
                                                </div>
                                                <div class="col-md-3">
                                                     <form:input path="numOutSide2" cssClass="form-control"/>
                                                </div>
                                                <div class="col-md-3">
                                                     <form:input path="numOutSide3" cssClass="form-control"/>
                                                </div>
                                                <div class="col-md-3">
                                                    <form:errors path="numOutSide1"  cssClass="text-danger"></form:errors>
                                                     <form:errors path="numOutSide2"  cssClass="text-danger"></form:errors>
                                                      <form:errors path="numOutSide2"  cssClass="text-danger"></form:errors>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row border-bottom p-2">
                                        <div class="col-md-4">
                                            <div class="row">

                                                <p class="h6">Telephone number (extention)</p>

                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="row">
                                                <div class="col-md-8">
                                                      <form:input path="ouPhone1" cssClass="form-control"/>
                                                </div>
                                                <div class="col-md-4">
                                                   <form:errors path="ouPhone1"  cssClass="text-danger"></form:errors>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row border-bottom p-2">
                                        <div class="col-md-4">
                                            <div class="row">

                                                <p class="h6">Telephone number (mobile)</p>

                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <form:input path="exPhone1" cssClass="form-control"/>
                                                </div>
                                                <div class="col-md-3">
                                                    <form:input path="exPhone2" cssClass="form-control"/>
                                                </div>
                                                <div class="col-md-3">
                                                     <form:input path="exPhone3" cssClass="form-control"/>
                                                </div>
                                                <div class="col-md-3">
                                                    <form:errors path="exPhone1"  cssClass="text-danger"></form:errors>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row border-bottom p-2">
                                        <div class="col-md-4">
                                            <div class="row">

                                                <p class="h6">Department</p>

                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <p class="h6">Please add the department int the left side</p>
                                            <div class="row border">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label for="exampleFormControlSelect2">Department</label>
                                                         <form:select path="department" cssClass="form-control" id="depart">
	                                                         <c:if test="${listCompany.size()>0 && listCompany!=null}">
	<!--                                                          <option value="" selected="selected">Choose</option> -->
	                                                         	<c:forEach var="item" items="${listCompany}">
	                                                         		<c:if test="${item.getPosts().size()>0}">
	                                                         			<c:forEach var="post" items="${item.getPosts()}">
	                                                         				 <form:option value='${item.getCompanyID()}'>
	                                                         				 	${post.getPostName()}
	                                                         				 </form:option>
	                                                         			</c:forEach>
	                                                         		</c:if>
	                                                         	</c:forEach>
	                                                         </c:if>
                                                       </form:select>
                                                    </div>
<!--                                                     <div class="row float-right"> -->
<!--                                                         <a href="#" class="btn btn-outline-warning mr-1" role="button" id="add"><i class="fa fa-plus"></i> Add</a> -->
<!--                                                     </div> -->
<!--                                                 </div> -->
<!--                                                 <div class="col-md-6"> -->
<!--                                                     <div class="form-group"> -->
<!--                                                         <label for="exampleFormControlSelect2">Department List</label> -->
<%--                                                         <form:select path="department" multiple="true"  cssClass="form-control " id="departResult"> --%>

<%--                                                         </form:select> --%>
<!--                                                     </div> -->
<!--                                                     <div class="row float-right"> -->
<!--                                                         <a href="#" class="btn btn-outline-danger mr-1" role="button" id="delete"><i class="fa fa-trash"></i> Delete</a> -->
<!--                                                     </div> -->
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row border-bottom p-2">
                                        <div class="col-md-4">
                                            <div class="row">

                                                <p class="h6">Position</p>

                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="row">
                                                <div class="form-group col-md-12">
                                                 <form:select path="position" cssClass="form-control" id="exampleFormControlSelect2">
<!--                                                     <select class="form-control" id="exampleFormControlSelect2"> -->
                                                   
                                                     <option value="" selected="selected">Choose</option>
                                                       <c:if test="${listPosition.size()>0 && listPosition!=null}">
                                                          	<c:forEach var="posi" items="${listPosition}">
                                                          		 <form:option value='${posi.getPositionID()}'>
                                                         				 	${posi.getPositionName()}
                                                         		</form:option>
                                                         	
                                                          	</c:forEach>
                                                          </c:if>
<!--                                                     </select> -->
                                                    </form:select>
                                                </div>
                                                <div class="form-group col-md-12">
                                                    <a href="#" class="btn btn-outline-secondary mr-1" role="button"><i class="fa fa-cog"></i> The new Input</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row border-bottom p-2">
                                        <div class="col-md-4">
                                            <div class="row">

                                                <p class="h6">Administrate porject</p>

                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                                <label class="form-check-label" for="">
                                                  Default checkbox
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                            <div class="modal-footer text-center">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <form:button type="submit" class="btn btn-primary">ADD</form:button>
                            </div>
                           </form:form>
                        </div>

                    </div>
                </div>
            </div>
		</div>
	</div>
</body>
</html>