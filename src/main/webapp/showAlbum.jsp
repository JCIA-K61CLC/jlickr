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
    <style>
        body {
            font-family: Verdana, sans-serif;
            margin: 0;
        }

        * {
            box-sizing: border-box;
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
            width: 25%;
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
    </style>
</head>

<body>

<%--<img src="displayStream?id=1&name=/images/B612_20180224_185420.jpg"  width="300px" height="auto">
<img src="displayStream?id=1&name=/images/white_cat.png" width ="200px" height="auto">
<img src ="displayStream?id=1&name=/images/guilty_crown-18-shu-depressed-memories_of_his_arm-glow.jpg">--%>

<%--<c:forEach items="${listImage}" var = "image">
    <img src="displayStream?id=${image.getIdUser()}&name=${image.getLink()}" width = "auto" height="200px">
</c:forEach>--%>

<div class="row">
    <c:forEach items="${listImage}" var="image">
        <div class="column" id = "test">
            <img src="display?id=${image.getIdUser()}&name=${image.getName()}"  id = "${image.getName()}" style="height:auto;width:300px" onclick="openModal();currentSlide(${image.getNumberOrder()})" class="hover-shadow cursor">
        </div>
    </c:forEach>
</div>
<div id="myModal" class="modal">
    <span class="close cursor" onclick="closeModal()">&times;</span>
    <div class="modal-content" >
        <c:forEach items="${listImage}" var="image" >
            <div class="mySlides">
                <img src="display?id=${image.getIdUser()}&name=${image.getName()}" style="width:auto;height:auto; max-height: 500px; max-width:500px; margin:auto;     transform: translate(-50%,-50%); ">
            </div>
        </c:forEach>

    </div>
    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
    <a class="next" onclick="plusSlides(1)">&#10095;</a>
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
