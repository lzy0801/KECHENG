package org.example.course_manager;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class CourseManagerApplicationTests {

    @Test
    void contextLoads() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/course?characterEncoding=utf-8&userSSL=false", "root", "12345678")
                .globalConfig(builder -> {
                    builder.author("lzy") // 设置作者
//.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E://yueqianshixun//course_manager//src//main//java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("org.example") // 设置父包名
                            .moduleName("course_manager") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    "E://yueqianshixun//course_manager//src//main//resources//mappers")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user");// 设置需要生成的表名
                })
                .strategyConfig(builder -> {
                    builder.addInclude("course");// 设置需要生成的表名
                })
                .strategyConfig(builder -> {
                    builder.addInclude("crcount");// 设置需要生成的表名
                })
                .strategyConfig(builder -> {
                    builder.addInclude("curelation");// 设置需要生成的表名
                })
                .strategyConfig(builder -> {
                    builder.addInclude("notice");// 设置需要生成的表名
                })
                .strategyConfig(builder -> {
                    builder.addInclude("power");// 设置需要生成的表名
                })
                .strategyConfig(builder -> {
                    builder.addInclude("role");// 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认
                .execute();
    }

}
