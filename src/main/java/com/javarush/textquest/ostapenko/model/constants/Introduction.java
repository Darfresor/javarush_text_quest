package com.javarush.textquest.ostapenko.model.constants;

public class Introduction {
    public static final String ANNOTATION = """
            <p>Ты стоишь в космическом порту и готов подняться на борт своего корабля. 
            <br>Разве ты не об этом мечтал? Стать капитаном галактического судна с экипажем, который будет совершать подвиги под твоим командованием.
            <br>Так что вперед!
            """;
    public static final String MEETING_THE_PLAYER = """
            <p>Когда ты поднялся на борт корабля, тебя поприветствовала девушка c черной папкой в руках: 
            <br>— Здравствуйте, командир! Я Энниэль — ваша помощница. 
            <br>Видите? Там в углу пьет кофе наш штурман — сержант Перестарый Шлейф,под штурвалом спит наш бортмеханик — Черный Ботали, а фотографирует его Сергей Стальная Пятка — наш навигатор.
            <br>А как обращаться к вам?
            """;
    public String getAnnotaionText(){
        return ANNOTATION;
    }
    public String getMettingThePlayerText(){
        return MEETING_THE_PLAYER;
    }
}
