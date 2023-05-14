package todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ToDoMvcApp extends PageObject {

    public static final By TASK_INPUT_FIELD = By.className("new-todo");
    public static final By CLEAR_COMPLETED_TASKS_BUTTON = By.className("clear-completed");
    public static final String COMPLETE_CHECKBOX = "//label[. = '{0}']/..//input[contains(@class, 'toggle')]";
    public static final String FILTER_BUTTON = "//ul[@class = 'filters']//a[. = '{0}']";

    private final By TASK_ITEMS = By.xpath("//ul[@class = 'todo-list']//label");

    public List<String> getListOfTasks() {
        waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(TASK_ITEMS));
        return findAll(TASK_ITEMS).textContents();
    }
}
