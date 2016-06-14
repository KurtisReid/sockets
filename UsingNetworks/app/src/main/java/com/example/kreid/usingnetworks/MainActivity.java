package com.example.kreid.usingnetworks;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends Activity {
    public static final String URL = "LFST.xml";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StackOverflowXmlParser stackOverflowXmlParser = new StackOverflowXmlParser();
        InputStream inputStream = new ByteArrayInputStream(URL.getBytes(StandardCharsets.UTF_16));
        StringReader stringReader = new StringReader(URL);
        try {
            stackOverflowXmlParser.parse(inputStream);
        } catch (XmlPullParserException e) {
            Log.i("MAINACTIVITY", "I failed due to XmlPullParserException");
            e.printStackTrace();
        } catch (IOException e) {
            Log.i("MAINACTIVITY", "I failed due to IOException");
            e.printStackTrace();
        }

    }
}
