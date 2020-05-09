import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {

    private Connection connection;

    public void connect(){
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/group_java_se_jdbc?useUnicode=true&serverTimezone=UTC",
                    "root", "");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addItem(Items item){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO items (name, price, amount) " +
                    "VALUES (?, ?, ?)");

            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getAmount());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public ArrayList<Items> getAllItems(){

        ArrayList<Items> items = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT id, name, price, amount FROM items");

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                items.add(new Items(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("amount")
                ));
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return items;

    }

    public void updateItem(Items item){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE items SET name = ?, price = ?, amount = ? " +
                    "WHERE id = ?");

            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getAmount());
            statement.setLong(4, item.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void deleteItem(Long id){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    " DELETE FROM items WHERE id = ? ");

            statement.setLong(1, id);

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
