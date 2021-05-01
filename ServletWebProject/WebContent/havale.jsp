<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="tr">
    <head>
        <meta charset="utf-8">
        <title>Sweet Bank</title>,
        <link rel="stylesheet" href="resources/css/havale.css">
    </head>
    <body>
        
        <div id="sayfa">
            <h1 id="baslik">Sayın [Kullanıcı Adı Soyadı]</h1>
        <p id="pUyari">Tek seferde maksimum 20000 TL gönderebilirsiniz !</p>

            <form action="havale" method="get" onsubmit="return kontrol();">
                <table id="table">
                    <tr>
                        <th>Toplam Bakiyeniz :</th>
                        <td>[BAKİYE]</td>
                    </tr>

                    <tr>
                        <th>Göndereceğeniz Miktar :</th>
                        <td><input 
                            class="input"
                            type="number"
                            required
                            id="inputMiktar"
                            name="miktar"
                            max="20000"
                            min="1">
                        </td>
                    </tr>

                    <tr>
                        <th>Havale Alacak Kişi :</th>
                        <td><input 
                            class="input"
                            type="number"
                            required
                            id="inputMusteriNo"
                            name="musteriNo"
                            
                            placeholder="Müsteri No Giriniz">
                        </td>
                    </tr>

                    <tr>
                        <th></th>
                        <td>
                            <button id="btn">
                                Havale Yap
                            </button>
                        </td>
                    </tr>
                </table>
            
            
            </form>

        </div>


    </body>
</html>