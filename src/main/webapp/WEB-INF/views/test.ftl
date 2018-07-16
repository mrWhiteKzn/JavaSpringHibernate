<#import "parts/_page.ftl" as page/>

<@page.body>
    <form action="/exam/saveResult/${test.id}" method="post" style="align-content: center">

        <div class="jumbotron">
            <div class="container">
                <h1 class="display-4">${test.name}</h1>
                <p class="lead">Количество вопросов: ${questionList?size}</p>
            </div>
        </div>


    <#list questionList as question>
    <div class="card-group">
        <div class="card bg-light" style="width: 20rem;">
            <div class="card-body">
                <h6 class="card-subtitle mb-2 text-muted">Вопрос № ${question_index+1}</h6>
                <p class="card-text">${question.questionText}</p>

            <#list question.answerEntityList as answer>
            <ul>
                <input type="checkbox" name="${question.id}" value="${answer.id}" id="${answer.id}">
                <label for="${answer.id}">${answer.answerText}</label>
            </ul>
            </#list>

            </div>
        </div>
    </div>
    </#list>

        <input type="submit" class="btn btn-success" value="сохранить">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</@page.body>
