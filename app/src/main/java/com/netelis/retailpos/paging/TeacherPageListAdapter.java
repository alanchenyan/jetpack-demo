package com.netelis.retailpos.paging;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.netelis.retailpos.R;
import com.netelis.retailpos.entity.Teacher;

public class TeacherPageListAdapter extends PagedListAdapter<Teacher, TeacherListViewHolder> {

    private static final DiffUtil.ItemCallback<Teacher> DIFF_CALLBACK = new DiffUtil.ItemCallback<Teacher>() {
        @Override
        public boolean areItemsTheSame(@NonNull Teacher oldItem, @NonNull Teacher newItem) {

            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Teacher oldItem, @NonNull Teacher newItem) {

            return oldItem.getId() == newItem.getId() && oldItem.getName().equals(newItem.getName());
        }
    };

    /**
     * 继承PagedListAdapter，必须要调用基类的一个构造函数
     */
    public TeacherPageListAdapter() {
        super(DIFF_CALLBACK);

    }

    @NonNull
    @Override
    public TeacherListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paging, parent, false);
        return new TeacherListViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherListViewHolder holder, int position) {
        holder.setName(getItem(position));
    }
}
