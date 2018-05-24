<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script language="JavaScript">
        function add(){
            var tr = document.createElement('tr');
            var td = document.createElement('td');

            td.innerHTML="<input type='text' name='question'>";
            document.getElementById('questionTable').appendChild(tr);
            tr.appendChild(td);
        }
    </script>
</head>
<body>
<h3>Форма редактирования теста:</h3>
<form name="editedTestContainer" action="/exam/updateTest" method="post">
<table id="testTable">
    ID теста: <input type="text" name="id" title="id" value="${testContainer.testEntity.id}"><br>
    Название теста: <input type="text" name="name" title="testName" value="${testContainer.testEntity.name}"><br>

    <input type="submit" name="updateTest" value="Сохранить">

</table>
    <table id="questionTable" name="questionTable">
        <tr>
            <td>Номер вопроса:</td>
            <td>Вопрос:</td>
        </tr>
        <#list testContainer.questionEntityList as question>
            <tr>
                <td>${question.id}</td>
                <td>${question.questionText}</td>
                <td><a href="/exam/editQuestion/${question.id}">изменить</a></td>
                <td><a href="/exam/deleteQuestion/${question.id}">удалить</a></td>
            </tr>
        </#list>
    </table>

</form>

<form action="/exam/addQuestion/${testContainer.testEntity.id}" method="get">
    <input type="submit" value="Добавить вопрос">
</form>

</body>
</html>