package br.com.petsoftwaremb.activitys;

import java.util.ArrayList;
import java.util.List;

import br.com.petsoftwaremb.activitys.R;
import br.com.petsoftwaremb.entidades.*;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;



public class FormActivity extends Activity{

	private Spinner mComboboxEstado;
	private ArrayAdapter<Estado> mAdapter;
	private List<Estado> mItens;
	
	public void onCreate (Bundle savedInstanceState){
	
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		mItens = new ArrayList<Estado>();
		
		Estado e1 = new Estado();
		e1.setId(1);
		e1.setNome("Goias");
		e1.setSigla("GO");
		mItens.add(e1);//adiciona o estado a combobox
		
		Estado e2 = new Estado();
		e2.setId(2);
		e2.setNome("Minas Gerais");
		e2.setSigla("MG");
		mItens.add(e2);//adiciona o estado a combobox
		
		Estado e3 = new Estado();
		e3.setId(3);//adiciona o estado a combobox
		e3.setNome("São Paulo");
		e3.setSigla("MG");
		mItens.add(e3);//adiciona o estado a combobox
		
		Estado e4 = new Estado();
		e4.setId(4);
		e4.setNome("Bahia");
		e4.setSigla("BA");
		mItens.add(e4);
		
		mAdapter = new ArrayAdapter<Estado>(this, R.layout.activity_spinner_item, mItens) ;
		//o ArrayAdapter irá utilizar o toString da entidade para reinderizar o item
		
		mComboboxEstado = (Spinner) findViewById(R.id.comboboxEstados);

		mComboboxEstado.setAdapter(mAdapter);
		
		/**testanto Intente**/ 
		if (getIntent().hasExtra("valor_nome")){
			Log.i("agenda", "Valor Recebido!");
			
			String valor = getIntent().getStringExtra("valor_nome");
			
			Log.i("agenda", "O valor é:"+ valor);
		}
	
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == android.R.id.home){
			finish();
			
		}
		return super.onOptionsItemSelected(item);
	}

}
