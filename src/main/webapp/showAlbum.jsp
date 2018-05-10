<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hoài Thu
  Date: 5/9/2018
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Reterving multiple images</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        *{margin: 0;padding: 0;}
        body {
            font-family: Verdana, sans-serif;
            margin: 0;
            background: #fff;
            color: #222;
            font-family: Arial, Tahoma, Verdana, sans-serif;
            font-size: 12px;
            height: 100%;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            /*text-align: center;*/
            overflow: hidden;
        }

        * {
            box-sizing: border-box;
        }
        *html body { padding:120px 0 50px 0; }
        #header {
            background: #1abc9c;
            border-bottom: 5px solid #1abc9c;
            color: #fff;
            height: 90px;
            line-height: 90px;
            /*text-align: center;*/
            /*position: absolute;*/
            padding: 0;
            top: 0;
            left: 0;
            width: 100%;
        }

        #header h1 {
            font-size: 200%;
            margin: 0;

            /*text-transform: uppercase;*/
        }
        #content {
            position: fixed;
            top: 120px;
            left: 0;
            bottom: 50px;
            margin: 0 auto;
            padding: 20px;
            text-align: left;
            overflow: auto;
        }
        * html #content {
            height:100%;
            width:100%;
        }
        .row > .column {
            padding: 8px 8px;
        }

        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        .column {
            float: left;
            /*width: 25%;*/
        }

        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            /*padding-top: 100px;*/
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: hidden;
            background-color: black;
        }
        .modal-content {
            top:50%;
            left: 50%;
            position: relative;
            background-color: black;
            /*margin: auto;
            padding: 0;*/
            /*width: 100%;
            height: 100%;*/
            /*max-width: 500px;
            max-height: 500px;*/

        }
        .close {
            color: white;
            position: absolute;
            top: 10px;
            right: 25px;
            font-size: 35px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: #999;
            text-decoration: none;
            cursor: pointer;
        }

        .mySlides {
            display: none;



        }

        .cursor {
            cursor: pointer
        }
        .prev,
        .next {
            cursor: pointer;
            position: absolute;
            top: 50%;
            width: auto;
            padding: 16px;
            margin-top: -50px;
            color: white;
            font-weight: bold;
            font-size: 20px;
            transition: 0.6s ease;
            border-radius: 0 3px 3px 0;
            user-select: none;
            -webkit-user-select: none;
        }

        .next {
            right: 0;
            border-radius: 3px 0 0 3px;
        }
        .prev:hover,
        .next:hover {
            background-color: rgba(0, 0, 0, 0.8);
        }
        .numbertext {
            color: #f2f2f2;
            font-size: 12px;
            padding: 8px 12px;
            position: absolute;
            top: 0;
        }

        img {
            margin-bottom: -4px;
        }

        .caption-container {
            text-align: center;
            background-color: black;
            padding: 2px 16px;
            color: white;
        }

        .demo {
            opacity: 0.6;
        }

        .active,
        .demo:hover {
            opacity: 1;
        }

        img.hover-shadow {
            transition: 0.3s
        }

        .hover-shadow:hover {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)
        }
        i{
            padding-left: 20px;
            padding-right: 10px;

        }
    </style>
</head>

<body>

<%--<img src="displayStream?id=1&name=/images/B612_20180224_185420.jpg"  width="300px" height="auto">
<img src="displayStream?id=1&name=/images/white_cat.png" width ="200px" height="auto">
<img src ="displayStream?id=1&name=/images/guilty_crown-18-shu-depressed-memories_of_his_arm-glow.jpg">--%>

<%--<c:forEach items="${listImage}" var = "image">
    <img src="displayStream?id=${image.getIdUser()}&name=${image.getLink()}" width = "auto" height="200px">
</c:forEach>--%>
<div id="header" >
    <h1>
        <i class="fa fa-bars" action="home.jsp"></i>
        <a style="text-decoration: none;padding-right: 490px;color: white;" href="home.jsp">Home</a>
       Album
    </h1>


</div>
<div id="content">
<div class="row">
    <c:forEach items="${listImage}" var="image">
        <div class="column" id = "test">
            <img src="display?id=${image.getIdUser()}&name=${image.getName()}"  id = "${image.getName()}" style="height:250px;width:auto" onclick="openModal();currentSlide(${image.getNumberOrder()})" class="hover-shadow cursor">
        </div>
    </c:forEach>
</div>
<div id="myModal" class="modal">
    <span class="close cursor" onclick="closeModal()">&times;</span>
    <div class="modal-content" >
        <c:forEach items="${listImage}" var="image" >
            <div class="mySlides">
                <img src="display?id=${image.getIdUser()}&name=${image.getName()}" style="width:auto;height:auto; max-height: 500px; max-width:500px; margin:auto;     transform: translate(-50%,-50%); ">
                <a href="deleteImage" onclick="confirm('Are you sure?')">Delete</a>
            </div>
        </c:forEach>

    </div>
    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
    <a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
</div>

<script>

    function openModal() {
        document.getElementById('myModal').style.display = "block";

    }

    function closeModal() {
        document.getElementById('myModal').style.display = "none";
    }

    var slideIndex = 1;
    showSlides(slideIndex);

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    function currentSlide(n) {
        showSlides(slideIndex = n);
    }
    function showSlides(n) {
        var i;
        var slides = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("demo");
        var captionText = document.getElementById("caption");
        if (n > slides.length) {slideIndex = 1}
        if (n < 1) {slideIndex = slides.length}
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex-1].style.display = "block";
        dots[slideIndex-1].className += " active";
        captionText.innerHTML = dots[slideIndex-1].alt;
    }
</script>
</body>

</html>
