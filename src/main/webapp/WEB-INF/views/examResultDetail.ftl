<#import "parts/_page.ftl" as page/>

<@page.body>
<h3>Отчет по пройденному тесту. </h3>
<table>
    <tr>
        <td>Название вопроса:</td>
        <td>Выбранный ответ:</td>
        <td>Правильный ответ:</td>
    </tr>
    <#if examResultDetailList?has_content>
        <#list examResultDetailList as detail>
        <tr>
            <td>${detail.questionName}</td>
            <td>${detail.choosenAnswer}</td>
            <td>
            <#if detail.correct>
                Верный
            <#else>Неверный
            </#if>
            </td>
        </tr>
        </#list>
    <#else>Записей нет. =/
    </#if>

</table>


</@page.body>