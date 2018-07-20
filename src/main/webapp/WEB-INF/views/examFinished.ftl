<#import "parts/_page.ftl" as page/>

<@page.body>
    <div class="container">
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <div class="alert alert-success" role="alert">
                    Результаты успешно сохранены!
                </div>
                <p class="lead">Посмотреть результаты теста можно <a
                        href="/reports/byExam/${lastExamination.id}">здесь</a></p>
            </div>
        </div>

    </div>
</@page.body>
