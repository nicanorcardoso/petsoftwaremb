package br.com.petsoftwaremb.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheNotificacao extends Activity{
	
	public static final String TITULO = "tituloNotificacao";
	public static final String TEXTO = "Texto";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalhe_notificacao);
		
		
		TextView tituloNotificacao = (TextView) findViewById(R.id.titulo);
		TextView textoNofificacao = (TextView) findViewById(R.id.texto);
		
		String titulo = getIntent().getStringExtra(TITULO);
		String texto = getIntent().getStringExtra(TEXTO);
		
		tituloNotificacao.setText(titulo);
		textoNofificacao.setText(texto);
		
	}

}
