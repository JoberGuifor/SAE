package com.sae.sae.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.sae.sae.R;
import com.sae.sae.model.GradientePadrao;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private Toolbar toolbar;

    private NavigationView navigationView;

    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(GradientePadrao.getGradiente());
        }
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.txt_layout);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_registroPaciente, R.id.nav_viasAereas, R.id.nav_AvaliacaoResp,
                R.id.nav_viasCirculatorias, R.id.nav_exameNeuro, R.id.nav_exameResp,
                R.id.nav_exameCardio, R.id.nav_exameUrinario, R.id.nav_sitioCirurgico, R.id.nav_SinaisVitais,
                R.id.nav_indiceAK, R.id.nav_registoInfoTransOperatorias)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public ActionBar getActionBarPrincipal(){

        //toolbar.setContentInsetStartWithNavigation((int) ((((CoordinatorLayout)toolbar.getParent().getParent()).getWidth() / 2) - ((toolbar.getTitle().length() * 15))));
        //toolbar.setTitleMarginStart(toolbar.getWidth() / 3 );
        return getSupportActionBar();
    }

    public NavigationView getNavigationView(){
        return navigationView;
    }

    public DrawerLayout getDrawer(){
        return drawer;
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
