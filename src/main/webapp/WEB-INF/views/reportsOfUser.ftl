<#import "parts/_page.ftl" as page/>

<@page.body>
<form action="/secure/saveUser/${user.id}" method="post">
    <h4>Пользователь:</h4>
    Логин:
    <input type="hidden" name="id" value="${user.id}">
    <input type="text" name="login" value="${user.login}" required>
    <br>
    Роли:
    <#list roles as role>
        <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}
        </label>
    </#list>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div><input type="submit" class="btn btn-sm" value="Сохранить"></div>
</form>

   <h4>Отчет по студенту: ${user.login}</h4>
    Пройденные тесты:
    <ul>
        <#if examResultOfUserList?has_content>
            <#list examResultOfUserList as exam>
            <li>
                <a href="/reports/byExam/${exam.id}">${exam.testName}</a>
                ${exam.date}
                0
            </li>
            </#list>
        <#else> Записей не найдено. Видимо, студент не сдавал никаких экзаменов.
        </#if>

    </ul>
</@page.body>