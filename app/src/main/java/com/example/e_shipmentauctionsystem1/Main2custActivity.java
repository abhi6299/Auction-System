package com.example.e_shipmentauctionsystem1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.navigation.NavigationView;

public class Main2custActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mtoggle;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.type1:
                Toast.makeText(Main2custActivity.this, "Setting", Toast.LENGTH_SHORT).show();

                break;
            case R.id.type2:
                Toast.makeText(Main2custActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Main2custActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2cust);



        androidx.appcompat.widget.Toolbar toolbar1 = findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar1);

        mDrawerLayout = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.nac_cview);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar1, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.nac_chome:
                Intent intent=new Intent(Main2custActivity.this,home2.class);
                startActivity(intent);
                break;
            case R.id.nac_ccontactus:
                Intent intent1=new Intent(Main2custActivity.this,contactus2.class);
                startActivity(intent1);
                break;
            case R.id.nac_cproduct:
                Intent intent2=new Intent(Main2custActivity.this,myproduct.class);
                startActivity(intent2);
                break;
            case R.id.nac_cpayment:
                Intent intent3=new Intent(Main2custActivity.this,payment2.class);
                startActivity(intent3);
                break;
            case R.id.nac_cshare:
                Intent intent4=new Intent(Main2custActivity.this,share2.class);
                startActivity(intent4);
                break;
            case R.id.nac_clogout:
                Intent intent5=new Intent(Main2custActivity.this,logout2.class);
                startActivity(intent5);
                break;
            case R.id.nac_ctool:
                Intent intent6=new Intent(Main2custActivity.this,setting2.class);
                startActivity(intent6);
                break;
        }
        mDrawerLayout.closeDrawer((GravityCompat.START));
        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

}
