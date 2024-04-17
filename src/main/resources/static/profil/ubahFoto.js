$("#gbrKosong").hide()
var custId=sessionStorage.getItem("custId")
//var foto=$("#selFoto").val()
//alert(foto)

var file = document.getElementById('selFoto');

file.onchange = function() {
  var ext = this.value.match(/\.([^\.]+)$/)[1];
  switch (ext) {
    case 'jpg':
    case 'jpeg':
    case 'png':
      alert('Allowed');
      break;
    default:
      alert('Not allowed');
      this.value = '';
  }
};

$("#btnUbahFoto").click(function(){
	if($("#selFoto").val()==0){
		$("#gbrKosong").show()
	}else{
	var gbr = $('#selFoto').val().replace(/C:\\fakepath\\/i, '')
	var gbrNoExt=gbr.replace(gbr,"ProfilImgUser"+custId)
	gbrNoExt+=".jpg"
	//alert(gbrNoExt)
	//alert(gbr)
	//alert(custId)
	var obj={};
	obj.id=custId;
	obj.imagePath=gbrNoExt;
	var myJson=JSON.stringify(obj);
	$.ajax({
	url:"http://localhost/api/biodata/ubahGambar",
	type: "PUT",
	contentType:"application/json",
	data: myJson,
	success:function(hasil){
		$("#gbrKosong").hide()
		alert("Berhasil Diubah");
		//$("#lebih").hide()
		kembali();
	}
})
var form=$("#frmGbr")[0];
var dt= new FormData(form);
var obj={};
obj.id=custId;
var myJson=JSON.stringify(obj);
$.ajax({
	url:"http://localhost/api/file/upload",
	type: "POST",
	enctype:"multipart/form-data",
	data: dt,
	processData:false,
	contentType: false,
	cache:false,
	success:function(hasil){
		
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

$("#btnCancelFoto").click(function(){
	kembali()
})