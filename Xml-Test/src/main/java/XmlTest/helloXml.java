package XmlTest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import org.junit.Test;

import java.util.List;


/**
 * Description:
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.12 14:58
 */
public class helloXml {
    //xml的文件读取路径在IDEA中是从当前module
    @Test
    public void test01() throws DocumentException {
        //创建SAXReader对象进行读取Xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/book.xml");
        //获取根元素
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
        //通过根元素再来获取其他标签对象
        List <Element> elements = rootElement.elements("book");
        for(Element element:elements){
            System.out.println(element.asXML());
        }
        System.out.println(document);
    }
}
