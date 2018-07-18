<#import "parts/_page.ftl" as page>
<#include "parts/security.ftl"/>

<@page.body>
<h6 class="h6">Добро пожаловать. Выберите экзамен:</h6>

    <#if isAdmin>
    <div class="card">
        <#list tests as test>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">
                    <a href="gettest/${test.id}" class="list-group-item list-group-item-action">${test.name}</a>

                    <a class="btn btn-sm btn-light" href="edit/${test.id}">редактировать</a>
                    <a class="btn btn-sm btn-light" href="delete/${test.id}"
                       onclick="return confirm('Вы уверены, что хотите удалить тест целиком?')">удалить</a>

                </li>
            </ul>
        </#list>
    </div>
    <#else>

    <div class="list-group">
    <#list tests as test>
        <a href="gettest/${test.id}" class="list-group-item list-group-item-action">${test.name}</a>
    </#list>
    </div>


    </#if>

    <#if isAdmin>
        <a href="addnew" class="list-group-item list-group-item-info">Добавить новый тест</a>
    </#if>


</@page.body>