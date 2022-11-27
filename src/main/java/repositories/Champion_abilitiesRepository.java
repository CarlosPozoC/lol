package repositories;
import models.Champions;
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

            ChampionsRepository championRepo = new ChampionsRepository();

            while (rs.next()) {
            	Champion_abilities ca = new Champion_abilities();
                ca.setId(rs.getInt("id"));
                ca.setChampion_name(rs.getString("champion_name"));
                ca.setChampion_description(rs.getString("champion_description"));
                ca.setChampion(championRepo.findById(rs.getInt("champion")));
                ca.setEffect(rs.getString("effect"));
                ca.setCost(rs.getString("cost"));
                ca.setRange(rs.getInt("range"));
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
            statement = conn.prepareStatement("INSERT INTO alumno(champion_name, champion_description, champion, effect, cost, range) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, ca.getChampion_name());
            statement.setString(2, ca.getChampion_description());
            statement.setInt(3, ca.getChampion().getId());
            statement.setString(4, ca.getEffect());
            statement.setString(5, ca.getCost());
            statement.setInt(6, ca.getRange());
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
