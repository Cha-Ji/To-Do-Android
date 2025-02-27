package com.gdsc.todo.ui.home

import android.graphics.Paint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gdsc.todo.R
import com.gdsc.todo.databinding.ItemTodoBinding
import com.gdsc.todo.data.entity.ToDo
import com.gdsc.todo.ui.base.BaseViewHolder

class ToDoAdapter : ListAdapter<ToDo, BaseViewHolder<ItemTodoBinding>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemTodoBinding> =
        BaseViewHolder(parent, R.layout.item_todo)

    override fun onBindViewHolder(holder: BaseViewHolder<ItemTodoBinding>, position: Int) {
        // TODO: data binding 변수를 대입해줄 것
        holder.binding.item = getItem(position)
        holder.binding.executePendingBindings() // 프레임 예약이 아닌 즉시 실행
    }

    // TODO: ToDo 속성에 Done 여부를 추가하는 migration을 진행
    private fun setCancelLineIfDone(binding: ItemTodoBinding) = with(binding) {
        tvTodoTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        tvTodoContents.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    }

    companion object {

        val diffUtil by lazy {
            object : DiffUtil.ItemCallback<ToDo>() {
                override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo) = oldItem.title == newItem.title

                override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo) = oldItem == newItem
            }
        }
    }
}