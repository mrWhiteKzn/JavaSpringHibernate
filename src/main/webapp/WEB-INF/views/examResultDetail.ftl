<#import "parts/_page.ftl" as page/>

<@page.body>
<h3>Отчет по пройденному тесту. </h3>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Вопрос:</th>
    <#--<th scope="col">Выбранные ответы:</th>-->
        <th scope="col">Результат:</th>
        <th scope="col">Детали:</th>
    </tr>
    </thead>
    <tbody>
    <#if examResultDetailList?has_content>
        <#list 0..examResultDetailList?size-1 as i>
            <#if examResultDetailList[i].correct>
            <tr class="table-success">
            <#else>
            <tr class="table-danger">
            </#if>
            <td>
                <#if prev?? && examResultDetailList[i].questionName == examResultDetailList[prev].questionName>
                <#else>
                    ${examResultDetailList[i].questionName}

                </#if>
            </td>
        <#--<td>${examResultDetailList[i].choosenAnswer}</td>-->
            <td>
            <#if examResultDetailList[i].correct>
                Верный
            <#else>Неверный
            </#if>
            </td>
        <td><a href="/reports/getRightAnswers/${examResultDetailList[i].questionId}" class="btn btn-sm btn-success">Посмотреть</a>
        </td>
        </tr>
            <#assign prev = i>
        </#list>
    <#else>Записей нет. =/
    </#if>
    </tbody>
</table>


</@page.body>