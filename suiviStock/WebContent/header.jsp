<%@page import="sn.isi.entities.Produit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;

List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
 
List<Produit> lproduits = (List<Produit>)request.getAttribute("list_produits");
for(Produit p:lproduits) {
	map = new HashMap<Object,Object>(); 
	map.put("label", p.getNom()); 
	map.put("y", p.getQtStock()); 
	list.add(map); 
}
String dataPoints = gsonObj.toJson(list);
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="./public/template/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="./public/template/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Suivi-Stock</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <!-- CSS Files -->
    <link href="./public/template/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./public/template/assets/css/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="./public/template/assets/css/demo.css" rel="stylesheet" />
	<script type="text/javascript">
		window.onload = function () {
		
		var chart = new CanvasJS.Chart("chartContainer", {
			theme: "light1", // "light2", "dark1", "dark2"
			animationEnabled: false, // change to true		
			title:{
				text: "Evolution du niveau de stock en fonction des produits"
			},
			data: [
			{
				// Change type to "bar", "area", "spline", "pie",etc.
				type: "column",
				dataPoints: [
					<%
					 List<Produit> produits = (List<Produit>)request.getAttribute("list_produits");
					 for(Produit p:produits) {
						 out.print("{ label: '"+p.getNom()+"',  y: "+p.getQtStock()+"  },");
					 }
					%>
					
					
				]
			}
			]
		});
		chart.render();
		
		
		//=============
		var chart1 = new CanvasJS.Chart("chartContainer1", {
			animationEnabled: true,
			title: {
				text: "Deposit Money Banks' Assets to GDP (percent), 2015"
			},
			axisY: {
				suffix: "%",
				includeZero: true
			},
			axisX: {
				title: "Countries"
			},
			data: [{
				type: "column",
				yValueFormatString: "#,##0\"%\"",
				dataPoints: <%out.print(dataPoints);%>
			}]
		});
		chart1.render();
		 
	}
	</script>
</head>

<body>
    <div class="wrapper">
        <div class="sidebar" data-image="./public/template/assets/img/sidebar-5.jpg">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

        Tip 2: you can also add an image using data-image tag
    -->
            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="http://localhost:8080/suiviStock/Accueil" class="simple-text">
                        Cours JAVA/JEE - DITI4
                    </a>
                </div>
                <ul class="nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="Accueil">
                            <i class="nc-icon nc-chart-pie-35"></i>
                            <p>tableau de bord</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="User?page=profil">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>Profil utilisateur</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="User?page=list">
                            <i class="nc-icon nc-notes"></i>
                            <p>Administration</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="Categorie">
                            <i class="nc-icon nc-notes"></i>
                            <p>Gestion - categories</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="Produit">
                            <i class="nc-icon nc-notes"></i>
                            <p>Gestion des produits</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                <div class="container-fluid">
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                        
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="User?page=profil">
                                    <span class="no-icon">Compte</span>
                                </a>
                            </li>
                          
                            <li class="nav-item">
                                <a class="nav-link" href="Logout">
                                    <span class="no-icon">Log out</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>