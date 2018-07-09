<#import "parts/_page.ftl" as page/>
<@page.body>
<h4>Список студентов:</h4>
<ul>
    <#list users as user>
        <#if user.login??>
           <li>
               <a href="/reports/byUser/${user.id}">${user.login}</a>
           </li>
        <#else>
           <li>Имя студента не найдено</li>
        </#if>
    </#list>
</ul>
</@page.body>