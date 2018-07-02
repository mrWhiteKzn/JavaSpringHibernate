<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>
<h3>Форма редактирования вопроса:</h3>
<form name="editedQuestion" action="/exam/updateQuestion/${questionContainer.questionEntity.id}" method="post">
    Id вопроса:
    <input type="text" value="${questionContainer.questionEntity.id}"><br>
    Текст вопроса:
    <input type="text" value="${questionContainer.questionEntity.questionText}">
    <input type="submit" value="Сохранить вопрос">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>

<form name="questionContainer" action="/exam/updateAnswers/" method="post">
    А теперь сохраним ответы: <br>
     <#list questionContainer.answerEntityList as answer>
         <@spring.bind path="questionContainer.answerEntityList[${answer_index}].id"/>
        <input type="hidden" name="${spring.status.expression}" value="${spring.status.value}">

         <@spring.bind path="questionContainer.answerEntityList[${answer_index}].answerText"/>
        <input type="text" name="${spring.status.expression}" value="${spring.status.value}">

         <@spring.bind path="questionContainer.answerEntityList[${answer_index}].correct"/>
        <input type="checkbox" name="${spring.status.expression}" id="correct${answer_index}"
               value="${spring.status.value}" onclick="changeValue('correct${answer_index}')">
        <label for="correct${answer_index}" onclick="changeValue('correct${answer_index}');">Верный</label>

     <#--<@spring.bind path="answerContainer.answerEntityList[${answer_index}].questionEntity"/>-->
     <#--<input type="hidden" name="${spring.status.expression}" value="${spring.status.value}">-->
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
</body>
</html>