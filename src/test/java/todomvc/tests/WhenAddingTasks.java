package todomvc.tests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import todomvc.actions.ToDoMvcAppActions;
import todomvc.pageobjects.ToDoMvcApp;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingTasks {

    private ToDoMvcApp toDoMvcApp;

    @Steps
    private ToDoMvcAppActions toDoList;

    @BeforeEach
    public void setUp() {
        toDoMvcApp.open();
    }

    // Exercise 1
    @Test
    public void addingASingleTask() {
        // Add "Feed the cat" to the list
        String task = "Feed the cat";
        toDoList.addTask(task);

        // Check that "Feed the cat" appears in the list
        List<String> listOfTasks = toDoMvcApp.getListOfTasks();
        Serenity.reportThat(
                "Task '" + task + "' is in the list of To Do items",
                () -> assertThat(listOfTasks).containsExactly(task)
        );
    }

    // Exercise 2
    @Test
    public void  addingMultipleTasks() {
        // Add "Feed the cat" and "Walk the dog"
        String taskOne = "Feed the cat";
        String taskTwo = "Walk the dog";
        toDoList.addTasks(taskOne, taskTwo);

        // Check that all added tasks appear in the list
        List<String> listOfTasks = toDoMvcApp.getListOfTasks();
        Serenity.reportThat(
                "Tasks '" + taskOne + "' and '" + taskTwo + "' are in the list of To Do items",
                () -> assertThat(listOfTasks).containsExactly(taskOne, taskTwo)
        );
    }
}
