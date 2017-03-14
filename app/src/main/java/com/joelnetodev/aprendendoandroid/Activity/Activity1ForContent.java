package com.joelnetodev.aprendendoandroid.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.joelnetodev.aprendendoandroid.R;

import java.util.ArrayList;
import java.util.List;

public class Activity1ForContent extends AppCompatActivity
{
    boolean permitidoLerContatos;
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Nova Activity Content");

        popularContatos();
    }

    public void popularContatos()
    {
        ListView listView = (ListView) findViewById(R.id.listViewContent);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                consultarContatos());

        listView.setAdapter(arrayAdapter);
    }

    public List<String> consultarContatos()
    {
        List<String> lista = new ArrayList<String>();
        Uri agenda = ContactsContract.Contacts.CONTENT_URI;
        String orderBy = ContactsContract.Contacts.DISPLAY_NAME + " ASC";
        Cursor cursor = getApplicationContext().getContentResolver().query(agenda,null,null,null, orderBy);

        while(cursor.moveToNext())
        {
            String nome = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

            if(lista.contains(nome)) continue;

            lista.add(nome);
        }
        cursor.close();
        return lista;
    }

    private  boolean verificarPermissao()
    {
        int permissionContacts = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);

        if (permissionContacts != PackageManager.PERMISSION_GRANTED)
        {
            permitidoLerContatos = false;

            ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS);
        }
        else
        {
            permitidoLerContatos = true;
        }

        return permitidoLerContatos;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode)
        {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS:
            {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    permitidoLerContatos = true;
                }
                else
                {
                    permitidoLerContatos = false;
                }
                return;
            }
        }
    }
}
