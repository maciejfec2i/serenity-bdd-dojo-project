package todomvc.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import todomvc.pageobjects.ToDoMvcApp;

import static todomvc.pageobjects.ToDoMvcApp.*;

public class ToDoMvcAppActions extends UIInteractionSteps {

    private ToDoMvcApp toDoMvcApp;

    @Step("Add task '{0}' to the list")
    public void addTask(String task) {
        $(TASK_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .typeAndEnter(task);
    }

    @Step("Add tasks '{0}' to the list")
    public void addTasks(String... tasks) {
        for(String task : tasks) {
            addTask(task);
        }
    }

    @Step("Toggle task '{0}'")
    public void toggleTask(String task) {
        $(COMPLETE_CHECKBOX, task)
                .click();
    }

    @Step("Filter tasks by '{0}'")
    public void filterBy(String filter) {
        $(FILTER_BUTTON, filter)
                .waitUntilVisible()
                .waitUntilClickable()
                .click();
    }

    @Step("Delete task '{0}'")
    public void deleteTask(String task) {
        toggleTask(task);
        $(CLEAR_COMPLETED_TASKS_BUTTON)
                .waitUntilVisible()
                .waitUntilClickable()
                .click();
    }
}
