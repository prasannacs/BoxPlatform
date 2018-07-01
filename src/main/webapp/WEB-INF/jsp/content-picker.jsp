<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="utf-8" />
    <title>Box File Selection</title>

    <!-- polyfill.io only loads the polyfills your browser needs -->
    <script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=es6,Intl"></script>
    <!-- Alternatively, use polyfill hosted on the Box CDN
    <script src="https://cdn01.boxcdn.net/polyfills/core-js/2.5.3/core.min.js"></script> 
    -->

    <!-- Latest version of the picker css for your locale -->
    <link rel="stylesheet" href="https://cdn01.boxcdn.net/platform/elements/4.4.0/en-US/picker.css" />
</head>
<body>
    <div class="container" style="height:600px"></div>
    <!-- Latest version of the picker js for your locale -->
    <script src="https://cdn01.boxcdn.net/platform/elements/4.4.0/en-US/picker.js"></script>
    <script>
      	var folderId = '0';
      	var accessToken = '${accessToken}';
      	var filePicker = new Box.FilePicker();
      	filePicker.show(folderId, accessToken, {
            container: '.container'
        });
      	
     // Attach event listener for when the choose button is pressed
      	filePicker.addListener('choose', function(items) {
      	  // do something with the items array
      	  alert("choose"+JSON.stringify(items, null, 2));
      	  console.log(JSON.stringify(items, null, 2));
      	});

      	// Attach event listener for when the cancel button is pressed
      	filePicker.addListener('cancel', function() {
      	  // do something
      	  alert("cancel");
      	});
    </script>
</body>
</html>