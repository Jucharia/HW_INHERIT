import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Epic;
import ru.netology.domain.Meeting;
import ru.netology.domain.SimpleTask;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void TestMatchesInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");


        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertTrue(actual);
    }

    @Test
    public void TestMatchesInEpic() {
        String[] subtasks = {"Масло", "Соль", "Перец"};
        Epic epic = new Epic(68, subtasks);

        boolean actual = epic.matches("Масло");
        Assertions.assertTrue(actual);
    }

    @Test
    public void TestMatchesInMeeting() {

        Meeting meeting = new Meeting(65, "Распределить задачи", "Курсовая работа", "03/04/2023");


        boolean actual = meeting.matches("Распределить");
        Assertions.assertTrue(actual);
    }


}