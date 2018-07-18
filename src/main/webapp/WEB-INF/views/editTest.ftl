<#import "parts/_page.ftl" as page />
<@page.body>

<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <p class="lead">Форма редактирования теста:</p>
        <hr class="my-4">
        <form name="testContainer" action="/exam/updateTest" method="post">
            Название теста:
            <div class="input-group">
                <input type="text" class="form-control" name="testEntity.name" value="${testContainer.testEntity.name}"
                       required="required"><br>

                <input type="submit" class="btn btn-success" name="updateTest" value="Сохранить">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="testEntity.id" value="${testContainer.testEntity.id}"><br>
            </div>
        </form>
    </div>
</div>
<p>Вопросы в тесте:</p>
    <ul class="list-group">
    <#list testContainer.questionEntityList as question>
        <li class="list-group-item">
            ${question_index+1}.  ${question.questionText}
            <p>
                <a href="/exam/editQuestion/${question.id}">изменить</a>
                <a href="/exam/deleteQuestion/${question.id}"
                   onclick="return confirm('Вы уверены, что хотите удалить вопрос?')"">удалить</a>
            </p>
        </li>
    </#list>
    </ul>

<form action="/exam/addQuestion/${testContainer.testEntity.id}" method="get">
    <input type="submit" class="btn btn-success" value="Добавить вопрос">
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