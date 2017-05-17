package com.example.tag.mybcastreceiverstat01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by tag on 2017/05/17.
 */

public class MyBcastReceiver extends BroadcastReceiver {

    static final String TAG = "MyBcastReceiver";

    //Broadcastを受け取ったときに実行されるメソッド
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connMgr =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo;

        String message = "ネットワークが使えません";

        //ネットワーク接続のハンドルを取得できた場合
        if(connMgr!=null){
            networkInfo = connMgr.getActiveNetworkInfo();
            //ネットワークに接続されている状態の場合
            if(networkInfo!=null && networkInfo.isConnected()){
                message = "ネットワークが使えます："+networkInfo.getTypeName();
            }
        }
        Log.d(TAG,message);
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();

    }
}
