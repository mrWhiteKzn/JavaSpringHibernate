<#import "spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>Добавить новый тест.</h3>
<form name="test" action="addNew" method="post">
    Наименование теста:<br>

    <input type="text" name="name">
    <input type="submit" name="addTest" value="Добавить">

    Вопрос:<br>

</form>
</body>
</html>