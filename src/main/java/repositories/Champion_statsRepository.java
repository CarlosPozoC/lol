package repositories;
import models.Champions;
import connection.*;
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
            statement = conn.prepareStatement("select * from alumno");
            rs = statement.executeQuery();

            ChampionsRepository championRepo = new ChampionsRepository();

            while (rs.next()) {
            	Champion_stats cs = new Champion_stats();
                cs.setStat_name(rs.getString("stat_name"));
                cs.setStat_value(rs.getInt("stat_value"));
                cs.setChampion(championRepo.findById(rs.getInt("champion")));
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

    public void insertOne(Champion_stats cs) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO champion_stats(stat_name, stat_value, champion, modifier_per_level ) VALUES (?, ?, ?, ?)");
            statement.setString(1, cs.getStat_name());
            statement.setInt(2, cs.getStat_value());
            statement.setInt(3, cs.getChampion().getId());
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

    public void updateChampion(int id, int champion) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("update champion set champion = ? where id = ?");
            statement.setInt(1, champion);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }
    }
    public String calcChampionStr(int id){
        ChampionsRepository championsRepository = new ChampionsRepository();
        return championsRepository.findById(id).getChampion_name();
    }
}
