<#import "spring.ftl" as spring />
<#import "parts/_page.ftl" as page />

<@page.body>

 <div class="jumbotron">
     <div class="container">
         <h4>${question.questionText}</h4>
         <p class="lead">Правильные ответы.</p>
     </div>
 </div>
    <#list question.answerEntityList as answer>
    <ul>
        <#if choosenAnswersIdList?seq_contains(answer.id)> (Выбран).</#if>
        <#if answer.correct>
            <li class="list-group-item list-group-item-success">
        <#else>
            <li class="list-group-item list-group-item-danger">
        </#if>
        ${answer.answerText}
    </li>
    </ul>
    </#list>
<button class="btn btn-primary btn-lg btn-outline-info" onclick="goBack()">Вернуться</button>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</@page.body>

