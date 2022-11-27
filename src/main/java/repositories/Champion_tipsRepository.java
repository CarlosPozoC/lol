package repositories;
import models.Champions;
import connection.*;
import models.Champion_tips;

import java.util.*;
import java.sql.*;

public class Champion_tipsRepository {

    private final AbstractConnection manager = new H2Connection();

    public List<Champion_tips> findAll() {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Champion_tips> Champion_tipsList = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from alumno");
            rs = statement.executeQuery();

            ChampionsRepository championRepo = new ChampionsRepository();

            while (rs.next()) {
            	Champion_tips ct = new Champion_tips();
                ct.setId(rs.getInt("id"));
                ct.setChampion(championRepo.findById(rs.getInt("champion")));
                ct.setTip(rs.getString("tip"));
                Champion_tipsList.add(ct);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  Champion_tipsList;
    }

    public void insertOne(Champion_tips ct) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO champion_stats(stat_name, stat_value, champion, modifier_per_level ) VALUES (?, ?, ?, ?)");
            statement.setInt(1, ct.getChampion().getId());
            statement.setString(2, ct.getTip());
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
