var otpW=sessionStorage.getItem("otpW")
showOTP()

function showOTP(){
	$("#outOTP").append("OTP anda: "+otpW)
}

$("#closeOTP").click(function(){
	kembali()
})

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