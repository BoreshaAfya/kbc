package app.amaroll.loise.kbc.Fragments;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import app.amaroll.loise.kbc.R;
import app.amaroll.loise.kbc.SlidingTabLayout;
import app.amaroll.loise.kbc.StationsViewPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Stations extends android.support.v4.app.Fragment {
    Toolbar toolbar;
    ViewPager pager;
    StationsViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"TV","radio"};
    int Numboftabs =2;
    View rootView;


    /*public Stations() {
        // Required empty public constructor
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       rootView= inflater.inflate(R.layout.fragment_stations, container, false);

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles   the Tabs and Number Of Tabs.
       adapter= new StationsViewPagerAdapter(getChildFragmentManager(), Titles, Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) rootView.findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) rootView.findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }

        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.post(new Runnable() {
            @Override
            public void run() {
                tabs.setViewPager(pager);
            }
        });

        return rootView;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
