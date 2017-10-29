var test = document.getElementById('TTT');

function whatClicked(evt) {
  var elID = evt.target.id;
  if(elID < 10 && elID > 0){
  	var url = document.URL + elID;
	window.location.href = url;
	console.log(url);
	}
}

if(test != null){
	test.addEventListener("click", whatClicked, false);
}