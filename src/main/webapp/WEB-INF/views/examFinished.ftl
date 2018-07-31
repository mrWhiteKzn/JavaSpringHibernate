<#import "parts/_page.ftl" as page/>

<@page.body>
    <div class="container">
        <div class="container">
            <div class="jumbotron">
                <h1 class="display-4">Экзамен завершен!</h1>
                <p class="lead">Поздравляем! Вы ответили правильно на ${grade}% вопросов.</p>
                <hr class="my-4">
                <p>Посмотреть детали можно <a href="/reports/byExam/${resultId}">здесь</a></p>
            </div>
        </div>
    </div>
</@page.body>
