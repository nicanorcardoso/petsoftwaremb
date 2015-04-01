package br.com.petsoftwaremb.activitys;

import java.util.Date;

import br.com.petsoftwaremb.activitys.R;
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
