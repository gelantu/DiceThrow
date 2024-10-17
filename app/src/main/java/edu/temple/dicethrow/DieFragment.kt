package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

const val DIESIDE = "sidenumber"

class DieFragment : Fragment() {

    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        throwDie()
        view.setOnClickListener{
            throwDie()
        }
    }
//add + 1
    fun throwDie() {
        dieTextView.text = Random.nextInt((dieSides)+1).toString()
    }
    /*
    fun new instance(int sides): DieFragment{
        create a bundle { place an int where the key is DIESIDE and value is the int parameter}
        put the bundle inside
                create a fragment instance (of diefragment)
    }

     */
companion object{
    fun newInstance(sides: Int): DieFragment {
        val fragment = DieFragment()
        val args = Bundle().apply {
            putInt(DIESIDE, sides)
        }
        fragment.arguments = args
        return fragment
    }
        }

}