package com.fan.mybatisplus.CodeGenerator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

//代码生成器
public class FastAutoGeneratorTest {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis_plus?characterEncoding=utf-8&userSSL=false&serverTimezone=GMT%2B8",
                "root", "root")
                .globalConfig(builder -> {
                    builder.author("fan") // 设置作者
                            .fileOverride()// 覆盖已生成文件
                            .outputDir("E://JavaProjects//testMybatisGenerator//mybatis_plus");// 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.fan")// 设置父包名
                            .moduleName("mybatisplus") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,"E://JavaProjects//testMybatisGenerator//mybatis_plus"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_user")// 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine())// 使用Freemarker 引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
