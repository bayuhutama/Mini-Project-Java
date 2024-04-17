var custId=sessionStorage.getItem("custId")
isiBiodata();
isiDOB();
isiDataAkun();

function isiBiodata(){
var url="http://localhost/api/biodata/biodataById/"+custId
$.ajax({
	url:url,
	type: "GET",
	contentType:"application/json",
	success:function(hasil){
		$("#namaUser").append(hasil.fullname);
		sessionStorage.setItem("namaLengkap",hasil.fullname)
		$("#nomorHP").append(hasil.mobilePhone);
		var fotoprofil="<div class='col-auto'>"
		if(hasil.imagePath!=null){
		var gambar= hasil.imagePath
		}else{
		var gambar="Image/EmptyProfile.png"
		}
		fotoprofil+="</div>"
		$("#fotoProfil").attr("src",gambar);
		var tahun=hasil.createdOn.substring(0,4)
		$("#TahunDaftar").append("Since "+tahun+"")
		}
	})
}

function isiDOB(){
	var url="http://localhost/api/customer/dobById/"+custId
$.ajax({
	url:url,
	type: "GET",
	contentType:"application/json",
	success:function(hasil){
		role=hasil.roleId
		var tahun=hasil.substring(0,4)
		var bulan=hasil.substring(5,7);
		var tanggal=hasil.substring(8,10);
		if(bulan=="01"){
			bulan="Januari"
		}else if(bulan=="02"){
			bulan="Februari"
		}else if(bulan=="03"){
			bulan="Maret"
		}else if(bulan=="04"){
			bulan="April"
		}else if(bulan=="05"){
			bulan="Mei"
		}else if(bulan=="06"){
			bulan="Juni"
		}else if(bulan=="07"){
			bulan="Juli"
		}else if(bulan=="08"){
			bulan="Agustus"
		}else if(bulan=="09"){
			bulan="September"
		}else if(bulan=="10"){
			bulan="Oktober"
		}else if(bulan=="11"){
			bulan="November"
		}else if(bulan=="12"){
			bulan="Desember"
		}
		$("#tanggalLahir").append(""+tanggal+" "+bulan+" "+tahun+"");
		}
	})
}

function isiDataAkun(){
	var url="http://localhost/api/user/userById/"+custId
$.ajax({
	url:url,
	type: "GET",
	contentType:"application/json",
	success:function(hasil){
		$("#inEmail").append(hasil.email);
		sessionStorage.setItem("emailTd",hasil.email)
		//$("#inPass").append(hasil.password);
		//$("#spanPass").append(hasil.password);
		for(i=0;i<(hasil.password).length;i++){
			$("#spanPass").append("*");
		}
		}
	})
}

$("#withdraw").click(function(){
	var url="http://localhost/walletWithdraw"
$.ajax({
	url:url,
	type: "GET",
	contentType:"application/json",
	success:function(hasil){
		$("#content2").html(hasil)
		}
	})
})

function kembali(){
	$.ajax({
	url:"http://localhost/dataProfil",
	type: "GET",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
		//window.location.href = "http://localhost/walletWithdraw"
		$("#content").html(hasil);
		//$("#nominalModal").modal("hide");
	}
	});
}

$("#btnCancel").click(function(){
		kembali();
})

$("#btnUbahData").click(function(){
$.ajax({
	url:"http://localhost/ubahDataProfil",
	type: "GET",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
		//window.location.href = "http://localhost/konfirmasiPin"
		$("#dataProfilModal").modal("show");
		$("#dataProfilModalBody").html(hasil);
	}
	});

})

$("#btnUbahPass").click(function(){
$.ajax({
	url:"http://localhost/inputPassLama",
	type: "GET",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
		//window.location.href = "http://localhost/konfirmasiPin"
		$("#dataProfilModal").modal("show");
		$("#dataProfilModalBody").html(hasil);
	}
	});

})

$("#btnUbahEmail").click(function(){
$.ajax({
	url:"http://localhost/ubahEmail",
	type: "GET",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
		//window.location.href = "http://localhost/konfirmasiPin"
		$("#dataProfilModal").modal("show");
		$("#dataProfilModalBody").html(hasil);
	}
	});

})

