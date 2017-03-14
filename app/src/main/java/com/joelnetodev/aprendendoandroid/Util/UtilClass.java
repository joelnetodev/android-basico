package com.joelnetodev.aprendendoandroid.Util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Joel on 11/11/2016.
 */

public abstract class UtilClass
{

    public static void mostrarAlerta(Context context, String mensagem)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Atenção");
        alertDialog.setMessage(mensagem);
        alertDialog.setButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public static String getBroadcastName()
    {
        return "com.joelnetodev.aprendendoandroid.broadcast.ACTION";
    }
}

