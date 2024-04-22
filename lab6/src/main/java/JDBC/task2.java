package JDBC;
import java.sql.*;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        String languageChoice;
        String word;

        if (args.length < 2) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Выберите язык (russian_belarusian_dictionary или belarusian_russian_dictionary): ");
            languageChoice = scanner.nextLine();
            System.out.print("Введите слово для перевода: ");
            word = scanner.nextLine();
        } else {
            languageChoice = args[0];
            word = args[1];
        }

        String url = "jdbc:postgresql://localhost:5432/" + languageChoice;
        String user = "postgres";
        String password = "75980";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String table;
            if (languageChoice.equals("russian_belarusian_dictionary")) {
                table = "russian_to_belarusian";
            } else {
                table = "belarusian_to_russian";
            }

            String query = "SELECT translation FROM " + table + " WHERE source_word = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, word);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String translation = resultSet.getString("translation");
                System.out.println("Перевод слова \"" + word + "\": " + translation);
            } else {
                System.out.println("Перевод для слова \"" + word + "\" не найден.");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при работе с базой данных: " + e.getMessage());
        }
    }
}
