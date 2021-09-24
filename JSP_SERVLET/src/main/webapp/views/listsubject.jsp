<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Subject</title>
<link href="<c:url value='/template/bootstrap.min.css' />"
	rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/template/mystyle.css' />" rel="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript"
	src="<c:url value='/template/jquery.min.js' />"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>

	<form action="" id="formSubmit" method="get">
		<input type="hidden" value=" " id="iddelete" name="iddelete" /> <input
			type="hidden" value=" " id="idedit" name="idedit" />
		<div style="margin: 10px; font-size: 30px; margin-left: 700px;">
			<span>Subjects List</span> <input type="button"
				value="Add New Subject" class="btn btn-success" id="themMonHoc"
				style="margin-left: 20px;">
		</div>
		<div>
			<table
				class="table table-striped table-hover table-bordered table-sm ">
				<thead style="background-color: #4267B2; color: white;">
					<th class="col-sm-2">ID</th>
					<th class="col-sm-3">Name</th>
					<th class="col-sm-2">#</th>
				</thead>
				<tbody>
					<c:forEach var="item" items="${modelsj}">
						<tr>
							<td>${item.id}</td>
							<td>${item.name}</td>
							
							<td>
								<div>
									<button style="margin-left: 10px" class="btn btn-danger"
										onclick="xoaHang( ${item.id} )">Delete</button>


									<input type="button" onclick="suaHang( ${item.id} )"
										value="Edit" class="btn btn-success">
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="panel"
			style="display: none; position: absolute; z-index: 1000; background-color: beige;"
			id="formSJ">
			<div class="panel-heading">Subject Input Form</div>
			<div class="panel-body">
				<form action="" id="addSubject" method="get">

					<div class="form-group">
						<label>Name</label> <input type="text" value="" name="name"
							id="name" class="form-control" placeholder="Enter Name">
					</div>
				
					<div class="form-group">

						<button class="btn btn-success" id="btnSave">Add</button>
						<input type="button" value="Close" class="btn btn-danger"
							id="btnClose">

					</div>
				</form>
			</div>
		</div>

 

		<div id="masLayer"
			style="display: none;; width: 100%; height: 100%; background-color: gray; z-index: 500; position: absolute; opacity: 0.1;">
		</div>
	</form>
	<script>
                function xoaHang(i) {
                	document.getElementById("idedit").value = -1;
                    document.getElementById("iddelete").value = i;
                }

             
                function suaHang(i) {


                    $(document).ready(function() {

                    	document.getElementById("iddelete").value = -1;
                     	document.getElementById("idedit").value = i;
                     	 $("#masLayer").toggle().animate({
                             left: '0px',
                             top: '0px'
                         });
                         $("#formSJ").toggle().animate({
                             left: '500px',
                             top: '200px'
                         }, 200);
                     	
                    });
                }
     </script>
	<script type="text/javascript">
                $(document).ready(function() {
                    $("#themMonHoc").click(function() {
                        $("#masLayer").toggle().animate({
                            left: '0px',
                            top: '0px'
                        });
                        $("#formSJ").toggle().animate({
                            left: '500px',
                            top: '200px'
                        }, 200);
                        document.getElementById("idedit").value = -1;
                        document.getElementById("iddelete").value = -1;
                        
                    });
                  	
                     
                   
                    
                    $("#btnClose").click(function() {
                        $("#formSJ").hide();
                        $("#masLayer").hide();
                         
                    });
                    $("#btnSave").click(function() {
                    	 if( document.getElementById("iddelete").value > 0){
                    		 document.getElementById("idedit").value = -1;
                    	 } else
                    	 if( document.getElementById("idedit").value > 0){
                    		 document.getElementById("iddelete").value = -1;
                    	 }
                    	 $("#formSJ").hide();
                         $("#masLayer").hide();
                    });
                    
                });    
            </script>
</body>

</html>