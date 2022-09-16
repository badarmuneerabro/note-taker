<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Note Taker- Add note</title>
</head>
<body>
	<form action="note" method="POST" class="container">
		<h1>Add Note</h1>
		<div class="form-group">
			<label for="title">Title</label> <input type="text"
				class="form-control" id="title" name="title"
				aria-describedby="emailHelp" placeholder="Enter title" required>
		</div>
		<div class="form-group">
			<label for="content">Description</label>
			<textarea id="content" placeholder="Enter note description"
				class="form-control" name="content" required>
				
			</textarea>
		</div>
		<div class="container text-center">
			<button type="submit" class="btn btn-primary">Add</button>
		</div>
	</form>
</body>
</html>