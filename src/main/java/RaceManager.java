import java.util.Scanner;

// В данном классе организована логика работы программы
class RaceManager {
    private RaceCar[] raceCars = new RaceCar[3]; // Массив на три автомобиля (из условия задачи)

    // Метод для запуска процесса гонки
    public void run() {
        showHelloMessage();
        for (int i = 0; i<3; i++){ // Заполняем массив автомобилями
            notifyStartInput(i+1);
            raceCars[i] = new RaceCar(inputNameCar(), inputSpeedCar());
        }
    }

    // Метод выводящий приветственное сообщение
    private void showHelloMessage() {
        System.out.println("_____________________________________________");
        System.out.println("Приветствую вас на «24 часа Ле-Мана»");
        System.out.println("_____________________________________________");
        System.out.println();
        System.out.println("Вам необходимо ввести данные трёх автомобилей");
        System.out.println();
    }

    // Метод уведомляющий о начале ввода данных на автомобиль с конкретным порядковым номером
    private void notifyStartInput(int numberCar) {
        System.out.println("Запрос данных автомобиля № " + numberCar);
        System.out.println();
    }

    private String inputNameCar() {
        System.out.println("Введите название автомобиля:");
        Scanner scanner = new Scanner(System.in);
        String nameCar = scanner.next(); // Получаем название автомобиля
        System.out.println("Название автомобиля введено успешно");
        System.out.println();
        return nameCar; // Возвращаем название из метода
    }

    // Метод для получения скорости автомобиля от пользователя
    private int inputSpeedCar() {
        System.out.println("Введите скорость автомобиля (целое число) от 1 до 250:");
        int speedCar; // Скорость автомобиля - может быть только целым числом от 1 до 250

        while (true) { // Цикл будет работать до ввода корректного значения скорости
            Scanner scanner = new Scanner(System.in);

            try { // Проверяем корректность ввода скорости
                speedCar = scanner.nextInt(); // Если скорость не целое число - будет ошибка
                if (speedCar < 1 || speedCar > 250) throw new IllegalArgumentException(); // Если
                // скорость вне допустимого диапазона - бросаем ошибку
                System.out.println("Скорость автомобиля введена успешно");
                System.out.println();
                break; // Значение скорости корректно - выходим из цикла

            } catch (Exception e) { // Ловим ошибки. Выводим сообщение
                System.out.println("Скорость автомобиля должна быть целым числом от 1 до 250");
                System.out.println("Введите скорость автомобиля ещё раз:");
            }
        }
        return speedCar; // Передаем скорость автомобиля из метода
    }
}
