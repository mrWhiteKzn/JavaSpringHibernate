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
<#--переделать-->
<#--https://stackoverflow.com/questions/9617207/listfoo-as-form-backing-object-using-spring-3-mvc-correct-syntax?rq=1 -->
<#--чтоб было красиво-->

<#--<#list question.answerEntitySet as answer>-->
<#--<input type="text" name="${answer.id}" value="${answer.answerText}">-->
<#--<input type="checkbox" id="isCorrect" name="isCorrect" value="${answer.id}">-->
<#--<label for="isCorrect">Верный</label><br>-->
<#--</#list>-->
     <#list answerContainer.answerEntityList as answer>
         <@spring.bind path="answerContainer.answerEntityList[${answer_index}].id"/>
        <input type="text" name="${spring.status.expression}" value="${spring.status.value}">

         <@spring.bind path="answerContainer.answerEntityList[${answer_index}].answerText"/>
        <input type="text" name="${spring.status.expression}" value="${spring.status.value}">

         <@spring.bind path="answerContainer.answerEntityList[${answer_index}].isCorrect"/>
        <input type="text" name="${spring.status.expression}" id="isCorrect" value="${spring.status.value}">

        <input type="text" name="questionEntity" value="">
     <#--<label for="isCorrect">Верный</label><br>--><br>
     </#list>

    <input type="submit" value="Сохранить ответы">
</form>
</body>
</html>