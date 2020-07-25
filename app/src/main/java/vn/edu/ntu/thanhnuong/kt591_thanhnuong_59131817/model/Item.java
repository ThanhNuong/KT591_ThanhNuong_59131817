package vn.edu.ntu.thanhnuong.kt591_thanhnuong_59131817.model;

public class Item {
    String ngay, loai, muaVao, banRa;

    public Item() {
    }

    public Item(String ngay, String loai, String muaVao, String banRa) {
        this.ngay = ngay;
        this.loai = loai;
        this.muaVao = muaVao;
        this.banRa = banRa;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getMuaVao() {
        return muaVao;
    }

    public void setMuaVao(String muaVao) {
        this.muaVao = muaVao;
    }

    public String getBanRa() {
        return banRa;
    }

    public void setBanRa(String banRa) {
        this.banRa = banRa;
    }
}
