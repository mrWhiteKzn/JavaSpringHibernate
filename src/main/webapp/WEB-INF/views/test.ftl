<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>Вы выбрали тест:
    <br> ${testContainer.testEntity.name}</h3>
<br>
<table>
<tr>
    <td>Номер вопроса</td>
    <td>Текст вопроса</td>
</tr>
Вопрос:
<#list testContainer.questionEntityList as question>
    <tr>
        <td>${question.id}</td>
        <td>${question.questionText}</td>
    </tr>
</#list>
</table>
</body>
</html>