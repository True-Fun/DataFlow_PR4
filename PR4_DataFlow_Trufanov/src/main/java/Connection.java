import java.sql.*;

public class Connection {
    private java.sql.Connection db = null;

    public Connection() {
        try {
            db = DriverManager.getConnection("jdbc:sqlite:src/main/resources/tour.db");
            System.out.println("База данных подключена");
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String selectTour(String name) {
        String sql = "SELECT * FROM tours WHERE name = (?)";
        String resultList = "";

        try {
            PreparedStatement ps = db.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
                resultList += rs.getString("name") + ". Цена: " + rs.getString("price") + " Отель: " + rs.getString("hotel") + "\n";
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        return resultList;
    }
}
