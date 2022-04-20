<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page='../template/header.jsp'>
<jsp:param name='title' value='Registro:' />
</jsp:include> 

<body>

<jsp:include page='../template/navbar.jsp'>
<jsp:param name='title' value='Sistema Web' />
</jsp:include> 


<br>
<br>

<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
					<div class="card shadow-lg" id="card">
						<div class="card-body p-5">
							<h1 class="fs-4 card-title mb-4">Formulario de Registro</h1>

							<c:if test="${msgError !=null}">
								<div class="alert alert-danger" role="alert">
									<c:out value="${msgError}"></c:out>
								</div>

							</c:if>

							<form:form  method="POST" action="/registro" modelAttribute="usuario">
							
							
							<!-- class="needs-validation" novalidate="" autocomplete="off" --> 
							<!-- pueden ir en la etiqueta de <form> para mejorar el formulario -->
						
								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="nombre">Nombre: </form:label> 
									<form:input type="text" class="form-control" path="nombre"
										value="" placeholder="Ingresa tu nombre" />
									<div class="invalid-feedback">El Nombre no es válido</div>
								</div>
	    			
								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="apellido">Apellido</form:label>
									<form:input type="text" class="form-control" path="apellido"
										value="" placeholder="Ingresa tu apellido" />
									<div class="invalid-feedback">El Apellido no es válido</div>
								</div>
					
								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="correo">Correo</form:label> 
									<form:input type="email" class="form-control" path="correo"
										value="" placeholder="Ingresa tu correo electrónico" />
									<div class="invalid-feedback">El Correo no es válido</div>
								</div>

								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="password">Password</form:label>
									<form:input type="password" class="form-control"
										path="password" placeholder="Ingresa tu password" />
									<div class="invalid-feedback">El Password es necesario</div>
								</div>

								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="passwordControl">Confirma tu Password</form:label>
									<form:input type="password" class="form-control"
										path="passwordControl" placeholder="Reingresa tu password" />
									<div class="invalid-feedback">El reingreso de Password es necesario</div>
								</div>

								<!-- <p class="form-text text-muted mb-3">
									By registering you agree with our terms and condition.
								</p>
								 -->
								<div class="align-items-center d-flex">
									<button type="submit" class="btn btn-primary ms-auto">
										Registrar</button>
								</div>
							</form:form>
						</div>
						<div class="card-footer py-3 border-0">
							<div class="text-center">
								¿Ya estás registrado? Anda directo a <a href="/"
									class="text-dark">Login</a>
							</div>
						</div>
					</div>
					<!-- <div class="text-center mt-5 text-muted">
						Copyright &copy; 2017-2021 &mdash; Your Company 
					</div>  -->
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js " integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p " crossorigin="anonymous "></script>

 
</body>
</html>