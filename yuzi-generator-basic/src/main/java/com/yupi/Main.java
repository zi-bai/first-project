package com.yupi;

import java.io.File;

import static com.yupi.generator.StaticGenerator.copyFilesByHutool;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
        //获取整个项目的根目录
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        //输入路径：ACM示例代码模板目录
        String inputPath=new File(parentFile,"yuzi-generator-demo-projects/acm-template").getAbsolutePath();
        //输出路径：直接输出到项目的根目录
        String outputPath = projectPath;
        copyFilesByHutool(inputPath,outputPath);
    }
}