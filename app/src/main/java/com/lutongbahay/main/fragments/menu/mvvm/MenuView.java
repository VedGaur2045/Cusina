package com.lutongbahay.main.fragments.menu.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.ServerMenuRecyclerAdapter;
import com.lutongbahay.helper.GridSpacingItemDecoration;
import com.lutongbahay.list.MenuListItemAdapter;
import com.lutongbahay.main.fragments.menu.MenuFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuView extends FrameLayout {
    private final MenuViewModel viewModel;
    @BindView(R.id.searchViewProfile)
    SearchView searchViewProfile;
    @BindView(R.id.menu_rv)
    RecyclerView gridViewMenuList;

    public MenuView(@NonNull Context context, MenuViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_menu,this);
        ButterKnife.bind(this,this);

        int spanCount = 2; // 3 columns
        int spacing = 20; // 50px
        boolean includeEdge = false;
        gridViewMenuList.setLayoutManager(new GridLayoutManager(context, 2));

        gridViewMenuList.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        ServerMenuRecyclerAdapter serverMenuRecyclerAdapter = new ServerMenuRecyclerAdapter();
        gridViewMenuList.setAdapter(serverMenuRecyclerAdapter);
//
//        MenuListItemAdapter menuListItemAdapter = new MenuListItemAdapter(context);
//        gridViewMenuList.setAdapter(menuListItemAdapter);

    }

}
