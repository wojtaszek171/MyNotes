<!DOCTYPE html>
<html>
<head>
    <meta title="viewport" content="width=device-width, initial-scale=1">
    <meta title="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/vendor/bootstrap/dist/css/bootstrap.css" />
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/vendor/bootstrap/dist/css/bootstrap-theme.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/logincss.css">
    <title>Login Page</title>
</head>
<body onload='document.f.j_username.focus();'>

    <div class="main">
        <div class="wrapper">
            <div class="divForm">
            <h3>Zaloguj się</h3>
            <form class="loginForm" title='f'
                action='${pageContext.request.contextPath}/j_spring_security_check'
                method='POST'>
                <table class="loginTable">
                    <tr>
                        <td>Nazwa użytkownika:</td>
                        <td><input type='text' title='j_username'
                            value=''></td>
                    </tr>
                    <tr>
                        <td>Hasło:</td>
                        <td><input type='password' title='j_password'
                            value="" /></td>
                    </tr>
                    <tr>
                        <td colspan='2'><input title="submit" type="submit"
                            value="Zaloguj" /></td>
                    </tr>
                </table>
            </form>
            <a href="register">Zarejestruj się</a>
            </div>
        </div>
    </div>
</body>
</html>