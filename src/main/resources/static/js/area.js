class Shape{
	area(){
		return this.height * this.width;
	}
}

Shape.prototype.values = function(height , width) {
	this.height = height;
	this.width =  width;
};

// Shape.prototype.values = function(side) {
	// this.height = side;
	// this.width = side;
// };

function buttonClicked() {
	var rectangle = new Shape();
 	rectangle.values(document.getElementById('height').value, document.getElementById('width').value);
	document.getElementById("area").value = rectangle.area();
}

function doLogin() {
	fetch('/login').then(function (response) {
		response.json();
    })
}

