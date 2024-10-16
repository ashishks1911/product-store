function checkData()
{
	var uid = document.getElementById('uid');
	var pass= document.getElementById('pass');
	
	document.getElementById('uidtext').innerHTML="";
	document.getElementById('passtext').innerHTML="";
	
	if(uid.value=="" && pass.value=="")
	{
		document.getElementById('uidtext').innerHTML="User ID is Required";
		document.getElementById('passtext').innerHTML="password is required";
		return false;
	}
	
	if(uid.value=="")
	{
		document.getElementById('uidtext').innerHTML="User ID is Required";
		return false;
	}
	if(pass.value=="")
	{
		document.getElementById('passtext').innerHTML="password is required";
		return false;
	}
	return true;
}

function checkPassword()
{
	var pass = document.getElementById('password').value;
	var rpass = document.getElementById('rpassword').value;
	if(pass!=rpass)
	{
		document.getElementById('passcheck').innerHTML="Password Mismatch";
		return false;
	}
	return true;
}


function calculateCost(tb)
{
	var price = document.getElementById("price").innerHTML;
	total=price*tb.value;
	document.getElementById("total").innerHTML = total;
}

function checkOtp()
{
	var k = document.getElementById("otpn").innerHTML;
	var p = document.getElementById("otp").value;
	if(k!=p)
	{
		alert("OTP does not match.")
		return false;
	}
	return true;
}