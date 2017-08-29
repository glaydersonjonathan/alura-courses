<%@page import="br.com.caelum.produtos.modelo.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function removeProduto(id){
			$("#mensagem").load('<c:url value="/produto/remove"/>' + '?produto.id=' + id);
			$("#produto" + id).remove();
		}
	</script>

	<h1>Produtos</h1>
	<c:out value="language code 1: ${pageContext.response.locale}"></c:out>
	<c:out value="language code 2: ${pageContext.request.locale.language}"></c:out>
	<c:out value="language code 3: ${header['accept-language']}"></c:out>
	<h2>
		<fmt:message key="mensagem.bemvindo" />
	</h2>
	<div id="mensagem"></div>
	<table width="100%">
		<tr>
			<td>Ordem</td>
			<td width="20%">Nome</td>
			<td>Preco</td>
			<td>Descricao</td>
			<td>Data de Inicio da Venda</td>
			<td>Usado?</td>
			<td width="20%">Remover?</td>
		</tr>
		<c:set var="originalLocale" value="${pageContext.request.locale.language}" />
		<c:forEach var="p" items="${produtoList}" varStatus="st">
			<tr id="produto ${p.id}">
				<td>${st.count}</td>
				<td>${p.nome.toUpperCase()}</td>
				<fmt:setLocale value="pt-BR"/>
				<td><fmt:formatNumber value="${p.preco}" minFractionDigits="2" type="currency" /></td>
				<td>${p.descricao}</td>
				<td><fmt:formatDate pattern="EEEE, dd 'de' MMMM 'de' yyyy"
						value="${p.dataInicioVenda.time}" /></td>
				<c:choose>
					<c:when test="${p.usado}">
						<td>Sim</td>
					</c:when>
					<c:otherwise>
						<td>Não</td>
					</c:otherwise>
				</c:choose>
				<td><a href="#" onclick="return removeProduto(${p.id})">Remover</a></td>
			</tr>

		</c:forEach>
		<fmt:setLocale value="${originalLocale}"/>
	</table>
	<c:url value="/produto/formulario" var="linkProduto" />
	<a href="${linkProduto}"><fmt:message key="mensagem.novoProduto" /></a>

	<c:set var="nome" value="João da Silva" />
	<c:out value="${nome}" />
	
	<c:import url="../_comum/rodape.jsp" />
</body>
</html>