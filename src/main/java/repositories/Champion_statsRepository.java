package repositories;
import connection.*;
import models.Champion_abilities;
import models.Champion_stats;
import java.util.*;
import java.sql.*;

public class Champion_statsRepository {

    private final AbstractConnection manager = new H2Connection();

    public List<Champion_stats> findAll() {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Champion_stats> Champion_statsList = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from champion_stats");
            rs = statement.executeQuery();


            while (rs.next()) {
            	Champion_stats cs = new Champion_stats();
            	cs.setChampion(rs.getInt("champion"));
                cs.setStat_name(rs.getString("stat_name"));
                cs.setStat_value(rs.getInt("stat_value"));
                cs.setModifier_per_level(rs.getInt("modifier_per_level"));
                Champion_statsList.add(cs);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  Champion_statsList;
    }
    public List<Integer> findByStat(String stat_name,String condition,Integer stat_value){
    	Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Integer> champions_ids = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from champion_stats.champion where stat_name=? and stat_value??");
            statement.setString(1, stat_name);
            statement.setString(2, condition);
            statement.setInt(3, stat_value);
            rs = statement.executeQuery();

            while (rs.next()) {
            	Champion_stats cs = new Champion_stats();
                cs.setChampion(rs.getInt("champion"));
                champions_ids.add(cs.getChampion());
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  champions_ids;
    }
    public void insertOne(Champion_stats cs) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO champion_stats(champion, stat_name, stat_value, modifier_per_level ) VALUES (?, ?, ?, ?)");
            statement.setInt(1, cs.getChampion());
            statement.setString(2, cs.getStat_name());
            statement.setInt(3, cs.getStat_value());   
            statement.setInt(4, cs.getModifier_per_level());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }
    }
    
    public void deleteById(int champion){
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("delete from champion_stats where champion = ?");
            statement.setInt(1, champion);
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
