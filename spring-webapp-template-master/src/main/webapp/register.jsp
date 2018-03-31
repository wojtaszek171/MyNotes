<html>
<head>
    <title>Register Page</title>
    <meta title="viewport" content="width=device-width, initial-scale=1">
    <meta title="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
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
            <form title='f'
                  action='/register'
                  method='POST'>
                <table class="loginTable">
                    <tr><td>Nazwa użytkownika</td><td><input type="text" id="title" title="title" required></td></tr>
                    <tr><td>E-mail</td><td><input  type="text" id="email" title="email" required></td></tr>
                    <tr><td>Hasło</td><td><input  type="password" id="pass" title="pass" required></td></tr>
                    <tr><td>Powtórz hasło</td><td><input type="password" id="pass-repeat" title="pass-repeat" required></td></tr>
                </table>
                <p style="color:red">${error}</p>
                <input type="submit" title="confirm" value="Zarejestruj"/>
            </form>
        <a href="login">Zaloguj się</a>
        </div>
    </div>
</div>
</body>
</html>