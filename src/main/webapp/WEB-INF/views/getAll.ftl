<#import "parts/_page.ftl" as page>
<#include "parts/security.ftl"/>

<@page.body>
<h6 class="h6">Добро пожаловать. Выберите экзамен:</h6>

<div class="list-group">
    <#list tests as test>
        <a href="gettest/${test.id}" class="list-group-item list-group-item-action">${test.name}</a>
        <#if isAdmin>
            <a href="edit/${test.id}">изменить</a>
            <a href="delete/${test.id}"
               onclick="return confirm('Вы уверены, что хотите удалить тест целиком?')">удалить</a>
        </#if>
    </#list>
    <#if isAdmin>
        <a href="addnew" class="list-group-item list-group-item-info">Добавить новый тест</a>
    </#if>
</div>

</@page.body>