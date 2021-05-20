package com.example.feedbackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //khai báo các thành phần có trong layout
    EditText txtUserName;
    TextView txtUserNameReport;
    EditText txtPassword;
    TextView txtPasswordReport;
    Spinner spnRolePicker;
    CheckBox chkRememberMe;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //lấy các thành phần có trong layout
        txtUserName = (EditText)findViewById(R.id.txt_UserName);
        txtUserNameReport = (TextView)findViewById(R.id.txt_UserNameReport);
        txtPassword = (EditText)findViewById(R.id.txt_Password);
        txtPasswordReport = (TextView)findViewById(R.id.txt_PasswordReport);
        spnRolePicker = (Spinner)findViewById(R.id.spn_RolePicker);
        chkRememberMe = (CheckBox)findViewById(R.id.chk_RememberMe);
        btnLogin = (Button)findViewById(R.id.btn_Login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OnLoginValidate();
            }
        });
    }

    //hàm validate cho login
    void OnLoginValidate(){
        //tạo biến kiểm tra đã đúng validate chưa
        boolean isValidated = true;

        //tạo biến lưu giá trị Username và Password
        String username = txtUserName.getText().toString();
        String password = txtPassword.getText().toString();
        int role = spnRolePicker.getSelectedItemPosition()+1;

        //kiểm tra để trống username và password
        if(username.trim().equals("")){
            txtUserNameReport.setText("Username must have at least 1 character!");
            isValidated = false;
            //return;
        }
        else if(username.contains(" ")){
            txtUserNameReport.setText("Username must have at blank space!");
            isValidated = false;
            //return;
        }
        else {
            txtUserNameReport.setText("");
        }

        if(password.trim().equals("")) {
            txtPasswordReport.setText("Password must have at least 1 character!");
            isValidated = false;
            //return;
        }
        else if(password.contains(" ")){
            txtPasswordReport.setText("Password must have at blank space!");
            isValidated = false;
            //return;
        }
        else{
            txtPasswordReport.setText("");
        }
        //nếu validate không lỗi, kiểm tra tài khoản
        if(isValidated){
            OnAccountCheck();
        }
    }

    void OnAccountCheck(){
        //tạo biến kiểm tra đã đúng account chưa
        boolean isVerified = true;

        //tạo biến lưu giá trị Username và Password
        String username = txtUserName.getText().toString();
        String password = txtPassword.getText().toString();
        int role = spnRolePicker.getSelectedItemPosition()+1;

        //kiểm tra tài khoản và role
        //gọi lấy dữ liệu về so khớp
        //xét tạm các giá trị mặc định, sẽ xóa sau
        if(username.equals("admin") && password.equals("admin") && role==1){
            Toast.makeText(getApplicationContext(),"Admin login",Toast.LENGTH_LONG).show();
        }
        else if(username.equals("trainer") && password.equals("trainer") && role==2){
            Toast.makeText(getApplicationContext(),"Trainer login",Toast.LENGTH_LONG).show();
        }
        else if(username.equals("trainee") && password.equals("trainee") && role==3){
            Toast.makeText(getApplicationContext(),"Trainee login",Toast.LENGTH_LONG).show();
        }
        else{
            //hiện dialog login failed
            LayoutInflater inflater = getLayoutInflater();
            View alertLayout = inflater.inflate(R.layout.login_failed_dialog, null);
            final Button btnYes = (Button) alertLayout.findViewById(R.id.btn_Yes);
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setView(alertLayout);
            alert.setCancelable(false);
            AlertDialog dialog = alert.create();
            btnYes.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    dialog.dismiss();
                }
            });
            dialog.show();
            isVerified = false;
        }
        //nếu validate không lỗi, kiểm tra Remember Me
        if(isVerified){
            OnRememberMeCheck();
        }
    }

    //hàm kiểm tra xử lý Remember Me
    void OnRememberMeCheck(){
        //chưa xử lý
    }
}