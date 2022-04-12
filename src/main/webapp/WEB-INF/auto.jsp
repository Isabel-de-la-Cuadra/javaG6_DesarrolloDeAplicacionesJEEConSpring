<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page='template/header.jsp'>
	<jsp:param name='title' value='Auto:' />
</jsp:include>

<body>

<jsp:include page='template/navbar2.jsp'>
<jsp:param name='title' value='Sistema Web G6' />
</jsp:include> 

	<br>
	<br>

	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
					<div class="card shadow-lg" style="background-color: #f6fa04">
						<div class="card-body p-5">
							<h1 class="fs-4 card-title fw-bold mb-4">Formulario de
								Registro de Auto</h1>

							<c:if test="${msgError !=null}">
								<div class="alert alert-danger" role="alert">
									<c:out value="${msgError}"></c:out>
								</div>
							</c:if>

							<c:if test="${msgOk !=null}">
								<div class="alert alert-success" role="alert">
									<c:out value="${msgOk}"></c:out>
								</div>
							</c:if>

							<form:form method="POST" action="/auto" modelAttribute="auto">

								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="marca">Marca: </form:label>
									<form:input type="text" class="form-control" path="marca"
										value="" placeholder="Ingresa la marca del auto" />
									<form:errors path="marca" class="text-danger" />
								</div>

								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="modelo">Modelo</form:label>
									<form:input type="text" class="form-control" path="modelo"
										value="" placeholder="Ingresa el modelo del auto" />
									<form:errors path="modelo" class="text-danger" />
								</div>

								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="color">Color</form:label>
									<form:input type="text" class="form-control" path="color"
										value="" placeholder="Ingresa el color del auto" />
									<form:errors path="color" class="text-danger"/>
								</div>

								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="velocidad">Velocidad</form:label>
									<form:input type="number" class="form-control" path="velocidad"
										placeholder="Ingresa la velocidad del Auto" />
									<form:errors path="velocidad" class="text-danger" />
								</div>

								<div class="align-items-center d-flex">
									<button type="submit" class="btn btn-warning ms-auto">
										Registrar</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<br>
	<br>

	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-6">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Marca</th>
						<th scope="col">Modelo</th>
						<th scope="col">Color</th>
						<th scope="col">Velocidad</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="auto" items="${listaAutos}">
						<tr>
							<th scope="row"><c:out value="${auto.id}"></c:out></th>
							<td><c:out value="${auto.marca}">
								</c:out></td>
							<td><c:out value="${auto.modelo}">
								</c:out></td>
							<td><c:out value="${auto.color}"></c:out></td>
							<td><c:out value="${auto.velocidad}"></c:out></td>
							<td><a class="btn btn-primary" href="/auto/editar/${auto.id}" role="button">Editar</a>
								<a class="btn btn-danger" href="/auto/eliminar/${auto.id}" role="button">Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
</div>
		<br> <br>

		<jsp:include page='template/footer.jsp'>
			<jsp:param name='title' value='Sistema Web G6' />
		</jsp:include>


		<!-- Bootstrap Bundle with Popper -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js "
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p "
			crossorigin="anonymous "></script>
</body>
</html>