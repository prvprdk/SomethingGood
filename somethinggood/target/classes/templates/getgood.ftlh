<#import "parts/common.ftlh" as c>

<@c.page  >

<div class="container text-center ">
<img src="/static/llovu.png" class="img-fluid mt-5" alt="Responsive image">
</div>

 <div class="form-control-lg" style=" margin-top: 50px;  text-align: center;">
  <span> ${goodMessage} </span> <br />
  <a href = "/main/${userId}"> ${username} </a>
     <div>
         <a class="btn btn-light btn-lg mx-2  " style=" background-color: #fff0f5 ;  margin-top: 50px; width: 250px; height: 50px;"  href ="/getgood"> получить хорошее </a>
     </div>
  </div>

</@c.page>