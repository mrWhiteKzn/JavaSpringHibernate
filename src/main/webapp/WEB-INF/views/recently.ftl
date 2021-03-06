<#import "parts/_page.ftl" as page/>

<@page.body>
    <h3>Список последних результатов:</h3>
<form action="/reports/recently" method="get">
    <input type="submit" class="btn btn-sm btn-outline-secondary" value="Обновить">
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Студент</th>
        <th scope="col">Экзамен</th>
        <th scope="col">Результат</th>
        <th scope="col">Дата</th>
    </tr>
    </thead>
    <tbody>
    <#list examResultList as examResult>
    <tr>
        <td><a href="/reports/byUser/${examResult.userId}">${examResult.userName}</a></td>
        <td><a href="/reports/byExam/${examResult.resultId}"> ${examResult.examName}</a></td>
        <td>${examResult.grade} %</td>
        <td>${examResult.sqlDate}</td>
    </tr>
    </#list>
    </tbody>

</table>
</@page.body>