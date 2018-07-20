<#import "parts/_page.ftl" as page/>

<@page.body>
<h3>Отчет по пройденному тесту. </h3>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Вопрос:</th>
        <th scope="col">Результат:</th>
        <th scope="col">Детали:</th>
    </tr>
    </thead>
    <tbody>
    <#if questionResultDetailList?has_content>
        <#list questionResultDetailList as questionDetail>
            <#if questionDetail.correct>
            <tr class="table-success">
            <#else>
            <tr class="table-danger">
            </#if>
                <td>${questionDetail.questionText}</td>
                <td>
                    <#if questionDetail.correct>Верный
                    <#else>Неверный
                    </#if>
                </td>
                <td><a href="/reports/explanation/${questionDetail.questionId}"
                       class="btn btn-sm btn-success">Посмотреть</a>
                </td>
            </tr>
        </#list>
    <#else>Записей нет. =/
    </#if>
    </tbody>
</table>
</@page.body>