<%-- 
    Document   : user-form
    Created on : 17 Aug, 2018, 7:53:47 PM
    Author     : vikash kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USER LOGIN</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker({  maxDate: "-18y" });
        });
        $(document).ready(function () {
            $('#txtPhone').blur(function (e) {
                if (validatePhone('txtPhone')) {
                    $('#spnPhoneStatus').html('Valid');
                    $('#spnPhoneStatus').css('color', 'red');
                }
            });
        });
            
        function Validation()
        {
            var flag = false;
            var sr = document.getElementById('mobile');
            if (!isNaN(sr.value) && sr.value !== '') {
                if (sr.value.length >= 10 && sr.value.length <= 12) {
                    alert('valid'); 
                    flag = true;
                }
                else {
                    alert('Mobile number should be 10 degits!');
                    sr.focus();
                }               
            }
            else {
                alert('Please input valid mobile number!');
                sr.focus();
            } 
            return flag;
        }
    </script>
    </head>
    <body style="background-color:lightskyblue; ">
        <form action="UserRegister" method="post">
                <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" required=""  title="Name shoud be Capital Alphabet"></td>
                </tr>
                 <tr>
                    <td>Date Of Birth:</td>
                    <td><input type="text" name="datepicker"id="datepicker" required=""></td>
                </tr>
                 <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" required="" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" title="follow E-mail pattern"></td>
                </tr>
                 <tr>
                    <td>Phone Number:</td>
                    <td><input type="number" name="mobile" id="mobile"  required="" title="Phone Number must be 10 Number"></td>
                </tr>
                 <tr>
                    
                     <td><input type="submit" name="submit" onclick="Validation();" value="submit"></td>
                </tr>
                </table>
            </form>
    </body>
</html>
