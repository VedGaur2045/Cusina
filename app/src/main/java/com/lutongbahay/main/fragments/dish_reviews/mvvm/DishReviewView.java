package com.lutongbahay.main.fragments.dish_reviews.mvvm;

import android.content.Context;
import android.media.Rating;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DishReviewView extends FrameLayout {
    private final DishReviewViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.givenAllReviewCount)
    ImageButton givenAllReviewCount;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.allReviewByUserCount)
    TextView allReviewByUserCount;
    @BindView(R.id.RateServer)
    TextView RateServer;
    @BindView(R.id._1_review_total_count)
    TextView _1_review_total_count;
    @BindView(R.id._2_review_total_count)
    TextView _2_review_total_count;
    @BindView(R.id._3_review_total_count)
    TextView _3_review_total_count;
    @BindView(R.id._4_review_total_count)
    TextView _4_review_total_count;
    @BindView(R.id._5_review_total_count)
    TextView _5_review_total_count;
    @BindView(R.id.reviewMsgListView)
    RecyclerView reviewMsgListView;

    public DishReviewView(@NonNull Context context, DishReviewViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_dish_review,this);
        ButterKnife.bind(this,this);
    }
}
