package JDBC;

import java.sql.*;
import java.util.Scanner;

public class task3 {

    private static final String url = "jdbc:postgresql://localhost:5432/task3db";
    private static final String username = "postgres";
    private static final String password = "75980";

    public static void main(String[] args) {
        clearTable();
        insertPoems();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter author:");
        String author = scanner.nextLine();

        String[] poemData = findPoemDataByAuthor(author);
        if (poemData != null) {
            System.out.println("Poem by " + author + " (Year: " + poemData[0] + "):\n" + poemData[1]);
            System.out.println("Number of sonnets by " + author + ": " + countSonnets(author));
        } else {
            System.out.println("No poem found for author " + author);
        }
    }

    public static void clearTable() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "DELETE FROM poems";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Table cleared successfully");
        } catch (SQLException e) {
            System.out.println("Error clearing table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void insertPoems() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String[] authors = {"Pushkin", "Lermontov", "Akhmatova"};
            int[] years = {1823, 1831, 1911};
            String[] poems = {"BLOB_DATA_FOR_POEM_1", "Sonnet. BLOB_DATA_FOR_POEM_2. blahblahblah!", "Sonnet"};

            String sql = "INSERT INTO poems (author, year, poem) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < authors.length; i++) {
                statement.setString(1, authors[i]);
                statement.setInt(2, years[i]);
                statement.setString(3, poems[i]);
                statement.executeUpdate();
            }
            System.out.println("Poems inserted successfully");
        } catch (SQLException e) {
            System.out.println("Error inserting poems: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String[] findPoemDataByAuthor(String author) {
        String[] poemData = null;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT year, poem FROM poems WHERE author = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, author);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                poemData = new String[2];
                poemData[0] = resultSet.getString("year");
                poemData[1] = resultSet.getString("poem");
            }

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            e.printStackTrace();
        }

        return poemData;
    }

    public static int countSonnets(String author) {
        int sonnetCount = 0;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT COUNT(*) AS sonnet_count FROM poems WHERE poem LIKE 'Sonnet%' AND author = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, author);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                sonnetCount = resultSet.getInt("sonnet_count");
            }

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            e.printStackTrace();
        }

        return sonnetCount;
    }
}
