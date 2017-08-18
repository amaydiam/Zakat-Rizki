package com.ad.zakatrizki.fragment;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ad.zakatrizki.R;
import com.ad.zakatrizki.Zakat;
import com.ad.zakatrizki.activity.DonasiDetailActivity;
import com.ad.zakatrizki.activity.DrawerActivity;
import com.ad.zakatrizki.model.Mustahiq;
import com.ad.zakatrizki.utils.ApiHelper;
import com.ad.zakatrizki.utils.CustomVolley;
import com.ad.zakatrizki.utils.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.EntypoModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.MaterialCommunityModule;
import com.joanzapata.iconify.fonts.MaterialIcons;
import com.joanzapata.iconify.fonts.MaterialModule;
import com.joanzapata.iconify.widget.IconButton;
import com.sdsmdg.tastytoast.TastyToast;
import com.wang.avi.AVLoadingIndicatorView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindBool;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class DonasiMapFragment extends Fragment implements OnMapReadyCallback,
        CustomVolley.OnCallbackResponse,
        GoogleMap.OnCameraIdleListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener, GoogleMap.OnMarkerClickListener {

    @BindBool(R.bool.is_tablet)
    boolean isTablet;
    @BindView(R.id.search)
    EditText search;
    @BindView(R.id.btn_search)
    IconButton btnSearch;
    @BindView(R.id.parent_search)
    CardView parentSearch;
    @BindView(R.id.btn_my_location)
    FloatingActionButton btnMyLocation;

    @BindView(R.id.indicator_identify_address)
    AVLoadingIndicatorView indicatorIdentifyAddress;

    @OnClick(R.id.btn_search)
    void Search() {
        String val_search = search.getText().toString().trim();
        if (!TextUtils.isNullOrEmpty(val_search)) {

            List<Address> addressList = null;

            Geocoder geocoder = new Geocoder(getActivity());
            try {
                addressList = geocoder.getFromLocationName(val_search, 1);
                Address address = addressList.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(activity, "Lokasi Tidak ditemukan", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private CustomVolley customVolley;
    private RequestQueue queue;
    private FragmentActivity activity;
    private Unbinder butterknife;
    private String keyword;
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private Location mLastLocation;
    private double current_latitude;
    private double current_longitude;
    private ArrayDeque mCurrLocationMarker;
    private float zoomLevel = 14;
    private String TAG_MUSTAHIQ_NEARBY = "TAG_MUSTAHIQ_NEARBY";

    public DonasiMapFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static DonasiMapFragment newInstance() {
        return new DonasiMapFragment();
    }
    //  private String session_key;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DrawerActivity) {
            // activity = (DrawerActivity) context;
        }
        activity = getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        Iconify
                .with(new FontAwesomeModule())
                .with(new EntypoModule())
                .with(new MaterialModule())
                .with(new MaterialCommunityModule());
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_list_donasi, container, false);
        butterknife = ButterKnife.bind(this, rootView);
        customVolley = new CustomVolley(activity);
        customVolley.setOnCallbackResponse(this);
        try {
            keyword = getArguments().getString(Zakat.KEYWORD);
        } catch (Exception e) {

        }

        btnMyLocation.setImageDrawable(
                new IconDrawable(getActivity(), MaterialIcons.md_my_location)
                        .colorRes(R.color.primary)
                        .actionBarSize());
        search.setHint("Lokasi, ex: Monas");
        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Search();
                    return true;
                }
                return false;
            }
        });

        new TedPermission(getActivity())
                .setPermissionListener(permissionMapsListener)
                .setDeniedMessage("Jika Anda menolak permission, Anda tidak dapat mendeteksi lokasi Anda \nHarap hidupkan permission ACCESS_FINE_LOCATION pada [Setting] > [Permission]")
                .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                .check();

        return rootView;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }


    @Override
    public void onVolleyStart(String TAG) {
        indicatorIdentifyAddress.setVisibility(View.VISIBLE);
    }

    @Override
    public void onVolleyEnd(String TAG) {
        indicatorIdentifyAddress.setVisibility(View.GONE);
    }

    @Override
    public void onVolleySuccessResponse(String TAG, String response) {
        DrawDataAllData(TAG, response);
    }


    @Override
    public void onVolleyErrorResponse(String TAG, String response) {
    }


    protected void DrawDataAllData(String tag, String response) {


        try {
            mMap.clear();

            JSONObject json = new JSONObject(response);
            Boolean isSuccess = Boolean.parseBoolean(json.getString(Zakat.isSuccess));
            String message = json.getString(Zakat.message);
            if (isSuccess) {
                JSONArray items_obj = json.getJSONArray(Zakat.mustahiq);
                int jumlah_list_data = items_obj.length();
                if (jumlah_list_data > 0) {
                    for (int i = 0; i < jumlah_list_data; i++) {
                        JSONObject obj = items_obj.getJSONObject(i);

                        String id_mustahiq = obj.getString(Zakat.id_mustahiq);
                        String id_calon_mustahiq = obj.getString(Zakat.id_calon_mustahiq);
                        String nama_calon_mustahiq = obj.getString(Zakat.nama_calon_mustahiq);
                        String alamat_calon_mustahiq = obj.getString(Zakat.alamat_calon_mustahiq);
                        String latitude_calon_mustahiq = obj.getString(Zakat.latitude_calon_mustahiq);
                        String longitude_calon_mustahiq = obj.getString(Zakat.longitude_calon_mustahiq);
                        String no_identitas_calon_mustahiq = obj.getString(Zakat.no_identitas_calon_mustahiq);
                        String no_telp_calon_mustahiq = obj.getString(Zakat.no_telp_calon_mustahiq);
                        String nama_perekomendasi_calon_mustahiq = obj.getString(Zakat.nama_perekomendasi_calon_mustahiq);
                        String alasan_perekomendasi_calon_mustahiq = obj.getString(Zakat.alasan_perekomendasi_calon_mustahiq);

                        String photo_1 = obj
                                .getString(Zakat.photo_1);
                        String photo_2 = obj
                                .getString(Zakat.photo_2);
                        String photo_3 = obj
                                .getString(Zakat.photo_3);
                        String caption_photo_1 = obj
                                .getString(Zakat.caption_photo_1);
                        String caption_photo_2 = obj
                                .getString(Zakat.caption_photo_2);
                        String caption_photo_3 = obj
                                .getString(Zakat.caption_photo_3);
                        String status_mustahiq = obj.getString(Zakat.status_mustahiq);
                        String jumlah_rating = obj.getString(Zakat.jumlah_rating);
                        String nama_validasi_amil_zakat = obj.getString(Zakat.nama_validasi_amil_zakat);
                        String waktu_terakhir_donasi = obj.getString(Zakat.waktu_terakhir_donasi);

                        Mustahiq mustahiq = new Mustahiq(
                                id_mustahiq,
                                id_calon_mustahiq,
                                nama_calon_mustahiq,
                                alamat_calon_mustahiq,
                                latitude_calon_mustahiq,
                                longitude_calon_mustahiq,
                                no_identitas_calon_mustahiq,
                                no_telp_calon_mustahiq,
                                nama_perekomendasi_calon_mustahiq,
                                alasan_perekomendasi_calon_mustahiq,
                                photo_1,
                                photo_2,
                                photo_3,
                                caption_photo_1,
                                caption_photo_2,
                                caption_photo_3,
                                status_mustahiq,
                                jumlah_rating,
                                nama_validasi_amil_zakat,
                                waktu_terakhir_donasi);
                        double Lat = Double.parseDouble(latitude_calon_mustahiq);
                        double Long = Double.parseDouble(longitude_calon_mustahiq);
                        MarkerOptions marker = new MarkerOptions()
                                .position(new LatLng(Lat, Long))
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mustahiq));

                        Marker m = mMap.addMarker(marker);
                        m.setTag(mustahiq);

                    }
                } else {
                }

            } else {
                TastyToast.makeText(activity, message, TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
            }


        } catch (JSONException e) {
            e.printStackTrace();
            TastyToast.makeText(activity, "Parsing data error ...", TastyToast.LENGTH_LONG, TastyToast.ERROR);
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterknife.unbind();
        if (queue != null) {
            //  queue.cancelAll(TAG_AWAL);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.setMyLocationEnabled(true);
        mMap.setOnCameraIdleListener(this);
        mMap.setOnMarkerClickListener(this);
        View locationButton = ((View) mapView.findViewById(Integer.parseInt("1")).getParent()).findViewById(Integer.parseInt("2"));
        locationButton.setVisibility(View.GONE);

        //Initialize Google Play Services
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
            }
        } else {
            buildGoogleApiClient();
        }

    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }


        btnMyLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMyLocationPosition();
            }
        });
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    private void toMyLocationPosition() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            if (location == null) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Please activate location")
                        .setMessage("Click ok to goto settings.")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
            } else {
                // current location
                current_latitude = location.getLatitude();
                current_longitude = location.getLongitude();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(current_latitude, current_longitude), 14), 1500, null);
            }
        }
    }


    private View mapView;
    PermissionListener permissionMapsListener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {

            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.map);
            mapView = mapFragment.getView();
            mapFragment.getMapAsync(DonasiMapFragment.this);
        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {

            String message = String.format(Locale.getDefault(), getString(R.string.message_denied), "ACCESS_FINE_LOCATION");
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }


    };

    @Override
    public void onCameraIdle() {
        zoomLevel = mMap.getCameraPosition().zoom;

        current_latitude = mMap.getCameraPosition().target.latitude;
        current_longitude = mMap.getCameraPosition().target.longitude;

        getDataFromServer(TAG_MUSTAHIQ_NEARBY);

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        // current location
        current_latitude = location.getLatitude();
        current_longitude = location.getLongitude();

        //move map camera
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(current_latitude, current_longitude), zoomLevel), 1500, null);

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    private void getDataFromServer(final String TAG) {
        /*queue = customVolley.Rest(Request.Method.GET, Zakat.api_test + "?" + Zakat.app_key + "=" + Zakat.value_app_key + "&session_key=" + session_key
                + "&PAGE=" + PAGE + "&limit="
                + Zakat.LIMIT_DATA, null, TAG);*/
        queue = customVolley.Rest(Request.Method.GET, getUrlToDownload(), null, TAG);

    }

    public String getUrlToDownload() {
        return ApiHelper.getDonasiByLocationLink(getActivity(), String.valueOf(current_latitude), String.valueOf(current_longitude));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Mustahiq mustahiq = (Mustahiq) marker.getTag();
        if (isTablet) {
            if (activity instanceof DrawerActivity) {
                ((DrawerActivity) getActivity()).loadDetailDonasiFragmentWith(mustahiq.id_mustahiq);
            }
        } else {
            Intent intent = new Intent(activity, DonasiDetailActivity.class);
            intent.putExtra(Zakat.CALON_MUSTAHIQ_ID, mustahiq.id_mustahiq);
            startActivity(intent);
        }

        return true;
        // return false;
    }
}
