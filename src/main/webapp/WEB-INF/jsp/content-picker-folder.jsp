<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="utf-8" />
    <title>Box Folder Selection</title>

    <!-- polyfill.io only loads the polyfills your browser needs -->
    <script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=es6,Intl"></script>

    <!-- Latest version of the picker css for your locale -->
    <link rel="stylesheet" href="https://cdn01.boxcdn.net/platform/elements/2.1.2/en-US/picker.css" />
</head>
<body>
    <div class="container" style="height:600px"></div>
    <!-- Latest version of the picker js for your locale -->
    <script src="https://cdn01.boxcdn.net/platform/elements/2.1.2/en-US/picker.js"></script>
    <script>
      	var folderId = '0';
      	var accessToken = '${accessToken}';
        var folderPicker = new Box.FolderPicker();
      	folderPicker.show(folderId, accessToken, {
            container: '.container'
        });
    </script>
</body>
</html>