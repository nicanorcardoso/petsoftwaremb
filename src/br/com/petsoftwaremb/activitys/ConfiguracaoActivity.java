package br.com.petsoftwaremb.activitys;

import br.com.petsoftwaremb.entidades.Estado;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ConfiguracaoActivity extends Activity {

	private Spinner mSpnnerDias;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuracoes);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Integer[] diaInicioNT = {1,2,3,4,5,6,7,8,9,10};
		
		
		

	}
	
}
