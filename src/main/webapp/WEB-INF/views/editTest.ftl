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
<div class="card">
    <ul class="list-group list-group-flush">
    <#list testContainer.questionEntityList as question>
        <li class="list-group-item">
            <div>
                ${question_index+1}.  ${question.questionText}
            </div>
            <a href="/exam/editQuestion/${question.id}" class="btn btn-sm btn-light">редактировать</a>
            <a href="/exam/deleteQuestion/${question.id}" class="btn btn-sm btn-light"
               onclick="return confirm('Вы уверены, что хотите удалить вопрос?')"">удалить</a>
        </li>
    </#list>
    </ul>
</div>
        <a href="/exam/addQuestion/${testContainer.testEntity.id}" class="list-group-item list-group-item-info">Добавить
            вопрос</a>
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