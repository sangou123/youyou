package com.example.mall;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mall.adter.FragmentAdater;
import com.example.mall.framenters.cart.CartFragment;
import com.example.mall.framenters.classifc.ClassifcFragment;
import com.example.mall.framenters.home.HomesFragment;
import com.example.mall.framenters.my.MyFragment;
import com.example.mall.framenters.special.SpecialFrament;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView too_title;
    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        too_title = (TextView) findViewById(R.id.too_title);
        vp = (ViewPager) findViewById(R.id.main_vp);
        tab = (TabLayout) findViewById(R.id.main_tab);
        List<Fragment> list = new ArrayList<>();
        list.add(new HomesFragment());
        list.add(new SpecialFrament());
        list.add(new ClassifcFragment());
        list.add(new CartFragment());
        list.add(new MyFragment());
        List<String> listtitle = new ArrayList<>();

        listtitle.add("首页");
        listtitle.add("专题");
        listtitle.add("分类");
        listtitle.add("购物");
        listtitle.add("我的");
        FragmentAdater fragmentAdater = new FragmentAdater(getSupportFragmentManager(), list, listtitle);
        vp.setAdapter(fragmentAdater);

        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setIcon(R.drawable.tabimg);
        tab.getTabAt(1).setIcon(R.drawable.tabimg2);
        tab.getTabAt(2).setIcon(R.drawable.tabimg3);
        tab.getTabAt(3).setIcon(R.drawable.tabimg3);
        tab.getTabAt(4).setIcon(R.drawable.tabimg4);
    }
}