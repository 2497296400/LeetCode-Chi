package generator.mapper;

import generator.domain.SopNotice;

/**
* @author 41038
* @description 针对表【sop_notice】的数据库操作Mapper
* @createDate 2023-06-28 18:16:52
* @Entity generator.domain.SopNotice
*/
public interface SopNoticeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SopNotice record);

    int insertSelective(SopNotice record);

    SopNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SopNotice record);

    int updateByPrimaryKey(SopNotice record);

}
