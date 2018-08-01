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
                <textarea class="form-control" aria-label="Текст вопроса" name="questionText"
                          required="required"></textarea>
            </div>
        </div>

        Ответы:
        <div class="input-group mb-3">
            <input type="text" class="form-control" name="answerEntityList[0].answerText" placeholder="Ответ 1"
                   required="required">
            <div class="input-group-append">
                <div class="input-group-text">
                    <input type="checkbox" name="answerEntityList[0].correct" id="1">
                    <label class="form-check-label" for="1">Верный</label>
                </div>
            </div>
        </div>

        <div class="input-group mb-3">
            <input type="text" class="form-control" name="answerEntityList[1].answerText" placeholder="Ответ 2"
                   required="required">
            <div class="input-group-append">
                <div class="input-group-text">
                    <input type="checkbox" name="answerEntityList[1].correct" id="2">
                    <label class="form-check-label" for="2">Верный</label>
                </div>
            </div>
        </div>

        <div class="input-group mb-3">
            <input type="text" class="form-control" name="answerEntityList[2].answerText" placeholder="Ответ 3"
                   required="required">
            <div class="input-group-append">
                <div class="input-group-text">
                    <input type="checkbox" name="answerEntityList[2].correct" id="3">
                    <label class="form-check-label" for="3">Верный</label>
                </div>
            </div>
        </div>

        <div class="input-group mb-3">
            <input type="text" class="form-control" name="answerEntityList[3].answerText" placeholder="Ответ 4"
                   required="required">
            <div class="input-group-append">
                <div class="input-group-text">
                    <input type="checkbox" name="answerEntityList[3].correct" id="4">
                    <label class="form-check-label" for="4">Верный</label>
                </div>
            </div>
        </div>
        <input type="submit" class="btn btn-info" name="addTest" value="Сохранить" onclick="function f() {
                    document.getElementById('1').value = document.getElementById('1').checked;
                    document.getElementById('2').value = document.getElementById('2').checked;
                    document.getElementById('3').value = document.getElementById('3').checked;
                    document.getElementById('4').value = document.getElementById('4').checked;
                }">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</div>

<script>
    $(document).ready(function () {
        $("form").submit(function () {
            if ($('input:checkbox').filter(':checked').length < 1) {
                alert("Укажите хотя бы один верный ответ!");
                return false;
            }
        });
    });
</script>
</@page.body>