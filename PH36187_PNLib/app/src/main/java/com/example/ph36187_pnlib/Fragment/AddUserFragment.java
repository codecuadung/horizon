package com.example.ph36187_pnlib.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ph36187_pnlib.DAO.ThuThuDAO;
import com.example.ph36187_pnlib.Model.ThuThu;
import com.example.ph36187_pnlib.R;
public class AddUserFragment extends Fragment {
EditText edAddUser,edAddPass,edAddRePass,edMaTT;
Button btnSave,btnCancel;
ThuThuDAO dao;
ThuThu thuThu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_user, container, false);
        edAddPass = v.findViewById(R.id.edAddPass);
        edAddUser = v.findViewById(R.id.edAddUser);
        edAddRePass = v.findViewById(R.id.edAddRePass);
        btnCancel = v.findViewById(R.id.btnCancel);
        edMaTT = v.findViewById(R.id.edAddMaTT);
        btnSave = v.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maTT = edMaTT.getText().toString();
                String hoten = edAddUser.getText().toString();
                String pass = edAddPass.getText().toString();
                String repass = edAddRePass.getText().toString();
                if(maTT.isEmpty()||hoten.isEmpty()||pass.isEmpty()||repass.isEmpty()){
                    Toast.makeText(getActivity(),"Vui lòng điển đầy đủ thông tin!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pass.equals(repass)){
                    Toast.makeText(getActivity(),"Mật khẩu không khớp!",Toast.LENGTH_SHORT).show();
                    return;
                }
                thuThu  = new ThuThu();
                thuThu.setMaTT(maTT);
                thuThu.setHoTen(hoten);
                thuThu.setMatKhau(pass);

                dao = new ThuThuDAO(getActivity());
                long result = dao.insert(thuThu);
                if(result != -1){
                    Toast.makeText(getActivity(),"Thêm thành công!",Toast.LENGTH_SHORT).show();
                    edAddPass.setText("");
                    edAddUser.setText("");
                    edAddRePass.setText("");
                }else {
                    Toast.makeText(getActivity(),"Thêm thất bại!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edAddPass.setText("");
                edAddUser.setText("");
                edAddRePass.setText("");
            }
        });
        return v;

    }
}