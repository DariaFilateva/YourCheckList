<#import "parts/common.ftl" as c>

<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}"
                   placeholder="Ключевое слово">
            <button type="submit" class="btn btn-primary ml-2">Поиск</button>
        </form>
    </div>
</div>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
   aria-controls="collapseExample">
    Создать свой чеклист
</a>

<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">


            <div class="form-group">
                <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                       value="<#if checklist??>${checklist.name}</#if>" name="name" placeholder="Название списка">
                <#if textError??>
                    <div class="invalid-feedback">
                    ${textError}
                    </div>
                </#if>
            </div class="form-group">


            <div class="form-group">
                <input type="text" class="form-control" name="e" placeholder="Элемент списка">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="comment" placeholder="Комментарий">
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Выберите файл</label>
                </div>
            </div>


            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary ml-2">Добавить</button>
            </div>
        </form>
    </div>
</div>

<div>Ознакомься с чеклистами:</div>
<div class="card-columns">
    <#list checklists as checklist>

        <div class="card my-3">
            <#if checklist.filename??>
                <img src="/img/${checklist.filename}" class="card-img-top">
            </#if>

            <div class="m-2">
                <b>${checklist.name}</b>


            <#--  <div>Список элементов</div>
  <#list checklist.elements as el>
      <b>${el.element}</b>
      <b>Комментарий</b>
      <b>${el.comment}</b>
  <#else>
  </#list>-->
            </div>
            <div class="card-footer text-muted">
                <strong>${checklist.authorName}</strong>
            </div>
        </div>

    <#else>
        Пока что чеклистов нет...
    </#list>
</div>
</body>
</html>
</@c.page>