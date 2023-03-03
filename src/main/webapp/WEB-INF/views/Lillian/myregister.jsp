<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊帳號</title>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/mymain.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>
<style>
</style>

</head>

<body>
	<%@ include file="../layout/mynav.jsp"%>

	<!-- regis -->
	<article id="" class="wrapper style2">
		<div class="container-fluid " id="register">
			<div id="space"></div>


			<div class="container" id="form_container">
				<div id="registerTitle">註冊會員</div>
				<form id="register_form" action="${contextRoot}/register/add" method="post">
					
					<div class="mb-6 row">
						<label for="account" class="col-sm-2 col-form-label">帳號</label>
						<div class="col-sm-10">
							<input type="text" placeholder="account" class="form-control"
								id="account" name="account">
						</div>
					</div>
					<div class="mb-6 row">
						<label for="password" class="col-sm-2 col-form-label">密碼</label>
						<div class="col-sm-10">
							<input type="password" placeholder="password(密碼長度需大於 5 小於 12)"
								class="form-control" id="password" name="password">
								<div class="messages"></div>
      					
						</div>
					</div>
					<div class="mb-6 row">
						<label for="confirm-password" class="col-sm-2 col-form-label">確認密碼</label>
						<div class="col-sm-10">
							<input id="confirm-password" class="form-control" type="password"
								placeholder="Confirm password" name="confirmPassword">
							<div class="messages"></div>
						</div>
					</div>
					<button type="submit">下一步</button>
					<br> <a href="">已有會員</a><br>

				</form>
			</div>
		</div>
	</article>



	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/jquery-3.6.3.min.js"></script>
	<script src="assets/js/main.js"></script>


	<script>
	
	$(function() {
      
      var constraints = {
        "password": {
          presence: {
            message: "是必填的欄位"
          }, // 密碼是必填欄位
          length: {
            minimum: 5, // 長度大於 ５
            maximum: 12, // 長度小於 12
            message: "^密碼長度需大於 5 小於 12"
          },
        },
        "confirmPassword": {  
          presence: {
            message: "是必填的欄位"
          },// 確認密碼是必填欄位
          equality: {
            attribute: "password",// 此欄位要和密碼欄位一樣
            message: "^密碼不相同"
          }
       
      };

      // Hook up the form so we can prevent it from being posted
      var form = document.querySelector("form#main");
      form.addEventListener("submit", function(ev) {
        ev.preventDefault();
        handleFormSubmit(form);
      });
      
      // 監聽 input 值改變的狀況
      var inputs = document.querySelectorAll("input, textarea, select")
      for (var i = 0; i < inputs.length; ++i) {
        inputs.item(i).addEventListener("change", function(ev) {
          var errors = validate(form, constraints) || {};
          showErrorsForInput(this, errors[this.name])
        });
      }

      // 沒有錯誤就顯示成功傳送
      function handleFormSubmit(form, input) {
        var errors = validate(form, constraints);// validate the form aainst the constraints
        showErrors(form, errors || {}); // then we update the form to reflect the results
        if (!errors) {
          showSuccess();
        }
      }

      // Updates the inputs with the validation errors
      function showErrors(form, errors) {
        // We loop through all the inputs and show the errors for that input
        _.each(form.querySelectorAll("input[name], select[name]"), function(input) {
          // Since the errors can be null if no errors were found we need to handle
          // that
          showErrorsForInput(input, errors && errors[input.name]);
        });
      }

      // Shows the errors for a specific input
      function showErrorsForInput(input, errors) {
        // This is the root of the input
        var formGroup = closestParent(input.parentNode, "form-group")
          // Find where the error messages will be insert into
          , messages = formGroup.querySelector(".messages");
        // First we remove any old messages and resets the classes
        resetFormGroup(formGroup);
        // If we have errors
        if (errors) {
          // we first mark the group has having errors
          formGroup.classList.add("has-error");
          // then we append all the errors
          _.each(errors, function(error) {
            addError(messages, error);
          });
        } else {
          // otherwise we simply mark it as success
          formGroup.classList.add("has-success");
        }
      }

      // Recusively finds the closest parent that has the specified class
      function closestParent(child, className) {
        if (!child || child == document) {
          return null;
        }
        if (child.classList.contains(className)) {
          return child;
        } else {
          return closestParent(child.parentNode, className);
        }
      }

      function resetFormGroup(formGroup) {
        // Remove the success and error classes
        formGroup.classList.remove("has-error");
        formGroup.classList.remove("has-success");
        // and remove any old messages
        _.each(formGroup.querySelectorAll(".help-block.error"), function(el) {
          el.parentNode.removeChild(el);
        });
      }

      // Adds the specified error with the following markup
      // <p class="help-block error">[message]</p>
      function addError(messages, error) {
        var block = document.createElement("p");
        block.classList.add("help-block");
        block.classList.add("error");
        block.innerText = error;
        console.log(block);
        messages.appendChild(block);
      }
      function showSuccess() {
        alert("Success!"); // We made it \:D/
      }
    })();
	///
		
	</script>

</body>
</html>