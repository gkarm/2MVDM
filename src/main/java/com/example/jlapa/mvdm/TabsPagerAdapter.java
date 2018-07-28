package com.example.jlapa.mvdm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


class TabsPagerAdapter extends FragmentPagerAdapter {



    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                CameraFragment cameraFragment = new CameraFragment();
                return cameraFragment;

            case 1:
                EditFragment editFragment = new EditFragment();
                return editFragment;
            case 2:
                ShareFragment shareFragment = new ShareFragment();
                return shareFragment;
            default:
                return null;

        }
    }



    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){

        switch (position){
            case 0:
                return "Camera";
            case 1:
                return "Edit";
            case 2:
                return "Share";
            default:
                return null;
        }

    }
}
