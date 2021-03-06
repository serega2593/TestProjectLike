package com.serhii.strila.testproject.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.serhii.strila.testproject.R;
import com.serhii.strila.testproject.ui.adapter.SectionsPagerAdapter;
import com.serhii.strila.testproject.ui.fragment.MapFragment;
import com.serhii.strila.testproject.ui.fragment.PersonsListFragment;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tabs)
    TabLayout mTabs;
    @Bind(R.id.container)
    ViewPager mViewPager;
    @BindString(R.string.main_activity_tab_list)
    String tabList;
    @BindString(R.string.main_activity_tab_map)
    String tabMap;

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
        sectionsPagerAdapter.addFragment(PersonsListFragment.newInstance(), tabList);
        sectionsPagerAdapter.addFragment(MapFragment.newInstance(), tabMap);
        mViewPager.setAdapter(sectionsPagerAdapter);
        mTabs.setupWithViewPager(mViewPager);
    }

}
