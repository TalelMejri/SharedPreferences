package com.example.sharedpreferences


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

lateinit var redbtn:Button
lateinit var bluebtn:Button
lateinit var greenbtn:Button
lateinit var blackbtn:Button
lateinit var countbtn:Button
lateinit var textcount:TextView
lateinit var clear:Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var color=Color.RED;
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textcount=findViewById(R.id.textCount);
        val sharedPreference: sharedPreferncesConfig =sharedPreferncesConfig(this)
        textcount.text=sharedPreference.getIntValue("count").toString();
        clear=findViewById(R.id.clear)
        if(sharedPreference.getStringValue("color")!=null){
            var testColor=sharedPreference.getStringValue("color");
            when (testColor) {
                "red"->  textcount.setBackgroundColor(Color.RED);
                "blue"->  textcount.setBackgroundColor(Color.BLUE);
                "green"->  textcount.setBackgroundColor(Color.GREEN);
                "black"->  textcount.setBackgroundColor(Color.BLACK);
            }
        }

        countbtn=findViewById(R.id.count)
        redbtn=findViewById(R.id.red);
        bluebtn=findViewById(R.id.blue)
        blackbtn=findViewById(R.id.black)
        greenbtn=findViewById(R.id.green)
        countbtn.setOnClickListener {
            var count=textcount.text.toString().toInt();
            count++;
            textcount.text=count.toString();
            sharedPreference.save("count",count);
        }
        redbtn.setOnClickListener {
            textcount.setBackgroundColor(Color.RED);
            sharedPreference.save("color","red");
        }
        bluebtn.setOnClickListener {
            textcount.setBackgroundColor(Color.BLUE);
            sharedPreference.save("color","blue");
        }
        blackbtn.setOnClickListener {
            textcount.setBackgroundColor(Color.BLACK);
            sharedPreference.save("color","black");
        }
        greenbtn.setOnClickListener {
            textcount.setBackgroundColor(Color.GREEN);
            sharedPreference.save("color","green");
        }
        clear.setOnClickListener {
            sharedPreference.clearSharedPreference();
            Toast.makeText(this,"SharedPrefences Clear",Toast.LENGTH_LONG).show();
            init();
        }

    }

    fun init(){
        textcount.text="0";
        textcount.setBackgroundColor(Color.GRAY)
    }
}