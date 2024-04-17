$("#pinKosong").hide()
$("#pinSalah").hide()
$("#pinKurang").hide()
var nominal= sessionStorage.getItem("inNominal");
var saldo=sessionStorage.getItem("saldo");
var sisasaldo=saldo-nominal
var custId=sessionStorage.getItem("custId")
var btnId=sessionStorage.getItem("btnId")
var emailTd=sessionStorage.getItem("emailTd")
var namaLengkap=sessionStorage.getItem("namaLengkap")
var iPin=0;
var otpW ='';
//alert(namaLengkap)

$("#btnConfirm3").click(function(){
	if($("#inPin").val()==0){
		$("#pinKurang").hide()
		$("#pinSalah").hide()
		$("#pinKosong").show()
	}else if(($("#inPin").val()).length<6){
		$("#pinSalah").hide()
		$("#pinKosong").hide()
		$("#pinKurang").show()
	}else{
	var pin1=$("#inPin").val();
	var pin2=pin1.toString();
	//var custId1=1;
	//var custId2=parseInt(custId1);
	var obj={};
	//obj.id=$("#inId").val();
	obj.customerId=custId//$("#custId").val();
	obj.pin=pin2;
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/wallet/cekPin",
	type: "POST",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		if(hasil==1){
			$("#pinKurang").hide()
			$("#pinSalah").hide()
			$("#pinKosong").hide()
			var digits = '0123456789';
			for (let i = 0; i < 6; i++ ) {
        		otpW += digits[Math.floor(Math.random() * 10)];
    			}
    	sessionStorage.setItem("otpW",otpW)
		//alert("Proses Penarikan Saldo Berhasil")
		//alert("OTP Anda: "+otpW)
		//alert("Pin Benar");
		tarikSaldo();
		saveTransaksi();
		expireOTP();
		getTokenWithdraw();
		otpWithdraw();
		//window.location.href = "http://localhost/profil"
		}else{
			$("#pinKurang").hide()
			$("#kosong").hide()
			$("#pinSalah").show()
			iPin+=1
			if (iPin>=3){
				$("#pinKurang").hide()
				$("#kosong").hide()
				alert("Akun Terkunci")
				kembali();
			}
			
		}
	}
})
}
})

$("#btnCancel3").click(function(){
	kembali()
})

function tarikSaldo(){
var obj={};
	obj.balance=sisasaldo;
	obj.customerId=custId;
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/wallet/editWallet",
	type: "PUT",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		//alert("Berhasil Ditarik");
		//$("#kosong").hide()
		//kembali();
	}
})
}

function kembali(){
	$.ajax({
	url:"http://localhost/walletWithdraw",
	type: "GET",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
		//window.location.href = "http://localhost/walletWithdraw"
		$("#withdrawModal").modal("hide");
		$("#content2").html(hasil);
		
	}
	});
}

function saveTransaksi(){
	var obj={};
	obj.customerId=custId;
	obj.walletDefaultNominalId=btnId;
	obj.ammount=nominal;
	obj.bankName="BNI";
	obj.accountNumber="123456";
	obj.accountName=namaLengkap;
	obj.otp=otpW;
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/withdraw/addWithdraw",
	type: "POST",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		
	}
	});
	
}

function otpWithdraw(){
	var url="http://localhost/otpWithdraw"
$.ajax({
	url:url,
	type: "GET",
	contentType:"application/json",
	success:function(hasil){
		$("#withdrawModal").modal("show");
		$("#withdrawModalBody").html(hasil);
		}
	})
}

function getTokenWithdraw(){
	var obj={};
	obj.email=emailTd;
	obj.userId=custId;
	obj.token=otpW;
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/token/addTokenWithdraw",
	type: "POST",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		//alert("Berhasil Ditarik");
		//$("#kosong").hide()
		//kembali();
	}
})
}

function expireOTP(){
	var obj={};
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/token/expireToken",
	type: "PUT",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		
	}
	})
}