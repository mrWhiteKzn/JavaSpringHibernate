<#import "spring.ftl" as spring />
<#import "parts/_page.ftl" as page />

<@page.body>

 <div class="jumbotron">
     <div class="container">
         <h4>${question.questionText}</h4>
         <p class="lead">Правильные ответы.</p>
     </div>
 </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Ответ</th>
            <th scope="col">Верный/Неверный</th>
            <th scope="col">Выбран</th>
        </tr>
        </thead>
    <tbody>
        <#list question.answerEntityList as answer>
        <#--Если выбран правильный-->
            <#if (choosenAnswersIdList?seq_contains(answer.id)) && (answer.correct)>
                <tr class="table-success">

            <#--Если выбран неправильный-->
            <#elseif (choosenAnswersIdList?seq_contains(answer.id)) && (!answer.correct)>
                <tr class="table-warning">

            <#--Если правильный невыбран-->
            <#elseif (answer.correct)>
                <tr class="table-info">
            <#--Неправильный вариант-->
            <#else>
                <tr class="table-light">
            </#if>

            <td>${answer_index+1}</td>
            <td>${answer.answerText}</td>
            <td>
                    <#if answer.correct>
                        Верный
                    </#if>
            </td>
            <td>
                    <#if choosenAnswersIdList?seq_contains(answer.id)>
                        Выбран
                    </#if>
            </td>
        </tr>
        </#list>
    </tbody>
    </table>
<button class="btn btn-primary btn-lg btn-outline-info" onclick="goBack()">Вернуться</button>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</@page.body>

