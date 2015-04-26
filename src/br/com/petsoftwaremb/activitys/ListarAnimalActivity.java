package br.com.petsoftwaremb.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ListarAnimalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listar_animais);

		SQLiteDatabase db = openOrCreateDatabase("petsoftware.db",
				Context.MODE_PRIVATE, null);

		ListView ltwAnimal = (ListView) findViewById(R.id.ltwAnimal);

		Cursor cursor = db
				.rawQuery(
						"SELECT animal._id, animal.nome, animal.raca FROM animal",
						null);

		String[] from = { "_id", "nome", "raca" };
		int[] to = { R.id.txvID, R.id.txvNomeAnimal, R.id.txvRaca };

		SimpleCursorAdapter ad = new SimpleCursorAdapter(getBaseContext(),
				R.layout.listar_animais_model, cursor, from, to);

		ltwAnimal.setAdapter(ad);

		
		ltwAnimal.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView ad, View v, int position, long id){
				
				SQLiteCursor C = (SQLiteCursor) ad.getAdapter().getItem(position);
				
				Intent it = new Intent(getBaseContext(), CartaoVacinaActivity.class);
				startActivity(it);
				
				
				
			}

		});

	}

}
