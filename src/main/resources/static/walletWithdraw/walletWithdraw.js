customerWallet();
var saldo=0;
//var customID=1//$("#customID").val();
listNominal();
customNominal();

function listNominal(){
	$.ajax({
		url:"http://localhost/api/nominal/listNominal",
		type: "GET",
		contentType:"application/json",
		success:function(hasil){
			var str1="";
			var formatter = new Intl.NumberFormat('in-ID', {
  style: 'currency',
  currency: 'IDR',

  // These options are needed to round to whole numbers if that's what you want.
  //minimumFractionDigits: 0, // (this suffices for whole numbers, but will print 2500.10 as $2,500.1)
  //maximumFractionDigits: 0, // (causes 2500.99 to be printed as $2,501)
});
			for(i=0;i<hasil.length;i++){
				if(hasil[i].nominal<=saldo){
				str1+="<div>"
				str1+= "<button input type='submit' class='btn btn-primary btnNominal' value='"+hasil[i].nominal+"' id="+i+" href='/withdrawConfirm'>"+formatter.format(hasil[i].nominal)+"</button></div><br>";
			}
			}
			$("#listNominal").html(str1);
			$(".btnNominal").click(function(){
  				var inNominal=$(this).val();
  				var btnId=$(this).attr("id");
  				sessionStorage.setItem("btnId",btnId)
  				sessionStorage.setItem("inNominal",inNominal)
 			 	//alert(value);
 			 	withdrawConfirm();
  				});
		}
	})
	}
	
function customerWallet(){
var url="http://localhost/api/wallet/walletById/"+custId
$.ajax({
	url:url,
	type: "GET",
	contentType:"application/json",
	success:function(hasil){
		var formatter = new Intl.NumberFormat('in-ID', {
  style: 'currency',
  currency: 'IDR',

  // These options are needed to round to whole numbers if that's what you want.
  //minimumFractionDigits: 0, // (this suffices for whole numbers, but will print 2500.10 as $2,500.1)
  //maximumFractionDigits: 0, // (causes 2500.99 to be printed as $2,501)
});
		var saldoformat=formatter.format(hasil.balance)
		var str1= "Saldo Anda Saat Ini, "+saldoformat;
		$("#customerWallet").append(str1);
		saldo=hasil.balance
		//custId=hasil.customerId
		sessionStorage.setItem("saldo",saldo)
		//sessionStorage.setItem("custId",custId)
		}
	})
}

function withdrawConfirm(){
	$.ajax({
	url:"http://localhost/withdrawConfrim",
	type: "GET",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
	//window.location.href = "http://localhost/withdrawConfrim"
	$("#tableKanan").html(hasil);
	//$("#nominalModal").modal("show");
	//$("#nominalContain").html(hasil);
	}
	});
	}
	
function customNominal(){
	var url="http://localhost/api/custom/customById/"+custId
	$.ajax({
		url:url,
		type: "GET",
		contentType:"application/json",
		success:function(hasil){
			var strCustom="";
			var formatter = new Intl.NumberFormat('in-ID', {
  				style: 'currency',
  				currency: 'IDR',

  				// These options are needed to round to whole numbers if that's what you want.
 				//minimumFractionDigits: 0, // (this suffices for whole numbers, but will print 2500.10 as $2,500.1)
  				//maximumFractionDigits: 0, // (causes 2500.99 to be printed as $2,501)
			});
			for(i=0;i<hasil.length;i++){
				if(hasil[i].nominal<=saldo){
				strCustom+="<div>"
				strCustom+= "<button type='submit' class='btn btn-primary btnNominal' value='"+hasil[i].nominal+"' href='/withdrawConfirm' id='custom"+i+"'>"+formatter.format(hasil[i].nominal)+"</button></div><br>";
			}
			}
			strCustom+="<button type='submit' class='btn btn-primary' id='nominalLain' value='Nominal Lain' href='/addCustom'>Nominal Lain</button>"
			$("#customNominal").html(strCustom);
			$(".btnNominal").click(function(){
  				var inNominal=$(this).val();
  				sessionStorage.setItem("inNominal",inNominal)
 			 	//alert(value);
 			 	withdrawConfirm();
  				});
  			$("#nominalLain").click(function(){
				$.ajax({
					url:"http://localhost/addCustom",
					type: "GET",
					dataType: "html",
					contentType:"application/json",
					success:function(hasil){
					//window.location.href = "http://localhost/withdrawConfrim"
					//$("#tableKanan").html(hasil);
					$("#withdrawModal").modal("show");
					$("#withdrawModalBody").html(hasil);
				}
			})
			})
		}
		})
}
