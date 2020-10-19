package com.example.internettelevision

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_config.*



class ConfigFragment : Fragment() {
    companion object {
        private var instance : ConfigFragment? = null
        public fun getInstance() : ConfigFragment {
            return instance!!
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_config, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //custom actionbar
        MainActivity.getInstance().setTitle("Config")
        var colorDrawable = ColorDrawable(Color.parseColor("#009688"))
        MainActivity.getInstance().getSupportActionBar()?.setBackgroundDrawable(colorDrawable)

        // send to handler to parse data
        var handler = HandleButton()
        buttonSubmit.setOnClickListener(handler)
    }

}

class HandleButton : View.OnClickListener {
    override fun onClick(p0: View?) {
        var navController = Navigation.findNavController(ConfigFragment.getInstance().requireView())
        var callLetters: String = ConfigFragment.getInstance().editCallLetters.text.toString()
        var url: String = ConfigFragment.getInstance().editURL.text.toString()
        // get data entered by user, send to Channel
        if (callLetters != "" || url != "") {
            var bundle: Bundle = Bundle()
            bundle.putString("call", callLetters)
            bundle.putString("url", url)
            navController.navigate(R.id.configToChannel, bundle)
        }
    }
}