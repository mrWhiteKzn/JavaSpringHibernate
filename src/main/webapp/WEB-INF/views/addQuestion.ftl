<#import "parts/_page.ftl" as page>

<@page.body>
    <h3>Добавить новый вопрос к тесту "${testEntity.name}".</h3>

<div id="checkboxTypeQuestion">
    <form name="question" action="/exam/addQuestion/${testEntity.id}" method="post">
        Текст вопроса:<br>
        <input type="hidden" name="id" value="0">
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text">Текст вопроса:</span>
            </div>
            <div>
                <textarea class="form-control" aria-label="Текст вопроса" name="questionText"></textarea>

            </div>
        </div>

        Ответы:
        <div class="input-group mb-3">
            <input type="text" class="form-control" name="answerText" placeholder="Ответ 1">
            <label><input id="1" type="checkbox">Верный</label>
        </div>

        <div class="input-group mb-3">
            <input type="text" class="form-control" name="answerText" placeholder="Ответ 2">
            <label><input id="2" type="checkbox">Верный</label>
        </div>

        <div class="input-group mb-3">
            <input type="text" class="form-control" name="answerText" placeholder="Ответ 3">
            <label><input id="3" type="checkbox">Верный</label>
        </div>

        <div class="input-group mb-3">
            <input type="text" class="form-control" name="answerText" placeholder="Ответ 4">
            <label><input id="4" type="checkbox">Верный</label>
        </div>


        <input type="submit" class="btn btn-info" name="addTest" value="Сохранить">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</div>



</@page.body>