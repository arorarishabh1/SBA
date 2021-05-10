package com.myproj.dao ; 
 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
 
import java.sql.ResultSet; 
import java.util.ArrayList; 
 
import com.myproj.dbutil.DbConn; 
import com.myproj.model.Player; 
 
//dml -> executeUpdate() 
//dql -> executeQuery() 
 
public class PlayerDao { 
 
 public String savePlayer(Player player) { 
 
  try { 
   String sql = "insert into player values(?,?,?,?)"; 
 
   Connection con = DbConn.dbConnect(); 
   PreparedStatement stat = con.prepareStatement(sql); 
 
   stat.setString(1, player.getPlayerName()); 
   stat.setString(2, player.getRole()); 
   stat.setString(3, player.getStyle()); 
   stat.setString(4, player.getTeam()); 
 
   int res = stat.executeUpdate(); 
 
   if (res > 0) 
    return "record inserted"; 
 
  } catch (Exception e) { 
 
   e.printStackTrace(); 
  } 
 
  return "cannot insert record"; 
 } 
 
 public Player getPlayerByName(String name) { 
 
  try { 
 
   Connection con = DbConn.dbConnect(); 
 
   String sql = "select * from player where name=?"; 
   PreparedStatement stat = con.prepareStatement(sql); 
 
   System.out.println(name); 
   stat.setString(1, name); 
   ResultSet rs = stat.executeQuery(); 
 
   rs.next(); 
 
   String playername = rs.getString("playername"); 
   String role = rs.getString("role"); 
   String style = rs.getString("style"); 
   String team = rs.getString("team"); 
 
   Player player = new Player(playername, role, style, team); 
 
   return player; 
 
  } catch (Exception e) { 
 
   e.printStackTrace(); 
  } 
  return null; 
 } 
 
 public ArrayList<Player> getPlayer() { 
 
  try { 
 
   Connection con = DbConn.dbConnect(); 
 
   String sql = "select * from player"; 
   PreparedStatement stat = con.prepareStatement(sql); 
 
   ResultSet rs = stat.executeQuery(); 
 
   ArrayList<Player> players = new ArrayList<>(); 
 
   while (rs.next()) { 
    String playername = rs.getString("playername"); 
    String role = rs.getString("role"); 
    String style = rs.getString("style"); 
    String team = rs.getString("team"); 
 
    Player player = new Player(playername, role, style, team); 
 
    players.add(player); 
   } 
 
   return players; 
 
  } catch (Exception e) { 
 
   e.printStackTrace(); 
  } 
  return null; 
 } 
 
 public String deletePlayerByName(String playername) { 
 
  try { 
 
   Connection con = DbConn.dbConnect(); 
 
   String sql = "delete from player where name=?"; 
   PreparedStatement stat = con.prepareStatement(sql); 
 
   stat.setString(1, playername); 
   int rs = stat.executeUpdate(); 
 
   if (rs > 0) 
    return "record in the name  " + playername + " is deleted"; 
  } catch (Exception e) { 
 
   e.printStackTrace(); 
  } 
  return null; 
 } 
 
 public String updatePlayer(Player player) { 
 
  try { 
 
   Player playerOld = getPlayerByName(player.getPlayerName()); 
 
   Connection con = DbConn.dbConnect(); 
 
   String sql = "update player set name=?, role=?, style=? , team=? where name=?"; 
   PreparedStatement stat = con.prepareStatement(sql); 
 
   if (player.getPlayerName() == null) 
    player.setPlayerName(playerOld.getPlayerName()); 
 
   if (player.getRole() == null) 
    player.setRole(playerOld.getRole()); 
 
   if (player.getStyle() == null) 
    player.setStyle(playerOld.getStyle()); 
 
   if (player.getTeam() == null) 
    player.setTeam(playerOld.getTeam()); 
 
   stat.setString(1, player.getPlayerName()); 
   stat.setString(2, player.getRole()); 
   stat.setString(3, player.getStyle()); 
   stat.setString(4, player.getTeam()); 
 
   stat.setString(5, player.getPlayerName()); 
 
   int rs = stat.executeUpdate(); 
 
   if (rs > 0) { 
 
    System.out.println(playerOld); 
 
    System.out.println(player); 
 
    return "record updated for player " + player.getPlayerName(); 
   } 
 
  } catch (Exception e) { 
 
   e.printStackTrace(); 
  } 
  return null; 
 } 
 
}
