package todomvc.tests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import todomvc.actions.ToDoMvcAppActions;
import todomvc.pageobjects.ToDoMvcApp;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenDeletingATask {

    private ToDoMvcApp toDoMvcApp;

    @Steps
    private ToDoMvcAppActions toDoList;

    private String taskOne = "Feed the cat";
    private String taskTwo = "Walk the dog";

    // Exercise 5
    @Test
    public void deletedItemsShouldDisappearFromTheList() {
        toDoMvcApp.open();

        // Add "Feed the cat" and "Walk the dog" to the list
        toDoList.addTasks(taskOne, taskTwo);

        // Delete "Feed the cat"
        toDoList.deleteTask(taskOne);

        // Check that only "Walk the dog appears"
        List<String> listOfTasks = toDoMvcApp.getListOfTasks();
        Serenity.reportThat(
                "Only '" + taskTwo + "' is visible",
                () -> assertThat(listOfTasks).containsExactly(taskTwo)
        );
    }
}
