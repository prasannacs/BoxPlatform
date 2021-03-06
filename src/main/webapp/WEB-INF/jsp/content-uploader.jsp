<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="utf-8" />
    <title>Box Content Uploader Demo</title>

    <!-- polyfill.io only loads the polyfills your browser needs -->
    <script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=es6,Intl"></script>
    <!-- Alternatively, use polyfill hosted on the Box CDN
    <script src="https://cdn01.boxcdn.net/polyfills/core-js/2.5.3/core.min.js"></script> 
    -->

    <!-- Latest version of the uploader css for your locale -->
    <link rel="stylesheet" href="https://cdn01.boxcdn.net/platform/elements/4.4.0/en-US/uploader.css" />
</head>
<body>
    <div class="container" style="height:600px"></div>
    <!-- Latest version of the uploader js for your locale -->
    <script src="https://cdn01.boxcdn.net/platform/elements/4.4.0/en-US/uploader.js"></script>
    <script>
      	var folderId = '0';
      	var accessToken = '${accessToken}';
      	var uploader = new Box.ContentUploader();
      	uploader.show(folderId, accessToken, {
            container: '.container'
        });
    </script>
</body>
</html>