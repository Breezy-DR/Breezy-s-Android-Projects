package com.breezydr.recordkeeper.editrecord

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.edit
import com.breezydr.recordkeeper.databinding.ActivityEditRecordBinding
import java.io.Serializable

const val INTENT_EXTRA_SCREEN_DATA = "screen_data"

class EditRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRecordBinding

    private val screenData: ScreenData by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(INTENT_EXTRA_SCREEN_DATA, ScreenData::class.java) as ScreenData
        } else {
            intent.getSerializableExtra(INTENT_EXTRA_SCREEN_DATA) as ScreenData
        }
    }

    private val recordPreferences by lazy {
        getSharedPreferences(screenData.sharedPreferencesName, Context.MODE_PRIVATE)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUi()

        displayRecord()

//        // Used throughout the app
//        val applicationPreferences = PreferenceManager.getDefaultSharedPreferences(this)
//
//        applicationPreferences.edit {
//            putString("Some app data", "App preference value here")
//        }
//
//        // For one screen only
//        val activityPreferences = getPreferences(Context.MODE_PRIVATE)
//
//        activityPreferences.edit {
//            putInt("Some activity data", 15)
//        }
//
//        // Make any shared preferences as many as possible in the app (for each record category)
//        val fileNamePreferences = getSharedPreferences("some shared pref file name", Context.MODE_PRIVATE)
//
//        fileNamePreferences.edit {
//            putBoolean("some pref file name data", false)
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupUi() {
        title = "${screenData.record} Record"
        binding.textInputRecord.hint = screenData.recordFieldHint
        binding.buttonSave.setOnClickListener {
            saveRecord()
            // finish activity
            finish()
        }
        binding.buttonDelete.setOnClickListener {
            clearRecord()
            // finish activity
            finish()
        }
    }

    private fun clearRecord() {
        recordPreferences.edit {
            remove("${screenData.record} record")
            remove("${screenData.record} date")
        }
    }

    private fun displayRecord() {
        binding.editTextRecord.setText(recordPreferences.getString("${screenData.record} record", null))
        binding.editTextDate.setText(recordPreferences.getString("${screenData.record} date", null))

    }

    private fun saveRecord() {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()


        recordPreferences.edit {
            putString("${this@EditRecordActivity.screenData.record} record", record)
            putString("${this@EditRecordActivity.screenData.record} date", date)
        }
    }

    data class ScreenData(
        val record: String,
        val sharedPreferencesName: String,
        val recordFieldHint: String
    ) : Serializable
}