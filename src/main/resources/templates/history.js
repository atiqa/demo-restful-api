var result = null;
var startNdx = 0;
$("#prev").prop("disabled",true);
$("#next").prop("disabled",true);

var p = document.createElement("p");
console.table(p);
p.innerHTML = new Date() + " Request: " + document.location + "/taxapi/history";
$("#result").append(p);
$.ajax({
	url : "/taxapi/history",
	success : function(rsp) {
		result = JSON.parse(rsp);
		p = document.createElement("p");
		console.table(p);
		p.innerHTML = new Date() + " Response: " +  JSON.stringify(result);
		$("#result").append(p);	
		if(result.length > 0) {
			$("#next").prop("disabled",false);
		}
		populateTable();
	}
});

function populateTable() {
	var endNdx = startNdx + 10;
	for(var ndx = startNdx, i = 0; ndx < endNdx && ndx < result.length; ndx++, i++) {
		var record = result[ndx];
		$("#row" + i + " > #date-id").html(record.date);
		$("#row" + i + " > #gross-id").html(record.gross);
		$("#row" + i + " > #super-id").html(record.super);
		$("#row" + i + " > #tax-id").html(record.tax);
		$("#row" + i + " > #net-id").html(record.net);
	}	
}

function clearTable() {
	var ndx = 0;
	while(ndx < 10) {
		$("#row" + ndx + " > #date-id").html('&nbsp; ');
		$("#row" + ndx + " > #gross-id").html(' ');
		$("#row" + ndx + " > #super-id").html(' ');
		$("#row" + ndx + " > #tax-id").html(' ');
		$("#row" + ndx + " > #net-id").html(' ');
		ndx++;
	}

}

$("#deleteHistory").submit(function(e) {
	e.preventDefault();
	var p = document.createElement("p");
	console.table(p);
	p.innerHTML = new Date() + " Request: " + "/taxapi/deleteHistory";
	$("#result").append(p);
	$.ajax({
		url : "/taxapi/deleteHistory",
		method: "delete",
		success : function(result) {
			p = document.createElement("p");
			console.table(p);
			p.innerHTML = new Date() + " Response: " +  result;
			$("#result").append(p);
			clearTable();
		}
	});
});

$("#prev").click(function() {
	$("#next").prop("disabled",false)
	if(startNdx >= 10){
		startNdx -= 10;
		populateTable();
	}
	else {
		$("#prev").prop("disabled",true);
	}
});

$("#next").click(function() {
	console.log("startNdx=" + startNdx);
	$("#prev").prop("disabled",false);
	if(startNdx < result.length - 10){
		startNdx += 10;
		populateTable();
	}
	else {
		$("#next").prop("disabled",true);
	}
});

$("#clear").click(function() {
	$("#result").empty();
});