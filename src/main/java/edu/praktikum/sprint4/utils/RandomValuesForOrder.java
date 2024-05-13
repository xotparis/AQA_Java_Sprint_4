package edu.praktikum.sprint4.utils;

import java.util.Random;

public class RandomValuesForOrder {

    private static final Random random = new Random();

    public static String phoneNumber() {

        // Генерируем случайное 10-значное число
        long randomNumber = 9;
        for (int i = 0; i < 9; i++) {
            randomNumber = randomNumber * 10 + random.nextInt(10);
        }
        return String.valueOf(randomNumber);
    }

    public static String randomFirstNames() {
        String[] firstNames = {
                "Александр",
                "Дмитрий",
                "Михаил",
                "Иван",
                "Андрей",
                "Сергей",
                "Юрий",
                "Николай",
                "Владимир",
                "Алексей",
                "Артём",
                "Максим",
                "Игорь",
                "Виктор",
                "Олег",
                "Павел",
                "Константин",
                "Станислав",
                "Григорий",
                "Денис"
        };

        // Генерируем случайный индекс массива
        int randomIndex = random.nextInt(firstNames.length);

        // Возвращаем случайную фамилию
        return firstNames[randomIndex];
    }

    public static String randomSurname() {
        String[] surname = {
                "Иванов",
                "Смирнов",
                "Кузнецов",
                "Попов",
                "Соколов",
                "Лебедев",
                "Козлов",
                "Новиков",
                "Морозов",
                "Петров",
                "Волков",
                "Соловьёв",
                "Васильев",
                "Зайцев",
                "Павлов",
                "Семёнов",
                "Голубев",
                "Виноградов",
                "Богданов",
                "Воробьёв"
        };

        // Генерируем случайный индекс массива
        int randomIndex = random.nextInt(surname.length);

        // Возвращаем случайную фамилию
        return surname[randomIndex];

    }

}
