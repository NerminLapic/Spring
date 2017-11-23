<%-- 
    Document   : detalji
    Created on : Jun 30, 2017, 3:48:29 PM
    Author     : Nermin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

       <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
       
        <title>DETALJI O PROIZVODU </title>
        
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
            
	<h4 id="naslov">Više o proizvodu: ${productName}</h4>
        <div class="opis"> 
            ${proizvod}
        </div>
        

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
