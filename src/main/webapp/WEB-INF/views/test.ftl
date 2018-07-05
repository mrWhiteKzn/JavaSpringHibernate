<#import "parts/_page.ftl" as page/>

<@page.body>
    <form action="/exam/saveResult/${test.id}" method="post" style="align-content: center">
        Тест: ${test.name}
    <p>
    <#list questionList as question>
        ${question.questionText}

        <#list question.answerEntityList as answer>
        <ul>
            <input type="checkbox" name="${question.id}" value="${answer.id}" id="${answer.id}">
            <label for="${answer.id}">${answer.answerText}</label>
        </ul>
        </#list>
    </#list>
        </p>
        <input type="submit" value="сохранить">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</@page.body>
