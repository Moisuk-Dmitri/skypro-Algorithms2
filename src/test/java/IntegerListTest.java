import exception.IncorrectIndexGivenException;
import exception.EmptyParameterGivenException;
import exception.IncorrectParameterGivenException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerListTest {

    IntegerList integerList;
    Integer strEmpty;
    Integer int1;
    Integer str2;

    @BeforeEach
    public void setup() {
        integerList = new IntegerListImpl();

        strEmpty = 0;
        int1 = 123;
        str2 = 1234;
    }

    @Test
    @DisplayName("Положительный тест на добавление элемента")
    public void shouldReturnIntegerElement() {
        assertEquals(integerList.add(int1), int1);
        assertEquals(integerList.add(str2), str2);
    }

    @Test
    @DisplayName("Положительный тест на добавление элемента через индекс")
    public void shouldReturnIntegerElementViaIndex() {
        assertEquals(integerList.add(0, int1), int1);
        assertEquals(integerList.add(0, str2), str2);
    }

    @Test
    @DisplayName("Отрицательный тест на добавление элемента с некорректным индексом")
    public void shouldThrowExceptionWhenIndexIsOutOfBoundsWhenAdd() {
        assertThrows(IncorrectIndexGivenException.class, () -> integerList.add(5, int1));
    }

    @Test
    @DisplayName("Положительный тест на замену элемента через индекс")
    public void shouldReturnIntegerElementWhenSet() {
        integerList.add(0, int1);
        assertEquals(integerList.set(0, str2), str2);
    }

    @Test
    @DisplayName("Отрицательный тест на замену элемента с некорректным индексом")
    public void shouldThrowExceptionWhenIndexIsOutOfBoundsWhenSet() {
        assertThrows(IncorrectIndexGivenException.class, () -> integerList.set(5, int1));
    }

    @Test
    @DisplayName("Положительный тест на удаление элемента через параметр")
    public void shouldReturnIntegerElementWhenRemoveViaParameter() {
        integerList.add(0, int1);
        assertEquals(integerList.remove(int1), int1);
    }

    @Test
    @DisplayName("Отрицательный тест на удаление элемента с некорректным параметром")
    public void shouldThrowExceptionWhenEmptyParameterWhenRemove() {
        assertThrows(IncorrectParameterGivenException.class, () -> integerList.remove(int1));
    }

    @Test
    @DisplayName("Положительный тест на удаление элемента через индекс")
    public void shouldReturnIntegerElementWhenRemoveViaIndex() {
        integerList.add(0, int1);
        assertEquals(integerList.remove(0), int1);
    }

    @Test
    @DisplayName("Отрицательный тест на удаление элемента с некорректным индексом")
    public void shouldThrowExceptionWhenIndexIsOutOfBoundsWhenRemove() {
        assertThrows(IncorrectIndexGivenException.class, () -> integerList.remove(5));
    }

    @Test
    @DisplayName("Положительный тест на успешный поиск элемента")
    public void shouldReturnTrueWhenContains() {
        integerList.add(int1);
        assertTrue(integerList.contains(int1));
    }

    @Test
    @DisplayName("Положительный тест на неудачный поиск элемента")
    public void shouldReturnFalseWhenContains() {
        integerList.add(0, int1);
        assertFalse(integerList.contains(str2));
    }

    @Test
    @DisplayName("Положительный тест на поиск индекса элемента с начала")
    public void shouldReturnIndexWhenIndexOf() {
        integerList.add(0, int1);
        assertEquals(integerList.indexOf(int1), 0);
    }

    @Test
    @DisplayName("Отрицательный тест на поиск индекса элемента с начала")
    public void shouldReturnNegativeIndexWhenIndexOf() {
        assertEquals(integerList.indexOf(int1), -1);
    }

    @Test
    @DisplayName("Положительный тест на поиск индекса элемента c конца")
    public void shouldReturnIndexWhenLastIndexOf() {
        integerList.add(0, int1);
        assertEquals(integerList.lastIndexOf(int1), 0);
    }

    @Test
    @DisplayName("Отрицательный тест на поиск индекса элемента c конца")
    public void shouldReturnNegativeIndexWhenLastIndexOf() {
        assertEquals(integerList.lastIndexOf(int1), -1);
    }

    @Test
    @DisplayName("Положительный тест на получение элемента по запросу")
    public void shouldReturnIntegerWhenGet() {
        integerList.add(int1);
        assertEquals(integerList.get(0), int1);
    }

    @Test
    @DisplayName("Отрицательный тест на получение элемента по запросу")
    public void shouldThrowExceptionWhenGet() {
        assertThrows(IncorrectIndexGivenException.class, () -> integerList.get(0));
    }

    @Test
    @DisplayName("Положительный тест на успешное сравнение объектов")
    public void shouldReturnTrueWhenEquals() {
        IntegerList otherIntegerList = new IntegerListImpl();
        otherIntegerList.add(int1);

        integerList.add(int1);
        assertTrue(integerList.equals(otherIntegerList));
    }

    @Test
    @DisplayName("Положительный тест на неудачное сравнение объектов")
    public void shouldReturnFalseWhenEquals() {
        IntegerList otherIntegerList = new IntegerListImpl();
        otherIntegerList.add(str2);

        integerList.add(int1);
        assertFalse(integerList.equals(otherIntegerList));
    }

    @Test
    @DisplayName("Положительный тест на получение размера листа")
    public void shouldReturnsSize() {
        integerList.add(int1);
        assertEquals(integerList.size(), 1);
    }

    @Test
    @DisplayName("Положительный тест на очистку листа")
    public void shouldClearArray() {
        integerList.add(int1);
        integerList.clear();
        assertEquals(integerList.size(), 0);
    }

    @Test
    @DisplayName("Положительный тест на получение копии листа")
    public void shouldReturnIntegerArray() {
        integerList.add(int1);

        Integer[] otherIntegerArray = new Integer[1];
        otherIntegerArray[0] = int1;
        assertArrayEquals(integerList.toArray(), otherIntegerArray);
    }
}
