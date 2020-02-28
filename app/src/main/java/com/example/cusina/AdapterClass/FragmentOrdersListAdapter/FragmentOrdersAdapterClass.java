package com.example.cusina.AdapterClass.FragmentOrdersListAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

import java.text.DecimalFormat;

public class FragmentOrdersAdapterClass extends RecyclerView.Adapter<FragmentOrdersAdapterClass.ViewHolder> {
    private Context context;
    private FragmentOrdersModalClass[] modalClasses;
    private ImageButton closeImgBtn;
    private Button submitBtn;
    private RatingBar ratingBar;
    private ViewStub viewStub;
    private Activity activity;
    private int check;

    public FragmentOrdersAdapterClass(Activity context, FragmentOrdersModalClass[] modalClasses, int check) {
        this.activity = context;
        this.modalClasses = modalClasses;
        this.check = check;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_list_on_fragment_button_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DecimalFormat dFormat = new DecimalFormat("#0.00");

        holder.productImg.setImageResource(modalClasses[position].getImageName());
        holder.prooductName.setText(modalClasses[position].getProductName());
        holder.productCount.setText(String.valueOf(modalClasses[position].getOrderCount()));
        holder.productPrice.setText(String.valueOf(dFormat.format(modalClasses[position].getProductPrice())));
        holder.productSubTotalPrice.setText(dFormat.format(modalClasses[position].getProductSubTotalPrice()));
        holder.deliveryFees.setText(dFormat.format(modalClasses[position].getDeliveryFees()));

        switch (check) {
            case 1:
                holder.productNameCancelled.setVisibility(View.GONE);
                holder.productNameProcessing.setVisibility(View.GONE);
                holder.productNameDelivered.setVisibility(View.VISIBLE);
                holder.rateDishBtn.setVisibility(View.VISIBLE);
                break;
            case 2:
                holder.productNameCancelled.setVisibility(View.VISIBLE);
                holder.productNameProcessing.setVisibility(View.GONE);
                holder.productNameDelivered.setVisibility(View.GONE);
                holder.rateDishBtn.setVisibility(View.GONE);
                break;
            case 3:
                holder.productNameCancelled.setVisibility(View.GONE);
                holder.productNameProcessing.setVisibility(View.VISIBLE);
                holder.productNameDelivered.setVisibility(View.GONE);
                holder.rateDishBtn.setVisibility(View.GONE);
                break;
        }

        holder.rateDishBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View popUpView = inflater.inflate(R.layout.add_review_layout,null);

                int width = LinearLayout.LayoutParams.MATCH_PARENT;
                int height = LinearLayout.LayoutParams.MATCH_PARENT;
                boolean focusable = true;

                UtilClass.fullsreenui(activity,"#99000000");

                final PopupWindow popupWindow = new PopupWindow(popUpView,width,height,focusable);

                // Popup Object Id

                viewStub = popUpView.findViewById(R.id.layout_stub);

                viewStub.setLayoutResource(R.layout.set_review_layout_for_dish);
                View inflated = viewStub.inflate();

                closeImgBtn = popUpView.findViewById(R.id.closeImgBtn);
                submitBtn = popUpView.findViewById(R.id.submitBtn);
                ratingBar = inflated.findViewById(R.id.ratingBarDish);

                //float rating = ratingBar.getRating();

                //System.out.println(rating);

                popupWindow.showAtLocation(popUpView, Gravity.CENTER,0,0);

                popupWindow.setOutsideTouchable(false);

                closeImgBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        UtilClass.fullsreenui(activity,"#FFFFFF");
                    }
                });

                submitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        UtilClass.fullsreenui(activity,"#FFFFFF");
                    }
                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return modalClasses.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView productImg;
        TextView prooductName,productCount,productPrice, productSubTotalPrice,deliveryFees;
        Button rateDishBtn;
        // For Visibility Gone
        TextView productNameCancelled,productNameProcessing,productNameDelivered;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.productImg = itemView.findViewById(R.id.productImg);
            this.prooductName = itemView.findViewById(R.id.productName);
            this.productCount = itemView.findViewById(R.id.productCount);
            this.productPrice = itemView.findViewById(R.id.productPriceOrdered);
            this.productSubTotalPrice = itemView.findViewById(R.id.subTotal);
            this.deliveryFees = itemView.findViewById(R.id.DeliveryFees);
            this.rateDishBtn = itemView.findViewById(R.id.RateDish);
            this.productNameProcessing = itemView.findViewById(R.id.productNameProcessingDeliveryAndPickup);
            this.productNameCancelled = itemView.findViewById(R.id.productNameCancelled);
            this.productNameDelivered = itemView.findViewById(R.id.productNameDelivered);
        }
    }

}
