isidata();
$("#kosong").hide()

$(".btnEdit2").click(function(){
	if($("#inNominal").val()==0){
		$("#kosong").show()
		}else if(isNaN($("#inNominal").val())){
		alert("Input harus angka")
		}else{
	var obj={};
	obj.id=$("#inId").val();
	obj.nominal=$("#inNominal").val();
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/nominal/editNominal",
	type: "PUT",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		if(hasil==1){
		alert("Berhasil Diedit");
		$("#kosong").hide()
		kembali();
		}else{
			alert("Data Sudah Ada")
		}
	}
})
}
})
function isidata(){
	var id= sessionStorage.getItem("id");
	$.ajax({
	url:"http://localhost/api/nominal/nominalById/"+id,
	type: "GET",
	contentType:"application/json",
	success:function(hasil){
		$("#inId").val(hasil.id)
		$("#inNominal").val(hasil.nominal)
	}
})
}

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
		window.location.href = "http://localhost/nominalwallet"
		//$("#content").html(hasil);
		$("#nominalModal").modal("hide");
	}
	});
}