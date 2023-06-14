package com.ubaya.anv160420119week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.anv160420119week4.R
import com.ubaya.anv160420119week4.databinding.StudentListItemBinding
import com.ubaya.anv160420119week4.model.Student
import com.ubaya.anv160420119week4.util.loadImage
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studenList:ArrayList<Student>):RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonDetailClickListener {
    class StudentViewHolder(var view: StudentListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater, R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student = studenList[position]
        holder.view.listener = this
//        holder.view.txtID.text = studenList[position].id
//        holder.view.txtName.text = studenList[position].name
//
//
//        holder.view.btnDetail.setOnClickListener {
//            val action = studenList[position].id?.let { it1 ->
//                StudentListFragmentDirections.actionStudentDetail(
//                    it1
//                )
//            }
//            if (action != null) {
//                Navigation.findNavController(it).navigate(action)
//            }
//        }
//
//        var imageView = holder.view.findViewById<ImageView>(R.id.imgView)
//        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
//        imageView.loadImage(studenList[position].photoUrl, progressBar)
    }

    override fun getItemCount(): Int {
        return studenList.size
    }

    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}
