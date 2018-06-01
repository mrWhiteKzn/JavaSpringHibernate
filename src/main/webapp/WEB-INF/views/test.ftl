<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/exam/saveResult/" method="post" style="align-content: center">
    Тест: ${test.name}
    <#list questionList as question>
        ${question.questionText}

        <#list question.answerEntitySet as answer>
        <ul>
            <div>
                <input type="checkbox" name="answerText" value="${answer.answerText}" id="${answer.id}">
                <input type="hidden" name="answer.id" value="${answer.id}">
                <label for="${answer.id}">${answer.answerText}</label>
            </div>
        </ul>
        </#list>

    </#list>
    <input type="submit" value="сохранить">
</form>
</body>
</html>