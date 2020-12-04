<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Carrito de la compra</h1>

<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Cantidad</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrito}" var="producto">
			<tr>
				<th>${producto.value.id}</th>
				<th>${producto.value.nombre}</th>
				<th><fmt:formatNumber type="currency" value="${producto.value.precioConDescuento}" /></th>
				<th>${producto.value.cantidad}</th>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
