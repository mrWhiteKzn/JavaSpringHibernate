<#macro body>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <#include "navbar.ftl"/>
<div class="container mt-4">
<#nested>
</div>
</body>
</html>
</#macro>