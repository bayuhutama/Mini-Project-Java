$("#kosong").hide()


$(".btnAdd2").click(function(){
	if($("#inNominal").val()==0){
		$("#kosong").show()
	}else if(isNaN($("#inNominal").val())){
		alert("Input harus angka")
	}else{
	var obj={};
	//obj.id=$("#inId").val();
	obj.nominal=$("#inNominal").val();
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/nominal/addNominal",
	type: "POST",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		if(hasil==1){
		alert("Berhasil Ditambahkan");
		$("#kosong").hide()
		kembali();
		}else{
			alert("Data Sudah Ada")
		}
	}
})}
})

$(".btnCancel").click(function(){
	kembali()
})

function kembali(){
	$.ajax({
	url:"http://localhost/nominalwallet",
	type: "GET",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
		//$("#content").html(hasil);
		$("#nominalModal").modal("hide");
		window.location.href = "http://localhost/nominalwallet"
	}
	});
}

