package vn.edu.ntu.thanhnuong.kt591_thanhnuong_59131817.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.thanhnuong.kt591_thanhnuong_59131817.model.Item;

public class Controller extends Application implements IController {
    List<Item> list = new ArrayList<>();

    public Controller() {
        list.add(new Item("9/7/2020", "Thế giới", "4500", "4700"));
    }

    public Controller(List<Item> list) {
        this.list = list;
    }

    @Override
    public List<Item> getAllGiaVang() {
        return list;
    }

    @Override
    public boolean addGiaVang(Item i) {
        if(!list.contains(i)){
            list.add(i);
            return true;
        }return false;
    }
}
