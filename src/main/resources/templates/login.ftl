<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div class="mb-1">Вход</div>
    <@l.login "/login" false/>
</@c.page>