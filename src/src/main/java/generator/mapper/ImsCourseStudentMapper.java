package generator.mapper;

import generator.domain.ImsCourseStudent;

/**
* @author 41038
* @description 针对表【ims_course_student】的数据库操作Mapper
* @createDate 2023-10-16 16:54:58
* @Entity generator.domain.ImsCourseStudent
*/
public interface ImsCourseStudentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ImsCourseStudent record);

    int insertSelective(ImsCourseStudent record);

    ImsCourseStudent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ImsCourseStudent record);

    int updateByPrimaryKey(ImsCourseStudent record);

}
