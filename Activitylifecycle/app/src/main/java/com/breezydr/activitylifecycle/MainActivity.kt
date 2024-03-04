package com.breezydr.activitylifecycle

import android.os.Bundle
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.breezydr.activitylifecycle.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //    private var numberOfLoads = 0
//    var seconds = 0
//
//    lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonExit.setOnClickListener {
            showDialog()
        }

        onBackPressedDispatcher.addCallback {
            // Will not actually run the default back button functionality (like return)
            // bc it got overridden
            showDialog()
        }

//    binding.textViewRefreshStatus.text = "welcome to app"

    }

    fun showDialog() {
        AlertDialog.Builder(this)
            .setTitle("Warning")
            .setView(R.layout.dialog_warning)
            .setPositiveButton("Yes") { _, _ ->
                finish()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .setNeutralButton("more info") {dialog, _ ->
                Toast.makeText(this, "this is the more info screen",
                    Toast.LENGTH_LONG).show()
            }
            .show()
    }



//    override fun onDestroy() {
//        super.onDestroy()
//        val userMessage = binding.editTextMessage.text
//        File(filesDir, "user message.txt").writeText(userMessage.toString())
//    }

//    override fun onPause() {
//        super.onPause()
//        timer.cancel()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        timer = fixedRateTimer(period = 1000L) {
//            runOnUiThread {
//                seconds++
//                binding.textViewTimer.text = "You've stared for $seconds seconds"
//            }
//        }
//    }

//    override fun onRestart() {
//        super.onRestart()
//        binding.textViewRefreshStatus.text = "feed updated"
//    }


//    override fun onResume() {
//        // Use onresume to refresh
//        super.onResume()
//        numberOfLoads++
//        binding.textViewRefreshStatus.text = "welcome to app, we have loaded your content $numberOfLoads time(s)"
//    }


}