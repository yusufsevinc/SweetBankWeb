<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Sweet Bank</title>
        <link rel="stylesheet" href="resources/css/basvuru.css">
  
<script>
    function karakterKontrol(event) {
         var asci = (event.which) ? event.which : event.keyCode
        if (asci > 31 && (asci < 48 || asci > 57))
            return false;
    
    }
</script>
    </head>
    <body>
        <div id="sayfa">
        <form action="basvuru" method="post" autocomplete="off">

      

            <table >
                
                <caption>LÜTFEN İSTENİLEN <strong>BİLGİLERİ</strong>  DOLDURUNUZ !</caption>
                
               
                <tr>
                    <th>Ad Soyad :</th>
                    <td>
                        <input type="text" name="inputAdSoyad" 
                        required
                        maxlength="228">
                    </td>
                </tr>

                <tr>
                    <th>TC Kimlik No :</th>
                    <td>
                        <input name="inputTcNo"
                        type ="text"
                        maxlength="11"
                        minlength="11"
                        onkeypress="return karakterKontrol(event)"
                        required/> 
                    </td>
                </tr>

                <tr>
                    <th>Telefon No :</th>
                    <td>
                        <input name="inputTelNo"
                        type ="text"
                        maxlength="11"
                        minlength="11"
                        onkeypress="return karakterKontrol(event)"
                        required
                        placeholder="exam:053"/> 
                    </td>
                </tr>

                <tr>
                    <th>Güvenlik Sorusu :</th>
                    <td>
                        <select name="inputGuvenlikSorusu">
                            <option value="evcilHaycan">İlk evcil hayvanınızın adı ?</option>
                            <option value="ogretmen" selected>İlk okul öğretmeninizin adı ?</option>
                            <option value="arkadas">En sevdiğin arkadaşının adı ?</option>
                        </select>
                       
                    </td>
                </tr>

                <tr>
                    <th>Güvenlik Sorusu Cevap :</th>
                    <td>
                        <input name="inputGuvenlikSorusuCevap"
                        type="text"
                        maxlength = "18"
                        required/> 
                    </td>
                </tr>
                <tr><th></th>
                    <td >
                        <button  type="submit"
                        >ÜYE OL
                        </button>
                    </td>
                </tr>


                

            </table>
            


        </form>
         

            
        </div>
    </div>
    </body>
</html>