<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/exam/saveResult/${testContainer.testEntity.id}" method="post">
    <h3>Вы выбрали тест:
        <br> ${testContainer.testEntity.name}</h3>
    <br>
    <table border="1">
        <tr>
            <td>Номер вопроса</td>
            <td>Текст вопроса</td>
            <td>Варианты ответа</td>
        </tr>
    <#list testContainer.questionEntityList as question>
    <tr>
        <td>${question.id}</td>
        <td>${question.questionText}</td>
        <td>
            <#list question.answerEntitySet as answer>
                <div>
                    <input type="checkbox" name="checkbox" value="${answer.answerText}" id="${answer.answerText}">
                    <label for="${answer.answerText}">${answer.answerText}</label>
                </div>
            </#list>
        </td>
    </tr>

    </#list>
    </table>
    <input type="submit" value="̶с̶п̶а̶с̶т̶и̶  ̶и̶ сохранить">
</form>
</body>
</html>