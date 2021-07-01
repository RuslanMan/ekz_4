<#include "base.ftlh">
<@html "Твои продукты">
<div>
    <#list products as product>
        <tr>
            <td>${product.name}</td>
            <td>${product.filename}</td>
            <td>${product.price}</td>
            <form action="/you_product" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <input type="hidden" name="name" value="${product.name}"/>
                <input type="submit" value="DELETE">
            </form>
        </tr>
    </#list>
</div>
</@>