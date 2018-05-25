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
            document.getElementById('testTable').appendChild(tr);
            tr.appendChild(td);
        }
    </script>
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

<form name="answers" action="updateAnswers/${question.id}" method="post">
    А теперь сохраним ответы: <br>
    Ответ №1 <input type="text" name="answer1"><br>
    Ответ №2 <input type="text" name="answer2"><br>
    Ответ №3 <input type="text" name="answer3"><br>
    Ответ №4 <input type="text" name="answer4"><br>
    <input type="submit" value="Сохранить ответы">
</form>
</body>
</html>