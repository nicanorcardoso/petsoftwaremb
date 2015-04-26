package br.com.petsoftwaremb.activitys;

import java.lang.reflect.Type;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.petsoftwaremb.activitys.R;
import br.com.petsoftwaremb.entidades.Usuario;
import br.com.petsoftwaremb.services.SincronismoRest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class PrincipalActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);

		SQLiteDatabase db = openOrCreateDatabase("petsoftware.db",
				Context.MODE_PRIVATE, null);

		StringBuilder sqlAnimal = new StringBuilder();
		sqlAnimal.append("CREATE TABLE IF NOT EXISTS [animal](");
		sqlAnimal.append("[_id] INTEGER PRIMARY KEY AUTOINCREMENT, ");
		sqlAnimal.append("nome varchar(80), ");
		sqlAnimal.append("raca varchar(50)); ");
		db.execSQL(sqlAnimal.toString());

		StringBuilder sqlVacina = new StringBuilder();
		sqlVacina.append("CREATE TABLE IF NOT EXISTS [cartao_vacina](");
		sqlVacina.append("[_id] INTEGER PRIMARY KEY AUTOINCREMENT, ");
		sqlVacina.append("nome varchar(80), ");
		sqlVacina.append("idade_aplic varchar(80), ");
		sqlVacina.append("dose varchar(80), ");
		sqlVacina.append("data_aplic char(8)); ");
		db.execSQL(sqlVacina.toString());

	//	db.execSQL("INSERT INTO cartao_vacina(nome, idade_aplic, dose, data_aplic) "
		//		+ "VALUES ('Pavavirose', '1 Mês', 'Unica', '22/04/2015')");
		// d
		// db.execSQL("INSERT INTO animal(nome, raca) VALUES('Toto', 'Vira+Lata')");

		/*
		 * String idBuscaWs = "nicanor";
		 * 
		 * SincronismoRest sincRest = new SincronismoRest();
		 * 
		 * String chamadaWS; String url =
		 * "http://10.50.0.6:8080/PetSinc/webresources/testews/Usuario/get/";
		 * String parametro = "fernanda"; chamadaWS = url + parametro;
		 * 
		 * 
		 * String resultado = sincRest.chamadaGet(chamadaWS); Log.i("JSON",
		 * resultado);
		 * 
		 * //try { //JSONObject json = new JSONObject(resultado);
		 * 
		 * Gson gson = new Gson(); Usuario usr = new Usuario();
		 * 
		 * Type usuarioType = new TypeToken<Usuario>() {}.getType(); usr =
		 * gson.fromJson(resultado, usuarioType);
		 * 
		 * TextView texto = (TextView) findViewById(R.id.testews);
		 * 
		 * texto.setText(usr.getEmail());
		 * 
		 * 
		 * }/*catch (JSONException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	public void onResume() {
		super.onResume();

		Date date = new Date();
		TextView txvDataSistema = (TextView) findViewById(R.id.txvDataSistema);
		txvDataSistema.setText("Data: " + date);

	}

	public void NotificacaoClick(View v) {
		startService(new Intent("NOTIFICACAO_AGENDA"));

	}

	/*
	 * MENUS-ACTION BAR
	 */

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == R.action_activity_principal.btnAddContato) {
			addContato();
		} else if (item.getItemId() == R.action_activity_principal.btnPesquisaContato) {
			iniciaPesquisa();
		} else if (item.getItemId() == R.action_activity_principal.btnConfiguracoes) {
			abreConfiguracoes();
		} else if (item.getItemId() == R.action_activity_principal.btnVacina) {
			abreCartaoVacina();
		}

		return super.onOptionsItemSelected(item);
	}

	private void addContato() {
		Intent it = new Intent();
		it.setClass(this, FormActivity.class);
		it.putExtra("valor_nome", "Nicanor");
		startActivity(it);

	}

	private void iniciaPesquisa() {
		Intent it = new Intent();
		it.setClass(this, ShowActivity.class);
		startActivity(it);
	}

	private void abreConfiguracoes() {
		Intent it = new Intent();
		it.setClass(this, ConfiguracaoActivity.class);
		startActivity(it);

	}

	private void abreCartaoVacina() {
		Intent it = new Intent();
		it.setClass(this, ListarAnimalActivity.class);
		startActivity(it);
	}

}
