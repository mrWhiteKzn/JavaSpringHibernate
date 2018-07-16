<#import "parts/_page.ftl" as page>
<#include "parts/security.ftl"/>

<@page.body>
<h6 class="h6">Добро пожаловать. Выберите экзамен:</h6>

<div class="list-group">
    <#list tests as test>
        <a href="gettest/${test.id}" class="list-group-item list-group-item-action">${test.name}</a>
        <#if isAdmin>
            <a href="edit/${test.id}">изменить</a>
            <a href="delete/${test.id}">удалить</a>
        </#if>
    </#list>
    <#if isAdmin>
        <a href="addnew" class="list-group-item list-group-item-info">Добавить новый тест</a>
    </#if>
</div>

<#--<table>-->
<#--<tr>-->
<#--<td>Id</td>-->
<#--<td>Название экзамена</td>-->
<#--</tr>-->
<#--<#list tests as test>-->
<#--<tr>-->
<#--<td>${test.id}</td>-->
<#--<td>${test.name}</td>-->
<#--<td><a href="gettest/${test.id}">пройти</a></td>-->
<#--<#if isAdmin>-->
<#--<td>-->
<#--<a class="btn btn-large btn-primary" data-toggle="confirmation" data-title="Open Google?"-->
<#--href="edit/${test.id}" target="_blank">изменить</a>-->
<#--</td>-->
<#--<td><a href="delete/${test.id}">удалить</a></td>-->
<#--</#if>-->
<#--</tr>-->
<#--</#list>-->
<#--</table>-->
<#--<#if isAdmin>-->
<#--<a href="addnew">Добавить новый тест</a>-->
<#--</#if>-->
</@page.body>