package com.prophet.ecommerce;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.prophet.ecommerce.fragment.HomeFragment;
import com.prophet.ecommerce.fragment.MyAccountFragment;
import com.prophet.ecommerce.fragment.OrderFragment;
import com.prophet.ecommerce.fragment.RewardFragment;
import com.prophet.ecommerce.fragment.WishListFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int HOME_FRAGMENT = 0;
    private static final int ORDER_FRAGMENT = 1;
    private static final int CART_FRAGMENT = 2;
    private static final int WISHLIST_FRAGMENT = 3;
    private static final int REWARD_FRAGMENT = 4;
    private static final int ACCOUNT_FRAGMENT = 5;

    private FrameLayout frameLayout;
    private static int CURRENT_FRAGMENT = -1;
    private NavigationView navigationView;
    private Toolbar toolbar;
    // private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // window = getWindow();
        // window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // Casting layout elements
        frameLayout = findViewById(R.id.main_frame);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        // Home is set here
        setFragment(new HomeFragment(), HOME_FRAGMENT);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (CURRENT_FRAGMENT == HOME_FRAGMENT){
                super.onBackPressed();
            }else {
                getSupportActionBar().setTitle("Home");
                invalidateOptionsMenu();
                setFragment(new HomeFragment(), HOME_FRAGMENT);
                navigationView.getMenu().getItem(0).setChecked(true);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        if (CURRENT_FRAGMENT == HOME_FRAGMENT){
            getMenuInflater().inflate(R.menu.main, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            // todo: search
            return true;
        } else if ( id == R.id.action_notification){
            // todo: notification
        } else if ( id == R.id.action_cart){
            switchFragment(new CartFragment(), CART_FRAGMENT, "My Cart");
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home){
            getSupportActionBar().setTitle("Home");
            invalidateOptionsMenu();
            setFragment(new HomeFragment(), HOME_FRAGMENT);
        } else if (id == R.id.nav_order) {
            switchFragment(new OrderFragment(), ORDER_FRAGMENT, "My Orders");
        } else if (id == R.id.nav_cart) {
            switchFragment(new CartFragment(), CART_FRAGMENT, "My Cart");
        } else if (id == R.id.nav_wishlist) {
            switchFragment(new WishListFragment(), WISHLIST_FRAGMENT, "My WishList");
        } else if (id == R.id.nav_reward) {
            switchFragment(new RewardFragment(), REWARD_FRAGMENT, "My Rewards");
        } else if (id == R.id.nav_account) {
            switchFragment(new MyAccountFragment(), ACCOUNT_FRAGMENT, "My Account");
        } else if (id == R.id.nav_signOut){
            // todo: signout
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Helper for fragment transaction
     *
     */
    private void setFragment(Fragment fragment, int fragmentNo){
        if (fragmentNo != CURRENT_FRAGMENT){
            CURRENT_FRAGMENT = fragmentNo;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            fragmentTransaction.replace(frameLayout.getId(), fragment);
            fragmentTransaction.commit();
        }
    }


    private void switchFragment(Fragment fragment, int position, String title){
        // runs onCreateOptionMenu again
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);

        if (position == CART_FRAGMENT){
            navigationView.getMenu().getItem(2).setChecked(true);
        }
        if (position == REWARD_FRAGMENT){
            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }else {
            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            invalidateOptionsMenu();
        }

        setFragment(fragment, position);
    }
}
