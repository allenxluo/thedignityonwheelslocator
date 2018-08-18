package dignityonwheels.org.locator;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static AssetManager assets;
    public static LayoutInflater inflater;

    public static HomeFragment home;
    public static ScheduleFragment schedule;
    public static AboutFragment about;

    private Toolbar topBar;
    private BottomNavigationView navBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assets = getAssets();

        inflater = getLayoutInflater();

        home = new HomeFragment();
        home.setButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.schedule_btn)
                    navBar.setSelectedItemId(R.id.nav_schedule);
            }
        });

        schedule = new ScheduleFragment();

        about = new AboutFragment();

        //The top bar of the application.
        topBar = (Toolbar) findViewById(R.id.toolbar);
        topBar.setTitle(" Dignity On Wheels Locator");
        topBar.setLogo(R.drawable.resizedlogo);
        setSupportActionBar(topBar);

        navBar = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = home;
                        break;
                    case R.id.nav_schedule:
                        selectedFragment = schedule;
                        break;
                    case R.id.nav_about:
                        selectedFragment = about;
                        break;
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();

                return true;
            }
        });

        navBar.setSelectedItemId(R.id.nav_home);
    }
}
