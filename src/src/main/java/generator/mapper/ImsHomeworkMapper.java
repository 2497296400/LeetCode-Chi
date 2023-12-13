package generator.mapper;

import generator.domain.ImsHomework;

/**
* @author 41038
* @description 针对表【ims_homework】的数据库操作Mapper
* @createDate 2023-10-16 16:55:34
* @Entity generator.domain.ImsHomework
*/
public interface ImsHomeworkMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ImsHomework record);

    int insertSelective(ImsHomework record);

    ImsHomework selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ImsHomework record);

    int updateByPrimaryKey(ImsHomework record);

}
