<%-- 
    Document   : edit_customer
    Created on : Jul 6, 2017, 9:54:47 AM
    Author     : Nermin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

       <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
       
        <title>UREDI KUPCA Lapic store </title>
        
    </head>
    <body>
        <div class="container">
                
            <header class="header">

		<div id="logo">
			
                    <h1> LAPIC WEB STORE </h1>
		</div>

		<nav>
			<ul>
				<li><a href="/Spring_MVC_Web_Prodavnica/">HOME</a></li>
				<li><a href="/Spring_MVC_Web_Prodavnica/lista.htm">PROIZVODI</a></li>
				<li><a href="/Spring_MVC_Web_Prodavnica/lista_kupaca.htm">KUPCI</a></li>
				<li><a href="/Spring_MVC_Web_Prodavnica/new_buy.htm">PRODAJA</a></li>
 				

			</ul>	
		</nav>

            </header>
	
	<aside class="aside">

	</aside>

	<div class="main">
            
	<h3 id="naslov">Unesite izmjene za kupca:</h3>
        
        <form:form action="edit_customer.htm" method="post" commandName="customer">
  
            <div class="field">
                <form:label path="customerId">Id kupca</form:label>
                <form:input path="customerId" value="${customer.customerId}" readonly="true"/>
                <form:errors path="customerId" cssClass="error"></form:errors>
            </div>
            <div class="field">
                <form:label path="firstName">Ime:</form:label>
                <form:input path="firstName"/>
                <form:errors path="firstName" cssClass="error"></form:errors>
            </div>
            
             <div class="field">
                <form:label path="lastName">Prezime:</form:label>
                <form:input path="lastName"/>
                <form:errors path="lastName" cssClass="error"></form:errors>
            </div>
            
              <div class="field">
                <form:label path="email">E-mail:</form:label>
                <form:input path="email"/>
                <form:errors path="email" cssClass="error"></form:errors>
            </div>    
            
            <input id="OK" type="submit"  value="Izmjeni kupca"/>
        </form:form>
            
        </div>
        

	

	<footer class="footer">
		<div>
	
		</div>
		<div>
			<br>
			<br>
			<p> Copyright &copy Lapic</p>
	
	
		</div>
	</footer>
	
        </div>
  
        
</body>
    
</html>