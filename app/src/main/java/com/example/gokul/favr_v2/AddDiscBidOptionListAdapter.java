package com.example.gokul.favr_v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by Gokul on 9/15/2015.
 */
public class AddDiscBidOptionListAdapter extends BaseAdapter {

    private MakeUserDiscoveryPostActivity adapterMakePostActivity;
    private ArrayList<Integer> adapterDeleteList;
    private ArrayList<Integer> adapterEditList;
    private ArrayList<String> adapterOptionList;


    public AddDiscBidOptionListAdapter(MakeUserDiscoveryPostActivity makePostActivity, ArrayList<Integer> deleteList, ArrayList<Integer> editList, ArrayList<String> optionList) {
        this.adapterMakePostActivity = makePostActivity;
        this.adapterDeleteList = deleteList;
        this.adapterEditList = editList;
        this.adapterOptionList = optionList;
    }

    @Override
    public int getCount() {
        return this.adapterDeleteList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(adapterMakePostActivity).inflate(R.layout.add_bid_option_row, parent, false);
        ImageButton editButton = (ImageButton) view.findViewById(R.id.btnEditOption);
        ImageButton deleteButton = (ImageButton) view.findViewById(R.id.btnDeleteOption);
        EditText editTextOption = (EditText) view.findViewById(R.id.editTextOption);


        editButton.setImageResource(this.adapterEditList.get(position));
        deleteButton.setImageResource(this.adapterDeleteList.get(position));
        editTextOption.setText(this.adapterOptionList.get(position));

        return view;    }
}
