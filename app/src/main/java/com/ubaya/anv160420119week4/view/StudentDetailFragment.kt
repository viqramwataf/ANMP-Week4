package com.ubaya.anv160420119week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubaya.anv160420119week4.R
import com.ubaya.anv160420119week4.databinding.FragmentStudentDetailBinding
import com.ubaya.anv160420119week4.model.Student
import com.ubaya.anv160420119week4.util.loadImage
import com.ubaya.anv160420119week4.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment(), ButtonUpdateClickListener, NotifClickListener {

    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentStudentDetailBinding
//    var studentID = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        arguments?.let{
//            studentID = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
//        }
//        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
//        viewModel.fetch(studentID)
//        observeViewModel()
        var id = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        viewModel.fetch(id)
        observeViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_student_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root
    }

    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
//            txtID.setText(it.id)
//            txtName.setText(it.name)
//            txtBod.setText(it.bod)
//            txtPhone.setText(it.phone)
//            imgView.loadImage(it.photoUrl, progressBar2)
            dataBinding.student=it
            dataBinding.notifListener=this
            dataBinding.updateListener=this

        })
    }

    override fun onClickNotif(v: View, s: Student) {

    }

    override fun onUpdateClick(v: View, s: Student) {
        Toast.makeText(context, "Student: "+s.name, Toast.LENGTH_SHORT).show()
    }
}
