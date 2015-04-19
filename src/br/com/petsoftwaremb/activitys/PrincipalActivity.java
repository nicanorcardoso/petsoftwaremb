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
import android.content.Intent;
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
		/*
		String idBuscaWs = "nicanor";
		
		SincronismoRest sincRest = new SincronismoRest();
		
		String chamadaWS;
		String url = "http://10.50.0.6:8080/PetSinc/webresources/testews/Usuario/get/";
		String parametro = "fernanda";
		//casa
		chamadaWS = url + parametro;
		//success
		//chamadaWS = "http://192.168.1.38:8080/PetSinc/webresources/testews/Usuario/get/nicanor";
		
		
		String resultado = sincRest.chamadaGet(chamadaWS);
		Log.i("JSON", resultado);
		
		//try {
			//JSONObject json = new JSONObject(resultado);
			
			Gson gson = new Gson();
			Usuario usr = new Usuario();
			
			Type usuarioType = new TypeToken<Usuario>() {}.getType();
			usr = gson.fromJson(resultado, usuarioType);
			
			TextView texto = (TextView) findViewById(R.id.testews);
			
			texto.setText(usr.getEmail());
			
			
		}/*catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

}
