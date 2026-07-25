class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class ArrayProcessor {
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4. Получено строк: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4x4. Строка " + i + " имеет длину " + array[i].length);
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Неверные данные в ячейке [" + i + "][" + j + "]: \"" + array[i][j] + "\""
                    );
                }
            }
        }

        return sum;
    }
    public static void demonstrateArrayIndexOutOfBounds() {
        try {
            String[][] array = new String[4][4];
            String value = array[4][0]; // Индекс 4 не существует
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Описание: Попытка доступа к несуществующему индексу массива");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Пример 1: корректный массив
        System.out.println("=== Пример 1: Корректный массив ===");
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(correctArray);
            System.out.println("Сумма всех элементов: " + result);
            System.out.println("Ожидаемая сумма: 136\n");
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Пример 2: массив неправильного размера
        System.out.println("=== Пример 2: Массив неправильного размера ===");
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        try {
            int result = processArray(wrongSizeArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage() + "\n");
        }

        // Пример 3: массив с некорректными данными
        System.out.println("=== Пример 3: Массив с некорректными данными ===");
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "abc", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(invalidDataArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage() + "\n");
        }
        System.out.println("=== Демонстрация ArrayIndexOutOfBoundsException ===");
        demonstrateArrayIndexOutOfBounds();
    }
}