package com.example.myflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit

class CategoryFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory: Button = view.findViewById(R.id.btn_detail_category)
        val tvData: TextView = view.findViewById(R.id.tv_data)

        btnDetailCategory.setOnClickListener(this)

        if (arguments != null) {
            val categoryName = arguments?.getString("Nama")
            tvData.text = categoryName
        }
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_detail_category) {
            val mDetailCategoryFragment = DetailCategoryFragment()

            val mBundle = Bundle()
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Data")
            val description = "Ini deskripsi dari category fragment"

            mDetailCategoryFragment.arguments = mBundle
            mDetailCategoryFragment.description = description

            /*val mFragmentManager = parentFragmentManager
            mFragmentManager.commit {
                addToBackStack(null)
                replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
            }*/
        }
    }


}