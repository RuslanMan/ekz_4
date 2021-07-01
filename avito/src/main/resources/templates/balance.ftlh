<#include "base.ftlh">
<@html "Баланс">
<div>
    <form action="/balance" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="hidden" name="nick" value="${user.nick}"/>
        <input name="balance" type="number" placeholder="PRICE" step="0.1">
        <input type="submit" value="pay">
    </form>
</div>
</@>