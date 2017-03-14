package com.joelnetodev.aprendendoandroid.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.joelnetodev.aprendendoandroid.Activity.ActivityMain;

public class ServiceAprendendoAndroid extends Service
{
    private boolean servicoAtivo = false;
    private Thread thread = null;

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        servicoAtivo = true;
        thread = criarServiceThread();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        if (servicoAtivo)
        {
            servicoAtivo = false;
            thread.start();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy()
    {
        servicoAtivo = false;
        super.onDestroy();
    }

    private Thread criarServiceThread()
    {
        return new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(5000);

                    Intent intentMain = new Intent();
                    intentMain.setClass(getApplication(), ActivityMain.class);
                    intentMain.putExtra("service", "service");
                    intentMain.setFlags(intentMain.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intentMain);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        };
    }
}
