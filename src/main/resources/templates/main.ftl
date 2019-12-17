<#import "parts/common.ftl" as c>

<@c.page>
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="name" placeholder="Название списка">
        <input type="text" name="e" placeholder="Элемент списка">
        <input type="text" name="comment" placeholder="Комментарий">
        <input type="file" name="file">
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
                <#if checklist.filename??>
                    <img src="/img/${checklist.filename}">
                </#if>
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