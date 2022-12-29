<#import "parts/common.ftlh" as c>
<@c.page>


<div class="container ">
<img src="/static/her.png" class="img-fluid mt-5" alt="Responsive image">
</div>
    <div class="container" style="margin-top: 50px;    ">
       <form  method="post"  enctype= "multipart/form-data"  >
       <textarea
         class=" ${(textError??)?string('is.invalid','')}"
          style="background-color: #fff0f5;border-radius:10px;  width:300px; height:80px; " type="text" name="text">
           </textarea>
                    <#if textError??>
                        <div clas="invalid-feedback">
                           ${textError}
                        </div>
                     </#if>
            <input  type="hidden" name = "_csrf" value="${_csrf.token}"/>
            <div>
            <button class="btn btn-light btn-lg mx-2 " style="  background-color: #fff0f5; margin-top: 40px; width: 250px; height: 50px;"   type="submit">поделиться хорошим</button>
            </div>
       </form>
    </div>

</@c.page>