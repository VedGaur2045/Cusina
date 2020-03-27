package com.lutongbahay.main.fragments.profile_frag.mvvm;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.lutongbahay.R;
import com.lutongbahay.adapter.OrderTabsViewPagerAdapter;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.main.fragments.cancelled_order.CancelledOrderFragment;
import com.lutongbahay.main.fragments.completed_order.CompletedOrderFragment;
import com.lutongbahay.main.fragments.menu.MenuFragment;
import com.lutongbahay.main.fragments.orders.OrdersFragment;
import com.lutongbahay.main.fragments.process_order_from_seller.ProcessOrderFragment;
import com.lutongbahay.main.fragments.processing_order.ProcessingOrderFragment;
import com.lutongbahay.main.fragments.profile_frag.ProfileFragmentDirections;
import com.lutongbahay.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileFragView extends FrameLayout {
    private final ProfileFragViewModel viewModel;
    @BindView(R.id.userImage)
    ImageView userImage;
    @BindView(R.id.heartImg)
    ImageView heartImg;
    @BindView(R.id.chatImg)
    ImageView chatImg;

    @BindView(R.id.setting)
    RelativeLayout settings;
    @BindView(R.id.sellfood)
    RelativeLayout sellFood;
    @BindView(R.id.savedplace)
    RelativeLayout savedPlace;
    @BindView(R.id.fbbuuton)
    RelativeLayout fbButton;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.editprofile)
    TextView editProfile;
    @BindView(R.id.usermobile)
    TextView userMobile;
    @BindView(R.id.useremail)
    TextView userEmail;
    @BindView(R.id.AddNewLuto)
    TextView AddNewLuto;
    @BindView(R.id.un_registered_layout)
    RelativeLayout unRegisteredLayout;
    @BindView(R.id.more_less_tv)
    TextView moreLessTv;
    @BindView(R.id.server_info_basic_details_view)
    LinearLayout serverInfoBasicDetailsView;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.registered_layout)
    RelativeLayout registeredLayout;
    Context context;
    @BindView(R.id.profile_review_section)
    RelativeLayout reviewSection;

    FragmentManager childManager;


    public ProfileFragView(@NonNull Context context, ProfileFragViewModel viewModel,FragmentManager childManager) {
        super(context);
        this.viewModel = viewModel;
        this.context = context;
        this.childManager = childManager;
        inflate(context, R.layout.fragment_user_profile, this);
        ButterKnife.bind(this, this);

        //AddNewLuto.setVisibility(VISIBLE);

        if (Constants.isRegistered){
            setUpRegisteredView();
        }else{
            setUpUnRegisteredView();
        }

    }

    @OnClick({R.id.setting, R.id.sellfood, R.id.savedplace, R.id.AddNewLuto,R.id.more_less_tv})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.setting:
                Navigation.findNavController(view).navigate(ProfileFragmentDirections.openSettings());
                break;
            case R.id.sellfood:
                Navigation.findNavController(view).navigate(ProfileFragmentDirections.SellFood());
                break;
            case R.id.savedplace:
                Navigation.findNavController(view).navigate(ProfileFragmentDirections.savedPlaced());
                break;
            case R.id.AddNewLuto:
                Bundle bundle = new Bundle();
                bundle.putInt("openPhotos",11);
                bundle.putString("titleName",CusinaApplication.getInstance().getString(R.string.addDishPhoto));
                bundle.putString("text_1",CusinaApplication.getInstance().getString(R.string._allPhoto));
                bundle.putString("text_2",CusinaApplication.getInstance().getString(R.string._choosePhotoTxt));
                bundle.putString("text_3",CusinaApplication.getInstance().getString(R.string._minimumPhotoTxt));
                Navigation.findNavController(view).navigate(R.id.AddPhotoFragment,bundle);
                break;
            case R.id.more_less_tv:
                showHideBasicDetails();
                break;
        }
    }

    public void setUpRegisteredView(){
        AddNewLuto.setVisibility(VISIBLE);
        reviewSection.setVisibility(VISIBLE);
        unRegisteredLayout.setVisibility(GONE);
        registeredLayout.setVisibility(VISIBLE);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setUpUnRegisteredView(){
        AddNewLuto.setVisibility(GONE);
        reviewSection.setVisibility(GONE);
        unRegisteredLayout.setVisibility(VISIBLE);
        registeredLayout.setVisibility(GONE);
    }

    public void showHideBasicDetails(){
        if (moreLessTv.getText().toString().equalsIgnoreCase("Show more")){
            serverInfoBasicDetailsView.setVisibility(VISIBLE);
            moreLessTv.setText(R.string._showLess);
        }else{
            serverInfoBasicDetailsView.setVisibility(GONE);
            moreLessTv.setText(R.string._showMore);
        }
    }


    private void setupViewPager(ViewPager viewPager) {
        OrderTabsViewPagerAdapter adapter = new OrderTabsViewPagerAdapter(childManager);
        adapter.addFragment(new MenuFragment(),"Menu");
        adapter.addFragment(new OrdersFragment(), "Orders");
        adapter.addFragment(new Fragment(),"About");
        viewPager.setAdapter(adapter);
    }
}
