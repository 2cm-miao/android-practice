package com.example.a2cm.androidtest5;

import android.net.Uri;

import java.security.PublicKey;

/**
 * Created by 2cm on 2017/5/9.
 */

public class People {
    public static final String MIME_DIR_PREFIX="vnd.android.cursor.dir";
    public static final String MIME_ITEM_PREFIX="vnd.android.cursor.item";
    public static final String Mine_ITEM="vnd.hrbeu.people";

    public static final String MINE_TYPE_SINGLE=MIME_ITEM_PREFIX+"/"+Mine_ITEM;
    public static final String MINE_TYPE_MULTIPLE=MIME_DIR_PREFIX+"/"+Mine_ITEM;

    public static final String AUTHORITY="edu.hrbeu.peopleprovider";
    public static final String PATH_SINGLE="people/#";
    public static final String PATH_MULTIPLE="people";
    public static final String CONTENT_URI_STRING="content://"+AUTHORITY+"/"+PATH_MULTIPLE;
    public static final Uri CONTENT_URI=Uri.parse(CONTENT_URI_STRING);

    public static final String KEY_ID="_id";
    public static final String KEY_NAME="name";
    public static final String KEY_AGE="age";
    public static final String KEY_APARTMENT="apartment";
    public static final String KEY_SALARY="salary";
}
