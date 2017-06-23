package cmproject.com.cmproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PushHistoryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_history);

        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedInputStream buf = null;
        try {

            Log.d("TAG", "park");
            //[URL 지정과 접속]

            //웹서버 URL 지정
            url= new URL("http://localhost:8080/test.html");

            //URL 접속
            urlConnection = (HttpURLConnection) url.openConnection();

            Log.d("URL",String.valueOf(urlConnection.getResponseCode()));

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line2 = null;

            while(true) {

                line2 = reader.readLine();
                if(line2 == null) {
                    break;
                }


            }

            //[웹문서 소스를 버퍼에 저장]
            //데이터를 버퍼에 기록

            //buf = new BufferedInputStream(urlConnection.getInputStream());
            //BufferedReader bufreader = new BufferedReader(new InputStreamReader(buf,"UTF-8"));

            BufferedReader bufreader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            Log.d("line:",bufreader.toString());

            String line = null;
            String page = "";

            //버퍼의 웹문서 소스를 줄단위로 읽어(line), Page에 저장함
            while((line = bufreader.readLine())!=null){
                Log.d("line:",line);
                page+=line;
            }

            //읽어들인 JSON포맷의 데이터를 JSON객체로 변환
            JSONObject json = new JSONObject(page);

            //ksk_list 에 해당하는 배열을 할당
            JSONArray jArr = json.getJSONArray("persons");

            Log.d("JSON",jArr.toString());

            //배열의 크기만큼 반복하면서, name과 address의 값을 추출함
            for (int i=0; i<jArr.length(); i++){

                //i번째 배열 할당
                json = jArr.getJSONObject(i);

                //ksNo,korName의 값을 추출함
                String name = json.getString("name");
                String age = json.getString("age");
                Log.d("name",name);
                Log.d("age",age);
            }

        } catch (Exception e) {

        }finally{
            //URL 연결 해제
            urlConnection.disconnect();
        }
    }

}
