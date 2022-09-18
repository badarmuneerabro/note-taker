<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Note Taker- Home</title>
</head>
<body>

	<br>
	<div class="container">
		<div class="card my-5">
			<img alt="notebook" src="images/notes.jpg"
				class="img-fluid mx-auto py-5 home-img">
			<h1 class="text-primary text-uppercase text-center mt-3">Start
				taking your notes</h1>
			<div class="container text-center my-3">
				<a
					href="<c:url value="/note">
				<c:param name="action" value="add" /></c:url>"><button
						class="btn btn-outline-primary text-center">Start here</button> </a>
			</div>
		</div>
	</div>

</body>
</html>