package com.cfi.teamwarrior.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cfi.teamwarrior.R;
import com.cfi.teamwarrior.model.JobList;

import java.util.List;

/**
 * Created by vipulkanade on 5/12/15.
 */
public class ListAdapter extends ArrayAdapter {

    private Context mContext;
    private int iLayoutResId;
    private List<? extends Object> mListItems;

    private TextView mTextView;

    public ListAdapter(Context context, List<? extends Object> listItems) {
        super(context, R.layout.list_item);
        this.mContext 		= context;
        this.iLayoutResId 	= R.layout.list_item;
        this.mListItems 	= listItems;
    }

    @Override
    public int getCount() {
        return mListItems.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Object obj = mListItems.get(position);

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(iLayoutResId, null);
            LinearLayout oListItemLayout = (LinearLayout) convertView.findViewById(R.id.list_item_layout);
        }

        mTextView = (TextView) convertView.findViewById(R.id.list_item_text);

        if (obj instanceof JobList) {
            JobList getJob = (JobList) obj;
            String setTextString = "Name : " + getJob.getEmployeeName()  + "\nPrice : " + getJob.getWage();
            mTextView.setText(setTextString);
        }
        return convertView;
    }
}
