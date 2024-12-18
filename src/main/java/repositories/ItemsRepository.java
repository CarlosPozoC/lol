package repositories;
import models.Items;
import connection.*;
import java.util.*;
import java.sql.*;

public class ItemsRepository {

    private final AbstractConnection manager = new H2Connection();

    public List<Items> findAll() {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Items> ItemList = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from items");
            rs = statement.executeQuery();

            while (rs.next()) {
                Items i = new Items();
                i.setId(rs.getInt("id"));
                i.setItem_name(rs.getString("item_name"));
                i.setEffect(rs.getString("effect"));
                ItemList.add(i);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  ItemList;
    }

    public void insertOne(Items i) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO items(id, item_name, effect) VALUES (?, ?, ?)");
            statement.setInt(1, i.getId());
            statement.setString(2, i.getItem_name());
            statement.setString(3, i.getEffect());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }
    }
    
    public void deleteById(int id){
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("delete from items where id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }
    }
}
