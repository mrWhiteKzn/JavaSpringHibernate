<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>Добавить новый вопрос к тесту ${testEntity.name}.</h3>
<form name="question" action="/exam/addQuestion/${testEntity.id}" method="post">
    Текст вопроса:<br>
    <input type="text" name="questionText">

    <input type="submit" name="addTest" value="Добавить">
</form>
</body>
</html>