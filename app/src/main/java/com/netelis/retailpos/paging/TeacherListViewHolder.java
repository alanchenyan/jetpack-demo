package com.netelis.retailpos.paging;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.netelis.retailpos.R;
import com.netelis.retailpos.entity.Teacher;


public class TeacherListViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName;
    private TextView tvSex;

    public TeacherListViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tv_name_item_rv_paging);
        tvSex = itemView.findViewById(R.id.tv_sex_item_rv_paging);
    }

    public void setName(Teacher teacher) {
        tvName.setText(teacher.getName());
        tvSex.setText(teacher.getSex());
    }

}
