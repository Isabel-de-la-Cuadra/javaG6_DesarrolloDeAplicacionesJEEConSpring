<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page='../template/header.jsp'>
	<jsp:param name='title' value='Lista Usuario Dirección:' />
</jsp:include>

<body>

	<jsp:include page='../template/navbar2.jsp'>
		<jsp:param name='title' value='Sistema Web' />
	</jsp:include>

	<br>
	<br>

	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<h1>Listado Usuarios - Dirección</h1>
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Nombre Usuario</th>
								<th scope="col">Apellido Usuario</th>
								<th scope="col">Correo Usuario</th>
								<th scope="col">Calle Usuario</th>
								<th scope="col">Número Usuario</th>
								<th scope="col">Ciudad Usuario</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="usuario" items="${listaUsuarios}">
								<tr>
									<th scope="row"><c:out value="${usuario.id}"></c:out></th>
									<td><c:out value="${usuario.nombre}"></c:out></td>
									<td><c:out value="${usuario.apellido}"></c:out></td>
									<td><c:out value="${usuario.correo}"></c:out></td>
									<td><c:out value="${usuario.direccion.calle}"></c:out></td>
									<td><c:out value="${usuario.direccion.numero}"></c:out></td>
									<td><c:out value="${usuario.direccion.ciudad}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>

	<br>
	<br>

	<jsp:include page='../template/footer.jsp'>
		<jsp:param name='title' value='Sistema Web G6' />
	</jsp:include>


	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js "
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p "
		crossorigin="anonymous "></script>
</body>
</html>