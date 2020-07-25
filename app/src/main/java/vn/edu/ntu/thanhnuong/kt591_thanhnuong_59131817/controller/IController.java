package vn.edu.ntu.thanhnuong.kt591_thanhnuong_59131817.controller;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.thanhnuong.kt591_thanhnuong_59131817.model.Item;

public interface IController {
    public List<Item> getAllGiaVang();
    public boolean addGiaVang (Item i);
}
