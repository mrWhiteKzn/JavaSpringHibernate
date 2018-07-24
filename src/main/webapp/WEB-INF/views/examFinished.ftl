<#import "parts/_page.ftl" as page/>

<@page.body>
    <div class="container">
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <div class="alert alert-success" role="alert">
                    Поздравляем! Вы ответили правильно на ${grade}% вопросов.
                </div>
                <p class="lead">
                    Посмотреть детали можно <a href="/reports/byExam/${resultId}">здесь</a>
                </p>
            </div>
        </div>

    </div>
</@page.body>
