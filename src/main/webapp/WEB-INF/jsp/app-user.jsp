<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="utf-8" />
<title>Box Content Preview Demo</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link rel="stylesheet"
	href="https://cdn01.boxcdn.net/platform/elements/4.4.0/en-US/explorer.css" />

<!-- Include Promise library if using Internet Explorer 11 -->
<script
	src="https://cdn01.boxcdn.net/js/vendor/bluebird/bluebird-core-some-any-cancel-settle-2.9.34.js"></script>

<!-- polyfill.io only loads the polyfills your browser needs -->
<script
	src="https://cdn.polyfill.io/v2/polyfill.min.js?features=es6,Intl"></script>
<!-- Alternatively, use polyfill hosted on the Box CDN
    <script src="https://cdn01.boxcdn.net/polyfills/core-js/2.5.3/core.min.js"></script> 
    -->

<!-- Latest version of Box Content Preview for en-US locale -->
<script
	src="https://cdn01.boxcdn.net/platform/elements/4.4.0/en-US/explorer.js"></script>

</head>
<body>

	<div class="container-fluid">
		<div class="row">

			<h1>Welcome ${userName}</h1>
			<h6>Access Token: ${accessToken}</h6>
			<h6>User Id: ${userId}</h6>
			<a href="/logout">Logout</a>

		</div>
		<div class="row">

			<div class="col-md-3" style="background-color: white;">
				<div id="result">
					<p>Events:</p>
				</div>

				<script>
					if (typeof (EventSource) !== "undefined") {
						var source = new EventSource("/events?userId=${userId}");
						source.onmessage = function(event) {
							document.getElementById("result").innerHTML += event.data
									+ "<br>";
						};
					} else {
						document.getElementById("result").innerHTML = "Sorry, your browser does not support server-sent events...";
					}
				</script>

			</div>

			<div class="col-md-9" style="background-color: white;">
				<div class="row">
					<div class="col-md-5" style="background-color: white; style="width: 480px; height: 240px;">
						<h4>Loan Id: A328XD23</h4>
						<img src="/css/loan-progress.jpg" alt="Italian Trulli" height="100%" width = "100%">

					</div>
										<div class="col-md-3" style="background-color: white;">

						<h4>My Advisor</h4>
						<img src="/css/advisor.png" alt="Italian Trulli"
							style="width: 480px; height: 240px;">
					</div>
					
				</div>
				<div class="row">
					<h4>This is your document vault with Liberty Loans</h4>
					<h5>Please upload your W2 and pay stubs</h5>

					<div class="explorer-container"
						style="float: left; height: 600px; width: 90%;"></div>
					<script>
						var folderId = '0';
						var accessToken = "${accessToken}";
						var fileExplorer = new Box.ContentExplorer();

						// Show the file picker
						fileExplorer
								.show(
										folderId,
										accessToken,
										{
											container : '.explorer-container',
											canSetShareAccess : false,
											canShare : false,
											canPreview : true,
											logoUrl : "http://1000logos.net/wp-content/uploads/2016/10/ACME-logo.png"
										});
					</script>
				</div>
			</div>
		</div>
	</div>

</body>
</html>