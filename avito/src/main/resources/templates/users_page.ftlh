<#include "base.ftlh">
<@html "users">
<div>
    <table>
        <tr>
            <th>id</th>
            <th>nick</th>
        </tr>
        <#list usersList as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.nick}</td>
            </tr>
        </#list>
    </table>
</div>
<form method="post" action="/banAll">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="BAN">
</form>
</@>