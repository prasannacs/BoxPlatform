<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="utf-8" />
    <title>Box Content Preview Demo</title>
  	
    <!-- polyfill.io only loads the polyfills your browser needs -->
    <script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=Promise"></script>
    <!-- Alternatively, use polyfills hosted on the Box CDN
    <script src="https://cdn01.boxcdn.net/polyfills/bluebird/3.5.1/bluebird.min.js"></script>
    -->

    <!-- Latest version of Box Content Preview for en-US locale -->
    <script src="https://cdn01.boxcdn.net/platform/preview/1.46.0/en-US/preview.js"></script>
    <link rel="stylesheet" href="https://cdn01.boxcdn.net/platform/preview/1.46.0/en-US/preview.css" />
</head>
<body>
    <div class="preview-container" style="height:400px; width:100%;"></div>
    <script>
        var preview = new Box.Preview();
      	preview.show('${fileId}', '${accessToken}', {
            container: '.preview-container',
            showDownload: true,
            showAnnotations: true
        });
    </script>
</body>
</html>