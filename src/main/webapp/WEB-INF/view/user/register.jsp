<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
</head>

<body>
	<li class="nav-item">
	  <a class="nav-link fs-5" href="/board/index" aria-label="Homepage">
	    Home
	  </a>
	</li>

<div class="container right-panel-active">
  <!-- Sign Up -->
  <div class="container__form container--signup">
    <form action="/user/register" class="form" id="form1">
      <h2 class="form__title">Join</h2>
      <input type="text" placeholder="User" class="input" />
      <input type="email" placeholder="Email" class="input" />
      <input type="password" placeholder="Password" class="input" />
      <button class="btn">Join</button>
    </form>
  </div>

  <!-- Sign In -->
  <div class="container__form container--signin">
    <form action="/user/login" class="form" id="form2">
      <h2 class="form__title">Login</h2>
      <input type="uid" placeholder="id" class="input" />
      <input type="password" placeholder="Password" class="input" />
      <a href="#" class="link">Forgot your password?</a>
      <button class="btn" type="submit">Login</button>
    </form>
  </div>

  <!-- Overlay -->
  <div class="container__overlay">
    <div class="overlay">
      <div class="overlay__panel overlay--left">
        <button class="btn" id="signIn">Login</button>
      </div>
      <div class="overlay__panel overlay--right">
        <button class="btn" id="signUp">Join</button>
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

fistForm.addEventListener("submit", (e) => e.preventDefault());
secondForm.addEventListener("submit", (e) => e.preventDefault());
</script>
</body>
</html>
