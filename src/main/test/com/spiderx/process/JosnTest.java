package com.spiderx.process;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.spiderx.bean.Config;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class JosnTest {
    @Test
    public void TestJsonInput() throws FileNotFoundException {
        Gson gson = new Gson();

        Reader reader = new FileReader(new File("/Users/xuning/workspace/idea/SpiderX/src/main/resources/dtd/spider_simple.json"));

        JsonReader jsonReader = new JsonReader(reader);
        Config map = gson.fromJson(jsonReader, Config.class);
        System.out.println(map);
    }
}
