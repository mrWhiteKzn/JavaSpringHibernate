<#import "spring.ftl" as spring />

<#import "parts/_page.ftl" as page />

<@page.body>

<h3>Добавить новый тест.</h3>
<form name="test" action="addNew" method="post">
    Наименование теста:<br>

    <input type="text" name="name" required="required">
    <input type="submit" name="addTest" value="Добавить">

    Вопрос:<br>

    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>

</@page.body>
