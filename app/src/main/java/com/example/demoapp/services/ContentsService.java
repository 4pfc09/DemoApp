package com.example.demoapp.services;

import com.example.demoapp.R;
import com.example.demoapp.model.Content;

import java.util.ArrayList;
import java.util.List;

public class ContentsService implements IContentsService {



    //For testing
    private ArrayList<Content> contents;

    public ContentsService() {


    }

    @Override
    public List<Content> getContentsById(int cabinaId) {
        this.contents = new ArrayList<>();

        switch (cabinaId) {
            case 1:
                this.contents.add(new Content(1L, "China long message caption", R.drawable.china));
                this.contents.add(new Content(2L, "Dog", R.drawable.dog));
                this.contents.add(new Content(3L, "MonaLisa", R.drawable.monalisa));
                this.contents.add(new Content(4L, "The Thinker", R.drawable.the_thinker));
                break;
            case 2:
                this.contents.add(new Content( 5L, "Statue", R.drawable.statue));
                break;
        }
        return contents;
    }

}
