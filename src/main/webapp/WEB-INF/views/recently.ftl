<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>Список последних результатов:</h3>
<table>
    <tr>
        <td>Имя</td>
        <td>Экзамен</td>
        <td>Оценка</td>
        <td>Дата</td>
    </tr>
    <#list examResultList as examResult>
        <tr>
            <td>${examResult.userName}</td>
            <td>${examResult.examName}</td>
            <td>0</td>
            <td>${examResult.sqlDate}</td>
        </tr>
    </#list>
</table>
</body>
</html>