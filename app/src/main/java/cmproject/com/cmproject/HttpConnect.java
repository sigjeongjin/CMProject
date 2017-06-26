package cmproject.com.cmproject;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by we25 on 2017-06-26.
 */

class HttpConnect extends AsyncTask<String, Void, Boolean> {

    String urlStr;

    @Override
    protected Boolean doInBackground(String... params) {

        StringBuffer sb = new StringBuffer();
        try {

            //주어진 URL 문서의 내용을 문자열로 얻는다.
            String jsonPage = getStringFromUrl("http://192.168.0.230:3000/min");

            //읽어들인 JSON포맷의 데이터를 JSON객체로 변환
            JSONObject json = new JSONObject(jsonPage);

            Log.d("JSON CONTENTS", json.toString());

            //ksk_list의 값은 배열로 구성 되어있으므로 JSON 배열생성
            JSONArray jArr = json.getJSONArray("ksk_list");

            //배열의 크기만큼 반복하면서, ksNo과 korName의 값을 추출함

            Log.d("JSON CONFIRM" , String.valueOf(jArr.length()));

            for (int i=0; i<jArr.length(); i++){

                //i번째 배열 할당
                json = jArr.getJSONObject(i);

                //ksNo,korName의 값을 추출함
                String ksNo = json.getString("ksNo");
                String korName = json.getString("korName");
                System.out.println("ksNo:"+ksNo+"/korName:"+korName);

                //StringBuffer 출력할 값을 저장
                sb.append("[ "+ksNo+" ]\n");
                sb.append(korName+"\n");
                sb.append("\n");
            }

            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public String getStringFromUrl(String pUrl){

        Log.d("STRING3","TEST3");

        BufferedReader bufreader=null;
        HttpURLConnection urlConnection = null;

        StringBuffer page=new StringBuffer(); //읽어온 데이터를 저장할 StringBuffer객체 생성

        Log.d("STRING4","TEST4");

        try {

            //[Type1]
            /*
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(pUrl));
            InputStream contentStream = response.getEntity().getContent();
            */

            Log.d("STRING5","TEST5");

            //[Type2]
            URL url= new URL(pUrl);
            urlConnection = (HttpURLConnection) url.openConnection();

            Log.d("STRING6","TEST6");


            Log.d("RESPONSE MESSAGE",urlConnection.getResponseMessage());
            Log.d("RESPONSE CODE",String.valueOf(urlConnection.getResponseCode()));

            InputStream contentStream = urlConnection.getInputStream();

            Log.d("STRING7","TEST7");

            bufreader = new BufferedReader(new InputStreamReader(contentStream,"UTF-8"));
            String line = null;

            //버퍼의 웹문서 소스를 줄단위로 읽어(line), Page에 저장함
            while((line = bufreader.readLine())!=null){
                Log.d("line:",line);
                page.append(line);
            }

        } catch (IOException e) {
            Log.d("EXCEPTION","EXCEPTION");
            e.printStackTrace();
        }finally{
            Log.d("finally","finally");
            //자원해제
            try {
                bufreader.close();
                urlConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return page.toString();
    }// getStringFromUrl()-------------------------

}
