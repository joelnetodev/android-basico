package com.joelnetodev.aprendendoandroid.Activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ScrollView;

import com.joelnetodev.aprendendoandroid.R;

import layout.FragActivity;
import layout.FragBroadcast;
import layout.FragContent;
import layout.FragIntent;
import layout.FragIntroducao;
import layout.FragInicio;
import layout.FragService;
import layout.FragSobre;

public class ActivityMain extends AppCompatActivity
{
    private DrawerLayout drawer;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {
            scrollView = (ScrollView) findViewById(R.id.scroll_main);
            criarDrawer();

            if(savedInstanceState == null)
            {
                carregarFragment(new FragInicio(), false);
            }

            verificarIntentExtras();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed()
    {
        if (getFragmentManager().getBackStackEntryCount() > 0)
        {
            getFragmentManager().popBackStack();
        }
        else
        {
            super.onBackPressed();
        }
    }

    private void criarDrawer()
    {
        //Obtenho o toolBar e o drawer
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        drawer = (DrawerLayout) findViewById(R.id.main_drawer);

        setSupportActionBar(toolbar);

        //Configura o toolbar dentro do ActionBarDrawerToggle (com isso o toolbar chama o drawer)
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //Obtem e configura o navegation
        NavigationView navigationView = (NavigationView) findViewById(R.id.main_navigation_view);
        setupDrawerContent(navigationView);
    }

    private void setupDrawerContent(NavigationView navigationView)
    {
        //Sobrescreve o onNavigationItemSelected pelo metodo selectDrawerItem
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener()
                {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem)
                    {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }
    public void selectDrawerItem(MenuItem menuItem)
    {
        try
        {
            Fragment fragment = escolherFragmento(menuItem.getItemId());
            carregarFragment(fragment);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            scrollView.fullScroll(ScrollView.FOCUS_UP);
            menuItem.setChecked(true);
            drawer.closeDrawers();
        }
    }

    private Fragment escolherFragmento(int idFragmento)
    {
        switch(idFragmento) {
            case R.id.nav_inicio:
                return new FragInicio();
            case R.id.nav_intro:
                return new FragIntroducao();
            case R.id.nav_intent:
                return new FragIntent();
            case R.id.nav_activity:
                return new FragActivity();
            case R.id.nav_service:
                return new FragService();
            case R.id.nav_content:
                return new FragContent();
            case R.id.nav_broad:
                return new FragBroadcast();
            case R.id.nav_sobre:
                return new FragSobre();
            default:
                return  new FragInicio();
        }
    }

    private void carregarFragment(Fragment fragment)
    {
        carregarFragment(fragment, true);
    }
    private void carregarFragment(Fragment fragment, boolean enfileirar)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame, fragment);

        if(enfileirar)
        {
            ft.addToBackStack(null);
        }

        ft.commit();
    }

    private void verificarIntentExtras()
    {
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            if(extras.getString("service") != null)
            {
                carregarFragment(new FragService(), false);
            }
        }
    }
}
