import java.util.Scanner;

class RaceManager {
    int i = 0;

    // Метод для запуска процесса гонки
    public void run() {
        i = inputSpeedCar();
    }

    // Метод для получения скорости автомобиля от пользователя
    public int inputSpeedCar() {
        System.out.println("Введите скорость автомобиля (целое число)");
        int speedCar = 0; // Скорость автомобиля - может быть только целым числом от 0 до 250
        boolean isInputCorrect = false; //Если true - ввод скорости прошел успешно

        while (!isInputCorrect) { // Цикл будет работать до ввода корректного значения скорости
            Scanner scanner = new Scanner(System.in);

            try { // Проверяем корректность ввода скорости
                speedCar = scanner.nextInt(); // Если скорость не целое число - будет ошибка
                if (speedCar < 1 || speedCar > 250) throw new IllegalArgumentException(); // Если
                // скорость вне допустимого диапазона - бросаем ошибку
                System.out.println("Скорость автомобиля введена успешно");
                isInputCorrect = true; // Значение скорости корректно - выходим из цикла

            } catch (Exception e) { // Ловим ошибки. Выводим сообщение
                System.out.println("Скорость автомобиля должна быть целым числом от 1 до 250");
                System.out.println("Попробуйте ввести скорость автомобиля ещё раз");
            }
        }
        return speedCar; // Передаем скорость автомобиля из метода
    }
}
