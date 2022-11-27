package repositories;
import models.Champions;
import connection.*;
import java.util.*;
import java.sql.*;

public class ChampionsRepository {

    private final AbstractConnection manager = new H2Connection();

    public List<Champions> findAll() {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Champions> ChampionList = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from champions");
            rs = statement.executeQuery();

            while (rs.next()) {
                Champions c = new Champions();
                c.setId(rs.getInt("id"));
                c.setChampion_name(rs.getString("champion_name"));
                c.setTitle(rs.getString("title"));
                c.setLore(rs.getString("lore"));
                c.setTags(rs.getString("tags"));
                ChampionList.add(c);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  ChampionList;
    }

    public void insertOne(Champions c) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO champions(champion_name, title, lore, tags) VALUES (?, ?, ?, ?)");
            statement.setString(2, c.getChampion_name());
            statement.setString(3, c.getTitle());
            statement.setString(4, c.getLore());
            statement.setString(5, c.getTags());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }
    }
    
    public Champions findById(int champion){
        Connection conn = manager.open();
        PreparedStatement statement = null;
        Champions c = new Champions();
        ResultSet rs = null;
        try{
            statement = conn.prepareStatement("select * from champions where id=?");
            statement.setInt(1, champion);
            rs= statement.executeQuery();
            while (rs.next()) {
            	c.setId(rs.getInt("id"));
            	c.setChampion_name(rs.getString("champion_name"));
            	c.setTitle(rs.getString("title"));
            	c.setLore(rs.getString("lore"));
            	c.setTags(rs.getString("tags"));
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  c;
    }
}