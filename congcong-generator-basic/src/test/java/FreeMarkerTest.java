import com.huchong.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerTest {

    @Test
    public void freeMarkTest() throws Exception {
        Configuration configuration =new Configuration(Configuration.VERSION_2_3_32);
        //指定模板文件路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        //设置字符集
        configuration.setDefaultEncoding("UTF-8");
        //创建模板对象，加载指定模板
        Template template = configuration.getTemplate("myweb.html.ftl");

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
        out.close();
    }

    @Test
    public void MainTemplateTest() throws Exception {
        Configuration configuration =new Configuration(Configuration.VERSION_2_3_32);
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        configuration.setDefaultEncoding("UTF-8");
        Template template = configuration.getTemplate("MainTemplate.java.ftl");
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
//        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setAuthor("胡冲");
        mainTemplateConfig.setOutputText("输出文本");
        Writer out = new FileWriter("MainTemplate2.java");
        template.process(mainTemplateConfig, out);
        out.close();
    }
}
