package 一些模式.行为型模式.responsibility.jdk;

public class ThridFilter implements Filter {
    @Override
    public void doFilter(Request req, Response res, FilterChain c) {
        System.out.println("过滤器3 前置处理");
        // 先执行所有request再倒序执行所有response
        c.doFilter(req, res);
        System.out.println("过滤器3 后置处理");
        
    }
}
