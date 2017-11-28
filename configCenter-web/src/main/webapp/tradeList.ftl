<#import "/spring.ftl" as spring/>
<table class="table" id="userList">
<thead>
<tr>
    <th>tradeNo</th>
    <th>goodsInfo</th>
</tr>
</thead>
<tbody>
<hr >

<@spring.bind "trade.tradeNo"/>
<#if spring.status.error>
<div class="error">
    <#list spring.status.errorMessages as error>
    ${error}<br/>
    </#list>
</div>
</#if>
<hr >
<#if tradeList??>
<#list tradeList as trade>
<#if trade_index % 2 == 0> <tr class="odd"> 
<#else> <tr class="even"> 
</#if>
    <td>${trade.tradeNo}</td>
    <td>${trade.goodsInfo}</td>
</tr>
</#list>
</#if>
</tbody>
</table>
aaa:${rc.requestUri}
<form method="post" action="<@spring.url '/tradeAdd'/>" name="trade2">
   tradeNO:<input type="text" name="tradeNo"/><br />
   goodsInfo:<input type="text" name ="goodsInfo" /><br />
   <input type="submit" name ="submit" />
</form>
<script type="text/javascript"></script>
