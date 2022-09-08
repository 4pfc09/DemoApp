package com.example.demoapp.services;

import com.example.demoapp.model.Content;

import java.util.List;

public interface IContentsService {

    List<Content> getContentsById(int cabinaId);


}
