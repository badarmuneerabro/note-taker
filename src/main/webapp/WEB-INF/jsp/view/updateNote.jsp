<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Note taker- Update note</title>
</head>
<body>
	<form action="update" method="POST" class="container">
		<h1>Update Note</h1>
		<div class="form-group">
		<input name="id" value="${note.id }" hidden>
			<label for="title">Title</label> <input type="text"
				class="form-control" id="title" name="title"
				aria-describedby="emailHelp" placeholder="Enter title" required value="${note.title }">
		</div>
		<div class="form-group">
			<label for="content">Description</label>
			<textarea id="content" class="form-control" name="content" required
				placeholder="Enter note description">${note.content }</textarea>
		</div>
		<div class="container text-center">
			<button type="submit" class="btn btn-success">Save note</button>
		</div>
	</form>
</body>
</html>