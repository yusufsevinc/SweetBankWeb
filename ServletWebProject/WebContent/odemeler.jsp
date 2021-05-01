<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html style="font-size: 16px;">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="keywords" content="Sayın KULLANICI ADI">
<meta name="description" content="">
<meta name="page_type" content="np-template-header-footer-from-plugin">
<meta http-equiv="Pragma" content="no-cache">
<title>Sweet Bank</title>
<link rel="stylesheet" href="resources/css/odemeler2.css" media="screen">
<link rel="stylesheet" href="resources/css/odemeler1.css" media="screen">

<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">



<script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"url": "index.html"
}</script>

<script>
		function kontrol(faturaTutari) {
				if( ${bakiye} < faturaTutari){
					alert("Yetersiz bakiye !");
						return false;
				}else{
						alert("Faturanız ödendi.");
						return true;
			}
		}
</script>

<meta property="og:title" content="Home">
<meta property="og:type" content="website">
<meta name="theme-color" content="#478ac9">
<link rel="canonical" href="index.html">
<meta property="og:url" content="index.html">
</head>



<body data-home-page="Home.html" data-home-page-title="Home"
	class="u-body">


	<section class="u-clearfix u-section-1" id="sec-7a41">
		<div class="u-clearfix u-sheet u-sheet-1">
			<h2 class="u-text u-text-custom-color-5 u-text-1"
				data-animation-name="zoomIn" data-animation-duration="5000"
				data-animation-delay="1000" data-animation-direction="">Sayın
				${kullaniciAdi }</h2>
			<div
				class="u-clearfix u-expanded-width-lg u-expanded-width-md u-expanded-width-sm u-expanded-width-xs u-gutter-0 u-layout-wrap u-layout-wrap-1">
				<div class="u-layout">
					<div class="u-layout-col">
						<div class="u-size-30">
							<div class="u-layout-row">
								<div
									class="u-container-style u-layout-cell u-size-33 u-layout-cell-1">
									<div
										class="u-container-layout u-valign-middle u-container-layout-1">
										<h3 class="u-text u-text-2">Toplam elektirk faturası
											borcunuz : &nbsp;</h3>
									</div>
								</div>
								<div
									class="u-container-style u-layout-cell u-size-14 u-layout-cell-2">
									<div
										class="u-container-layout u-valign-middle u-container-layout-2">
										<h3
											class="u-align-center u-text u-text-custom-color-1 u-text-3">${elektrik}
											TL</h3>
									</div>
								</div>
								<div
									class="u-container-style u-layout-cell u-size-13 u-layout-cell-3">
									<div
										class="u-container-layout u-valign-middle u-container-layout-3">
										
										<form action="odemeler" method="post" onsubmit="return kontrol(${elektrik});">
											<button type="submit" name="elektrik" id="elektrikBtn"
												disabled value="${elektrik}"
												class="u-btn u-btn-round u-button-style u-custom-color-4 u-hover-palette-3-light-2 u-radius-17 u-btn-1
                      "
												data-animation-name="lightSpeedIn"
												data-animation-duration="5000" data-animation-delay="1000"
												data-animation-direction="">ÖDE</button>

											<script>
														if(${elektrik} != 0 ){
															document.getElementById("elektrikBtn").disabled = false;
														}
											</script>
										</form>



									</div>
								</div>
							</div>
						</div>
						<div class="u-size-30">
							<div class="u-layout-row">
								<div
									class="u-container-style u-layout-cell u-size-33 u-layout-cell-4">
									<div
										class="u-container-layout u-valign-middle u-container-layout-4">
										<h3 class="u-text u-text-4">Toplam su faturası borcunuz
											:&nbsp;</h3>
									</div>
								</div>
								<div
									class="u-container-style u-layout-cell u-size-14 u-layout-cell-5">
									<div
										class="u-container-layout u-valign-middle u-container-layout-5">
										<h3
											class="u-align-center u-text u-text-custom-color-1 u-text-5">${su}
											TL</h3>
									</div>
								</div>
								<div
									class="u-container-style u-layout-cell u-size-13 u-layout-cell-6">
									<div
										class="u-container-layout u-valign-middle u-container-layout-6">

										<form action="odemeler" method="post"
											onsubmit="return kontrol(${su});">


											<button type="submit" name="su" id="suBtn" disabled
												value="${su}"
												class="u-border-0 u-btn u-btn-round u-button-style u-custom-color-2 u-hover-palette-3-light-2 u-radius-17 u-btn-2"
												data-animation-name="lightSpeedIn"
												data-animation-duration="5000" data-animation-delay="1000"
												data-animation-direction="">ÖDE</button>

											<script>
														if(${su} != 0 ){
															document.getElementById("suBtn").disabled = false;
														}
											</script>


										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div
				class="u-clearfix u-expanded-width-lg u-expanded-width-md u-expanded-width-sm u-expanded-width-xs u-gutter-0 u-layout-wrap u-layout-wrap-2">
				<div class="u-layout">
					<div class="u-layout-col">
						<div class="u-size-30">
							<div class="u-layout-row">
								<div
									class="u-container-style u-layout-cell u-size-33 u-layout-cell-7">
									<div
										class="u-container-layout u-valign-middle u-container-layout-7">
										<h3 class="u-text u-text-6">Toplam doğalgaz faturası
											borcunuz :</h3>
									</div>
								</div>
								<div
									class="u-align-left u-container-style u-layout-cell u-size-14 u-layout-cell-8">
									<div class="u-container-layout u-container-layout-8">
										<h3
											class="u-align-center u-text u-text-custom-color-1 u-text-7">${dogalgaz}
											TL</h3>
									</div>
								</div>
								<div
									class="u-container-style u-layout-cell u-size-13 u-layout-cell-9">
									<div
										class="u-container-layout u-valign-middle u-container-layout-9">
										
										
										<form action="odemeler" method="post" onsubmit="return kontrol(${dogalgaz});">
											<button type="submit" disabled id="dogalgazBtn"
												name="dogalgaz" value="${dogalgaz}"
												class="u-btn u-btn-round u-button-style u-hover-palette-1-light-3 u-palette-5-light-1 u-radius-17 u-btn-3"
												data-animation-name="lightSpeedIn"
												data-animation-duration="5000" data-animation-delay="1000"
												data-animation-direction="">ÖDE</button>
											<script>
														if(${dogalgaz} != 0 ){
															document.getElementById("dogalgazBtn").disabled = false;
														}
											</script>

										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="u-size-30">
							<div class="u-layout-row">
								<div
									class="u-container-style u-layout-cell u-size-33 u-layout-cell-10">
									<div
										class="u-container-layout u-valign-middle u-container-layout-10">

										<h3 class="u-text u-text-8">Toplam internet faturası
											borcunuz : &nbsp;</h3>
									</div>
								</div>
								<div
									class="u-container-style u-layout-cell u-size-14 u-layout-cell-11">
									<div
										class="u-container-layout u-valign-middle u-container-layout-11">
										<h3
											class="u-align-center u-text u-text-custom-color-1 u-text-9">${internet}
											TL</h3>
									</div>
								</div>
								<div
									class="u-container-style u-layout-cell u-size-13 u-layout-cell-12">
									<div
										class="u-container-layout u-valign-top u-container-layout-12">


										<form action="odemeler" method="post" id="5" onsubmit="return kontrol(${internet});">


											<button id="internetBtn" type="submit"
												onclick="internetOdeme()" disabled name="internet"
												value="${internet}"
												class="u-btn u-btn-round u-button-style u-custom-color-3 u-hover-palette-3-light-2 u-radius-17 u-btn-4"
												data-animation-name="lightSpeedIn"
												data-animation-duration="5000" data-animation-delay="1000"
												data-animation-direction="">ÖDE</button>

											<script>
														if(${internet} != 0 ){
															document.getElementById("internetBtn").disabled = false;
														}
											</script>
											

										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<h6 class="u-text u-text-10">
				Sweet Bank<span style="font-size: 1.0625rem;"></span>
			</h6>
		</div>
	</section>



</body>
</html>