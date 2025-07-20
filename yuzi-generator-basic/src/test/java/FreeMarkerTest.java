import freemarker.template.Template;
import org.junit.Test;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerTest {
    @Test
    public void testConfiguration() throws IOException, TemplateException { // 添加方法体

    }

    public static void doGenerate(String inputPath, String outputPath,Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        configuration.setNumberFormat("0.######");

        //创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        //创建数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2023);
        List<Map<String, Object>> menuItems = new ArrayList<>();

        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url", "https://codefather.cn");
        menuItem1.put("label", "编程导航");

        Map<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url", "https://laoyujianli.com");
        menuItem2.put("label", "老鱼简历");

        menuItems.add(menuItem1);
        menuItems.add(menuItem2);

        dataModel.put("menuItems", menuItems);

        Writer out = new FileWriter("myweb.html");
        template.process(dataModel, out);

        // 生成文件后别忘了关闭哦
        out.close();

    }
}
