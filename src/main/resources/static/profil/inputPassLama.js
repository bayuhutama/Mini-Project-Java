$("#tidakSama").hide()
$("#passKosong").hide()
var custId=sessionStorage.getItem("custId")

$("#btnUbahPassword1").click(function(){
	if($("#inPass1").val()!=$("#inPass2").val()){
		$("#tidakSama").show()
		$("#passKosong").hide()
	}else if($("#inPass1").val()==0 || $("#inPass2").val()==0){
		$("#tidakSama").hide()
		$("#passKosong").show()
	}else{
	var obj={};
	obj.biodataId=custId;
	obj.password=$("#inPass1").val();
	var passtd=$("#inPass1").val();
	sessionStorage.setItem("passtd",passtd)
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/user/cekPassword",
	type: "POST",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		if(hasil=="1"){
			alert("Password Salah")
			$("#tidakSama").hide();
			$("#passKosong").hide()
		}else{
			$("#tidakSama").hide();
			$("#passKosong").hide()
			$("#dataProfilModal").modal("hide");
			inputPassBaru()

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

function inputPassBaru(){
	var url="http://localhost/inputPassBaru"
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

$("#showHide1").click(function myFunction() {
  var x = document.getElementById("inPass1");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
})
$("#showHide2").click(function myFunction() {
  var x = document.getElementById("inPass2");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
})
