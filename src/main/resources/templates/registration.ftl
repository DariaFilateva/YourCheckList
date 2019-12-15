<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
Зарегистрироваться
${message?if_exists}
    <@l.login "/registration" />
</@c.page>