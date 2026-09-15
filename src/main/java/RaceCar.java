//Класс описывающий автомобиль. Помимо названия автомобиля и его скорости отвечает
//за вычисления пройденного за время гонки пути.
//Название, скорость, а также время задаются в конструкторе, переменные не доступны для
//изменения, получить можно только название автомобиля и пройденное им расстояние.
public class RaceCar {
    private final String nameCar; // Название автомобиля
    private final int speedCar; // Скорость автомобиля
    private final int timeRace; // Время гонки

    public RaceCar(String nameCar, int speedCar) { // Создаем машину
        this.nameCar = nameCar;
        this.speedCar = speedCar;
        this.timeRace = 24; //Время проведения гонки (задано в задании)
    }

    public String getNameCar() { // Возвращаем название
        return nameCar;
    }

    public int getDistanceCar() { // Вычисляем и возвращаем пройденный за гонку путь
    //По условиям скорость автомобиля и время гонки целые числа, поэтому возвращаем целое число.
        return speedCar * timeRace;
    }

    public int getSpeedCar() {
        return speedCar;
    }

    public int getTimeRace() {
        return timeRace;
    }
}
