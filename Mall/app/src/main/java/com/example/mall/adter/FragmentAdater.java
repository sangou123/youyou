package com.example.mall.adter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentAdater extends FragmentPagerAdapter {
    private List<Fragment>list;
    private List<String>listtitle;

    public FragmentAdater(@NonNull FragmentManager fm) {
        super(fm);
    }

    public FragmentAdater(@NonNull FragmentManager fm, List<Fragment> list, List<String> listtitle) {
        super(fm);
        this.list = list;
        this.listtitle = listtitle;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listtitle.get(position);
    }
}
