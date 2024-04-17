isidata();

$(".btnDelete2").click(function(){
	var obj={};
	obj.id=$("#inId").val();
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/nominal/deleteNominal",
	type: "PUT",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		alert("Berhasil Dihapus");
		kembali();
	}
})
})
function isidata(){
	var id= sessionStorage.getItem("id");
	$.ajax({
	url:"http://localhost/api/nominal/nominalById/"+id,
	type: "GET",
	contentType:"application/json",
	success:function(hasil){
		var formatter = new Intl.NumberFormat('in-ID', {
  			style: 'currency',
  			currency: 'IDR',

  				// These options are needed to round to whole numbers if that's what you want.
 				//minimumFractionDigits: 0, // (this suffices for whole numbers, but will print 2500.10 as $2,500.1)
  				//maximumFractionDigits: 0, // (causes 2500.99 to be printed as $2,501)
			});
		$("#inId").val(hasil.id)
		$("#nilaiNominal").append(formatter.format(hasil.nominal))
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