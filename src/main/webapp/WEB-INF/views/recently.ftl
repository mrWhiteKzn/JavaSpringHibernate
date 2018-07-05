<#import "parts/_page.ftl" as page/>

<@page.body>
    <h3>Список последних результатов:</h3>
<table>
    <tr>
        <td>Имя</td>
        <td>Экзамен</td>
        <td>Оценка</td>
        <td>Дата</td>
    </tr>
    <#list examResultList as examResult>
        <tr>
            <td>${examResult.userName}</td>
            <td>${examResult.examName}</td>
            <td>0</td>
            <td>${examResult.sqlDate}</td>
        </tr>
    </#list>
</table>
</@page.body>