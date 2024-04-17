var custId=1;
sessionStorage.setItem("custId",custId)
isiMenu();

function isiMenu(){
	var url="http://localhost/dataProfil"
$.ajax({
	url:url,
	type: "GET",
	contentType:"application/json",
	success:function(hasil){
		$("#content").html(hasil)
		}
	})
}

$("#editFoto").click(function gantifoto(){
	$.ajax({
	url:"http://localhost/ubahFoto",
	type: "GET",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
		//window.location.href = "http://localhost/konfirmasiPin"
		$("#profilModal").modal("show");
		$("#profilModalBody").html(hasil);
	}
	});
})