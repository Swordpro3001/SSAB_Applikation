package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.influxdb.client.*;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;

import java.time.Instant;

public class FunktionPage_Page4 extends AppCompatActivity {

    private String url,  token,  bucket,  org;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_funktion_page_page4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public static void main(final String[] args) {

        // You can generate an API token from the "API Tokens Tab" in the UI
        String token = System.getenv("INFLUX_TOKEN");
        String bucket = "SSAB";
        String org = "TGM";

        InfluxDBClient client = InfluxDBClientFactory.create("http://tgm-edu.de:8086", token.toCharArray());

        String data = "mem,host=host1 used_percent=23.43234543";

        WriteApiBlocking writeApi = client.getWriteApiBlocking();
        writeApi.writeRecord(bucket, org, WritePrecision.NS, data);

        Point point = Point
                .measurement("mem")
                .addTag("host", "host1")
                .addField("used_percent", 23.43234543)
                .time(Instant.now(), WritePrecision.NS);

        writeApi.writePoint(bucket, org, point);
    }

    public InfluxDBClient buildConnection(String url, String token, String bucket, String org) {

        setToken(token);

        setBucket(bucket);

        setOrg(org);

        setUrl(url);

        return InfluxDBClientFactory.create(getUrl(), getToken().toCharArray(), getOrg(), getBucket());

    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBucket() {
        return bucket;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }
}