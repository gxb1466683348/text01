package com.sqnu.test;

import com.sqnu.dao.StudentDao;
import com.sqnu.domain.Student;
import com.sqnu.util.SqlSessionUtil;
import com.sqnu.vo.StudentAndClassroomVo;

import javax.xml.transform.Source;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test02 {
    public static void main(String[] args) {

        StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);

        //测试：parameterType使用简单数据类型  String
        /*Student s1 = studentDao.select1("A0001");
        System.out.println(s1);*/

        //测试parameterType使用简单的数据类型 int
        //查询出所有年龄为33岁的学员详细信息
        /*List<Student> sList = studentDao.select2(33);
        for (Student s2 :sList){
            System.out.println(s2);
        }*/

        //测试paramterType
        //需求:查询出姓名为zl，年龄为33岁的学员信息
        /*List<Student> sList = studentDao.select3("zl",23);
        for (Student s2 :sList){
            System.out.println(s2);
        }*///不可以同时传递两个参数

        //测试：paramterType，使用domain为参数Student s
       /* Student s = new Student();
        s.setName("ww");
        s.setAge(33);
        List<Student> sList = studentDao.select4(s);
        for(Student s1 : sList){
            System.out.println(s1);
        }*/

       //测试：paramterType ，使用map为参数
        //需求:查询出姓名为zl，年龄为33岁的学员信息
        /*Map<String ,Object> map = new HashMap<>();
        map.put("name","ww");
        map.put("age",33);
        List<Student> sList = studentDao.select5(map);
        for(Student s1 : sList){
            System.out.println(s1);
        }*/

        //测试：动态sql where标签+if标签
        /*Student s= new Student ();
        s.setName("l");
        s.setAddress("g");
        List<Student> sList = studentDao.select17(s);
        for (Student s1 : sList){
            System.out.println(s1);
        }*/

        //测试：动态sql foreach标签
        //查询编号为A0001，A0002,A0003的学员信息
        /*String strArr[] = {"A0001","A0002","A0003"};
        List<Student> sList = studentDao.select18(strArr);
        for (Student s1 : sList){
            System.out.println(s1);
        }*/

        //根据id查单条
  /*      Student s = studentDao.select19("A0001");
        System.out.println(s);
*/

        //测试多表联查
       /* List<Map<String,Object>> sList = studentDao.select20();
        for (Map<String,Object> map :sList){
            Set<String> set =  map.keySet();
            for (String key :set){
                System.out.println("key="+key);
                System.out.println("value="+map.get(key));
            }
            System.out.println();

        }*/

       //测试：多表联查 查询出学生和班级所有信息  加VO
        List<StudentAndClassroomVo> voList = studentDao.select21();

        for (StudentAndClassroomVo vo:voList){
            System.out.println(vo);
        }


        //测试：多表联查 查询出学生和班级所有信息  加VO
        /*List<StudentAndClassroomVo> voList = studentDao.select22("l");

        for (StudentAndClassroomVo vo:voList){
            System.out.println(vo);
        }*/


    }
}
