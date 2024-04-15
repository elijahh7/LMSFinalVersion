import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:/Users/purpl/Downloads/sqlite3/gui/LibraryDatabase1";
        String userName = "ElijahHutchison";
        String password = "Thor22";
        String query = "SELECT * FROM Book";

        try {
            // Load the SQLite JDBC driver (optional for JDBC 4.0 and later)
            Class.forName("org.sqlite.JDBC");

            // Establish connection to the SQLite database
            try (Connection connection = DriverManager.getConnection(url, userName, password);
                 Statement statement = connection.createStatement();
                 ResultSet result = statement.executeQuery(query)) {

                // Iterate over the ResultSet to retrieve data
                while (result.next()) {
                    StringBuilder libraryContents = new StringBuilder();
                    int columnCount = result.getMetaData().getColumnCount();
                    for (int x = 1; x <= columnCount; x++) {
                        libraryContents.append(result.getString(x)).append(", ");
                    }
                    System.out.println(libraryContents);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
