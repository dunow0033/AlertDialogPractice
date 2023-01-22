package com.express.alertdialogpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var button : Button

    private lateinit var builder : AlertDialog.Builder

    private lateinit var editText: EditText

    private lateinit var st1: String

    private lateinit var textViewUsername: TextView
    private lateinit var textViewPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button = findViewById(R.id.button)

        textViewUsername = findViewById(R.id.textview_username)
        textViewPassword = findViewById(R.id.textview_password)

        button = findViewById(R.id.button)
        button.setOnClickListener ({
            showDialog()
        })
    }

    private fun bringUpAlertDialog(){

        builder = AlertDialog.Builder(this)

        editText = EditText(this)

        editText.setText("name here")

        builder.setTitle("Alert!")
            .setMessage("Do you want to exit?")
            .setView(editText)
            .setCancelable(true)
            .setPositiveButton("Yes"){ dialogInterface, it ->
                finish()
            }
            .setNegativeButton("No"){ dialogInterface, it ->
                st1 = editText.text.toString()
                dialogInterface.cancel()
                Toast.makeText(this@MainActivity, st1, Toast.LENGTH_SHORT).show()
            }
            .setNeutralButton("Help"){ dialogInterface, it ->
                Toast.makeText(this@MainActivity, "Help Clicked", Toast.LENGTH_SHORT).show()
            }.show()
    }

    fun showAlertDialog() {
        var alert = AlertDialog.Builder(this)

        alert.setTitle("Android Studio")
        alert.setMessage("Do you love Android?")
        alert.setPositiveButton("Yes") { dialogInterface, it ->
            Toast.makeText(this, "Good job!!", Toast.LENGTH_SHORT).show()
        }
        alert.setNegativeButton("No") { dialogInterface, it ->
            Toast.makeText(this, "Negative job!!", Toast.LENGTH_SHORT).show()
        }
        alert.setNeutralButton("Help") { dialogInterface, it ->
            Toast.makeText(this, "Cancel Clicked", Toast.LENGTH_SHORT).show()
        }
        alert.create().show()
    }

    fun showDialog() {
        var alert = AlertDialog.Builder(this)
            alert.setTitle("Android Studio")
            .setMessage("Do you love Android?")
            .setCancelable(true)
            .setPositiveButton("Yes") { dialogInterface, it ->
                Toast.makeText(this, "Good job!!", Toast.LENGTH_SHORT).show()
                dialogInterface.dismiss()
            }
            .setNegativeButton("No") { dialogInterface, it ->
                Toast.makeText(this, "Negative job!!", Toast.LENGTH_SHORT).show()
            }
            .setNeutralButton("Help") { dialogInterface, it ->
                Toast.makeText(this, "Cancel Clicked", Toast.LENGTH_SHORT).show()
            }.create().show()
    }
}