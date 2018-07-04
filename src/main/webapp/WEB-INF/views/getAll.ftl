<#import "parts/_page.ftl" as page>
<#include "parts/navbar.ftl">

<@page.body>
    <h3>Список:</h3>
<table>
    <tr>
        <td>Id</td>
        <td>Название экзамена</td>
    </tr>
    <#list tests as test>
        <tr>
            <td>${test.id}</td>
            <td><a href="gettest/${test.id}">${test.name}</a></td>
            <td><a href="gettest/${test.id}">пройти</a></td>
            <td><a href="edit/${test.id}">изменить</a></td>
            <td><a href="delete/${test.id}">удалить</a></td>
        </tr>
    </#list>
</table>
<a href="addnew">Добавить новый тест</a>
<div>
    <form action="/secure/login?logout" method="post">
        <input type="submit" value="Выйти">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</div>
</@page.body>