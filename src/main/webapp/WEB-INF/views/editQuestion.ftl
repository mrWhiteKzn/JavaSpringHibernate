<#import "spring.ftl" as spring />
<#import "parts/_page.ftl" as page />

<@page.body>
    <h3>Форма редактирования вопроса:</h3>
<form name="question" action="/exam/updateQuestion/${questionContainer.questionEntity.id}" method="post">
    <input type="hidden" name="questionEntity.id" value="${questionContainer.questionEntity.id}"><br>
    Текст вопроса:
    <input type="text" name="questionEntity.questionText" value="${questionContainer.questionEntity.questionText}"
           required="required">

    <input type="submit" value="Сохранить вопрос">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>

<form name="questionContainer" action="/exam/updateAnswers/" method="post">
    А теперь сохраним ответы: <br>
     <#list questionContainer.answerEntityList as answer>
         <@spring.bind path="questionContainer.answerEntityList[${answer_index}].id"/>
        <input type="hidden" name="${spring.status.expression}" value="${spring.status.value}">

         <@spring.bind path="questionContainer.answerEntityList[${answer_index}].answerText"/>
        <input type="text" name="${spring.status.expression}" value="${spring.status.value}" required="required">

         <@spring.bind path="questionContainer.answerEntityList[${answer_index}].correct"/>
        <input type="checkbox" name="${spring.status.expression}" id="correct${answer_index}"
               value="${spring.status.value}" onclick="changeValue('correct${answer_index}')">
        <label for="correct${answer_index}" onclick="changeValue('correct${answer_index}');">Верный</label>
     <br>
     </#list>
    <input type="submit" value="Сохранить ответы">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
<script language="JavaScript">
    function changeValue(id) {
        document.getElementById(id).setAttribute("value", "true");
    }
</script>
<script src=”https://code.jquery.com/jquery-3.2.1.min.js”></script>
</@page.body>

