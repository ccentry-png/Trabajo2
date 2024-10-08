package cl.ipvg.myapplication;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.google.android.gms.tasks.OnSuccessListener;




    public class MainActivity extends AppCompatActivity {


        private final int splashDuracion =5000;


        //private FusedLocationProviderClient fusedLocationClient;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);



            Intent intent = new Intent(this, MapsActivity.class);
            new Handler().postDelayed(new Runnable() {
                                          @Override
                                          public void run() {
                                              startActivity(intent);
                                              finish();
                                          }
                                      }
                    , splashDuracion);


           /* fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {


                            if (location != null) {
                                // Logic to handle location object
                                textView.setText(location.toString());

                            }
                        }*/





            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }

