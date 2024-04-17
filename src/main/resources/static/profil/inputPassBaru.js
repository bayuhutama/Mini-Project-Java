$("#tidakSama").hide()
$("#passKosong").hide()
$("#passSama").hide()
$("#passTidakBenar").hide()
var custId=sessionStorage.getItem("custId")
var passtd=sessionStorage.getItem("passtd")

$("#btnUbahPassword2").click(function(){
	var regularExpression = /^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
	var str = $('#inPass3').val();
	if($("#inPass3").val()==0 || $("#inPass4").val()==0){
		$("#tidakSama").hide()
		$("#passSama").hide()
		$("#passTidakBenar").hide()
		$("#passKosong").show()
	}else if($("#inPass4").val()!=$("#inPass3").val()){
		$("#passKosong").hide()
		$("#passSama").hide()
		$("#passTidakBenar").hide()
		$("#tidakSama").show()
	}else if($("#inPass4").val()==passtd){
		$("#tidakSama").hide()
		$("#passKosong").hide()
		$("#passTidakBenar").hide()
		$("#passSama").show()
	}else if(!regularExpression.test(str)) {
		$("#tidakSama").hide()
		$("#passSama").hide()
		$("#passKosong").hide()
		$("#passTidakBenar").show()
	}else {
		var obj={};
	obj.biodataId=custId;
	obj.password=$("#inPass3").val();
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/user/gantiPass",
	type: "PUT",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		if(hasil=="1"){
			alert("Password Salah")
			$("#tidakSama").hide();
			$("#passKosong").hide()
		}else{
			$("#tidakSama").hide();
			$("#passKosong").hide();
			$("#dataProfilModal").modal("hide");
			kembali()
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

$("#btnCancelPass").click(function(){
	kembali()
})

$("#showHide1").click(function myFunction() {
  var x = document.getElementById("inPass3");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
})
$("#showHide2").click(function myFunction() {
  var x = document.getElementById("inPass4");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
})