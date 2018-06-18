<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>Форма редактирования вопроса:</h3>
<form name="editedQuestion" action="/exam/updateQuestion/${question.id}" method="post">
    Id вопроса:
    <input type="text" value="${question.id}"><br>
    Текст вопроса:
    <input type="text" value="${question.questionText}">
    <input type="submit" value="Сохранить вопрос">
</form>

<form name="answerContainer" action="/exam/updateAnswers/" method="post">
    А теперь сохраним ответы: <br>
     <#list answerContainer.answerEntityList as answer>
         <@spring.bind path="answerContainer.answerEntityList[${answer_index}].id"/>
        <input type="hidden" name="${spring.status.expression}" value="${spring.status.value}">

         <@spring.bind path="answerContainer.answerEntityList[${answer_index}].answerText"/>
        <input type="text" name="${spring.status.expression}" value="${spring.status.value}">

         <@spring.bind path="answerContainer.answerEntityList[${answer_index}].correct"/>
        <input type="checkbox" name="${spring.status.expression}" id="correct" value="${spring.status.value}">
        <label for="correct">Верный</label>

         <@spring.bind path="answerContainer.answerEntityList[${answer_index}].questionEntity"/>
        <input type="hidden" name="${spring.status.expression}" value="${spring.status.value}">
     <br>
     </#list>
    <input type="submit" value="Сохранить ответы">
</form>
</body>
</html>