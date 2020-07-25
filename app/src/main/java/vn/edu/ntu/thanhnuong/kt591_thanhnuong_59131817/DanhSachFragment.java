package vn.edu.ntu.thanhnuong.kt591_thanhnuong_59131817;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import vn.edu.ntu.thanhnuong.kt591_thanhnuong_59131817.controller.Controller;
import vn.edu.ntu.thanhnuong.kt591_thanhnuong_59131817.model.Item;


/**
 * A simple {@link Fragment} subclass.
 */
public class DanhSachFragment extends Fragment {
    NavController navController;
    RecyclerView rvList;
    List<Item> list;
    GiaVangAdapter giaVangAdapter;
    Controller controller;

    public DanhSachFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_danh_sach, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = NavHostFragment.findNavController(DanhSachFragment.this);
        ((MainActivity)getActivity()).navController = navController;

        rvList = view.findViewById(R.id.rvList);

        controller = (Controller) getActivity().getApplication();//dùng chung
        list = controller.getAllGiaVang();
        giaVangAdapter = new GiaVangAdapter(list);

        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvList.setAdapter(giaVangAdapter);

    }

    private  class  GiaVangViewHolder extends RecyclerView.ViewHolder{
        TextView txtNgay, txtMuaVao, txtBanRa, txtLoai;
        Item i;

        public GiaVangViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNgay = itemView.findViewById(R.id.txtNgay);
            txtMuaVao = itemView.findViewById(R.id.txtMuaVao);
            txtBanRa = itemView.findViewById(R.id.txtBanRa);
            txtLoai = itemView.findViewById(R.id.txtLoai);

        }

        public void bind(Item i ){
            this.i = i;
            txtNgay.setText(i.getNgay());
            txtLoai.setText(i.getLoai());
            txtMuaVao.setText(i.getMuaVao());
            txtBanRa.setText(i.getBanRa());

        }

    }

    private class GiaVangAdapter extends RecyclerView.Adapter<GiaVangViewHolder>{

        List<Item> list;

        public GiaVangAdapter(List<Item> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public GiaVangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.item, parent, false);
            return new GiaVangViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull GiaVangViewHolder holder, int position) {
            holder.bind(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}
