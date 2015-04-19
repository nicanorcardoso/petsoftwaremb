package br.com.petsoftwaremb.activitys;

import java.util.ArrayList;
import java.util.List;

import br.com.petsoftwaremb.entidades.Configuracoes;
import br.com.petsoftwaremb.entidades.Estado;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class ConfiguracaoActivity extends Activity {


	private Spinner mSpinnerDias;
	private ArrayAdapter<Configuracoes> mAdapter;
	private List<Configuracoes> mItens;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuracoes);
		
		mItens = new ArrayList<Configuracoes>();
		
		Configuracoes cfgDiaNull = new Configuracoes();
		cfgDiaNull.setDiaIniciaNT("");
		mItens.add(cfgDiaNull);

		
		Configuracoes cfgDia1 = new Configuracoes();
		cfgDia1.setDiaIniciaNT("01");
		mItens.add(cfgDia1);

		Configuracoes cfgDia2 = new Configuracoes();
		cfgDia2.setDiaIniciaNT("02");
		mItens.add(cfgDia2);
		
		Configuracoes cfgDia3 = new Configuracoes(); 
		cfgDia3.setDiaIniciaNT("03");
		mItens.add(cfgDia3);
		
		Configuracoes cfgDia4 = new Configuracoes();
		cfgDia4.setDiaIniciaNT("04");
		mItens.add(cfgDia4);
	
		Configuracoes cfgDia5 = new Configuracoes();
		cfgDia5.setDiaIniciaNT("05");
		mItens.add(cfgDia5);
		
		
		mAdapter = new ArrayAdapter<Configuracoes>(this, R.layout.activity_spinner_item, mItens);
		
		mSpinnerDias = (Spinner) findViewById(R.id.spinnerIniciaNTF);
		
		mSpinnerDias.setAdapter(mAdapter);
		
	}
	
}
