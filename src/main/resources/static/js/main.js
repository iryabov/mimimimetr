/**
 *  Hide/show logic and AJAX POST realization method
 */

function hideAll() {
	let contentBody = document
		.getElementsByClassName("content-body");

	for (i = 0; i < contentBody.length; ++i) {
		contentBody[i].style.display = 'none';
	}

	if (contentBody.length > 0) {
		contentBody[Math.floor(Math.random() * contentBody.length)].style.display = "flex";

	} else if (contentBody.length == 0) {
		document.getElementById("content-header").style.display = "none";
		document.getElementById("votes-done").style.display = "block";

	}

}

hideAll();

function sendRequest(winnerCatId, catCoupleId) {
	console.log(winnerCatId + " " + catCoupleId);

	const request = new XMLHttpRequest();
	const url = "/mimimimetr/save-vote";
	const params = "winnerCatId=" + winnerCatId + "&catCoupleId="
		+ catCoupleId;

	request.responseType = "json";
	request.open("POST", url, true);
	request.setRequestHeader("Content-type",
		"application/x-www-form-urlencoded");

	request.send(params);
	document.getElementById(catCoupleId).remove();
	hideAll();
}