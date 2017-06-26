package cmproject.com.cmproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class WmMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "SmMapActivity";
    SupportMapFragment mapFragment;
    GoogleMap map;

    Button wmListActivityGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wm_map);

        wmListActivityGo = (Button) findViewById(R.id.wmListActivityGo);

        wmListActivityGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WmListActivity.class);
                startActivity(intent);
            }
        });

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);  // 메인 쓰레드에서 호출되어야 메인스레드에서 콜백이 실행
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "GoogleMap is ready.");
        map = googleMap;

        LatLng Sensor = new LatLng(37.573974, 127.023666);

        // marker 표시
        // market 의 위치, 타이틀, 짧은설명 추가 가능.
        MarkerOptions marker = new MarkerOptions();
        marker.position(Sensor);
        marker.title("박현진"); // maker title
        marker.snippet("바보");
        map.addMarker(marker); // maker click 시 보여줌
        //map.addMarker(marker).showInfoWindow(); 화면에 보여줌

        //movecamera 좌표를 설정한 곳으로 이동
        map.moveCamera(CameraUpdateFactory.newLatLng(Sensor));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));

//        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
//        googleMap.animateCamera(zoom);

    }
}
