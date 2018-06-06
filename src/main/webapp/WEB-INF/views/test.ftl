<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/exam/saveResult/${test.id}" method="post" style="align-content: center">
    Тест: ${test.name}
    <p>
    <#list questionList as question>
        ${question.questionText}

        <#list question.answerEntitySet as answer>
        <ul>
                <input type="checkbox" name="${question.id}" value="${answer.id}" id="${answer.id}">
                <label for="${answer.id}">${answer.answerText}</label>
        </ul>
        </#list>
    </#list>
    </p>
    <input type="submit" value="сохранить">
</form>
</body>
</html>