<#import "parts/_page.ftl" as page/>

<@page.body>
    <div class="container" style="width: 300px">
        <form action="/secure/registration" method="post">
            <h3>Регистрация</h3>
            <p><input type="text" class="form-control" name="login" placeholder="login" required autofocus></p>
            <p><input type="password" class="form-control" name="password" placeholder="password"></p>

            <input type="submit" class="btn btn-lg btn-primary btn-block" value="Зарегистрироваться">

            <div class="alert-warning">
            <#if message??>
                ${message}
            </#if>
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </form>
    </div>
</@page.body>