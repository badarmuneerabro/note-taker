<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Note taker- All notes</title>
</head>
<body>
	<section class="container">
		<h1>All notes</h1>
		<c:choose>
			<c:when test="${empty allNotes }">
				<h2>No available notes</h2>
			</c:when>
			<c:otherwise>
				<c:forEach items="${allNotes }" var="note">
					<div class="card mt-3">
						<img class="card-img-top mx-auto" src="images/note-image.png"
							alt="Card image cap">
						<div class="card-body px-5">
							<h5 class="card-title">${note.title }</h5>
							<p class="card-text">${note.content }</p>
							<p class="text-primary font-weight-bold">
							written on: <time datetime="${note.addedDate }" >${note.addedDate }</time>
							</p>
						</div>
						
						<div class="container text-center my-3" >
							<a href="note?action=delete&id=${note.id }" class="btn btn-danger">Delete</a>
							<a href="note?action=update&id=${note.id }" class="btn btn-primary">Update</a>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>