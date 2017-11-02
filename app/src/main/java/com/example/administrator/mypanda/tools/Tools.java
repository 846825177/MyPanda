package com.example.administrator.mypanda.tools;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author 农民伯伯
 * @version 2017/11/1
 *          工具类
 */

public class Tools {

    private static ProgressDialog dialog;

    /**
     * 显示AlertDialog
     *
     * @param context 上下文
     * @param title   标题
     * @param message 内容
     */
    public static void showAlertDialog(Context context, String title, String message) {
        dialog = ProgressDialog.show(context, title, message, true, false, null);
    }

    /**
     * 取消显示AlertDialog
     */
    public static void cancleAlertDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.cancel();
        }
    }

    /**
     * 检测当的网络（WLAN、3G/2G）状态
     *
     * @param context Context
     * @return true 表示网络可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }

    public static void showNetWork(Context context, String message,
                                   String posiTiveText, DialogInterface.OnClickListener posiTivelistener) {

        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(posiTiveText, posiTivelistener)
                .show();

    }
}
