package JDBC;

import java.sql.*;

public class task1 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/task1db?useUnicode=yes&characterEncoding=UTF-8";
        String user = "postgres";
        String password = "75980";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();

            String userInput = "hello";
            String query = "SELECT russian_translation FROM Dictionary WHERE english_word = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userInput);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("russian_translation"));
            }

        } catch (SQLException e) {
            System.err.println("Ошибка при работе с базой данных: " + e.getMessage());
        }
    }
}
