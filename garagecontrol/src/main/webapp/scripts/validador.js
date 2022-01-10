/**
 * Validador de formulário
 * @author Lúcio Hermano Batista
 *
 */

function validar() {
	let nome = frmCliente.nome.value
	let rg = frmCliente.rg.value
	let cpf = frmCliente.cpf.value
	let dtnasc = frmCliente.dtnasc.value

	if (nome === "") {
		alert('Preencha o campo Nome')
		frmCliente.nome.focus()
		return false

	} else if (rg === "") {
		alert('Preencha o campo RG')
		frmCliente.rg.focus()
		return false

	} else if (cpf === "") {
		alert('Preencha o campo CPF')
		frmCliente.cpf.focus()
		return false

	} else if (dtnasc === "") {
		alert('Preencha o campo Data Nascimento')
		frmCliente.dtnasc.focus()
		return false

	} else {
		document.forms["frmCliente"].submit()
	}
}