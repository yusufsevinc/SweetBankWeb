<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="tr">
    <head>
        <meta charset="utf-8">
        <title>Sweet Bank</title>
        <link rel="stylesheet" href="resources/css/para_yatir.css">
            <script>
        function kontrol(miktar) {
        	
				alert(miktar + " TL yatırıldı. \n"+
				"Menüye yönlendiriliyorsunuz.");
				return true;
			
			
		}
        </script>
    </head>
    <body >
        <div id="sayfa"">

        
        <h1 id="baslik" >Sayın ${isim} </h1>

        <p id="pMiktar">Tek seferde maksimum 40000 TL Yatırabilirsiniz !</p>
        
        <form action="paraYatir" method="POST" onsubmit="kontrol(miktar.value);">
            <table id="table" >
                <tr>
                    <th>Toplam Bakiyeniz:</th>
                    <td>${bakiye }</td>
                </tr>

                <tr>
                    <th>Yatıracağanız Miktar:</th>
                    <td><input id="mmiktar"
                    class="btn" type="number"
                         name="miktar" 
                         id="textMiktar"
                         max="40000"
                         required
                         min="1">
                    </td>
                </tr>

                <tr>
                    <th></th>
                    <th colspan="2">
                        <button id="btn" type="submit"
                        class="btn">
                            Para Yatir
                        </button>
                    </th>
                </tr>
            </table>
        </form>
    </div>
    </body>

</html>