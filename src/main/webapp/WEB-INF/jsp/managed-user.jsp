<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="utf-8" />
    <title>Box Content Preview Demo</title>
    <link rel="stylesheet" href="https://cdn01.boxcdn.net/platform/elements/4.4.0/en-US/explorer.css" />
    
    <!-- Include Promise library if using Internet Explorer 11 -->
    <script src="https://cdn01.boxcdn.net/js/vendor/bluebird/bluebird-core-some-any-cancel-settle-2.9.34.js"></script>
    
    <!-- polyfill.io only loads the polyfills your browser needs -->
    <script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=es6,Intl"></script>
    <!-- Alternatively, use polyfill hosted on the Box CDN
    <script src="https://cdn01.boxcdn.net/polyfills/core-js/2.5.3/core.min.js"></script> 
    -->

    <!-- Latest version of Box Content Preview for en-US locale -->
    <script src="https://cdn01.boxcdn.net/platform/elements/4.4.0/en-US/explorer.js"></script>
    
</head>
<body>
	<h3>Welcome ${userName}</h3>
	<h5>Access Token ${accessToken}</h5>
	<a href="/logout">Logout</a>
    <div class="explorer-container" style="float:left; height:600px; width:90%;"></div>
    <script>
        var folderId = '0';
      	var accessToken = "${accessToken}";
        var fileExplorer = new Box.ContentExplorer();
        
        // Show the file picker
        fileExplorer.show(folderId, accessToken, {
            container: '.explorer-container',
            canSetShareAccess: false,
            canShare:false,
            canPreview: true,
            logoUrl: "http://1000logos.net/wp-content/uploads/2016/10/ACME-logo.png"
        });
        
        
    </script>
</body>
</html>