function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
    console.log("쿠키가 저장되었습니다.<br/> " + document.cookie);
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
        	console.log("쿠키를 불러왔습니다.");
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function saveScroll() {
	var scroll = (window.scrollTo) ? 1 : 0;
	console.log("scroll" + scroll);
	
	if (!scroll) return
	  var x = window.pageXOffset;
	  var y = window.pageYOffset;
	  setCookie("xyScroll", x + "_" + y);
	console.log("saveScroll");
	console.log("xyScroll: " + x + "_" + y);

}

function loadScroll() {
	if (!scroll) return
	  var xy = getCookie("xyScroll");
	  if (!xy) return
	  var ar = xy.split("_");
	  if (ar.length == 2) scrollTo(parseInt(ar[0]), parseInt(ar[1]));
	console.log("loadScroll");

}

function resetScroll(){
	
}

function saveScrollSubmit(){
	saveScroll();
	
}