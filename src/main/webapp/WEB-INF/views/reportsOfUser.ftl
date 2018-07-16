<#import "parts/_page.ftl" as page/>

<@page.body>
<form action="/secure/saveUser/${user.id}" method="post">
    <h4>Пользователь:</h4>

    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">Логин</span>
        </div>
        <input type="hidden" name="id" value="${user.id}">
        <input type="text" class="form-control" name="login" value="${user.login}" required>
    </div>
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

    <table class="table table-striped">
        <thead>
        <th scope="col">Экзамен</th>
        <th scope="col">Дата</th>
        <th scope="col">Оценка</th>
        </thead>
        <tbody>

        <#if examResultOfUserList?has_content>
            <#list examResultOfUserList as exam>
            <tr>
                <th scope="row">
                    <a href="/reports/byExam/${exam.id}">
                        ${exam.testName}
                    </a>
                </th>
                <td>${exam.date}</td>
                <td>${exam.grade}</td>
            </tr>
            </#list>
        <#else>Записей не найдено. Видимо, студент не сдавал никаких экзаменов.
        </#if>

        </tbody>
    </table>

<#--<ul>-->
<#--<#if examResultOfUserList?has_content>-->
<#--<#list examResultOfUserList as exam>-->
<#--<li>-->
<#--<a href="/reports/byExam/${exam.id}">${exam.testName}</a>-->
<#--${exam.date}-->
<#--${exam.grade}-->
<#--</li>-->
<#--</#list>-->
<#--<#else> -->
<#--</#if>-->
<#--</ul>-->
</@page.body>