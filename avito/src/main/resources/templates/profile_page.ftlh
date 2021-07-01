<#include "base.ftlh">
<@html "Продукты">
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit">Добавить</button>
    </form>
</div>
<div>
    <#if user.filename??>
        <img src="/img/${user.filename}">
    </#if>
</div>
    <div>Имя пользователя :${user.nick}</div>
    <div>Emal :${user.email}</div>
</@>