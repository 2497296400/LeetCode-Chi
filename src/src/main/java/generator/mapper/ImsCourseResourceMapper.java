package generator.mapper;

import generator.domain.ImsCourseResource;

/**
* @author 41038
* @description 针对表【ims_course_resource】的数据库操作Mapper
* @createDate 2023-10-16 16:54:58
* @Entity generator.domain.ImsCourseResource
*/
public interface ImsCourseResourceMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ImsCourseResource record);

    int insertSelective(ImsCourseResource record);

    ImsCourseResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ImsCourseResource record);

    int updateByPrimaryKey(ImsCourseResource record);

}
