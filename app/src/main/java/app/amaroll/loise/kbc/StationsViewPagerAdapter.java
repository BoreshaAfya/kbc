package app.amaroll.loise.kbc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import app.amaroll.loise.kbc.Fragments.radio;
import app.amaroll.loise.kbc.Fragments.tv;

/**
 * Created by muli on 9/23/2015.
 */
public class StationsViewPagerAdapter extends FragmentStatePagerAdapter{
    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    public StationsViewPagerAdapter(FragmentManager fm, CharSequence mTitles[],int mNumbOfTabsumb ) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
    }


    @Override
    public Fragment getItem(int position) {
        if(position == 0) // if the position is 0 we are returning the First tab
        {
            tv tvtab = new tv();
            return tvtab;
        }
        else   // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            radio radiotab = new radio();
            return radiotab;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }



    @Override
    public int getCount() {

        return NumbOfTabs;
    }
}
