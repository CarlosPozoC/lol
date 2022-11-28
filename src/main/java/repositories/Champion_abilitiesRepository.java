package repositories;
import connection.*;
import models.Champion_abilities;
import java.util.*;
import java.sql.*;

public class Champion_abilitiesRepository {

    private final AbstractConnection manager = new H2Connection();

    public List<Champion_abilities> findAll() {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Champion_abilities> Champion_abilitiesList = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from champion_abilities");
            rs = statement.executeQuery();

            while (rs.next()) {
            	Champion_abilities ca = new Champion_abilities();
                ca.setId(rs.getInt("id"));
                ca.setChampion(rs.getInt("champion"));
                ca.setChampion_name(rs.getString("champion_name"));
                ca.setChampion_description(rs.getString("champion_description"));
                ca.setEffect(rs.getString("effect"));
                ca.setCost(rs.getString("cost"));
                ca.setRango(rs.getInt("rango"));
                Champion_abilitiesList.add(ca);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  Champion_abilitiesList;
    }

    public void insertOne(Champion_abilities ca) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO champion_abilities(id, champion, champion_name, champion_description, effect, cost, rango) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, ca.getId());
            statement.setInt(2, ca.getChampion());
            statement.setString(3, ca.getChampion_name());
            statement.setString(4, ca.getChampion_description());
            statement.setString(5, ca.getEffect());
            statement.setString(6, ca.getCost());
            statement.setInt(7, ca.getRango());
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
            statement = conn.prepareStatement("delete from champion_abilities where id = ?");
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
