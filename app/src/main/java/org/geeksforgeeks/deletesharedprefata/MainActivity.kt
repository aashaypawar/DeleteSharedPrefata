package org.geeksforgeeks.deletesharedprefata

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTextView1 = findViewById<TextView>(R.id.text_view_1)
        val mButton = findViewById<Button>(R.id.button_1)

        val mSharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val mEditor = mSharedPreferences.edit()

        mEditor.putString("City", "Delhi").putString("Country", "India").apply()


        mTextView1.text = "${mSharedPreferences.getString("City", "")}\n${mSharedPreferences.getString("Country", "")}"

        mButton.setOnClickListener {
            mEditor.remove("City").apply()
            Toast.makeText(applicationContext, "City removed", Toast.LENGTH_SHORT).show()
            mTextView1.text = "${mSharedPreferences.getString("City", "")}\n${mSharedPreferences.getString("Country", "")}"
        }



    }
}