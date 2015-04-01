package br.com.petsoftwaremb.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class ConfiguracaoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuracoes);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId()==android.R.id.home){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
}
