<%-- 
    Document   : edit_product
    Created on : Jul 3, 2017, 9:50:04 PM
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
       
        <title>UREDI PROIZVOD Lapic store </title>
        
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
            
	<h3 id="naslov">Unesite izmjene za proizvod:</h3>
        
        <form:form action="edit_product.htm" method="post" commandName="product">
            <div class="field">
                <form:label path="productId" >Id proizvoda:</form:label>
                <form:input path="productId" value="${product.productId}" readonly="true"/>
                <form:errors path="productId" cssClass="error"></form:errors>
            </div>
            
            <div class="field">
                <form:label path="productName" >Naziv proizvoda:</form:label>
                <form:input path="productName" value="${product.productName}" />
                <form:errors path="productName" cssClass="error"></form:errors>
            </div>
            
             <div class="field">
                <form:label path="productPrice">Cijena proizvoda:</form:label>
                <form:input path="productPrice"value="${product.productPrice}"/>
                <form:errors path="productPrice" cssClass="error"></form:errors>
            </div>
            
              <div class="field">
                <form:label path="productDescription">Opis proizvoda:</form:label>
                <form:textarea path="productDescription"/>
                <form:errors path="productDescription" cssClass="error"></form:errors>
            </div>     
             <div class="field">
                <form:label path="productQty">Zaliha:</form:label>
                <form:input path="productQty" value="${product.productQty}"/>
                <form:errors path="productQty" cssClass="error"></form:errors>
            </div>  
            
            <input id="OK"type="submit"  value="Izmjeni proizvod"/>
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