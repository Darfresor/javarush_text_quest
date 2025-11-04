package com.javarush.textquest.ostapenko;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javarush.textquest.ostapenko.model.entity.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestFillListQuestCard {
    public static void main(String[] args) throws IOException {

        Question question1 = new Question(1L, """
                После мгновения тишины в ваши уши врывается привычный гомон толпы.
                Вы находитесь в метро, застыв среди бесконечного людского потока.
                Многие тихо ругаются себе под нос когда сталкиваются с вами,
                но уже через мгновение вы чудесным образом стираетесь из их памяти и люди продолжают свой путь дальше.
                Впрочем вы не замечаете эти детали, а даже если бы захотели, сейчас есть дела поважнее.
                На часах 18:00. Ровно один час до начала трагической истории.
                Вы не можете ее остановить, но у вас есть время на подготовку.
                ""","На что вы потратите этот час?","img/quests/id2/images.jpg");
        List<Answer> listOfQuestion1 = new ArrayList<>();
        Answer answer1 = new Answer(1L,"Конечно же пора искать кузнечиков, муравьев и прочую живность!");
        Answer answer2 = new Answer(2L,"Ничего не делать");
        listOfQuestion1.add(answer1);
        listOfQuestion1.add(answer2);
        question1.setAnswers(listOfQuestion1);

        Question question3 = new Question(3L, """
                Вы лихорадочно вбиваете в смартфон поиск ближайших зоомагазинов и определившись с маршрутом двигаетесь в путь.
                По вашим внутренним ощущениям время почему-то начинает идти все быстрее, а поезд метро двигается все медленней.
                Потрачено 10 минут... 20 минут... 50 минут
                За 5 минут до 19:00 вы наконец вваливаетесь в зоомагазин тяжело дыша и бешено оглядываясь вокруг.  
                Хорошая новость - здесь есть муравьиная ферма!
                Плохая новость - перед вами слишком большая очередь.
                ""","Вы явно не успеваете ничего купить за оставшееся время. Ваши действия?","none");
        answer1.setNextQuestion(question3);
        List<Answer> listOfQuestion3 = new ArrayList<>();
        Answer answer3 = new Answer(3L,"Ну апокалипсис совсем скоро, просто подожду и потом заберу его.");
        Answer answer4 = new Answer(4L,"Схватить в руки ферму и стать в очередь. Нужно быть готовым к неожиданности.");
        listOfQuestion3.add(answer3);
        listOfQuestion3.add(answer4);
        question3.setAnswers(listOfQuestion3);




        Question question2 = new Question(2L, """
                В 19:00 тьма на мгновение окутывает ваше зрение и вы обнаруживаете себя в заполненном вагоне, со всех сторон зажатым людьми.
                Не успеваете вы приспособиться к внезапной смене обстановки, как слышите механический женский голос.
                [БЕСПЛАТНОЕ ОБСЛУЖИВАНИЕ ПЛАНЕТАРНОЙ СИСТЕМЫ 8612 БЫЛО ПРЕКРАЩЕНО]
                [С ЭТОГО МОМЕНТА НАЧНЁТСЯ МОНЕТИЗАЦИЯ] 
                [ОСНОВНОЙ СЦЕНАРИЙ ЗАПУЩЕН]
                Ваше тело не желает двигаться, в то время как история продолжает развиваться согласно известной вам новелле.
                Появление токкэби, первые смерти и наконец паника после объявления первого задания.
                Беспомощный, вы можете только наблюдать и лишь после ухода причудливого существа к вам возвращается подвижность.
                К сожалению, как бы вы не старались, пройти задание вам не удается. 
                
                ""","ВЫ ПРОИГРАЛИ!","none");
        answer3.setNextQuestion(question2);
        answer2.setNextQuestion(question2);
        question2.setDefeatFlag(true);



        Question question4 = new Question(4L, """
                Естественно за оставшиеся пять минут, очередь до вас не доходит.
                Затем ровно 19:00 тьма на мгновение окутывает ваше зрение и вы обнаруживаете себя в заполненном вагоне, со всех сторон зажатым людьми.
                Вы напряженно замираете, затем чувствуете текстуру стекла фермы, все еще зажатой под мышкой и слегка расслабляетесь. 
                В следующее мгновение со всех сторон звучит механический женский голос.
                [БЕСПЛАТНОЕ ОБСЛУЖИВАНИЕ ПЛАНЕТАРНОЙ СИСТЕМЫ 8612 БЫЛО ПРЕКРАЩЕНО]
                [С ЭТОГО МОМЕНТА НАЧНЁТСЯ МОНЕТИЗАЦИЯ] 
                [ОСНОВНОЙ СЦЕНАРИЙ ЗАПУЩЕН]
                Вы пытаетесь вытащить муравья из фермы, но ваше тело не желает двигаться.
                В то же время история продолжает развиваться согласно известной вам новелле.
                Появление токкэби, первые смерти и наконец паника после объявления первого задания.
                Беспомощный, вы можете только наблюдать и лишь после ухода причудливого существа к вам возвращается подвижность. 
                ""","До вашей гибели осталось 30 минут. Ваши действия?","none");
        answer4.setNextQuestion(question4);
        List<Answer> listOfQuestion4 = new ArrayList<>();
        Answer answer5 = new Answer(5L,"Разбить ферму и раздавить одного муравья. Остальных попытаться раздать другим.");
        Answer answer6 = new Answer(6L,"Разбить ферму и раздавить всех муравьев вкладывая монеты в статистику.");
        listOfQuestion4.add(answer5);
        listOfQuestion4.add(answer6);
        question4.setAnswers(listOfQuestion4);

        Question question5 = new Question(5L, """
                Как известно благими намерениями устлана дорога в Ад.
                Пока вы пытаетесь привлечь чужое внимание, кто-то бьет вас сзади по голове.
                Мир вокруг темнеет.
                ""","ПОРАЖЕНИЕ!","none");
        answer5.setNextQuestion(question5);
        question5.setDefeatFlag(true);

        Question question6 = new Question(6L, """
                Вы лихорадочно давите муравьев попутно повышая статистику.
                Благодаря повышенной выносливости, чужие удары не могут вам навредить и вы благополучно завершаете первый сценарий.
                ""","ПОБЕДА!","none");
        answer6.setNextQuestion(question6);
        question6.setWinFlag(true);


        Question question7 = new Question(7L, """
                Заглушка.
                ""","Заглушка","none");
        List<Answer> listOfQuestion7 = new ArrayList<>();
        Answer answer7 = new Answer(7L,"Заглушка");
        listOfQuestion7.add(answer7);
        question7.setAnswers(listOfQuestion7);

        List<Question> listQuestion = new ArrayList<>();
        listQuestion.add(question1);
        listQuestion.add(question2);
        listQuestion.add(question3);
        listQuestion.add(question4);
        listQuestion.add(question5);
        listQuestion.add(question6);
        listQuestion.add(question7);

        ObjectMapper mapper1 = new ObjectMapper();
        mapper1.enable(SerializationFeature.INDENT_OUTPUT);
        Path sourceResourcesPath1 = Paths.get("src/main/resources/data/quests");
        mapper1.writerWithDefaultPrettyPrinter()
                .writeValue(sourceResourcesPath1.resolve("listQuestion.json").toFile(), listQuestion);

        // Чтение из файла обратно в Java объект
        mapper1 = new ObjectMapper();
        List<Question> loadedList1 = mapper1.readValue(
                new File("src/main/resources/data/quests/listQuestion.json"),
                new TypeReference<List<Question>>() {
                }
        );
        System.out.println(loadedList1);



        List<Answer> listAnswer = new ArrayList<>();
        listAnswer.add(answer1);
        listAnswer.add(answer2);
        listAnswer.add(answer3);
        listAnswer.add(answer4);
        listAnswer.add(answer5);
        listAnswer.add(answer6);
        listAnswer.add(answer7);

        ObjectMapper mapper2 = new ObjectMapper();
        mapper2.enable(SerializationFeature.INDENT_OUTPUT);
        Path sourceResourcesPath2 = Paths.get("src/main/resources/data/quests");
        mapper2.writerWithDefaultPrettyPrinter()
                .writeValue(sourceResourcesPath2.resolve("listAnswer.json").toFile(), listAnswer);

        // Чтение из файла обратно в Java объект
        mapper2 = new ObjectMapper();
        List<Answer> loadedList2 = mapper2.readValue(
                new File("src/main/resources/data/quests/listAnswer.json"),
                new TypeReference<List<Answer>>() {
                }
        );
        System.out.println(loadedList2);



        QuestCard questCard1 = new QuestCard(1L, "История о попаданце в мир Мурима.", false, "none",question7);
        QuestCard questCard2 = new QuestCard(2L, "История по мотивам романа Всеведущий читатель", false, "none",question1);
        QuestCard questCard3 = new QuestCard(3L, "История в стиле РеалРПГ во вселенной Ника Перумова.", false, "none",question7);

        List<QuestCard> list = new ArrayList<>();
        list.add(questCard1);
        list.add(questCard2);
        list.add(questCard3);
        System.out.println(list);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Path sourceResourcesPath = Paths.get("src/main/resources/data/quests");
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(sourceResourcesPath.resolve("listCard.json").toFile(), list);

        // Чтение из файла обратно в Java объект
        mapper = new ObjectMapper();
        List<QuestCard> loadedList = mapper.readValue(
                new File("src/main/resources/data/quests/listCard.json"),
                new TypeReference<List<QuestCard>>() {
                }
        );
        System.out.println(loadedList);


        Set<UserRoles> adminUserRoles = new HashSet<>();
        adminUserRoles.add(UserRoles.ADMIN);
        adminUserRoles.add(UserRoles.BASE);
        User admin = new User("admin","admin",0L);
        admin.setUserRoles(adminUserRoles);

        Set<UserRoles> ordinaryUserRoles = new HashSet<>();
        ordinaryUserRoles.add(UserRoles.BASE);
        User ordinary = new User("user123","user123",0L);
        ordinary.setUserRoles(ordinaryUserRoles);

        List<User> listUsers = new ArrayList();
        listUsers.add(admin);
        listUsers.add(ordinary);

        ObjectMapper mapper4 = new ObjectMapper();
        mapper4.enable(SerializationFeature.INDENT_OUTPUT);
        Path sourceResourcesPath4 = Paths.get("src/main/resources/data/quests");
        mapper4.writerWithDefaultPrettyPrinter()
                .writeValue(sourceResourcesPath4.resolve("listUsers.json").toFile(), listUsers);

        // Чтение из файла обратно в Java объект
        mapper4 = new ObjectMapper();
        List<User> loadedList4 = mapper.readValue(
                new File("src/main/resources/data/quests/listUsers.json"),
                new TypeReference<List<User>>() {
                }
        );
        System.out.println(loadedList4);


    }
}
