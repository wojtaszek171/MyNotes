<html>
<head>
    <title>Register Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/vendor/bootstrap/dist/css/bootstrap.css" />
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/vendor/bootstrap/dist/css/bootstrap-theme.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/logincss.css">
</head>
<body>
<div class="main">
    <div class="wrapper">
        <div class="divForm">
        <h3>Zarejestruj się</h3>
            <form name='f'
                  action='/register'
                  method='POST'>
                <p><label for="name">Nazwa użytkownika</label><input type="text" id="name" name="name" required></p>
                <p><label for="email">E-mail</label><input  type="text" id="email" name="email" required></p>
                <p><label for="pass">Hasło</label><input  type="password" id="pass" name="pass" required></p>
                <p><label for="pass-repeat">Powtórz hasło</label><input type="password" id="pass-repeat" name="pass-repeat" required></p>
                <p style="color:red">${error}</p>
                <input type="submit" name="confirm" value="Zarejestruj"/>
            </form>
        <a href="login">Zaloguj się</a>
        </div>
    </div>
</div>
</body>
</html>