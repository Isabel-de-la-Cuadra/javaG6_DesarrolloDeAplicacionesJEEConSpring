
<ul class="nav nav-tabs" style="background-color: rgba(0, 0, 255, 0.5);">
	<li class="nav-item"><a class="nav-link" style="color:Black;" href="/">Inicio
			para ${param.nombreUsuario}</a></li>
	<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
		data-bs-toggle="dropdown" style="color:Black;" href="usuario">Usuarios</a>
		<ul class="dropdown-menu">
			<li><a class="dropdown-item" style="color:Black;" href="/listaUsuariosDireccion">Listar
					Usuario - Dirección</a></li>
			<li><a class="dropdown-item" href="/listaDireccionesUsuarios">Listar
					Dirección - Usuario</a></li>
		</ul>
	</li>
	
	<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
		data-bs-toggle="dropdown" style="color:Black;" href="venta">PDF</a>
		<ul class="dropdown-menu">
			<li><a class="dropdown-item" style="color:Black;" href="/venta/export/pdf">Exportar Ventas a PDF
			</a></li>
			<li><a class="dropdown-item" style="color:Black;" href="">Por implementar</a></li>
		</ul>
	</li>
	
	<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
		data-bs-toggle="dropdown" style="color:Black;" href="venta">Venta</a>
		<ul class="dropdown-menu">
			<li><a class="dropdown-item" style="color:Black;" href="/venta">Ingresar Venta</a></li>
			<li><a class="dropdown-item" style="color:Black;" href="/venta/ver">Ver Venta por Id</a></li>
		</ul>
	</li>
	
	<li class="nav-item"><a class="nav-link" style="color:Black;" href="/direccion/usuario">Crear
			Dirección Usuario</a></li>
	<li class="nav-item"><a class="nav-link" style="color:Black;" href="/direccion/cliente">Crear
			Dirección cliente</a></li>		
	<li class="nav-item"><a class="nav-link" style="color:Black;" href="/cliente">Crear
			Cliente</a></li>
	<li class="nav-item"><a class="nav-link" style="color:Black;" href="/auto">Crear
			Auto</a></li>
	<li class="nav-item"><a class="nav-link" style="color:Black;" href="/compra">Compra</a></li>
	<li class="nav-item"><a class="nav-link" style="color:Black;" href="/producto">Producto</a></li>
	<li class="nav-item"><a class="nav-link" style="color:Black;" href="/" action="/logout">Salir</a></li>
	
	<!-- <li class="nav-item">
		<form method="POST" action="/logout">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input class="dropdown-item"
				type="submit" value="Logout" />
		</form>
	</li> -->

</ul>




<!-- 
style="background-image: linear-gradient(to right, rgba(230,100,50,0), rgba(230,100,50,1));"
<nav class="navbar navbar-expand-lg navbar-light"
	style="background-image: linear-gradient(to right, red, orange, yellow, green, blue, indigo, violet);">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">${param.title}</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/">Home para ${param.nombreUsuario}</a></li>
				<li class="nav-item"><a class="nav-link" href="cliente">Crear
						Cliente</a></li>
				<li class="nav-item"><a class="nav-link" href="/auto">Crear
						Auto</a></li>
				<li class="nav-item"><a class="nav-link" href="/listaUsuariosDireccion">Listar Usuario - Dirección
						</a></li>
				<li class="nav-item"><a class="nav-link" href="/listaDireccionesUsuarios">Listar Direcciones - Usuarios
						</a></li>
				<li class="nav-item">
					<form method="POST" action="/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <input class="dropdown-item"
							type="submit" value="Logout" />
					</form>
				</li>
			</ul>
		</div>
	</div>
</nav>
 -->