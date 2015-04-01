package br.com.petsoftwaremb.activitys;

import br.com.petsoftwaremb.activitys.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	}

	public void Login_Click (View v){
		startActivity(new Intent(getBaseContext(), PrincipalActivity.class ));
		
	}
}
