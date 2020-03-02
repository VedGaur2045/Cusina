package com.lutongbahay.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import com.lutongbahay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */


public class ProgressDialogFragment extends DialogFragment {
    public static final String TAG = ProgressDialogFragment.class.getSimpleName();

    // Note: only the system can call this constructor by reflection.
    public ProgressDialogFragment() {
    }

    private Builder builder;

    private Unbinder unbinder;

    @BindView(R.id.progress_dialog_progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.progress_dialog_title)
    TextView title;

    private static ProgressDialogFragment instance = new ProgressDialogFragment();

    public static ProgressDialogFragment getInstance() {
        return instance;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        this.setCancelable(true);

        if (savedInstanceState != null) {
            if (builder != null) {
                builder = savedInstanceState.getParcelable(Builder.class.getSimpleName());
            }
        }
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (builder != null)
            outState.putParcelable(Builder.class.getSimpleName(), builder);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_progress_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        if (builder != null) {
            if (builder.getTextTitle() != null) {
                title.setText(builder.getTextTitle());
            } else {
                title.setVisibility(View.GONE);
            }
        }
    }

    private Dialog show(Activity activity, Builder builder) {
        this.builder = builder;
        if (!isAdded())
            show(((AppCompatActivity) activity).getSupportFragmentManager(), TAG);
        return getDialog();
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        if (dialog.getWindow() != null) {
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener((dialog1, keyCode, event) -> {
            // Disable Back key and Search key
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                case KeyEvent.KEYCODE_SEARCH:
                    return true;
                default:
                    return false;
            }
        });
        return dialog;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    public static class Builder implements Parcelable {

        private String textTitle;
        private Context context;

        protected Builder(Parcel in) {
            textTitle = in.readString();
        }

        public static final Creator<Builder> CREATOR = new Creator<Builder>() {
            @Override
            public Builder createFromParcel(Parcel in) {
                return new Builder(in);
            }

            @Override
            public Builder[] newArray(int size) {
                return new Builder[size];
            }
        };

        public String getTextTitle() {
            return textTitle;
        }

        public Builder setTextTitle(String textTitle) {
            this.textTitle = textTitle;
            return this;
        }

        public Builder build() {
            return this;
        }

        public Context getContext() {
            return context;
        }

        public Builder setActivity(Context context) {
            this.context = context;
            return this;
        }

        public Builder(Context context) {
            this.context = context;
        }

        public Dialog show() {
            return ProgressDialogFragment.getInstance().show(((Activity) context), this);
        }

        public void dismiss() {
            try {
                ProgressDialogFragment.getInstance().dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(textTitle);
        }
    }


    public static void showProgressDialog(@NonNull Context context, String title) {
        try {
            Builder alert = new Builder(context)
                    .setTextTitle(title)
                    .build();
            alert.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dismissProgressDialog(@NonNull Context context) {
        new Builder(context).build().dismiss();
    }
}
