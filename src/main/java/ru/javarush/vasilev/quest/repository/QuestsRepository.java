package ru.javarush.vasilev.quest.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import ru.javarush.vasilev.quest.entity.Quest;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class QuestsRepository {
    private static QuestsRepository instance;
    private Map<Integer, Quest> quests = new HashMap<>();

    private QuestsRepository() {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream("/json/quest02.json");
            StringReader reader = new StringReader(IOUtils.toString(stream, Charset.defaultCharset()));
            ObjectMapper mapper = new ObjectMapper();
            Quest src = mapper.readValue(reader, Quest.class);
            quests.put(0, src);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static QuestsRepository getInstance() {
        if (instance == null) {
            instance = new QuestsRepository();
        }
        return instance;
    }
    public Quest getQuestSourceById(Integer id){
        return quests.get(id);
    }
    public void putQuestSource(Quest source){
        quests.put(quests.size(), source);
    }
}
