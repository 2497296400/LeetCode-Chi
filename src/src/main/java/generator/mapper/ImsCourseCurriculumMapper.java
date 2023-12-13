package generator.mapper;

import generator.domain.ImsCourseCurriculum;

/**
* @author 41038
* @description 针对表【ims_course_curriculum(课表)】的数据库操作Mapper
* @createDate 2023-10-16 16:54:58
* @Entity generator.domain.ImsCourseCurriculum
*/
public interface ImsCourseCurriculumMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ImsCourseCurriculum record);

    int insertSelective(ImsCourseCurriculum record);

    ImsCourseCurriculum selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ImsCourseCurriculum record);

    int updateByPrimaryKey(ImsCourseCurriculum record);

}
