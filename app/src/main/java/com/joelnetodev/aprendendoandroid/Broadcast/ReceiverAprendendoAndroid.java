package com.joelnetodev.aprendendoandroid.Broadcast;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.joelnetodev.aprendendoandroid.Activity.Activity1ForBroadcast;
import com.joelnetodev.aprendendoandroid.R;

public class ReceiverAprendendoAndroid extends BroadcastReceiver
{
    public ReceiverAprendendoAndroid()
    {

    }
    @Override
    public void onReceive(Context context, Intent intent)
    {
        mostrarNotificacao(context);
    }

    private void mostrarNotificacao(Context context)
    {
        NotificationManager  notificationManager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);

        String ticker = "Aprendendo Android";
        String titulo = "Notificação de Aprendendo Android";
        String texto = "Texto da notificação de Aprendendo Android";

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setSmallIcon(R.mipmap.appicon);
        mBuilder.setTicker(ticker);
        mBuilder.setContentTitle(titulo);
        mBuilder.setContentText(texto);
        mBuilder.setAutoCancel(true);

        Intent intentReceiver = new Intent(context, Activity1ForBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intentReceiver, 0);

        mBuilder.setContentIntent(pendingIntent);

        notificationManager.notify(1, mBuilder.build());
    }
}
