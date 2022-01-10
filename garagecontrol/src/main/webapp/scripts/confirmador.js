/**
 * Confirmação de exclusão de um cliente
 * @author Lúcio Hermano Batista
 *
 */

function confirmar(idcli) {
	let resposta = confirm("Confirma a exclusão deste contato?")
	if (resposta === true) {
		//alert(idcli) //- Envia o código para teste
		window.location.href = "delete?idcli=" + idcli

	}
}