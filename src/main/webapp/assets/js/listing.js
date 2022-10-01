$(document).ready(function() {
	var currentPath = $(location).attr('pathname');
	if (!currentPath.includes('home')) {
		console.log('Checking if this is active session!')
		isUserLoggedIn();
	}
});


function listHelper() {
	var url = "/property";
	var promise = httpGetAsync(url);
	var currentIndex = 1;
	promise.then(function(response) {
		var data = JSON.parse(response);
		$.each(data,
			function(idx, currentData) {
				var baseElement = document.getElementById("base--element");
				var cloneElement = baseElement.cloneNode(true);
				cloneElement.id = "child--element" + currentIndex;
				baseElement.parentNode.appendChild(cloneElement);
				var childElement = document.getElementById("child--element" + currentIndex);
				var image = childElement.getElementsByClassName("property--image")[0];
				var address = childElement.getElementsByClassName("property--address")[0];
				var area = childElement.getElementsByClassName("property--area")[0];
				var bed = childElement.getElementsByClassName("property--bed")[0];
				var price = childElement.getElementsByClassName("property--price")[0];
				var imageIndex = currentIndex % 10;
				image.src = "assets/img/property-" + imageIndex + ".jpg";
				address.innerHTML = currentData.propertyName;
				area.innerHTML = currentData.propertyArea + "ft <sup>2</sup>";
				price.innerHTML = currentData.propertyCategory + " | " + currentData.propertyType + " | INR " + formatNumber(currentData.propertyPrice);
				bed.innerHTML = currentData.propertyBed;

				childElement.setAttribute('style', 'display:block');
				currentIndex = currentIndex + 1;
			});

	});
}

listHelper();