/**
 * Validador de formulário
 * @author Lúcio Hermano Batista
 *
 */

function confirm(usuLog) {
	let resposta = confirm(usuLog)
	if (resposta === true) {
		alert("Usuário ou Senha não conferem!") //- Envia o código para teste
		//window.location.href = "delete?idcli=" + idcli
	} else{
		alert("Beleza!")
	}
}