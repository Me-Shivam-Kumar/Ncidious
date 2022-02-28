package com.ncidious.ncidious.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.ncidious.ncidious.R
import com.ncidious.ncidious.data.network.responses.ExamsAttemptedResponse
import com.ncidious.ncidious.ui.analytics.IAnalyticsCall
import com.ncidious.ncidious.ui.analytics.TestAnalyticsContainerFragment
import com.ncidious.ncidious.ui.examsattempted.ExamsAttemptedFragment
import com.ncidious.ncidious.ui.home.homeFragment.HomeFragment
import com.ncidious.ncidious.ui.notices.NoticesFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    IAnalyticsCall {
    lateinit var mainActivityFrameLayout: FrameLayout
    lateinit var noInternetConnectionIV: ImageView
    lateinit var navigationView: NavigationView
    lateinit var drawerView: DrawerLayout
    private val HOME_FRAGMENT = 0
    private val NOTICES_FRAGMENT = 1
    private val EXAMS_ATTEMPTED_FRAGMENT = 2
    private var currentFragment = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(false)

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        drawerView = findViewById(R.id.drawer_layout)

        mainActivityFrameLayout = findViewById(R.id.main_frame_layout)
        noInternetConnectionIV = findViewById(R.id.no_internet_connection)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerView,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerView.addDrawerListener(toggle)
        toggle.syncState()
        drawerView.setScrimColor(Color.parseColor("#FFCC80"))
        setFragment(HomeFragment(), HOME_FRAGMENT)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        if (id == R.id.Home) {
            invalidateOptionsMenu()
            setFragment(HomeFragment(), HOME_FRAGMENT)
        } else if (id == R.id.nav_notices) {
            setFragment(NoticesFragment(), NOTICES_FRAGMENT)
        } else if (id == R.id.nav_my_atttempted_exams) {
            setFragment(ExamsAttemptedFragment(), EXAMS_ATTEMPTED_FRAGMENT)
        } else if (id == R.id.nav_my_rewards) {

        } else if (id == R.id.nav_my_wishlist) {

        } else if (id == R.id.nav_my_account) {

        } else if (id == R.id.nav_sign_out) {
        }
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerView.isDrawerOpen(GravityCompat.START)) {
            drawerView.closeDrawer(GravityCompat.START)
        } else {
            if (currentFragment == HOME_FRAGMENT) {
                currentFragment = -1
                super.onBackPressed()
            } else {
                invalidateOptionsMenu()
                setFragment(HomeFragment(), HOME_FRAGMENT)
                navigationView.menu.getItem(0).isChecked = true
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (currentFragment == HOME_FRAGMENT) {
            supportActionBar!!.setDisplayShowTitleEnabled(true)
            menuInflater.inflate(R.menu.main, menu)
        }
        return true
    }

    private fun setFragment(fragment: Fragment, fragmentNo: Int) {
        if (fragmentNo != currentFragment) {
            currentFragment = fragmentNo
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            fragmentTransaction.replace(mainActivityFrameLayout.getId(), fragment)
            fragmentTransaction.commit()
        }
    }

    override fun onAttemptedTestOnClick(attemmptedTestItem: ExamsAttemptedResponse) {
        val fragment = TestAnalyticsContainerFragment()
        var bundle = Bundle()
        bundle.putParcelable("attemptedTestItem_ket", attemmptedTestItem)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(mainActivityFrameLayout.id, fragment).commit()

    }
}