package com.example.jitu.androidtablayout;

/**
 * Created by jitu on 11/30/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Belal on 2/3/2016.
 */
//Extending FragmentStatePagerAdapter
public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
               // Tab1 tab1 = new Tab1();
                return new Tab1();
            case 1:
               // Tab2 tab2 = new Tab2();
                return new Tab2();
            case 2:
               // Tab3 tab3 = new Tab3();
                return new Tab3();
            case 3:
                //Tab4 tab4 = new Tab4();
                return new Tab4();
            case 4:
                //Tab5 tab5 = new Tab5();
                return new Tab5();
            case 5:
                //Tab6 tab6 = new Tab6();
                return new Tab6();

            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}