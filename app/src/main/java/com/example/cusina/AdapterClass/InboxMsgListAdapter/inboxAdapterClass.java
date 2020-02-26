package com.example.cusina.AdapterClass.InboxMsgListAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cusina.R;

public class inboxAdapterClass extends RecyclerView.Adapter<inboxAdapterClass.ViewClass> {
    private Context context;
    private inboxModalClass[] modalClasses;

    public inboxAdapterClass(Context context, inboxModalClass[] modalClasses) {
        this.context = context;
        this.modalClasses = modalClasses;
    }

    @NonNull
    @Override
    public ViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.inbox_layout,parent,false);
        return new ViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewClass holder, int position) {
        holder.msgTxt.setText(modalClasses[position].getMegTxt());
        holder.msgDate.setText(modalClasses[position].getmsgDate());
        /*
        * msgIconimg change according to message
        * Date text change if find any promocode
        * unread msg setup */
    }

    @Override
    public int getItemCount() {
        return modalClasses.length;
    }

    public class ViewClass extends RecyclerView.ViewHolder{
        TextView msgTxt,msgDate;
        ImageView msgIconImg,unreadSetupImg;
        public ViewClass(@NonNull View itemView) {
            super(itemView);
            this.msgTxt = itemView.findViewById(R.id.msgTxtId);
            this.msgDate = itemView.findViewById(R.id.msgDateId);
            this.msgIconImg = itemView.findViewById(R.id.msgImg);
            this.unreadSetupImg = itemView.findViewById(R.id.unreadMsgId);
        }
    }

}
