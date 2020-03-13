package com.lutongbahay.main.fragments.menu.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.list.MenuListItemAdapter;
import com.lutongbahay.main.fragments.menu.MenuFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuView extends FrameLayout {
    private final MenuViewModel viewModel;
    @BindView(R.id.searchViewProfile)
    SearchView searchViewProfile;
    @BindView(R.id.gridViewMenuList)
    GridView gridViewMenuList;

    public MenuView(@NonNull Context context, MenuViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_menu,this);
        ButterKnife.bind(this,this);

        MenuListItemAdapter menuListItemAdapter = new MenuListItemAdapter();
        gridViewMenuList.setAdapter(menuListItemAdapter);

    }

}
