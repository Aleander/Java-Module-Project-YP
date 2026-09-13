import java.util.Scanner;

// В данном классе организована логика работы программы
class RaceManager {
    private RaceCar[] raceCars = new RaceCar[3]; // Массив на три автомобиля (из условия задачи)
    // Массив позволяет жестко привязаться к порядковому номеру, таким образом даже если автомобили
    //будут с одинаковыми названиями, их можно будет идентифицировать.

    // Метод для запуска процесса гонки
    public void run() {
        int distanceWinnerCar = 0; // Хранит расстояние пройденное победителем (победителями)
        showHelloMessage();
        for (int i = 0; i < 3; i++) { // Заполняем массив автомобилями
            notifyStartInput(i + 1);
            raceCars[i] = new RaceCar(inputNameCar(), inputSpeedCar());
        }
        for (int i = 0; i < 3; i++) { // Определяем расстояние пройденное победителем (победителями)
            if (raceCars[i].getDistanceCar() > distanceWinnerCar) {
                distanceWinnerCar = raceCars[i].getDistanceCar();
            }
        }
        announceResults();
        for (int i = 0; i < 3; i++) { // Определяем победителя (победителей)
            // для этого сравниваем расстояние пройденное автомобилем с победным расстоянием
            // Таким образом, победителей может быть больше, чем один
            if (raceCars[i].getDistanceCar() == distanceWinnerCar) {
                showWinnerCar(i, raceCars[i]);
            }
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
    // Сообщаем, что далее выведем результат
    private void announceResults() {
        System.out.println("_____________________________________________");
        System.out.println("В гонке «24 часа Ле-Мана» победил (победили):");
        System.out.println("_____________________________________________");
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
        System.out.println("Введите скорость автомобиля (целое число) от 1 до 250 км/ч:");
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
                System.out.println("Скорость автомобиля должна быть целым числом от 1 до 250 км/ч");
                System.out.println("Введите скорость автомобиля ещё раз:");
            }
        }
        return speedCar; // Передаем скорость автомобиля из метода
    }

    // Метод возвращающий данные победителя.
    // В случае подачи на вхд Null будут проблемы.
    // Но организация проверки усложнит логику - оставил так
    private void showWinnerCar(int numberWinnerCar, RaceCar winnerCar) {
        System.out.println("Автомобиль № " + (numberWinnerCar + 1)); // Преобразовал строку в скобках в int
        System.out.println("Название автомобиля: " + winnerCar.getNameCar());
        System.out.println("Скорость автомобиля: " + winnerCar.getSpeedCar() + " км/ч");
        System.out.println("За время " + winnerCar.getTimeRace() + " ч победитель проехал " +
                winnerCar.getDistanceCar() + " км");
        System.out.println("_____________________________________________");
    }
}
