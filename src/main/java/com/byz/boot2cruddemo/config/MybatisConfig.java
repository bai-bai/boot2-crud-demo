package com.byz.boot2cruddemo.config;

//import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
@Deprecated
public class MybatisConfig {

//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor(){
//        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
//        // paginationInterceptor.setOverflow(false);
//        // 设置最大单页限制数量，默认 500 条，-1 不受限制
//        // paginationInterceptor.setLimit(500);
//        // 开启 count 的 join 优化,只针对部分 left join
//
//        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
//        //创建拦截器
//        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
//        paginationInnerInterceptor.setOverflow(true);
//        paginationInnerInterceptor.setMaxLimit(500l);
//        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
//
//        return mybatisPlusInterceptor;
//    }

}