<#import "parts/_page.ftl" as page/>

<@page.body>
   <h3>Отчет по студенту: ${user.login}</h3>
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
        <#else> Записей не найдено. Видимо студент не сдавал никаких экзаменов.
        </#if>

    </ul>
</@page.body>