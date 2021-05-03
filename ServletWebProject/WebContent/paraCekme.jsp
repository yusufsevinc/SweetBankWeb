<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="tr">
    <head>
        <meta charset="utf-8">
        <title>Sweet Bank</title>
        <link rel="stylesheet" href="resources/css/para_cekme.css">
        <script>
        function kontrol(miktar) {
        	if (miktar > ${bakiye}) {
        		alert("Yetersiz Bakiye !");
        		return false;
			}else{
				alert(miktar + " TL çekildi. \n"+
				"Menüye yönlendiriliyorsunuz.");
				yonlendir();
				return true;
			}
		}
        </script>
        <script>
       function yonlendir(){ 
         window.location.href="mainMenu";
       }
       
  </script>
    </head>
    
   
    <body >
        <div id="sayfa">

        
        <h1 id="baslik" >Sayın ${isim} </h1>

        <p id="pMiktar">Tek seferde maksimum 5000 TL çekebilirsiniz !</p>
        
        <form name"formParaCekme" action="paraCekme" method="POST" onsubmit="return kontrol(inputParaCek.value);">
            <table id="table" >
                <tr>
                    <th>Toplam Bakiyeniz:</th>
                    <td>${bakiye }</td>
                </tr>

                <tr>
                    <th>Çekeceğiniz Miktar:</th>
                    <td><input id="inputParaCek" class="btn" type="number"
                         name="miktar"
                         required
                         id="textMiktar"
                         max="5000"
                         min="1">
                    </td>
                </tr>
     
                <tr>
                    <th></th>
                    <th colspan="2">
                        <button id="btn" type="submit"
                        class="btn"
                        disabled >
                            Para Çek
                        </button>
                               <script >
                               if(${bakiye} != 0){
                            	   document.getElementById("btn").disabled = false;
                               }

								</script>
                    </th>
                </tr>
            </table>
        </form>
    </div>
    </body>

</html>