package com.example.a2cm.coursedesign;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.widget.TabHost;

/**
 * Created by 2cm on 2017/5/22.
 */

public class FragmentTabs extends FragmentActivity {
    private TabHost tabHost;
    private TabManager mTabManager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        tabHost=(TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabManager tab_one=new TabManager(this,tabHost,R.id.tab1);
        TabManager tab_two=new TabManager(this,tabHost,R.id.tab2);
        TabManager tab_three=new TabManager(this,tabHost,R.id.tab3);
        mTabManager = new TabManager(this, tabHost,R.id.tab1);
        tabHost.setCurrentTab(0);
        mTabManager.addTab(
                tabHost.newTabSpec("Fragment1").setIndicator("Fragment1",this.getResources().getDrawable(
                        android.R.drawable.ic_dialog_alert)),tab_one.getClass(),null);
    }
}
