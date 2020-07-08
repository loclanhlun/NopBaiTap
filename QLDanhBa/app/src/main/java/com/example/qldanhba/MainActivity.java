package com.example.qldanhba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.ContactAdapter;
import model.Contact;

public class MainActivity extends AppCompatActivity {
    private List<Contact> arrayContact ;
    private ContactAdapter adapter;
    private EditText edName;
    private EditText edNumber;
    private RadioButton rbtnMale;
    private RadioButton rbtnFemale;
    private Button btnThem, btnSua, btnXoa;
    private ListView lvContact;
    int i = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidget();
        arrayContact = new ArrayList<>();
        adapter = new ContactAdapter(this, R.layout.item_contact_listview, arrayContact);
        lvContact.setAdapter(adapter);
        xuly();

    }

    public void setWidget(){
        edName = (EditText) findViewById(R.id.edt_name);
        edNumber = (EditText) findViewById(R.id.edt_sdt);
        rbtnMale = (RadioButton) findViewById(R.id.rbtnMale);
        rbtnFemale = (RadioButton) findViewById(R.id.rbtnFemale);
        btnThem = (Button) findViewById(R.id.btn_them);
        btnSua = (Button) findViewById(R.id.btn_sua);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        lvContact = (ListView) findViewById(R.id.list_view);



    }

    public void addContact (View view) {
        if (view.getId() == R.id.btn_them) {
            String name = edName.getText().toString().trim();
            String number = edNumber.getText().toString().trim();
            boolean isMale = true;
            if(rbtnMale.isChecked()) {
                isMale = true;
            }else {
                isMale = false;
            }
            //

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(number)) {
                Toast.makeText(this, "Hãy nhập tên hoặc số điện thoại", Toast.LENGTH_SHORT).show();

            } else {
                Contact contact = new Contact(isMale, name , number);
                arrayContact.add(contact);
            }
            adapter.notifyDataSetChanged();
        }
    }
    // onClick Button sua
    public void  fixContact(View view){
        if (view.getId() == R.id.btn_sua){
                String name = edName.getText().toString();
                String number = edNumber.getText().toString();
                boolean isMale = true;
                if (rbtnMale.isChecked()) {
                    isMale = true;
                    Contact contact = new Contact(isMale, name, number);
                    arrayContact.set(i, contact);
                } else {
                    isMale = false;
                    Contact contact = new Contact(isMale, name, number);
                    arrayContact.set(i, contact);
                }
                adapter.notifyDataSetChanged();

        }
    }
    //onClick Button Xoa
    public void removeContact(View view){
        if(view.getId() == R.id.btnXoa){




                if (arrayContact.size() >= 1) {
                    arrayContact.remove(i);
                    adapter.notifyDataSetChanged();

                }

        }
    }
    public void xuly (){
        //click item listview
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i = position;

                edName.setText(arrayContact.get(position).getmName().toString());
                edNumber.setText(arrayContact.get(position).getmNumber().toString());
            }
        });


    }

}


