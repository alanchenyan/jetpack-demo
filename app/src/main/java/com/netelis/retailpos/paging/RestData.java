package com.netelis.retailpos.paging;

import java.util.ArrayList;
import java.util.List;

public class RestData {

    /**
     * 假装是从服务器取的数据
     * @return
     */
    public List<Teacher> getTeachers(){
        List<Teacher> teachers = new ArrayList<>();

        for(int i = 1;i<101;i++){
            String sex;
            if(i%2==0){
                sex = "男";
            }else{
                sex = "女";
            }

            Teacher teacher = new Teacher(i,"Teacher "+i,sex);
            teachers.add(teacher);
        }
        return teachers;
    }
}
