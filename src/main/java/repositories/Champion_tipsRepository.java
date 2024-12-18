package repositories;
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
            statement = conn.prepareStatement("select * from champion_tips");
            rs = statement.executeQuery();


            while (rs.next()) {
            	Champion_tips ct = new Champion_tips();
                ct.setId(rs.getInt("id"));
                ct.setChampion(rs.getInt("champion"));
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
    public List<Champion_tips> findByIds(List<Integer> champion_ids) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Champion_tips> champion_tips = new ArrayList<>();
        ResultSet rs = null;

        try{
        	for(int i=0;i<champion_ids.size();i++) {
        		statement = conn.prepareStatement("select * from champion_tips where champion=?");
                statement.setInt(1, champion_ids.get(i));
                rs = statement.executeQuery();

                while (rs.next()) {
                    Champion_tips c = new Champion_tips();
                    c.setId(rs.getInt("id"));
                    c.setChampion(rs.getInt("champion"));
                    c.setTip(rs.getString("tip"));
                    champion_tips.add(c);
                }
        	}
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return champion_tips;
    }

    public void insertOne(Champion_tips ct) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO champion_tips(id, champion, tip) VALUES (?, ?, ?)");
            statement.setInt(1, ct.getId());
            statement.setInt(2, ct.getChampion());
            statement.setString(3, ct.getTip());
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
            statement = conn.prepareStatement("delete from champion_tips where id = ?");
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
