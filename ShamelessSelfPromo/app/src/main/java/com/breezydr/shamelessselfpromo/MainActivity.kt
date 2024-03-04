package com.breezydr.shamelessselfpromo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private var contactNameEditText: TextInputEditText? = null
    private var contactNumberEditText: TextInputEditText? = null
    private var myDisplayNameEditText: TextInputEditText? = null
    private var startDateEditText: TextInputEditText? = null
    private var juniorCheckbox: CheckBox? = null
    private var immediateStartCheckbox: CheckBox? = null
    private var jobTitleSpinner: Spinner? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val previewButton: Button = findViewById(R.id.button_preview)
        previewButton.setOnClickListener {

            onPreviewClicked()
        }


    }

    private fun onPreviewClicked() {

        contactNameEditText = findViewById(R.id.edit_text_contact_name)
        contactNumberEditText = findViewById(R.id.edit_text_contact_number)
        myDisplayNameEditText = findViewById(R.id.edit_text_my_display_name)
        startDateEditText = findViewById(R.id.edit_text_start_date)
        juniorCheckbox = findViewById(R.id.check_box_junior)
        immediateStartCheckbox = findViewById(R.id.check_box_immediate_start)
        jobTitleSpinner = findViewById(R.id.spinner_job_title)
        
        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Contact Name", contactNameEditText?.text.toString())
        previewActivityIntent.putExtra("Contact Number", contactNumberEditText?.text.toString())
        previewActivityIntent.putExtra("My Display Name", myDisplayNameEditText?.text.toString())
        previewActivityIntent.putExtra("Include Junior", juniorCheckbox.toString())
        previewActivityIntent.putExtra("Job Title", contactNameEditText?.text.toString())
        previewActivityIntent.putExtra("Immediate Start", contactNameEditText.toString())
        previewActivityIntent.putExtra("Start Date", contactNameEditText.toString())


        startActivity(previewActivityIntent)

    }
}