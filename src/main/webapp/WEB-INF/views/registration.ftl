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
        <h3>Регистрация</h3>
        <p><input type="text" class="form-control" name="j_username" placeholder="login" required autofocus></p>
        <p><input type="password" class="form-control" name="j_password" placeholder="password"></p>
        <p><input type="password" class="form-control" name="j_password" placeholder="confirm password"></p>

        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Зарегистрироваться">

        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</div>
</body>
</html>