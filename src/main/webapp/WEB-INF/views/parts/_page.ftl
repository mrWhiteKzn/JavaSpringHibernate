<#macro body>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/jquery.js"></script>
</head>
<body>
    <#include "_header.ftl">
    <#include "navbar.ftl"/>
<div class="container mt-4">
    <#nested>
</div>
</body>
</html>
</#macro>