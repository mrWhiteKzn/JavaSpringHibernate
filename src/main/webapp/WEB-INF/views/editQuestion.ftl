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
<form name="editedQuestion" action="/exam/updateQuestion" method="post">
Id вопроса:
    <input type="text" value="${question.id}">
    Текст вопроса:
    <input type="text" value="${question.questionText}">

</form>
</body>
</html>