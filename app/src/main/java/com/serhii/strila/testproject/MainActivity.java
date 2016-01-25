package com.serhii.strila.testproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tabs)
    TabLayout mTabs;
    @Bind(R.id.container)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        initPager();
    }

    private void initPager() {
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(
                getSupportFragmentManager());
        sectionsPagerAdapter.addFragment(ListUsersFragment.newInstance(), "List");
        sectionsPagerAdapter.addFragment(MapFragment.newInstance(), "Map");
        mViewPager.setAdapter(sectionsPagerAdapter);
        mTabs.setupWithViewPager(mViewPager);
    }

}
