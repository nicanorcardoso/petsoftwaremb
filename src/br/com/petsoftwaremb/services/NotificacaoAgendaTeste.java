package br.com.petsoftwaremb.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.WildcardType;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.message.BufferedHeader;
import org.json.JSONObject;

import br.com.petsoftwaremb.activitys.DetalheNotificacao;
import br.com.petsoftwaremb.activitys.PrincipalActivity;
import br.com.petsoftwaremb.activitys.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.util.Log;

public class NotificacaoAgendaTeste extends Service implements Runnable { 

	public void onCreate() {
		// um Service deve ser isolado em uma thread para que a activity n�o
		// fique travada enquanto o servi�o est� em execu��o
		new Thread(NotificacaoAgendaTeste.this).start();

		// qando o start � chamado ele automaticamente ir� procurar o m�todo run

	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void run() {

		int totalDB = 0;
		int totalReplicado = 0;
		String tipoAtendimento = "Motivo Retorno";
		 
		 NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		 
		 Notification nt = null;
		
		 
		 if(totalDB == totalReplicado){
			 nt = new Notification(R.drawable.ic_launcher, "Status Replica��o", System.currentTimeMillis());
		 
			 nt.flags |= Notification.FLAG_AUTO_CANCEL;
			 
			 PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this.getApplicationContext(), PrincipalActivity.class), 0);
			 
			 nt.setLatestEventInfo(this, "Atendimento Pet-Shop", "Retornar ao Pet-Shop em x dias para: " + tipoAtendimento, p);
			 
			 
		 } else {
			 nt = new Notification(R.drawable.ic_launcher, "Status Replica��o", System.currentTimeMillis());
			 
			 nt.flags |= Notification.FLAG_AUTO_CANCEL;
			 
			 PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this.getApplicationContext(), PrincipalActivity.class), 0);
			 
			 nt.setLatestEventInfo(this, "Atendimento Pet-Shop", "N�o foi poss�vel conectar ao servidor para obter dados do pr�ximo atendimento", p);
		 }
		 
		nt.vibrate = new long[]{100, 2000, 1000, 2000}; 
		
		notificationManager.notify((int)Math.round(Math.random()), nt);
		 
	}
}
