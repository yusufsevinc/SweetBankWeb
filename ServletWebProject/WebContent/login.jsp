<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="tr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--başlık-->
<title>Login</title>
<script type="text/javascript">window.onbeforeunload = function() { redirect(window.history.back(1)); };</script>

<link rel="stylesheet" type="text/css" href="resources/css/login.css">
</head>

<body>
    <div class="giris">
        <h2>Sweet Banka Hoşgeldiniz</h2>
        <form action ="loginController" method="post" >
            <div class="pc">
                <span>Müşteri No veya TC Kimlik No</span>
            <input type="text"  name="username" required>
            </div>
              <div class="pc">
                   <span>Şifre</span>
            <input type="password"  name="password" required>
            </div>
              <div class="pc">
            <input type="submit" value="submit">
            </div>
        </form>
        <a href="#">şifremi unuttum</a><br>
        <a href="/loginController">Sende Sweet Banklı ol</a>
    </div>
  
</body>
</html>
