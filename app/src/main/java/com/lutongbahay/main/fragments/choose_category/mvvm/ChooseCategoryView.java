package com.lutongbahay.main.fragments.choose_category.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.ChooseCategoryRecyclerAdapter;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.main.fragments.choose_category.ChooseCategoryFragmentDirections;
import com.lutongbahay.utils.Constants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseCategoryView extends FrameLayout {
    private final ChooseCategoryViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.imageFirst)
    ImageView imageFirst;
    @BindView(R.id.imageSecond)
    ImageView imageSecond;
    @BindView(R.id.imageThird)
    ImageView imageThird;
    @BindView(R.id.searchViewHome)
    SearchView searchViewHome;
    @BindView(R.id.listView)
    RecyclerView listView;

    public ChooseCategoryView(@NonNull Context context, ChooseCategoryViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_choose_category, this);
        ButterKnife.bind(this,this);

        titleName.setText(R.string.choose_category);
        closeImgBtn.setVisibility(GONE);

        dishCategory((AppCompatActivity) context, Constants.TOKEN);

    }

    @OnClick({R.id.backBtnImg,R.id.imageSecond,R.id.imageThird,R.id.imageFirst})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.backBtnImg:
            case R.id.imageFirst:
            case R.id.imageSecond:
            case R.id.imageThird:
                Navigation.findNavController(view).navigate(ChooseCategoryFragmentDirections.toCameraFragment());
                break;
        }
    }

    public void dishCategory(AppCompatActivity compatActivity, String token){
        ArrayList<String> dishCategoryList = new ArrayList<>();
        viewModel.dishCategory(compatActivity, token).observe(compatActivity, responseDishCategory -> {
            if(responseDishCategory == null){
                showErrorAlert(compatActivity, "Oops!! Server error occurred. Please try again.");
            } else {
                if (!responseDishCategory.getSuccess()){
                    showErrorAlert(compatActivity, responseDishCategory.getMessage());
                } else {
                    System.out.println("Total SIze of : "+responseDishCategory.getData().size());
                    for(int i=0; i<responseDishCategory.getData().size();i++) {
                        dishCategoryList.add(responseDishCategory.getData().get(i).getName());
                        System.out.println("dishCategoryList : "+responseDishCategory.getData().get(i).getName());
                    }
                    ChooseCategoryRecyclerAdapter chooseCategoryRecyclerAdapter = new ChooseCategoryRecyclerAdapter(dishCategoryList);
                    listView.setAdapter(chooseCategoryRecyclerAdapter);
                }
            }
            ProgressDialogFragment.dismissProgressDialog(compatActivity);
        });
    }

    public void showErrorAlert(Context context, String errorMessage) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, "Error", errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }

}
