$("#otpKadaluarsa").hide()
$("#otpSalah").hide()
$("#otpKosong").hide()
var emailBaru1=sessionStorage.getItem("emailBaru1")
var custId=sessionStorage.getItem("custId")
var otpEmail2='';

$("#btnConfirmOTP").click(function(){
	expireOTP()
	if($("#inInputOTP").val()==0){
		$("#otpKosong").show()
	}else{
	var obj={};
	obj.token=$("#inInputOTP").val();
	obj.email=emailBaru1
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/token/cekTokenEmail",
	type: "POST",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		if(hasil==1){
			$("#otpSalah").hide()
			$("#otpKosong").hide()
			$("#otpKadaluarsa").hide()
			gantiEmail()
			invalidOTP()
			kembali()
		}else if(hasil==2){
			$("#otpKadaluarsa").hide()
			$("#otpKosong").hide()
			$("#otpSalah").show()
		}else{
			$("#otpSalah").hide()
			$("#otpKosong").hide()
			$("#otpKadaluarsa").show()
		}
	}
})
}
})

function gantiEmail(){
	var obj={};
	obj.email=emailBaru1;
	obj.biodataId=custId;
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/user/gantiEmail",
	type: "PUT",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		alert("Berhasil diganti")
	}
})
}

function generateOTP(){
	var digits = '0123456789';
	for (let i = 0; i < 6; i++ ) {
		otpEmail2 += digits[Math.floor(Math.random() * 10)];
		}
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

function addTokenOTP(){
	generateOTP()
	var obj={};
	obj.email=emailBaru1;
	obj.token=otpEmail2
	obj.userId=custId;
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/token/addTokenEmail",
	type: "POST",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		
	}
})
}


function invalidOTP(){
	var obj={};
	obj.email=emailBaru1;
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/token/invalidateTokenEmail",
	type: "PUT",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		
	}
	})
}

function sendOTP(){
	var obj={};
	obj.email=emailBaru1;
	obj.token=otpEmail2
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/mail/sendEmailOTP",
	type: "POST",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		alert("OTP telah dikirim ke email anda")
	}
})
}

function kembali(){
	$.ajax({
	url:"http://localhost/dataProfil",
	type: "GET",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
		window.location.href = "http://localhost/profil"
		//$("#dataProfilModal").modal("hide");
		//$("#content").html(hasil);
		//$("#nominalModal").modal("hide");
	}
	});
}

$("#btnResendOTP").click(function(){
	expireOTP()
	var obj={};
	obj.email=emailBaru1;
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/token/cekIntervalToken",
	type: "POST",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		if(hasil==1){
			invalidOTP()
			addTokenOTP()
			sendOTP()
			alert("OTP sedang dikirim ")
		}else{
			alert("Harap tunggu 3 menit sebelum kirim ulang OTP")
		}
	}
})
})

$("#btnCancelOTP").click(function(){
	kembali()
})