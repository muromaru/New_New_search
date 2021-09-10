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


    void setInfo(String shop, String productNumber, String info) {
        Map<String, Object> data = new HashMap<>();
        data.put("info", info);

        db.collection(shop).document(productNumber)
                .set(data, SetOptions.merge());
    }



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
/*
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
                        } else {
                            Log.d("abc", "Error getting documents: ", task.getException());
                        }
                    }
                });
*/
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
/*
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
                        } else {
                            Log.d("abc", "Error getting documents: ", task.getException());
                        }
                    }
                });
 */
    }

    Double getStar(String shop, String productNumber) {
        DocumentReference docRef = db.collection(shop).document(productNumber);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        Map aaa = document.getData();
                        s = (Double) aaa.get("star");
                        Log.d("abc_star", String.valueOf(s));
                    } else {
                        Log.d("abc", "No such document");
                    }
                } else {
                    Log.d("abc", "get failed with ", task.getException());
                }
            }
        });
        return s;
    }

    Double getStarNum(String shop, String productNumber) {
        DocumentReference docRef = db.collection(shop).document(productNumber);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        Map aaa = document.getData();
                        sn = (Double) aaa.get("star_num");
                        Log.d("abc_starNum", String.valueOf(sn));
                    } else {
                        Log.d("abc", "No such document");
                    }
                } else {
                    Log.d("abc", "get failed with ", task.getException());
                }
            }
        });
        return sn;
    }

    String getReview(String shop, String productNumber, String reviewName) {
        DocumentReference docRef = db.collection(shop).document(productNumber);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        Map aaa = document.getData();
                        r = (String) aaa.get(reviewName);
                        Log.d("abc", r);
                    } else {
                        Log.d("abc", "No such document");
                    }
                } else {
                    Log.d("abc", "get failed with ", task.getException());
                }
            }
        });
        return r;
    }

    void getImage(Integer i) {
        StorageReference storageRef = storage.getReference();
        StorageReference pathReference = storageRef.child("2109_1/family"+i+".jpg");
        StorageReference listRef = storageRef.child("2109_1");
        Integer a = 1;
        if (a == 1) {
            //StorageReference gsReference = storage.getReferenceFromUrl("gs://new-search-8836c.appspot.com/aaa/0252997.jpg");
            //StorageReference httpsReference = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/b/bucket/o/images%20stars.jpg");
            final long ONE_MEGABYTE = 1024 * 1024;
            pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    MainActivity.setImageValue(bitmap);
                    Log.d("abc", "success"+(i+1));
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                    Log.d("abc", "error");
                }
            });
        }
        if (a == 2) {
            listRef.listAll()
                    .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                        @Override
                        public void onSuccess(ListResult listResult) {
                            for (StorageReference prefix : listResult.getPrefixes()) {
                                // All the prefixes under listRef.
                                // You may call listAll() recursively on them.
                                Log.d("abc", "success1");
                            }

                            for (StorageReference item : listResult.getItems()) {
                                // All the items under listRef.
                                Log.d("abc", "success2");
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Uh-oh, an error occurred!
                            Log.d("abc", "error");
                        }
                    });


        }

    }
}