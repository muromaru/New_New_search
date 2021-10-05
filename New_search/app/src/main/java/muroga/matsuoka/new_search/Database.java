package muroga.matsuoka.new_search;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {



    private static Double s;
    private static Double sn;
    private static String r;



    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseStorage storage = FirebaseStorage.getInstance();






    void setStar(String shop, String productNumber, double num) {
        Map<String, Object> data = new HashMap<>();
        //Integer current_sn = getStarNum(shop,productNumber);
        //Double current_s = getStar(shop,productNumber);
        Log.d("abc", "1111111");
        Log.d("abc_sn", String.valueOf(sn));
        Log.d("abc_s", String.valueOf(s));
        Double star = (s * sn + num) / (sn + 1);
        Log.d("abc_new", String.valueOf(star));
        Log.d("abc", "2222222");
        data.put("star", star);

        db.collection(shop).document(productNumber)
                .set(data, SetOptions.merge());
    }

    void setStarNum(String shop, String productNumber) {
        Map<String, Object> data = new HashMap<>();
        data.put("star_num", FieldValue.increment(1.0));

        db.collection(shop).document(productNumber)
                .set(data, SetOptions.merge());
    }

    void setReview(String shop, String productNumber, int num, String review) {
        Map<String, Object> data = new HashMap<>();
        String review_num = "";
        if (num < 10) {
            review_num = "review0" + num;
        } else {
            review_num = "review" + num;
        }
        data.put(review_num, review);

        db.collection(shop).document(productNumber)
                .set(data, SetOptions.merge());
    }

    void getInfoAll() throws IOException {

        Log.d("abc", "Seven start");
        db.collection("seveneleven")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map sss = document.getData();
                                SevenEleven.setData(sss);
                            }
                            Log.d("abc", "Seven complete");
                            SevenEleven.sendMain();
                        } else {
                            Log.d("abc", "Error getting documents: ", task.getException());
                        }
                    }
                });

        Log.d("abc", "Lawson start");
        db.collection("lawson")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map lll = document.getData();
                                Lawson.setData(lll);
                            }
                            Log.d("abc", "Lawson complete");
                            Lawson.sendMain();
                        } else {
                            Log.d("abc", "Error getting documents: ", task.getException());
                        }
                    }
                });

        Log.d("abc", "Family start");
        db.collection("family")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map fff = document.getData();
                                FamilyMart.setData(fff);
                            }
                            Log.d("abc", "Family complete");
                            FamilyMart.sendMain();
                        } else {
                            Log.d("abc", "Error getting documents: ", task.getException());
                        }
                    }
                });
 
    }




    void getImage(String date, String shop, String name, Integer i) {
        StorageReference storageRef = storage.getReference();
        StorageReference pathReference = storageRef.child(shop+date+"/"+name);
        final long ONE_MEGABYTE = 1024 * 1024;
        pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                MainActivity.setImage(shop, bitmap);
                Log.d("abc", "success" + shop + (i + 1));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                Log.d("abc", "no img");
            }
        });
//        pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//            @Override
//            public void onSuccess(byte[] bytes) {
//                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                Activity2.setImage(shop, bitmap);
//                Log.d("abc", "success" + shop + (i + 1));
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Handle any errors
//                Log.d("abc", "no img");
//            }
//        });

    }



    void getImageName(String shop, String date) {
        StorageReference storageRef = storage.getReference();
        StorageReference listRef = storageRef.child(shop+date);
        listRef.listAll()
                .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                    @Override
                    public void onSuccess(ListResult listResult) {
                        for (StorageReference item : listResult.getItems()) {
                            // All the items under listRef.
                            if(shop=="seven") {
                                Content.setImageNameS(item.getName());
                            }
                            if(shop=="lawson") {
                                Content.setImageNameL(item.getName());
                            }
                            if(shop=="family") {
                                Content.setImageNameF(item.getName());
                            }

                        }
                        Log.d("abc",shop+" name,finish");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("abc","name_error");
                    }
                });
    }
}