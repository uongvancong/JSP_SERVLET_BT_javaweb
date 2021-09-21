<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
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
	<div class="grid-container">
		<div class="grigHeader">Header</div>
		<div class="gridLeftMenu">Left Menu</div>
		<div class="gridRightMenu">Right Menu</div>
		<div class="gridContent">


			<div style="margin: 10px; font-size: 30px; margin-left: 400px;">
				<span>Students List</span> <input type="button"
					value="Add New Student" class="btn btn-success" id="themSinhVien"
					style="margin-left: 20px;"> <input type="number"
					name="index" id="index" style="display: none;">
			</div>

			<div style="min-height: 700px;">

				<table
					class="table table-striped table-hover table-bordered table-sm "
					id="danhsachSV">

					<tr>
					<thead style="background-color: #4267B2; color: white;">
						<th class="col-sm-2">ID</th>
						<th class="col-sm-3">Name</th>
						<th class="col-sm-2">Age</th>
						<th class="col-sm-3">Address</th>
						<th class="col-sm-2">#</th>

					</thead>

					</tr>
					<tbody id="duLieuSV">

					</tbody>

				</table>
			</div>




			<div class="panel"
				style="display: none; position: absolute; z-index: 1000; background-color: beige;"
				id="formSV">
				<div class="panel-heading">Student Input Form</div>
				<div class="panel-body">
					<form>
						<div class="form-group">
							<label>ID</label> <input type="text" name="id" id="id"
								class="form-control" placeholder="Enter ID">
						</div>
						<div class="form-group">
							<label>Name</label> <input type="text" name="name" id="name"
								class="form-control" placeholder="Enter Name">
						</div>
						<div class="form-group">
							<label>Age</label> <input type="text" name="age" id="age"
								class="form-control" placeholder="Enter Age">
						</div>
						<div class="form-group">
							<label>Address</label> <input type="text" name="address"
								id="address" class="form-control" placeholder="Enter Adress">
						</div>
						<div class="form-group">
							<input type="button" value="Add" class="btn btn-success"
								id="btnSave" onclick="addSV()"> <input type="button"
								value="Close" class="btn btn-danger" id="btnClose">

						</div>
					</form>
				</div>
			</div>


			<div class="panel"
				style="display: none; position: absolute; z-index: 1000; background-color: beige;"
				id="formSVEdit">
				<div class="panel-heading">Student Edit Form</div>
				<div class="panel-body">
					<form>
						<div class="form-group">
							<label>ID</label> <input type="text" name="idEdit" id="idEdit"
								class="form-control">
						</div>
						<div class="form-group">
							<label>Name</label> <input type="text" name="nameEdit"
								id="nameEdit" class="form-control">
						</div>
						<div class="form-group">
							<label>Age</label> <input type="text" name="ageEdit" id="ageEdit"
								class="form-control">
						</div>
						<div class="form-group">
							<label>Address</label> <input type="text" name="addressEdit"
								id="addressEdit" class="form-control">
						</div>
						<div class="form-group">
							<input type="button" value="Edit" class="btn btn-success"
								id="btnSaveEdit"> <input type="button" value="Close"
								class="btn btn-danger" id="btnCloseEdit">

						</div>
					</form>
				</div>
			</div>

			<div id="masLayer"
				style="display: none;; width: 100%; height: 100%; background-color: gray; z-index: 500; position: absolute; opacity: 0.1;">

			</div>

		</div>

		<div class="gridFooter">Footer</div>
		<div class="gridAuthor">Author</div>
	</div>
	<script>
		var count = 0;
		var listSV;
		// var listSV = [];
		function checkValid(id, name, age, address) {
			//id, name, age, address
			var maSV = document.getElementById(id).value.trim();
			var tenSV = document.getElementById(name).value.trim();
			var tuoi = document.getElementById(age).value.trim();
			var diachi = document.getElementById(address).value.trim();

			if (maSV == null || maSV == "") {
				alert("Please enter ID");
				return false;
			}

			if (tenSV == null || tenSV == "") {
				alert("Please enter Name");
				return false;
			}

			if (tuoi == null || tuoi == "") {
				alert("Please enter Age");
				return false;
			}
			if (diachi == null || diachi == "") {
				alert("Please enter Address");
				return false;
			}

			try {
				tuoiInt = parseInt(tuoi);

				var tuoiString = tuoiInt + "";
				if (isNaN(tuoiInt) || tuoi.length != tuoiString.length) {
					alert("Age must be NUMBERIC");
					return false;
				}
			} catch (error) {

				alert("Age must be NUMBERIC");
				return false;

			}

			return true;
		}

		  function hienthiListSV() {
	            document.getElementById("duLieuSV").innerHTML = "";
	            for (var i = 0; i < listSV.length; ++i) {
	                document.getElementById("duLieuSV").innerHTML +=
	                    '<tr>' +
	                    '<td>' + listSV[i].id + '</td>' +
	                    '<td>' + listSV[i].name + '</td>' +
	                    '<td>' + listSV[i].age + '</td>' +
	                    '<td>' + listSV[i].address + '</td>' +
	                    '<td><div>' +
	                    '<button style="margin-left: 20px" class="btn btn-success" onclick=suaHang(' + i + ')>Edit</button>' +
	                    '<button style="margin-left: 10px" class="btn btn-danger" onclick=xoaHang(' + i + ')>Delete</button>' +
	                    '</div></td> </tr>';
	            }
	        }

		function getCookie(cookieName) {
			var cookies = document.cookie.split(";");
			for (var i = 0; i < cookies.length; ++i) {
				var tmp = cookies[i].trim();
				if (tmp.indexOf(cookieName) == 0) {
					return tmp.substring(cookieName.length + 1, tmp.length);
				}
			}
			return "";
		}
		var cookieTMP = getCookie("SV");
		if (cookieTMP.length == 0) {
			listSV = [];
		} else {
			listSV = JSON.parse(cookieTMP);
		}

		hienthiListSV();

		function xoaHang(i) {
			listSV.splice(i, 1);
			document.cookie = "SV=" + JSON.stringify(listSV);
			hienthiListSV();
		}

		function suaHang(i) {

			$(document)
					.ready(
							function() {

								document.getElementById("idEdit").value = listSV[i].id;
								document.getElementById("nameEdit").value = listSV[i].name;
								document.getElementById("ageEdit").value = listSV[i].age;
								document.getElementById("addressEdit").value = listSV[i].address;
								document.getElementById("index").value = i;

								$("#masLayer").toggle().animate({
									left : '0px',
									top : '0px'
								});
								$("#formSVEdit").toggle().animate({
									left : '500px',
									top : '200px'
								}, 200);

							});
		}

		function addSV() {
			if (checkValid("id", "name", "age", "address")) {
				++count;
				var maSV = document.getElementById("id").value;
				var tenSV = document.getElementById("name").value;
				var tuoi = document.getElementById("age").value;
				var diachi = document.getElementById("address").value;

				var studentTmp = {
					'id' : maSV,
					'name' : tenSV,
					'age' : tuoi,
					'address' : diachi
				};

				listSV.push(studentTmp);
				document.cookie = "SV=" + JSON.stringify(listSV);

				hienthiListSV();
			}
		}

		function xoaDuLieuForm() {
			document.getElementById("id").value = "";
			document.getElementById("name").value = "";
			document.getElementById("age").value = "";
			document.getElementById("address").value = "";
		}
	</script>
	<script>
		$(document)
				.ready(
						function() {
							$("#themSinhVien").click(function() {
								$("#masLayer").toggle().animate({
									left : '0px',
									top : '0px'
								});
								$("#formSV").toggle().animate({
									left : '500px',
									top : '200px'
								}, 200);

							});
							$("#btnClose").click(function() {
								$("#formSV").hide();
								$("#masLayer").hide();
								xoaDuLieuForm();
							});
							$("#btnCloseEdit").click(function() {
								$("#formSVEdit").hide();
								$("#masLayer").hide();

							});

							$("#btnSaveEdit")
									.click(
											function() {
												if (checkValid("idEdit",
														"nameEdit", "ageEdit",
														"addressEdit")) {
													var index = parseInt(document
															.getElementById("index").value);
													var id = document
															.getElementById("idEdit").value;
													var name = document
															.getElementById("nameEdit").value;
													var age = document
															.getElementById("ageEdit").value;
													var address = document
															.getElementById("addressEdit").value;
													listSV[index].id = id;
													listSV[index].name = name;
													listSV[index].age = age;
													listSV[index].address = address;
													document.cookie = "SV="
															+ JSON
																	.stringify(listSV);
													hienthiListSV();
													$("#formSVEdit").hide();
													$("#masLayer").hide();
												}
											});

						});
	</script>





</body>
</html>