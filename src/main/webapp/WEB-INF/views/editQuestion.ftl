<#import "spring.ftl" as spring />
<#import "parts/_page.ftl" as page />

<@page.body>
<h3>Форма редактирования вопроса:</h3>
    <#if saved?has_content>
        <div class="alert alert-success" role="alert">
            ${saved}
        </div>
    </#if>
<form name="question" action="/exam/updateQuestion/${questionContainer.questionEntity.id}" method="post">
    <input type="hidden" name="questionEntity.id" value="${questionContainer.questionEntity.id}"><br>
    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">Текст вопроса:</span>
        </div>
        <input type="text" class="form-control" aria-label="Текст вопроса:" name="questionEntity.questionText"
               value="${questionContainer.questionEntity.questionText}" required="required">
    </div>

    <input type="submit" class="btn btn-sm btn-info" value="Сохранить вопрос">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>

<form name="questionContainer" action="/exam/updateAnswers/" method="post">
    <input type="hidden" name="questionEntity.id" value="${questionContainer.questionEntity.id}">
    <input type="hidden" name="questionEntity.questionText" value="${questionContainer.questionEntity.questionText}">
    А теперь сохраним ответы: <br>
     <#list questionContainer.answerEntityList as answer>

         <@spring.bind path="questionContainer.answerEntityList[${answer_index}].id"/>
         <input type="hidden" name="${spring.status.expression}" value="${spring.status.value}">

     <div class="input-group mb-3">
         <@spring.bind path="questionContainer.answerEntityList[${answer_index}].answerText"/>
         <input type="text" class="form-control" name="${spring.status.expression}" value="${spring.status.value}"
                required="required">
         <div class="input-group-append">
             <div class="input-group-text">
                    <@spring.bind path="questionContainer.answerEntityList[${answer_index}].correct"/>
                 <input type="checkbox" name="${spring.status.expression}" id="correct${answer_index}"
                        value="${spring.status.value}" <#if spring.status.value=="true">checked</#if>
                        onclick="changeValue('correct${answer_index}')">
                 <label for="correct${answer_index}" class="form-check-label"
                        onclick="changeValue('correct${answer_index}');">Верный</label>

             </div>
         </div>
     </div>
     </#list>
    <input type="submit" class="btn btn-sm btn-info" value="Сохранить ответы">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
<script language="JavaScript">
    function changeValue(id) {
        document.getElementById(id).setAttribute("value", "true");
    }
</script>
<script src=”https://code.jquery.com/jquery-3.2.1.min.js”></script>
</@page.body>

