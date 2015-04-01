package br.com.petsoftwaremb.services;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import br.com.petsoftwaremb.activitys.DetalheNotificacao;
import br.com.petsoftwaremb.activitys.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class NotificacaoService extends Service {

	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}

	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1);
		long delayInicial = 0;
		long periodo = 1;
		TimeUnit unit = TimeUnit.MINUTES;
		pool.scheduleAtFixedRate(new NotificacaoTask(), delayInicial,
				periodo, unit);

		return START_STICKY;
	}
	
	private void criarNotificacao(String titulo, String texto, int id){
		
		int icone = R.drawable.ic_launcher;
		
		String tituloNotificacao = getString(R.string.tituloNotificacao);
		String avisoNotificacao = getString(R.string.avisoNotificacao);
		long data = System.currentTimeMillis();
		
		Context contexto = getApplicationContext();
		Intent it = new Intent(contexto, DetalheNotificacao.class);
		it.putExtra(DetalheNotificacao.TITULO, titulo.toString());
		it.putExtra(DetalheNotificacao.TEXTO, texto.toString());
		
		PendingIntent penIntent = PendingIntent.getActivity(contexto, id, it, Intent.FLAG_ACTIVITY_NEW_TASK);
		
		Notification notification = new Notification(icone, avisoNotificacao, data);
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		notification.defaults |= Notification.DEFAULT_VIBRATE;
		notification.defaults |= Notification.DEFAULT_LIGHTS;
		notification.defaults |= Notification.DEFAULT_SOUND;
		notification.setLatestEventInfo(contexto, tituloNotificacao, texto, penIntent);
		
		String ns = Context.NOTIFICATION_SERVICE;
		NotificationManager notificationManager =
		(NotificationManager) getSystemService(ns);
		notificationManager.notify(id, notification);
	}

}
