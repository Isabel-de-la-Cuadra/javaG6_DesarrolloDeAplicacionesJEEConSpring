<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page='../template/header.jsp'>
	<jsp:param name='title' value='Bienvenida:' />
</jsp:include>

<body>

	<jsp:include page='../template/navbar2.jsp'>
		<jsp:param name='title' value='Sistema Web G6 - 2' />
		<jsp:param name='nombreUsuario' value='${nombreUsuario}' />
	</jsp:include>

	<div class="container">

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

<br>
<br>
		<h1>¡Bienvenid@ al sistema web!</h1>
<br>	
<br>			
		<h3>${nombreUsuario}, elige en el Navbar lo que deseas hacer </h3>

	</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
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