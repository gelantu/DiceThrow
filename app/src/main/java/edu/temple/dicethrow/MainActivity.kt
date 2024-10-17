package edu.temple.dicethrow

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.rollDiceButton).setOnClickListener(){
            (supportFragmentManager.findFragmentById(R.id.rollDiceButton) as DieFragment).throwDie()
        }
        if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
                    !is DieFragment)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, DieFragment.newInstance(100))
                .commit()
    }

}