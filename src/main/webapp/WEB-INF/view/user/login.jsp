<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/style.css">
</head>

<body>
  <a class="nav-link fs-5" href="/board/index" aria-label="Homepage">
    Home
  </a>

<div class="container right-panel-active">
  <!-- 회원가입 -->
	<div class="container__form container--signup">
    	<form action="/user/register" class="form" id="form1" method="post">
      	<h2 class="form__title">Join</h2>
      	<input type="text" placeholder="User" class="input" disabled="disabled" />
      	<input type="email" placeholder="Email" class="input" disabled="disabled" />
      	<input type="password" placeholder="Password" class="input" disabled="disabled" />
      	<a href="/user/register" class="btn" >Join</a>
		</form>
	</div>

  <!-- 로그인 -->
	<div class="container__form container--signin">
		<form action="/user/login" class="form" id="form2" method="post">
			<h2 class="form__title">Login</h2>
		    <input type="text" name="uid" id="uid" placeholder="아이디" class="input" />
		    <input type="password" name="pwd" id="pwd" placeholder="패스워드" class="input" />
      		<button class="btn" type="submit" value="로그인" >Login</button>
		</form>
	</div>

  <!-- Overlay -->
  <div class="container__overlay">
    <div class="overlay">
      <div class="overlay__panel overlay--left">
        <button class="btn" id="signIn">Login</button>
      </div>
      <div class="overlay__panel overlay--right">
        <a href="/user/register" class="btn" id="signUp" >Join</a>
      </div>
    </div>
  </div>
</div>

	<script>
		const signInBtn = document.getElementById("signIn");
		const signUpBtn = document.getElementById("signUp");
		const fistForm = document.getElementById("form1");
		const secondForm = document.getElementById("form2");
		const container = document.querySelector(".container");
		
		signInBtn.addEventListener("click", () => {
		  container.classList.remove("right-panel-active");
		});
		
		signUpBtn.addEventListener("click", () => {
		  container.classList.add("right-panel-active");
		});
		
	//	fistForm.addEventListener("submit", (e) => e.reg_sub().submit);
	//	secondForm.addEventListener("submit", (e) => e.preventDefault());
	</script>
</body>
</html>
