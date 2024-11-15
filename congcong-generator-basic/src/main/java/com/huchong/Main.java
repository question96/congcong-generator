package com.huchong;

import com.huchong.generator.StaticGenerator;

import java.io.File;
import java.util.Properties;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        // 输入路径：ACM 示例代码模板目录
        String inputPath = projectPath + File.separator + "sample-projects" + File.separator + "acm-template";
        // 输出路径：直接输出到项目的根目录
        String ouputpath = projectPath;
        //复制文件
        StaticGenerator.copyFilesByHutool(inputPath, ouputpath);
    }

}
