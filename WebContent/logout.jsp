<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session = "true" %>
<%@ page import="java.io.*,java.util.*" %>
<%  
//HttpSession session = request.getSession(true);
session.removeAttribute( "username" );
session.removeAttribute( "password" );    
%>
<script>
window.location = "/LocarWeb/";
</script>