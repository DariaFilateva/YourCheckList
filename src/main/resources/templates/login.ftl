<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
Вход
    <@l.login "/login" false/>
<a href="/registration">Зарегистрироваться</a>
</@c.page>