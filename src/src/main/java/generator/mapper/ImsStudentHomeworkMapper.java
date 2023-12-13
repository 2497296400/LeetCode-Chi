package generator.mapper;

import generator.domain.ImsStudentHomework;

/**
* @author 41038
* @description 针对表【ims_student_homework】的数据库操作Mapper
* @createDate 2023-10-16 16:54:58
* @Entity generator.domain.ImsStudentHomework
*/
public interface ImsStudentHomeworkMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ImsStudentHomework record);

    int insertSelective(ImsStudentHomework record);

    ImsStudentHomework selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ImsStudentHomework record);

    int updateByPrimaryKey(ImsStudentHomework record);

}
