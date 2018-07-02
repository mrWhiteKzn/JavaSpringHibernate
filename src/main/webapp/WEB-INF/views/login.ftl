<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

<#--Bootstrap core CSS-->
    <link href="/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<div class="container" style="width: 300px">
    <form action="/secure/login" method="post">
        <h3>Вход</h3>
        <input type="text" class="form-control" name="username" placeholder="login" required autofocus>
        <input type="password" class="form-control" name="password" placeholder="password">

        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me">Запомнить меня
            </label>
        </div>

        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Войти">
    </form>
</div>
</body>
</html>