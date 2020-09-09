package com.coolbanter.leaderboard;


import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FormActivity extends AppCompatActivity {

    private static final String TAG = "OnSuccess";
    private static final String TAG_FAIL = "OnFailure";
    private EditText emailEt;
    private EditText firstNameEt;
    private EditText lastNameEt;
    private EditText projectLinkEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Toolbar myToolbar = findViewById(R.id.dialog_appbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        emailEt = findViewById(R.id.email);
        firstNameEt = findViewById(R.id.first_name);
        lastNameEt = findViewById(R.id.last_name);
        projectLinkEt = findViewById(R.id.link);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        Intent intent = new Intent(FormActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        return true;
    }

    public void submitForm(View view) {
    APIService apiService = FormApiClient.getFormService();

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(FormActivity.this);
        alertDialog.setTitle(" ");
        alertDialog.setMessage(R.string.dialog_confirm_submission);
        alertDialog.setPositiveButton(R.string.positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String firstName = firstNameEt.getText().toString();
                String lastName = lastNameEt.getText().toString();
                String email = emailEt.getText().toString();
                String projectLink = projectLinkEt.getText().toString();
                if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !projectLink.isEmpty()) {
                    Call<Void> mFormResponseCall  = apiService.submitDetails(firstName, lastName,
                            email, projectLink);
                    mFormResponseCall.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if (response.isSuccessful()) {
                                Log.i(TAG, "Was A Success!" + response.code());

                            }
                            successDialog();


                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            failureDialog();
                            Log.i(TAG_FAIL, "Has Failed!" + t);
//                            if (call.isCanceled()) {
//                                Log.i(TAG_FAIL, "was cancelled");
//                            }



                        }
                    });
                } else {
                    Toast.makeText(FormActivity.this, "All fields are required", Toast.LENGTH_LONG).show();
                }

                dialog.dismiss();

            }

        });
        alertDialog.setNegativeButton(R.string.negative, (dialog, which) -> {
            Toast.makeText(FormActivity.this, "Post cancelled!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(FormActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        });
        alertDialog.create().show();




    }

private void successDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(FormActivity.this);
        alertDialog.setMessage("Submitted Successfully");
        alertDialog.setTitle(" ");
        alertDialog.setIcon(R.drawable.ic_baseline_check_box_24);
        alertDialog.create();
        alertDialog.show();

        }
private void failureDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(FormActivity.this);
        alertDialog.setMessage("Submission Failed");
        alertDialog.setTitle(" ");
        alertDialog.setIcon(R.drawable.ic_baseline_cancel_24);
        alertDialog.create();
        alertDialog.show();

        }



}










