/**
 * Validador de formulário
 * @author Lúcio Hermano Batista
 *
 */

function valida() {
	let usuNo = frmUsuario.usuLogin.value
	let usuSe = frmUsuario.usuSenha.value
	
	out.print(usuLogin);
	out.print(usuSenha);

	if (usuNo === "") {
		alert('Preencha o campo Usuario')
		frmCliente.usuNome.focus()
		return false

	} else if (usuSe === "") {
		alert('Preencha o campo Senha')
		frmCliente.usuSenha.focus()
		return false

	} else {
		document.forms["frmUsuario"].submit()
	}
}