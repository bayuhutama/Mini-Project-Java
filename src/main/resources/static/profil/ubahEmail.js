$("#emailSama").hide()
$("#emailKosong").hide()
$("#emailSalah").hide()
var custId=sessionStorage.getItem("custId")
var otpEmail='';
var isiEmail=$("#inEmailBaru").val();
var emailHurufKecil=isiEmail.toLowerCase();
sessionStorage.setItem("emailBaru1",$("#inEmailBaru").val())


$("#btnConfirmEmail").click(function(){
	expireOTP()
	var val=ValidateEmail()
	if($("#inEmailBaru").val()==0){
		$("#emailSama").hide()
		$("#emailSalah").hide()
		$("#emailKosong").show()
	}else if(val==false){
		$("#emailSama").hide()
		$("#emailKosong").hide()
		$("#emailSalah").show()	
	}else if(val==true){
	var obj={};
	obj.email=emailHurufKecil;
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/user/cekEmail",
	type: "POST",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		if(hasil==1){
			invalidOTP()
			$("#emailSama").hide()
			$("#emailKosong").hide()
			$("#emailSalah").hide()
			generateOTP()
			addTokenOTP()
			sendOTP()
			sessionStorage.setItem("emailBaru1",$("#inEmailBaru").val())
			alert("Mohon tunggu OTP terkirim")
		}else{
			$("#emailKosong").hide()
			$("#emailSalah").hide()
			$("#emailSama").show()
		}
	}
})
}
})


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

$("#btnCancelEmail").click(function(){
	kembali()
})


function emailOTP(){
	var url="http://localhost/emailOTP"
$.ajax({
	url:url,
	type: "GET",
	contentType:"application/json",
	success:function(hasil){
		$("#dataProfilModal").modal("show");
		$("#dataProfilModalBody").html(hasil);
		}
	})
}

function ValidateEmail() {
 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($("#inEmailBaru").val()))
  {
    return (true)
  }else{
    return (false)
    }
}

function sendOTP(){
	var obj={};
	obj.email=$("#inEmailBaru").val();
	obj.token=otpEmail
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/mail/sendEmailOTP",
	type: "POST",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		alert("OTP telah dikirim ke email anda")
		$("#dataProfilModal").modal("hide");
		emailOTP()
	}
})
}

function generateOTP(){
	var digits = '0123456789';
	for (let i = 0; i < 6; i++ ) {
		otpEmail += digits[Math.floor(Math.random() * 10)];
		}
}

function addTokenOTP(){
	var obj={};
	obj.email=$("#inEmailBaru").val();
	obj.token=otpEmail
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

function invalidOTP(){
	var obj={};
	obj.email=$("#inEmailBaru").val();
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
