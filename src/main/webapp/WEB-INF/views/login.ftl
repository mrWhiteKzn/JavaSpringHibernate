<#import "parts/_page.ftl"as page />

<@page.body>
    <div class="container" style="width: 300px">
        <form action="/secure/login" method="post">
            <h3>Вход</h3>
            <input type="text" class="form-control" name="username" placeholder="login" required autofocus>
            <input type="password" class="form-control" name="password" placeholder="password">
            <input type="hidden" name="_csrf" value="${_csrf.token}">

            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me">Запомнить меня
                </label>
            </div>
            <input type="submit" class="btn btn-lg btn-primary btn-block" value="Войти">
            <label>
                <a href="/secure/registration">Регистрация</a>
            </label>
        </form>
    </div>
</@page.body>