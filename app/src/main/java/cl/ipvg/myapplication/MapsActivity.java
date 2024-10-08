package cl.ipvg.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import cl.ipvg.myapplication.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Libreria = new LatLng(-36.61361867093137, -72.10269698761319);
        LatLng Hospital = new LatLng(-36.60864611608423, -72.0927684421444);
        LatLng Plaza = new LatLng(-36.60642453092332, -72.10394057450823);
        LatLng Sodimac = new LatLng(-36.59929054782851, -72.10059209834921);
        LatLng Cecinas =new LatLng(-36.611368505507414, -72.11670457744596);

        mMap.addMarker(new MarkerOptions().position(Libreria).title("Libreria"));
        mMap.addMarker(new MarkerOptions().position(Hospital).title("hospital"));
        mMap.addMarker(new MarkerOptions().position(Sodimac).title("Homecenter sodimac"));
        mMap.addMarker(new MarkerOptions().position(Cecinas).title("Universidad del bio bio"));
        mMap.addMarker(new MarkerOptions().position(Plaza).title("Plaza de armas"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Plaza));
        mMap.setMinZoomPreference(8.0F);
        mMap.setMaxZoomPreference(18.0f);
    }
}