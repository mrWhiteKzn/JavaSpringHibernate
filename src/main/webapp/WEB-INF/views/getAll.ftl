<#import "parts/_page.ftl" as page>
<#include "parts/security.ftl"/>

<@page.body>
    <h6>Список:</h6>
<table>
    <tr>
        <td>Id</td>
        <td>Название экзамена</td>
    </tr>
    <#list tests as test>
        <tr>
            <td>${test.id}</td>
            <td>${test.name}</td>
            <td><a href="gettest/${test.id}">пройти</a></td>
            <#if isAdmin>
            <td>
                <a class="btn btn-large btn-primary" data-toggle="confirmation" data-title="Open Google?"
                   href="edit/${test.id}" target="_blank">изменить</a>
            </td>
                <td><a href="delete/${test.id}">удалить</a></td>
            </#if>
        </tr>
    </#list>
</table>
    <#if isAdmin>
    <a href="addnew">Добавить новый тест</a>
    </#if>
</@page.body>