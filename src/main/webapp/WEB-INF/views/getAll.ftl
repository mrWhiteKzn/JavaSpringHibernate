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
                <form action="edit/${test.id}" method="get">
                    <button class="btn btn-default" data-toggle="confirmation">Изменить</button>
                </form>
            </td>
            <#--<a href="edit/${test.id}">изменить</a>-->
                <td><a href="delete/${test.id}">удалить</a></td>
            </#if>
        </tr>
    </#list>
</table>
    <#if isAdmin>
    <a href="addnew">Добавить новый тест</a>
    </#if>
</@page.body>