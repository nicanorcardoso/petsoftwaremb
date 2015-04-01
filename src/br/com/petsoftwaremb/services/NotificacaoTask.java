package br.com.petsoftwaremb.services;
import br.com.petsoftwaremb.services.NotificacaoService;;

public class NotificacaoTask implements Runnable{

	@Override
	public void run() {

		int iniciaNotificacao = 0;
		
		if (iniciaNotificacao == 0){
			
			String titulo="";
			String texto="";
			
			criarNotificacao(titulo, texto);
			
			
		}
		
				
		
	}

	private void criarNotificacao(String titulo, String texto) {
		// TODO Auto-generated method stub
		
	}
	

}
