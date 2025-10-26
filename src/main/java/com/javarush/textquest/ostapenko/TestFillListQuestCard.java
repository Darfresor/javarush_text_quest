package com.javarush.textquest.ostapenko;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javarush.textquest.ostapenko.model.entity.QuestCard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestFillListQuestCard {
    public static void main(String[] args) throws IOException {
        QuestCard questCard1 = new QuestCard(1L, "История о попаданце в мир Мурима.", false, "none");
        QuestCard questCard2 = new QuestCard(2L, "История по мотивам романа Всеведущий читатель", false, "none");
        QuestCard questCard3 = new QuestCard(3L, "История в стиле РеалРПГ во вселенной Ника Перумова.", false, "none");

        List<QuestCard> list = new ArrayList<>();
        list.add(questCard1);
        list.add(questCard2);
        list.add(questCard3);
        System.out.println(list);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Path sourceResourcesPath = Paths.get("src/main/resources/data/quests");
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(sourceResourcesPath.resolve("list.json").toFile(), list);

        // Чтение из файла обратно в Java объект
        mapper = new ObjectMapper();
        List<QuestCard> loadedList = mapper.readValue(
                new File("src/main/resources/data/quests/list.json"),
                new TypeReference<List<QuestCard>>() {
                }
        );
        System.out.println(loadedList);


    }
}
