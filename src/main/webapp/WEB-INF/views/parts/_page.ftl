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
<script src="/js/jquery.js"></script>
<script src="/js/popper.js"></script>
<script src="/js/popover.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="/js/bootstrap-confirmation.js"></script>
<script src="/js/confirmation.js"></script>
</body>
</html>
</#macro>