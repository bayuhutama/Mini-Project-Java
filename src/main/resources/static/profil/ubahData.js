$("#inKosong").hide()
var custId=sessionStorage.getItem("custId")

$("#btnConfirmData").click(function(){
	var nomorHandphone='+62'+$("#inNomorHP").val()
	//alert(nomorHandphone)
	if($("#inFullname").val()==0 || $("#inNomorHP").val()==0 ||$("#inDOB").val()==0){
		$("#inKosong").show()
	}else{
	var obj={};
	obj.biodataId=custId;
	obj.fullname=$("#inFullname").val();
	obj.noHP=nomorHandphone;
	obj.dob=$("#inDOB").val();
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/profil/ubahDataProfil",
	type: "PUT",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		alert("Berhasil Diubah");
		$("#inKosong").hide()
		//$("#lebih").hide()
		kembali();
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

$("#btnCancelData").click(function(){
	kembali()
})