package br.com.petsoftwaremb.activitys;

import br.com.petsoftwaremb.activitys.R;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

public class ShowActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

}
