var PeopleCounter = PeopleCounter || {};

PeopleCounter.AtualizarPlacar = (function(){
	
	function AtualizarPlacar(){
		this.quantidadePessoasNaTela = $(".quantidade-pessoas");
	}
	
	AtualizarPlacar.prototype.iniciar = function(){
		var qtdPessoas = $(".quantidade-pessoas");
		setInterval(function(){
			$.ajax({
				url: "/peopleCounter/contador",
				method: 'POST',
				contentType: 'application/json',
				data: JSON.stringify({ quantidadeDePessoas: qtdPessoas }),
				error: onErroAtualizandoTela.bind(this),
				success: onSucessoAtualizandoTela.bind(this)
			});
		}, 2000);

	}
	
	function onErroAtualizandoTela(contador){
		console.log("Ocorreu um erro na requisição! : ", contador);
	}
	
	function onSucessoAtualizandoTela(contador){
		var quantidadePessoasNaTela = $(".quantidade-pessoas");
		console.log(contador);
		
		quantidadePessoasNaTela.text(contador.quantidadeDePessoas);
	}
	
	
	return AtualizarPlacar;
	
})();

$(function(){
	var atualizaPlacar = new PeopleCounter.AtualizarPlacar();
	atualizaPlacar.iniciar();
});