<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
    <span><a href="/user">Список пользователей</a></span>>
</div>

<div>
    <form method="post">
        <input type="text" name="name" placeholder="Название списка">
        <input type="text" name="e" placeholder="Элемент списка">
        <input type="text" name="comment" placeholder="Комментарий">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Ознакомься с чеклистами:</div>
    <#list checklists as checklist>
    <div>

        <div>
            <b>${checklist.id}</b>
            <b>${checklist.name}</b>
            <strong>${checklist.authorName}</strong>
            <div>
            <#--  <div>Список элементов</div>
  <#list checklist.elements as el>
      <b>${el.element}</b>
      <b>Комментарий</b>
      <b>${el.comment}</b>
  <#else>
  </#list>-->
            </div>
        </div>
    </div>
    <#else>
    Пока что чеклистов нет...
    </#list>
</body>
</html>
</@c.page>