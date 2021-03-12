package com.example.movedatabase.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.movedatabase.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3,R.string.tab_text_4};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
   if(position==0){
       HomeFragment homeFragment = new HomeFragment();
   return homeFragment;}
   else if(position==1){
       MoviesFragment moviesFragment= new MoviesFragment();
       return moviesFragment;}
   else if (position==2){
       TVFragment tvFragment = new TVFragment();
   return tvFragment;}
   else {
       CelebsFragment celebsFragment = new CelebsFragment();
       return celebsFragment;
   }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
           return "HOME";}
        else if(position==1){
         return "MOVIES";}
        else if (position==2){
        return "TV";}
        else {
            return "CELEBS";
        }
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}