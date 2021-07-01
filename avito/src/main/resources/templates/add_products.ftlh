<#include "base.ftlh">
<@html "Добавить продукт">
<form action="/add_products" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="hidden" name="Nick" value="${user.nick}"/>
    <input name="Name" type="text" placeholder="NAME_PRODUCT">
    <input name="filename" type="text" placeholder="Pickher">
    <input name="Price" type="number" placeholder="PRICE" step="0.1">
    <input type="submit" value="SELL">
</form>
</@>