package com.example.cusina.Fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;

import com.asksira.bsimagepicker.BSImagePicker;
import com.bumptech.glide.Glide;
import com.example.cusina.Activities.AddPhotoActivity;
import com.example.cusina.AdapterClass.MenuListItemProfileAdapterPackage.menuListItemOnProfileAdapter;
import com.example.cusina.AdapterClass.MenuListItemProfileAdapterPackage.menuListItemOnProfileModel;
import com.example.cusina.R;

import java.util.ArrayList;
import java.util.List;

public class MenuListFragment extends Fragment  implements BSImagePicker.OnSingleImageSelectedListener,
        BSImagePicker.OnMultiImageSelectedListener,
        BSImagePicker.ImageLoaderDelegate {

    private SearchView searchView;
    private Button addNewLutoBtn;
    private GridView gridViewItem;

    private ArrayList<menuListItemOnProfileModel> modelArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_menu_list, container, false);

        setObjectId(mView);

        modelArrayList.clear();

        for(int i=0;i<12;i++){
            menuListItemOnProfileModel model = new menuListItemOnProfileModel("ABC",40.00,5,"1 day ago",5,R.mipmap.item_name,false);
            modelArrayList.add(model);
        }

        gridViewItem.setAdapter(new menuListItemOnProfileAdapter(getContext(),modelArrayList));

        gridViewItem.smoothScrollBy(0, 0);

        addNewLutoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewLutoBtnOnClick(view);
            }
        });

        return mView;
    }

    private void setObjectId(View mView){
        searchView = mView.findViewById(R.id.searchViewProfile);
        addNewLutoBtn = mView.findViewById(R.id.AddNewLuto);
        gridViewItem = mView.findViewById(R.id.gridViewMenuList);
    }

    private void addNewLutoBtnOnClick(View view){
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int height = displayMetrics.heightPixels;
//
//        BSImagePicker.Builder builder = new BSImagePicker.Builder("com.example.lutongbahay");
//        builder.setPeekHeight(height);
//        builder.setSpanCount(5);
//        builder.setGridSpacing(Utils.dp2px(3));
//        builder.setPeekHeight(Utils.dp2px(height));
//        builder.useFrontCamera();
//        builder.hideGalleryTile();
//        builder.dontDismissOnSelect();
//
//        BSImagePicker singleSelectionPicker = builder.build();
//
//        singleSelectionPicker.show(getChildFragmentManager(),"picker");

        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(getActivity(), R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        getContext().startActivity(new Intent(getContext(), AddPhotoActivity.class),bndlAnimation);
    }

    @Override
    public void loadImage(Uri imageUri, ImageView ivImage) {
        Glide.with(getContext()).load(imageUri).into(ivImage);
    }

    @Override
    public void onMultiImageSelected(List<Uri> uriList, String tag) {

    }

    @Override
    public void onSingleImageSelected(Uri uri, String tag) {

    }
}
