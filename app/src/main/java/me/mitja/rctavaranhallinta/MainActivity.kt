package me.mitja.rctavaranhallinta

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.google.zxing.integration.android.IntentIntegrator
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    lateinit var intentIntegrator: IntentIntegrator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initPython()
        val sum1 = findViewById<TextView>(R.id.sum1);
        val sum2 = findViewById<TextView>(R.id.sum1);
        val ans = findViewById<TextView>(R.id.ans);
        ans.text = laske(sum1.text.toString() ,sum2.text.toString())
    }
    //Python
    private fun laske(sum1: String,sum2: String): String {
        val python = Python.getInstance()
        val pythonFile = python.getModule("laske")
        return pythonFile.callAttr("laske",sum1,sum2).toString()
    }
    private fun initPython() {
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }
    }
}