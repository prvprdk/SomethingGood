<#import "parts/common.ftlh" as c>
<@c.page>

    <div class="container text-center ">
        <img src="/static/fight.png" class="img-fluid mt-5" alt="Responsive image">
    </div>

    <div class="form-control-lg  " style="  margin-top: 100px;  text-align: center;">

        <#list messages as message>
           <div> <span class=""> ${message.text} </span> </div>

            <#else >
            No message
        </#list>

    </div>
</@c.page>