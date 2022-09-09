package com.example.demoapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.demoapp.R;
import com.example.demoapp.model.Content;
import com.example.demoapp.services.ContentsService;
import com.example.demoapp.services.IContentsService;

import java.util.List;

public class ContentAdapter extends BaseAdapter {
    IContentsService contentsService;
    List<Content> contentList;
    private Context context;
    private int cabinaId;
    //++
    private LayoutInflater layoutInflater;
    private  static  String CONTENT_ADAPTER_TAG = "ContentAdapter";


    public ContentAdapter(){
        contentsService = new ContentsService();
    }
    public ContentAdapter(Context context, int cabinaId) {
        contentsService = new ContentsService();
        this.context = context;
        this.cabinaId= cabinaId;
        this.layoutInflater = LayoutInflater.from(context);

        contentList = contentsService.getContentsById(this.cabinaId);
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

    //https://developer.android.com/reference/android/widget/Adapter#getView(int,%20android.view.View,%20android.view.ViewGroup)
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
     //   view = layoutInflater.inflate(R.layout.fragment_item_grid, null);
        https://developer.android.com/reference/android/view/LayoutInflater#inflate(int,%20android.view.ViewGroup)
        view = layoutInflater.inflate(R.layout.fragment_item_grid, viewGroup, false);
       LinearLayout itemGridHolderLayout = view.findViewById(R.id.itemGridHolderLayout);
      itemGridHolderLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Log.println(Log.DEBUG, CONTENT_ADAPTER_TAG, "Item grid onclick");
          }
      });

       ImageView imgview = view.findViewById(R.id.imgViewItemGrid);
             imgview.setImageResource(
                contentList.get(position).getResourceInt());
        TextView textViewCaption = view.findViewById(R.id.textViewCaption);
        textViewCaption.setText(contentList.get(position).getCaption());
        return itemGridHolderLayout;
    }


}
