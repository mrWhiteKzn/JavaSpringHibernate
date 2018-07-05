<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getLogin()
    isAdmin = user.isAdmin()
    >
<#else>
    <#assign
    name = "Гость"
    isAdmin = false
    >
</#if>
