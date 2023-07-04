package generator.mapper;

import generator.domain.EduUserNotice;

/**
* @author 41038
* @description 针对表【edu_user_notice】的数据库操作Mapper
* @createDate 2023-06-28 18:01:10
* @Entity generator.domain.EduUserNotice
*/
public interface EduUserNoticeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(EduUserNotice record);

    int insertSelective(EduUserNotice record);

    EduUserNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EduUserNotice record);

    int updateByPrimaryKey(EduUserNotice record);

}
