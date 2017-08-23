<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>Bem vindo ao nosso gerenciador de empresas!</h1>
	<br />
	<c:if test="${usuarioLogado != null}">
		Você está logado como ${usuarioLogado.email}
	</c:if>
	<form action="executa?tarefa=NovaEmpresa" method="post">
		Nome: <input type="text" name="nome" /><br /> 
		<input type="submit" value="Enviar" />
	</form>
	
	<form action="login" method="post">
		Email: <input type="email" name="email"/> <br />
		Senha: <input type="password" name="senha"/> <br />
		<input type="submit" value="Login"/>
	</form>
	
	<form action="executa?tarefa=Logout" method="post">
		<input type="submit" value="Logout"/>
	</form>
</body>
</html>