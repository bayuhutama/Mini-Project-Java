listNominal();

$("#btnAddNominal").click(function(){
	$.ajax({
	url:"http://localhost/addNominal",
	type: "GET",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
	//window.location.href = "http://localhost/addNominal"
		//$("#content").html(hasil);
	$("#nominalModal").modal("show");
	$("#nominalContain").html(hasil);
	}
	});
})

function listNominal(){
	var url="";
	var t=$("#carinominal").val();
	if(t==""){
		url="http://localhost/api/nominal/listNominal"
	}else{
		url="http://localhost/api/nominal/searchNominal/"+t
	}
	 $.ajax({
	url:url,
	type: "GET",
	contentType:"application/json",
	success:function(hasil){
		var strCustom="";
		var formatter = new Intl.NumberFormat('in-ID', {
  			style: 'currency',
  			currency: 'IDR',

  				// These options are needed to round to whole numbers if that's what you want.
 				//minimumFractionDigits: 0, // (this suffices for whole numbers, but will print 2500.10 as $2,500.1)
  				//maximumFractionDigits: 0, // (causes 2500.99 to be printed as $2,501)
			});
	var str1= "<table class='table table-striped table-sm' id='nominalTable'>";
	str1+=  "<thead> <tr class='table-primary'><th>Nominal</th><th>#</th> </tr> </thead>";
	str1+= "<tbody>";
	for(i=0;i<hasil.length;i++){
	str1+= "<tr> <td>"+formatter.format(hasil[i].nominal) +"</td> ";
	str1+="<td><input class='btn btn-primary btnEdit' type='button' value='Edit' href='"+hasil[i].id+"'>";
	str1+="<input class='btn btn-danger btnDelete' type='button' value='Delete' href='"+hasil[i].id+"'> </td> </tr>";
	}
	str1+= "</tbody>";
	str1+= "</table>";
	$("#listNominal").html(str1);
	$(".btnEdit").click(function(){
		var id=$(this).attr("href");
		sessionStorage.setItem("id",id)
		editNominal();
	})
	$(".btnDelete").click(function(){
		var id=$(this).attr("href");
		sessionStorage.setItem("id",id)
		deleteNominal();
	})
	//$("#nominalTable").DataTable({
	//		searching:false, 
	//		"ordering": false,
	//		"lengthMenu":[[3,10,15],[3,10,15]]});
	}
	})
}

function editNominal(){
	$.ajax({
	url:"http://localhost/editNominal",
	type: "PUT",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
	//window.location.href = "http://localhost/editNominal"
		//$("#content").html(hasil);
	$("#nominalModal").modal("show");
	$("#nominalContain").html(hasil);
	}
	});
	

}
function deleteNominal(){
	$.ajax({
	url:"http://localhost/deleteNominal",
	type: "PUT",
	dataType: "html",
	contentType:"application/json",
	success:function(hasil){
	//window.location.href = "http://localhost/deleteNominal"
		//$("#content").html(hasil);
	$("#nominalModal").modal("show");
	$("#nominalContain").html(hasil);
	}
	});
	
	}
	
	
$("#carinominal").keyup(function carinominal(){
listNominal();
})