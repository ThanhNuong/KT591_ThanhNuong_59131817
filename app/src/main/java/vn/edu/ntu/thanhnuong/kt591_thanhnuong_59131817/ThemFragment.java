package vn.edu.ntu.thanhnuong.kt591_thanhnuong_59131817;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;

import vn.edu.ntu.thanhnuong.kt591_thanhnuong_59131817.controller.Controller;
import vn.edu.ntu.thanhnuong.kt591_thanhnuong_59131817.model.Item;

public class ThemFragment extends Fragment {
    NavController navController;
    Controller controller;

    EditText edtNgay, edtMuaVao, edtBanRa;
    Spinner spnLoai;
    ImageView imvNgay;
    Button btnThem, btnXemDS;

    String[] loaiVang;
    ArrayAdapter<String> adapter;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_themt, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        navController = NavHostFragment.findNavController(ThemFragment.this);
        ((MainActivity)getActivity()).navController = navController;

      controller = (Controller) getActivity().getApplication();//dùng chung

        //addView
        edtNgay = view.findViewById(R.id.edtNgay);
        edtMuaVao = view.findViewById(R.id.edtMuaVao);
        edtBanRa = view.findViewById(R.id.edtBanRa);
        spnLoai = view.findViewById(R.id.spnLoai);
        imvNgay = view.findViewById(R.id.imvNgay);
        btnThem = view.findViewById(R.id.btnThem);
        btnXemDS = view.findViewById(R.id.btnXemDS);



        loaiVang = new String[]{"DOJI", "SJC", "Thế giới"};
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, loaiVang);
        spnLoai.setAdapter(adapter);


        addEvents();

    }

    private void addEvents() {
        imvNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int nam = calendar.get(Calendar.YEAR);
                int thang = calendar.get(Calendar.MONTH);
                int ngay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int nam, int thang, int ngay) {
                        String s = ngay + "/" + (thang+1) + "/" + nam;
                        edtNgay.setText(s);
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), listener, nam, thang, ngay);
                datePickerDialog.show();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ngay =edtNgay.getText().toString();
                String muaVao =edtMuaVao.getText().toString();
                String banRa =edtBanRa.getText().toString();
                String loai = spnLoai.getSelectedItem().toString();
                Item i = new Item(ngay, muaVao, banRa, loai);


                if(controller.addGiaVang(i))
                {
                    Toast.makeText(getActivity(), " Thêm thành công", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getActivity(), "Thất bại", Toast.LENGTH_SHORT).show();
                }

        });

        btnXemDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_themFragment_to_danhSachFragment);
            }
        });

    }


    @Override
    public void onPause() {
        super.onPause();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
