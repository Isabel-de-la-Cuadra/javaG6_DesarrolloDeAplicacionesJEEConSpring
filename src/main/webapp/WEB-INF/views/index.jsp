<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page='../template/header.jsp'>
<jsp:param name='title' value='Index:' />
</jsp:include> 

<body>
<jsp:include page='../template/navbar.jsp'>
<jsp:param name='title' value='Sistema Web G6' />
</jsp:include> 

<h1>Mi primera web con SpringBoot</h1>


<jsp:include page='../template/footer.jsp'>
<jsp:param name='title' value='Sistema Web G6' />
</jsp:include> 

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>