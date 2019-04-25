<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="css/UserInfo.css">
    <script>
        function display()
        {
            document.getElementById("displayarea").innerHTML = document.getElementById("fname").value;
            document.getElementById("fname").value = "";
            document.getElementById("displayarea1").innerHTML = document.getElementById("lname").value;
            document.getElementById("lname").value = "";

        }
    </script>
</head>
<header>
    <%@ include file="welcome.jsp"%>
</header>
<body>
<table width="400px" align="center" border=0>
    <tr style="background-color:Purple;">
        <td align="center"><b>First Name</b></td>
        <td align="center"><b>Last Name</b></td>
        <td align="center"><b>E-mail Address</b></td>
        <td align="center"><b>Role</b></td>
    </tr>
    <tr>
        <td align="center"><div id="displayarea"></div></td>
        <td align="center"><div id="displayarea1"></div></td>
        <td align="center"><div id="asd"></div></td>
        <td align="center"><div id="asdasd"></div></td>
    </tr>
</table>
</body>
</html>
