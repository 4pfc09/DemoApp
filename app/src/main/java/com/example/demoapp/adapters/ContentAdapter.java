package com.example.demoapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.demoapp.R;
import com.example.demoapp.model.Content;
import com.example.demoapp.services.ContentsService;
import com.example.demoapp.services.IContentsService;

import java.util.List;

public class ContentAdapter extends BaseAdapter {
    IContentsService contentsService;
    List<Content> contentList;
    private Context context;


    public ContentAdapter(){
        contentsService = new ContentsService();
    }
    public ContentAdapter(Context context) {
        contentsService = new ContentsService();
        this.context = context;
        //TODO necesito obtener el índice de la tab y en función de eso buscar los contenidos
        //No sé si es conveniente hacerlo aquí...
        contentList = contentsService.getContentsById(1);
    }

    @Override
    public int getCount() {
        return contentList.size();
    }

    @Override
    public Object getItem(int i) {
        return contentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return contentList.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imgview = new ImageView(this.context);
        imgview.setLayoutParams(new GridView.LayoutParams(300, 500));
        imgview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgview.setPadding(10,10,10, 10);
        imgview.setImageResource(
                contentList.get(position).getResourceInt());
        return imgview;
    }
}
