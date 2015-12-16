<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session = "true" %>
<%@ page import="java.io.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<title>LocarWeb</title>
<script src="/LocarWeb/includes/angular.min.js"></script>
<script src="/LocarWeb/includes/jquery.min.js"></script>
<script src="/LocarWeb/includes/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/LocarWeb/includes/bootstrap-3.3.6-dist/css/bootstrap.min.css">
</head>
<body>
<%

if (session.getAttribute("username")!= null){
	out.print("Usuario Logado: " +session.getAttribute("username"));
	out.print("<br>");
	out.print ("<a href='/LocarWeb/logout.jsp'>Logout</a>");
}
else
{

}
%>

<%
if (session.getAttribute("username")== null){ %>
<a href="#" data-toggle="modal" data-target="#myModal">Login</a>
<a href="/LocarWeb/cadastro.html">Cadastro de Usuario</a>

<% } %>
   </head>
   <body>
      <div class="section">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <h1 class="text-primary">Locar Imóveis</h1>
               </div>
            </div>
         </div>
      </div>
      <div class="section">
         <div class="container">
            <div class="row">
               <div class="col-md-4">
                  <img src="/LocarWeb/imagens/anuncios.png" class="img-responsive"> 
                  <h2 align=center>Cliente</h2>
                  <p>Efetuar Cadastro.</p>
               </div>
               <div class="col-md-4">
                  <a href="buscar-imoveis.html"><img src="/LocarWeb/imagens/cliente.png" alt="Buscar Imoveis" title="Buscar Imoveis" class="img-responsive"></a> 
                  <h2 align=center>Anuncios</h2>
                  <p>Gerencie seus anunncios.</p>
               </div>
               <div class="col-md-4">
                  <img src="/LocarWeb/imagens/relatorio.png" class="img-responsive"> 
                  <h2 align=center>Relatórios</h2>
                  <p>Gerencie Relatórios.</p>
               </div>
            </div>
         </div>
      </div>
               <!-- Login Modal -->
         <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">
               <!-- Modal content-->
               <div class="modal-content">
                  <div class="modal-header">
                     <button type="button" class="close" data-dismiss="modal">&times;</button>
                     <h4 class="modal-title">Formulário de Login</h4>
                  </div>
                  <div class="modal-body">
                     <p>
                     <form class="form-horizontal" action="/LocarWeb/Login" method="POST">
                        <fieldset>
                           <div class="form-group">
                              <label class="col-md-4 control-label" for="username">Usuário</label>  
                              <div class="col-md-4">
                                 <input id="username" name="username" type="text" placeholder="UserName" class="form-control input-md" required="">
                              </div>
                           </div>
                           <div class="form-group">
                              <label class="col-md-4 control-label" for="password">Senha:</label>
                              <div class="col-md-4">
                                 <input id="password" name="password" type="password" placeholder="Password" class="form-control input-md" required="">
                              </div>
                           </div>
                           <!-- Button -->
               -            <div class="form-group">
                              <label class="col-md-4 control-label" for="singlebutton"></label>
                              <div class="col-md-4">
                                 <button id="singlebutton" name="singlebutton" class="btn btn-primary">Efetuar Login</button>
                              </div>
                           </div>
                        </fieldset>
                     </form>
                  </div>
                  <div class="modal-footer">
                     <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  </div>
               </div>
            </div>
         </div> <!-- Login Modal -->
      
      
      
      
      
      
      
      
   </body>
</html>
