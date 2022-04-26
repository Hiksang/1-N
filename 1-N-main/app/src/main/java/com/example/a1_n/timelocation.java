package com.example.a1_n;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class timelocation extends AppCompatActivity{
    Button btn_dialog;
    List<String> mSelectedItems;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle saveInstancesState) {
        super.onCreate(saveInstancesState);
        setContentView(R.layout.activity_timelocation);

        btn_dialog = findViewById(R.id.btn_dialog);

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                showDialog();
            }
        });
    }
    public void showDialog(){
        mSelectedItems = new ArrayList<>();
        builder = new AlertDialog.Builder(timelocation.this);
        builder.setTitle("시간을 선택하세요");

    builder.setMultiChoiceItems(R.array.time,null,new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        String[] items = getResources().getStringArray(R.array.time);

        if(isChecked) {
                mSelectedItems.add(items[which]);
            }else if(mSelectedItems.contains(items[which])){
                mSelectedItems.remove(items[which]);
            }
            }

    });
    builder.setPositiveButton("ok",new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialog, int which){
            String final_selection="";
            for(String item : mSelectedItems){
                final_selection = final_selection + "\n" + item;
            }

            Toast.makeText(getApplicationContext(), "선택된 시간은" + final_selection, Toast.LENGTH_SHORT).show();
        }
    });

    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
           @Override
           public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();
           }
    });
    AlertDialog alertDialog = builder.create();
    alertDialog.show();
    }

}