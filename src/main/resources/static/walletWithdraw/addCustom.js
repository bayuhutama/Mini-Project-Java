$("#nominalKosong").hide()
$("#nominalLebih").hide()
$("#nominalSudahAda").hide()
var custId=sessionStorage.getItem("custId")
var saldo2=parseInt(sessionStorage.getItem("saldo"),10);
//alert(saldo2)


$("#btnAdd2").click(function(){
	//alert(saldo)
	//alert($("#AddCustomNom").val())
	if($("#AddCustomNom").val()==0){
		$("#nominalLebih").hide()
		$("#nominalSudahAda").hide()
		$("#nominalKosong").show()
	}else if(saldo2<$("#AddCustomNom").val()){
		$("#nominalKosong").hide()
		$("#nominalSudahAda").hide()
		$("#nominalLebih").show()
	}else{
	var obj={};
	obj.customerId=custId;
	obj.nominal=$("#AddCustomNom").val();
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/custom/addCustom",
	type: "POST",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		if(hasil==1){
		alert("Berhasil Ditambahkan");
		$("#kosong").hide()
		$("#lebih").hide()
		kembali();
		}else{
			$("#nominalKosong").hide()
			$("#nominalLebih").hide()
			$("#nominalSudahAda").show()
		}
	}
})
}
})

$("#btnCancel1").click(function(){
		kembali();
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