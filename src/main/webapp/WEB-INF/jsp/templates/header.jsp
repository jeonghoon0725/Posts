<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function formatDate(dateString) {
            if (dateString == null || dateString === "") {
                return "";
            }

            let date = new Date(dateString); // 문자열을 Date 객체로 변환

            if (isNaN(date)) {
                return "";
            }

            let year = date.getFullYear();
            let month = String(date.getMonth() + 1).padStart(2, '0'); // 월은 0부터 시작하므로 +1
            let day = String(date.getDate()).padStart(2, '0');
            let hours = String(date.getHours()).padStart(2, '0');
            let minutes = String(date.getMinutes()).padStart(2, '0');
            let seconds = String(date.getSeconds()).padStart(2, '0');

            console.log(year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds) //2024-11-15 14:35:25
            console.log( `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`) //-- ::
            return year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
        }
    </script>
</head>