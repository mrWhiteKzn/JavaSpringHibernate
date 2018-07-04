<#import "parts/_page.ftl" as page />
<#include "parts/navbar.ftl" />

<@page.body>
    <h3>Форма редактирования теста:</h3>
<form name="editedTestContainer1" action="/exam/updateTest" method="post">
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

    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>

<form action="/exam/addQuestion/${testContainer.testEntity.id}" method="get">
    <input type="submit" value="Добавить вопрос">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
<script language="JavaScript">
    function add() {
        var tr = document.createElement('tr');
        var td = document.createElement('td');

        td.innerHTML = "<input type='text' name='question'>";
        document.getElementById('questionTable').appendChild(tr);
        tr.appendChild(td);
    }
</script>
</@page.body>