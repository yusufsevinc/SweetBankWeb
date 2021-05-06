<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="tr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Sweet Bank</title>
<script type="text/javascript">window.onbeforeunload = function() { redirect(window.history.back(1)); };</script>

<link rel="stylesheet" type="text/css" href="resources/css/login.css">


</head>

<body>
    <div class="giris">
        <h2>Sweet Banka Hoşgeldiniz</h2>
        <form action ="loginController" method="post" >
            <div class="pc">
                <span>Müşteri No veya TC Kimlik No</span>
            <input type="text"  name="username" maxlength="11" required>
            </div>
              <div class="pc">
              <br>
                   <span>Şifre</span><br>
            <input type="password"  name="password" required>
            </div>
              <div class="pc">
              <br>
            <input id="input" type="submit" value="Giriş">
            </div>
        </form>
        <br>
        <br>
        <a  class = "link" href="loginController">Şifremi Unuttum</a><br>
        <a class = "link"  href="basvuru">Sende Sweet Banklı Ol</a>
    </div>
  
</body>
</html>
