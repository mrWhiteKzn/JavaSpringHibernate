<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>Список:</h3>
<table>
    <tr>
        <td>Id</td>
        <td>Название экзамена</td>
    </tr>
    <#list tests as test>
        <tr>
            <td>${test.id}</td>
            <td><a href="gettest/${test.id}">${test.name}<a/></td>
            <td><a href="gettest/${test.id}">пройти</a></td>
            <td><a href="edit/${test.id}">изменить</a></td>
            <td><a href="delete/${test.id}">удалить</a></td>
        </tr>
    </#list>
</table>
<a href="addnew">Добавить новый тест</a>

</body>
</html>