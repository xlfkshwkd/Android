package com.example.customview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<ListViewItem>listViewlist=new ArrayList<ListViewItem>();

    public ListViewAdapter(){

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos =position;
        final Context context =parent.getContext();
        if (converView ==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }
        ImageView iconImageView=(ImageView)convertView.findViewById(R.id.imageView);
        TextView titleTextView =(TextView)convertView.findViewById(R.id.textView1);
        TextView descTextView =(TextView)convertView.findViewById(R.id.textView2);

        ListView listViewItem =listViewItemList.get(position);
        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());

        return convertView;
        }
        @Override
        public long getItemID(int position){
            return position;
        }
        @Override
        public Object getItem(int position){
            return listViewItemlist.get(position);
        }
        public void addItem(Drawable icon,String title, String desc){
        ListViewItem item = new listViewItem();
        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);

        listViewlist.add(item);
        }


    }

}

