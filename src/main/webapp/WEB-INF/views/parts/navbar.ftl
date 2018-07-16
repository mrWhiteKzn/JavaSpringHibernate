<#include "security.ftl" />

<nav class="navbar navbar-expand-sm navbar-light bg-light sticky-top">
    <a class="navbar-brand" href="/exam/getall">Saturn here</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/main/about">О нас </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/exam/getall">Список экзаменов</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/reports/recently">Последние результаты</a>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/secure/users">Список студентов</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">Здравствуйте, ${name}</div>
        <#if name =="Гость">
            <div class="navbar-text">
                <a class="nav-item" href="/secure/login">Войти</a>
            </div>
        </#if>

        <#if name != "Гость">
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input class="btn btn-sm btn-info" type="submit" value="Выйти">
        </form>
        </#if>

    </div>
</nav>
