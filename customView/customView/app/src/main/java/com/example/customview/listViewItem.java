package com.example.customview;

import android.graphics.drawable.Drawable;
import android.telephony.mbms.StreamingServiceInfo;

public class listViewItem {
    private Drawable iconDrawable;
    private String titleStr;
    private String descStr;

    public void setIcon(Drawable icon){
        iconDrawable =icon;
    }

    public void setDescStr(String desc) {
        descStr = desc;
    }

    public void getTitle(String title) {
        titleStr= title;
    }

    public Drawable getIcon(){
        return this.iconDrawable;
    }
    public String getTitle(){
        return this.titleStr;
    }
    public String getDesc(){
        return this.descStr;
    }









}
