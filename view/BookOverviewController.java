package com.labs.group8.view;

import com.labs.group8.model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BookOverviewController {
    @FXML
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, String> bookNameColumn;
    @FXML
    private TableColumn<Book, String> year;
    @FXML
    private TableColumn<Book, String> pages;
    @FXML
    private TableColumn<Book, String> number;
    @FXML
    private TableColumn<Book, String> publ;



    // Ссылка на главное приложение.
    private MainView mainView;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public BookOverviewController() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorsProperty());
        bookNameColumn.setCellValueFactory(cellData -> cellData.getValue().bookNameProperty());
        //year.setCellValueFactory(cellData -> cellData.getValue().yearProperty());
        //pages.setCellValueFactory(cellData -> cellData.getValue().pagesProperty());
        //number.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        //publ.setCellValueFactory(cellData -> cellData.getValue().publProperty());
    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param mainView
     */
    public void setMainView(MainView mainView) {
        this.mainView = mainView;

        // Добавление в таблицу данных из наблюдаемого списка
        bookTable.setItems(mainView.getBookData());
    }
}
