package br.com.petsoftwaremb.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class CartaoVacinaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listar_cartao);

		SQLiteDatabase db = openOrCreateDatabase("petsoftware.db",
				Context.MODE_PRIVATE, null);

		ListView ltwVacina = (ListView) findViewById(R.id.ltwVacina);

		Cursor cursor = db.rawQuery("SELECT * FROM cartao_vacina", null);

		String[] from = { "_id", "nome", "idade_aplic", "dose", "data_aplic" };
		int[] to = { R.id.txvID, R.id.txvNomeVacina, R.id.txvIdadeAplicacao,
				R.id.txvDose, R.id.txvDataAplicacao };

		SimpleCursorAdapter ad = new SimpleCursorAdapter(getBaseContext(),
				R.layout.listar_cartao_model, cursor, from, to);

		ltwVacina.setAdapter(ad);

	}

}
