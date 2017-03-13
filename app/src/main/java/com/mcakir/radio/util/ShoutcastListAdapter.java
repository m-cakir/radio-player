package com.mcakir.radio.util;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mcakir.radio.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoutcastListAdapter extends BaseAdapter {

    private Activity activity;

    private List<Shoutcast> shoutcasts = new ArrayList<>();

    public ShoutcastListAdapter(Activity activity, List<Shoutcast> shoutcasts){
        this.activity = activity;
        this.shoutcasts = shoutcasts;
    }

    @Override
    public int getCount() {
        return shoutcasts.size();
    }

    @Override
    public Object getItem(int position) {
        return shoutcasts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();

        ViewHolder holder;

        if (view != null) {

            holder = (ViewHolder) view.getTag();

        } else {

            view = inflater.inflate(R.layout.list_item, parent, false);

            holder = new ViewHolder(view);

            view.setTag(holder);

        }

        Shoutcast shoutcast = (Shoutcast) getItem(position);
        if(shoutcast == null){

            return view;

        }

        holder.text.setText(shoutcast.getName());

        return view;
    }

    static class ViewHolder {

        @BindView(R.id.text)
        TextView text;

        public ViewHolder(View view) {

            ButterKnife.bind(this, view);

        }
    }
}
