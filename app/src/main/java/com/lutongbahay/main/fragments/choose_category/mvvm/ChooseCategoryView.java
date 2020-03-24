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

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjllODAxYTkwZjJjZDg0ZDI1ZWE1YTZhNmE0YTBmNjE0NzBmYTcyMTE1ZWJkY2FkM2JlNmQ0ZDVlMzE0NjQ4NmI3NWMwMjZmMTEwZDQ0Mjk4In0.eyJhdWQiOiIyIiwianRpIjoiOWU4MDFhOTBmMmNkODRkMjVlYTVhNmE2YTRhMGY2MTQ3MGZhNzIxMTVlYmRjYWQzYmU2ZDRkNWUzMTQ2NDg2Yjc1YzAyNmYxMTBkNDQyOTgiLCJpYXQiOjE1ODM2OTI0NjUsIm5iZiI6MTU4MzY5MjQ2NSwiZXhwIjoxNjE1MjI4NDY1LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.WsVHwfus2vs9gA0fbiv5LVmOFhhUmn28OrnKtXx_e5O7VCOy3fQ_plRXJiLNkatGBnGBCSgny-bjI1kUOf_6m9e1Vou17WT6ouGdUZQCA5Kp0gLnxPrCLveop4qqwBGR_tl0Myvphz1UCTnHuciePYtQaqyrsuAV3ub9tZf3gJcAeH3jF2hFz1gdu_r6-ZUaMcU3nKAjQXpxZtiCGUrVPwvzjQNN7nHED_EE7xXM-JQf2_qe4AS0hVfZjUWvNPDAQZ0BfiqD0xpWObMfIkGkf5C2eMRlISEhrdobHsGd7_3XyM7gKE7pm8cZqWlAPig4tHeRSa1vfEV48tbjsXi-_-Ufr4_AQmGIe4HzsrWcnQ3ZaCEiGYeBdKdkGe2xtw64mRKtIBAEupiZtAQExvCc3ziWW64_LtZZ5THWB-4PCUzPnwQTVu_ck0PKAQ87xsZyjNPNNfyjHs-ykyGoN3N3hL-c_BmoLukGu9sDCsRrFxfkQvF5AdTZvkIhANEVXpXBqQnFzK5JwaV_-xsjQKywRRBlX1s1xMNjAD5fo4wJ3bnylL1GQBIMm4tEpKZn_MzCHcJ7bhs0j7f80yj3Hr0USDdN4xmnEN5yc0R0hKSKTaO7YpNaezpAyfJPVbsXc-7qKbIyO97RwOBLHNSh5yRXD-wIssAwstyt2DwRPpPQmiQ";

        dishCategory((AppCompatActivity) context, token);

    }

    @OnClick({R.id.backBtnImg,R.id.imageSecond,R.id.imageThird})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.backBtnImg:
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
                        for(int i=0; i<responseDishCategory.getData().size();i++)
                            dishCategoryList.add(responseDishCategory.getData().get(i).getName());
                    System.out.println("Total SIze of dishCategoryList : "+dishCategoryList.size());

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
