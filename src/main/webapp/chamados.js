$(function() {
	$(".js-load-chamados").on('click', function() {
		$.ajax({
				url: "http://localhost:8080/api_proway/rest/chamados/",
				type: "GET",
				success: function(response) {
					desenhaTabela(response);
				}
		});
	})
});

$(function() {
	$(".js-save-chamados").on('click', function() {
		var elAssunto = document.getElementById('assunto');
		var strAssunto = elAssunto.value;
		
		var elMensagem = document.getElementById('mensagem');
		var strMensagem = elMensagem.value;
		
		var elStatus = document.getElementById('status');
		var strStatus= elStatus.value;
		
		
		var chamados = {};
		
		
		chamados.assunto = strAssunto;
		chamados.status = strStatus;
		chamados.mensagem = strMensagem;
	
		var chamadoObj = JSON.stringify(chamados);
		$.ajax({
				url: 'http://localhost:8080/api_proway/rest/chamados/',
				headers: { 
					contentType: 'application/json'				
				},
				type: 'POST',
				data:chamadoObj,
				contentType: 'application/json; charset=utf-8',
				success: function() {
					alert('salvo com sucesso');
				},
				error: function(error) {
					alert('ERROS '+ error);
				}
				

		});
	})
});



function desenhaTabela(dados) {
	$(".js-chamados-table-body tr").remove();
	for(var i=0; i < dados.length; i++) {
		desenhaLinha(dados[i]);
	}
}

function desenhaLinha(linha) {
	var linhaTabela = $("<tr/>");
	$(".js-chamados-table-body").append(linhaTabela);
	linhaTabela.append("<td>" + linha.id + "</td>");
	linhaTabela.append("<td>" + linha.assunto + "</td>");
	linhaTabela.append("<td>" + linha.mensagem + "</td>");
	linhaTabela.append("<td>" + linha.status + "</td>");
}


function salvarDados() {
	var elId = document.getElementById('id');
	var elAssunto = document.getElementById('assunto');
	var elMensagem = document.getElementById('mensagem');
	var elStatus = document.getElementById('status');
}






