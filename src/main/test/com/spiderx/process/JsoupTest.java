package com.spiderx.process;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import us.codecraft.webmagic.selector.Html;

import java.io.IOException;

public class JsoupTest {
    @Test
    public void TestJsoupSelectorParse(){
            try {
                Document doc  = Jsoup.connect("http://blog.csdn.net/MyCodeDream/article/category/5595045").get();
                Html html = Html.create(doc.html());
                html.xpath("").links().all();
                html.css("#main > div > ul.detail > li.blog-detail > ul.blog-units.blog-units-box > li:nth-child(1) > a").links().all();
                doc.title();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
