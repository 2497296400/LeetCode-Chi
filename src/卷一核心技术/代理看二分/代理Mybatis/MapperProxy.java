package 卷一核心技术.代理看二分.代理Mybatis;

public class MapperProxy {
    public static UserMapper getUserMapper(Class useClass) {
        return new MybatisInvcationHand(useClass).getProxy();
    }

    public static void main(String[] args) {
        UserMapper mapper = getUserMapper(UserMapper.class);
        mapper.add();
    }
}
