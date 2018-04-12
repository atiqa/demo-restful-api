var i = 0;
while (i < 10) {
	text += "<br>The number is " + i;
	i++;
}
var p = document.createElement("p");
console.table(p);
p.innerHTML = new Date() + " Request: " + document.location + "/taxapi/history";
$("#result").append(p);
$.ajax({
	url : "/taxapi/history",
	success : function(result) {
		var result = JSON.parse(result);
		p = document.createElement("p");
		console.table(p);
		p.innerHTML = new Date() + " Response: " +  JSON.stringify(result);
		$("#result").append(p);

		var ndx = 1;
		for(var record of result) {
			$("#row" + ndx + " > #date-id").html(record.date);
			$("#row" + ndx + " > #gross-id").html(record.gross);
			$("#row" + ndx + " > #super-id").html(record.super);
			$("#row" + ndx + " > #tax-id").html(record.tax);
			$("#row" + ndx + " > #net-id").html(record.net);
			if(ndx++ == 10)
				break;
			/**************
					$("#gross-id").html(result.gross);
					$('#super-id').html(result.super);
					$("#tax-id").html(result.tax);
					$("#net-id").html(result.net);
					var p = document.createElement("p");
					console.table(p);
					p.innerHTML = JSON.stringify(result);
					$("#result").append(p);
			 *************/
		}
	}
});

function clearTable() {
	var i = 1;

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
		}
	});
});