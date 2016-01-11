package com.kiwi.kiwi;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Vue principale contenant la liste des restaurants et la carte
 */
public class MainFragment extends Fragment {

    public static final String tag = "main_frag";
    public ListFragment liste;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        liste = (ListFragment) getChildFragmentManager().findFragmentByTag(ListFragment.tag);
        CarteFragment carte = (CarteFragment) getChildFragmentManager().findFragmentByTag(CarteFragment.tag);
        TriFragment tri = (TriFragment) getChildFragmentManager().findFragmentByTag(TriFragment.tag);

        if (liste == null) liste = new ListFragment();
        if (carte == null) carte = new CarteFragment();
        if (tri == null) tri = new TriFragment();

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(liste, "Liste");
        adapter.addFragment(carte, "Carte");
        adapter.addFragment(tri, "Tri");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    public void triPrix(){
        liste.triPrix();
    }

    public void triAttente(){
        liste.triAttente();
    }

    public void triAller(){
        liste.triAller();
    }

    /**
     * Gère les onglets
     */
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
