<#import "parts/_page.ftl" as page>

<@page.body>
    <h3>Добавить новый вопрос к тесту "${testEntity.name}".</h3>
<form name="question" action="/exam/addQuestion/${testEntity.id}" method="post">
    Текст вопроса:<br>
    <input type="text" name="questionText" >
    <input type="hidden" name="id" value="0">
    <br>

    Ответы:
    <table>
        <tr>
            <td><input type="text" name="answerText" placeholder="Ответ 1"></td>
            <td><input id="1" type="checkbox">Верный</td>
        </tr>
        <tr>
            <td><input type="text" name="answerText" placeholder="Ответ 2"></td>
            <td><input id="2" type="checkbox">Верный</td>
        </tr>
        <tr>
            <td><input type="text" name="answerText" placeholder="Ответ 3"></td>
            <td><input id="3" type="checkbox">Верный</td>
        </tr>
        <tr>
            <td><input type="text" name="answerText" placeholder="Ответ 4"></td>
            <td><input id="4" type="checkbox">Верный</td>
        </tr>
    </table>

    <input type="submit" name="addTest" value="Сохранить">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
</@page.body>