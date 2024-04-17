var nominal= sessionStorage.getItem("inNominal");
var saldo=sessionStorage.getItem("saldo");
var sisasaldo=saldo-nominal

var formatter = new Intl.NumberFormat('in-ID', {
  style: 'currency',
  currency: 'IDR',

  // These options are needed to round to whole numbers if that's what you want.
  //minimumFractionDigits: 0, // (this suffices for whole numbers, but will print 2500.10 as $2,500.1)
  //maximumFractionDigits: 0, // (causes 2500.99 to be printed as $2,501)
});
var nominalFormatted=formatter.format(nominal)
var str2= "Apakah anda akan menarik saldo sebesar Rp. "+nominalFormatted;
$("#txtKonfirmasi").append(str2);

function kembali(){
	$.ajax({
	url:"http://localhost/walletWithdraw",
	type: "GET",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
		//window.location.href = "http://localhost/walletWithdraw"
		$("#content2").html(hasil);
		//$("#nominalModal").modal("hide");
	}
	});
}

$("#btnCancel").click(function(){
		kembali();
})

$("#btnConfirm").click(function(){
$.ajax({
	url:"http://localhost/konfirmasiPin",
	type: "GET",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
		//window.location.href = "http://localhost/konfirmasiPin"
		$("#withdrawModal").modal("show");
		$("#withdrawModalBody").html(hasil);
	}
	});

})