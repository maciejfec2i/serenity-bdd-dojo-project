package todomvc.tests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import todomvc.actions.ToDoMvcAppActions;
import todomvc.pageobjects.ToDoMvcApp;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenCompletingATask {

    private ToDoMvcApp toDoMvcApp;

    @Steps
    private ToDoMvcAppActions toDoList;

    private String taskOne = "Feed the cat";
    private String taskTwo = "Walk the dog";

    @BeforeEach
    public void setUp() {
        toDoMvcApp.open();

        // Add "Feed the cat" and "Walk the dog" to the list
        toDoList.addTasks(taskOne, taskTwo);

        // Complete "Feed the cat"
        toDoList.toggleTask(taskOne);
    }

    // Exercise 3
    @Test
    public void activeTasksShouldNotShowCompletedTasks() {
        // Filter by "Active"
        toDoList.filterBy("Active");

        // Check that only "Walk the dog" appears
        List<String> listOfTasks = toDoMvcApp.getListOfTasks();
        Serenity.reportThat(
                "Only '" + taskTwo + "' is visible",
                () -> assertThat(listOfTasks).containsExactly(taskTwo)
        );
    }

    // Exercise 4
    @Test
    public void completedTasksShouldNotShowActiveTasks() {
        // Filter by "Completed"
        toDoList.filterBy("Completed");

        // Check that only "Feed the cat" appears
        List<String> listOfTasks = toDoMvcApp.getListOfTasks();
        Serenity.reportThat(
                "Only '" + taskOne + "' is visible",
                () -> assertThat(listOfTasks).containsExactly(taskOne)
        );
    }
}
