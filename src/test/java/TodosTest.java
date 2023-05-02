import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void TestSearch1Match() {
        SimpleTask simpleTask = new SimpleTask(66, "Пойти в магазин");

        String[] subtasks = {"Масло", "Картошка", "Хлеб"};
        Epic epic = new Epic(12, subtasks);

        Meeting meeting = new Meeting(
                52,
                "Распределение задач",
                "Заметки",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask};

        Task[] actual = todos.search("Пойти");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSearch2Matches() {
        SimpleTask simpleTask = new SimpleTask(66, "Не есть хлеб после шести");

        String[] subtasks = {"масло", "картошка", "хлеб"};
        Epic epic = new Epic(12, subtasks);

        Meeting meeting = new Meeting(
                52,
                "Распределение задач",
                "Заметки",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask, epic};

        Task[] actual = todos.search("хлеб");


        Assertions.assertArrayEquals(expected, actual);
    }

}

