package com.example.ketul.calc1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends Activity {
    EditText n1,n2,ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addition(View v){
        n1=(EditText)findViewById(R.id.editText);
        n2=(EditText)findViewById(R.id.editText2);
        ans=(EditText)findViewById(R.id.editText3);
        Float f1=Float.parseFloat(n1.getText().toString());
        Float f2=Float.parseFloat(n2.getText().toString());
        String s3=add(f1,f2);
        ans.setText(s3);
    }
    public String add(Float f1,Float f2){
        Float f3=f1+f2;
        return f3.toString();
    }
    public void subtraction(View v){
        n1=(EditText)findViewById(R.id.editText);
        n2=(EditText)findViewById(R.id.editText2);
        ans=(EditText)findViewById(R.id.editText3);
        Float f1=Float.parseFloat(n1.getText().toString());
        Float f2=Float.parseFloat(n2.getText().toString());
        f2=f1-f2;
        ans.setText(f2.toString());

    }
    public void multiplication(View v){
        n1=(EditText)findViewById(R.id.editText);
        n2=(EditText)findViewById(R.id.editText2);
        ans=(EditText)findViewById(R.id.editText3);
        Float f1=Float.parseFloat(n1.getText().toString());
        Float f2=Float.parseFloat(n2.getText().toString());
        f2=f1*f2;
        ans.setText(f2.toString());

    }
    public void division(View v){
        n1=(EditText)findViewById(R.id.editText);
        n2=(EditText)findViewById(R.id.editText2);
        ans=(EditText)findViewById(R.id.editText3);
        Float f1=Float.parseFloat(n1.getText().toString());
        Float f2=Float.parseFloat(n2.getText().toString());
        f2=f1/f2;
        ans.setText(f2.toString());

    }
    public void sin(View v){
        n1=(EditText)findViewById(R.id.editText);
//        n2=(EditText)findViewById(R.id.editText2);
        ans=(EditText)findViewById(R.id.editText3);
        Float f1=Float.parseFloat(n1.getText().toString());
//        Float f2=Float.parseFloat(n2.getText().toString());
        Double d=Math.sin(Math.toRadians(f1.doubleValue()));
        ans.setText(d.toString());

    }
    public void cos(View v){
        n1=(EditText)findViewById(R.id.editText);
//        n2=(EditText)findViewById(R.id.editText2);
        ans=(EditText)findViewById(R.id.editText3);
        Float f1=Float.parseFloat(n1.getText().toString());
//        Float f2=Float.parseFloat(n2.getText().toString());
        Double d=Math.cos(Math.toRadians(f1.doubleValue()));
        ans.setText(d.toString());

    }
    public void tan(View v){
        n1=(EditText)findViewById(R.id.editText);
//        n2=(EditText)findViewById(R.id.editText2);
        ans=(EditText)findViewById(R.id.editText3);
        Float f1=Float.parseFloat(n1.getText().toString());
//        Float f2=Float.parseFloat(n2.getText().toString());
        Double d=Math.tan(Math.toRadians(f1.doubleValue()));
        ans.setText(d.toString());

    }
    public void sqroot(View v){
        n1=(EditText)findViewById(R.id.editText);
        n2=(EditText)findViewById(R.id.editText2);
        ans=(EditText)findViewById(R.id.editText3);
        Float f1=Float.parseFloat(n1.getText().toString());
        Double d=Math.sqrt(f1.doubleValue());

        ans.setText(d.toString());

    }
    public void save_file(View v){
        File f= this.getExternalFilesDir(null);
        File f1= new File(f,"xyz.txt");
        try{
            FileOutputStream fileOutputStream =new FileOutputStream(f1);
            ans=(EditText)findViewById(R.id.editText3);
            try {
                fileOutputStream.write(ans.getText().toString().getBytes());
                Toast.makeText(this,"Copied "+ans.getText().toString() + " to file",Toast.LENGTH_LONG).show();

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                fileOutputStream.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void get_file(View v){
        n1=(EditText)findViewById(R.id.editText);
        File path=this.getExternalFilesDir(null);
        File file=new File(path,"xyz.txt");
        int length= (int) file.length();
        byte[] bytes =new byte[length];
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            fileInputStream.read(bytes);
            String s=new String(bytes);
            Toast.makeText(this,s+" REcalled ",Toast.LENGTH_LONG).show();
            n1.setText(s);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
