package com.example.cloudfirestore20072021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 : Kiểu nguyên thủy
//        Map<String,String> mapMessage = new HashMap<>();
//        mapMessage.put("content","Tôi đang làm lập trình");

//        Map<String,Object> mapMessageUpdate = new HashMap<>();
//        mapMessageUpdate.put("content Data","Tôi đang làm lập trình");

//        db.collection("message")
//                .document("randomabc123")
//                .update("content","Tôi đang làm lập trình update")
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(MainActivity.this, "Thành công", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

        // 2 : Dạng list
//        Map<String,Object> docData = new HashMap<>();
//        docData.put("list", Arrays.asList("Java","Kotlin", "Php"));
//
//
//        Map<String,Object> docData1 = new HashMap<>();
//        docData.put("listUpdate", Arrays.asList("Java","Kotlin", "Php"));
//
//        db.collection("language").document("o2tl2Q8XIBcAZ97GM6e3")
//                .update(docData1)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(MainActivity.this, "Thành công", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

        // 1 : Lấy dữ liệu
        db.collection("message").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d("BBB", document.getId() + " => " + document.getData().get("content"));
                    }
                } else {
                    Log.d("BBB", "Error getting documents: ", task.getException());
                }
            }
        });
    }
}