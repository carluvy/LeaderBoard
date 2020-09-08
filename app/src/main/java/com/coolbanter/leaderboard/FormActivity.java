package com.coolbanter.leaderboard;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import org.jetbrains.annotations.NotNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormActivity extends AppCompatActivity {

    private static final String BASE_URL_FORM = "https://docs.google.com/forms/d/e/";
    private static final String TAG = "moriio";
    private static final String TAG_FAIL = "Nyamba";
    private static Retrofit mRetrofit = null;
    private EditText emailEt;
    private EditText firstNameEt;
    private EditText lastNameEt;
    private EditText projectLinkEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
//        submitProject("email", "first name", "last name", "link",
//        submitDetails("email", "first name", "last name", "link");
//                );


//        showAlertDialog();
//        getData();


        emailEt = findViewById(R.id.email);
        firstNameEt = findViewById(R.id.first_name);
        lastNameEt = findViewById(R.id.last_name);
        projectLinkEt = findViewById(R.id.link);


//        formResponses = findViewById(R.id.formResponse);


    }

//    private void showAlertDialog() {
//        FragmentManager fm = getSupportFragmentManager();
//        MyDialogFragment dialogFragment = MyDialogFragment.newInstance();
//        dialogFragment.show(fm, "fragment_alert");
//    }


    public static Retrofit getRetrofit() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();


        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_FORM)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;

    }

    public void submitDetails(String email, String firstName, String lastName, String link) {
        APIService apiService = getRetrofit().create(APIService.class);

        Call<Void> submission = apiService.submitDetails(email, firstName, lastName, link);
        submission.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
//                    submitData.postValue(true);
//
//
//                } else {
//                    submitData.postValue(false);


                }
                Log.i(TAG, "OnResponse; " + response.code());

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                if (submission.isCanceled()) {
                    Log.e(TAG_FAIL, "was cancelled");
                }
                Log.i(TAG_FAIL, "OnFailure: " + t);

            }
        });


//        if (isNetworkConnected()) {
//
//            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
////        alertDialog.setTitle(title);
//            alertDialog.setMessage(R.string.dialog_confirm_submission);
//            alertDialog.setPositiveButton(R.string.positive, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
////                    getData();
//
//
//                }
//            });
//            alertDialog.setNegativeButton(R.string.negative, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
////                if (dialog != null) {
//                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(intent);
//                    finish();
//
//
//                }
//            });
//            alertDialog.create();
//            alertDialog.show();
//
//
//            final ProgressDialog progressDialog = new ProgressDialog(this);
//            progressDialog.setMessage("Loading...");
//            progressDialog.show();
//
//
//            APIService apiService = getRetrofit().create(APIService.class);
//            Call<Void> call = apiService.submitDetails("email", "name",
//                    "last name", "Link to Project");
//
//
//
//
//
//            call.enqueue(new Callback<Void>() {
//                @Override
//                public void onResponse(@NotNull Call<Void> call, Response<Void> response) {
//
//                    if (!response.isSuccessful()) {
//
//                        submitData();
////                        formResponses.setText("code: " + response.code());
//                        return;
//                    }
//
//
//                    Void formResponse = response.body();
//
////                    String content = "";
//                    assert formResponse != null;
////
//                    String firstName = formResponse.getFirstName();
//                    String lastName = formResponse.getLastName();
//                    String emailAddress = formResponse.getEmailAddress();
//                    String projectLink = formResponse.getProjectLink().getPath();
//
//
//
//
//
//
////                    emailEt.setText(formResponse.getEmailAddress());
////                    firstNameEt.setText(formResponse.getFirstName());
////                    lastNameEt.setText(formResponse.getLastName());
////                    projectLinkEt.setText(formResponse.getProjectLink().getPath());
//////
////                    formResponses.setText(content);
//
//
//                    progressDialog.dismiss();
//                }
//
//                @Override
//                public void onFailure(Call<FormResponse> call, Throwable t) {
//                    Log.e("failure", t.getLocalizedMessage());
//                    progressDialog.dismiss();
//                Toast.makeText(getApplicationContext(), "An error occurred", Toast.LENGTH_SHORT).show();
//
//                }
//
//
//            });
//        } else {
//            Toast.makeText(getApplicationContext(), "No internet connection", Toast.LENGTH_LONG).show();
//        }
//
//
//    }

//    private boolean isNetworkConnected() {
//        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext()
//                .getSystemService(Context.CONNECTIVITY_SERVICE);
//        assert connectivityManager != null;
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//        if (networkInfo == null) {
//            return false;
//        } else {
//            return true;
//        }
//
//    }
//
//
//    public void submitData(View view) {
//        getRetrofit().create(APIService.class);
//
//
//    }
    }

    public void submitProject(View view) {
        APIService apiService = getRetrofit().create(APIService.class);

        Call<Void> submission = apiService.submitDetails("email", "first name",
                "last name", "project link");

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
//        alertDialog.setTitle(title);
        alertDialog.setMessage(R.string.dialog_confirm_submission);
        alertDialog.setPositiveButton(R.string.positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
//                emailEt.getText();
//                firstNameEt.getText();
//                lastNameEt.getText();
//                projectLinkEt.getText();
                String emailAddress = emailEt.getText().toString();
                String firstName = firstNameEt.getText().toString();
                String lastName = lastNameEt.getText().toString();
                String projectLink = projectLinkEt.getText().toString();
                if (!TextUtils.isEmpty(emailAddress)) {
                    if (!TextUtils.isEmpty(firstName)) {
                        if (!TextUtils.isEmpty(lastName)) {
                            if (!TextUtils.isEmpty(projectLink)) {

                                submitDetails(emailAddress, firstName, lastName, projectLink);

                            }
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "All fields are required!", Toast.LENGTH_LONG).show();
                }


//


            }
        });
        alertDialog.setNegativeButton(R.string.negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                submission.cancel();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();


            }

        });

        alertDialog.create();
        alertDialog.show();

    }

}


