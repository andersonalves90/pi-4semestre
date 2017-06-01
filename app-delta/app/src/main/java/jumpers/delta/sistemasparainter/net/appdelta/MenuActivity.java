package jumpers.delta.sistemasparainter.net.appdelta;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by qw on 27/05/2017.
 */

public class MenuActivity extends AppCompatActivity{
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navegar);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                if (menuItem.getItemId() == R.id.home) {
                    MainActivity mainActivity = new MainActivity();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,mainActivity ).commit();

                    return true;

                }else  if (menuItem.getItemId() == R.id.sobre) {
                    Sobre fragment = new Sobre();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, fragment).commit();
                    return true;
                }else  if (menuItem.getItemId() == R.id.categorias) {
                    Categoria categoria = new Categoria ();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, categoria).commit();
                    return true;

                }else  if (menuItem.getItemId() == R.id.qr_code) {
                    //QRCode  qrcode= new QRCode();
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, qrcode).commit();
                    //return true;

                }else if (menuItem.getItemId() == R.id.carrinho) {
                    CarrinhoActivity fragment = new CarrinhoActivity();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, fragment).commit();
                    return true;

            }else if (menuItem.getItemId() == R.id.sair) {
          finish();

            }
                return false;
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close) {};
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}