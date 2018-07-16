<#import "spring.ftl" as spring />

<#import "parts/_page.ftl" as page />

<@page.body>

<h3>Добавить новый тест.</h3>
<form name="test" action="addNew" method="post">
    Наименование теста:<br>
    <div class="input-group">
        <textarea class="form-control" name="name"></textarea>
    </div>
    <div>
        <input type="submit" class="btn btn-info" name="addTest" value="Добавить">
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>

</@page.body>
