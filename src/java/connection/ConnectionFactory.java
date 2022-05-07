/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 *
 * @authors Gustavo Schwanka GRR20193748
            Leonardo Xavier da Silva Moraes GRR20204488
            Lucas Cassilha Zawadneak GRR20200141
            Ludimilla Krautzuk GRR20204467
 */
public class ConnectionFactory implements AutoCloseable {
    private static String DRIVER = "org.postgresql.Driver";
    private static String URL = "jdbc:postgresql://localhost:5432/java";
    private static String LOGIN = "postgres";
    private static String PASSWORD = "postgres";
    private static final  String CREATE_ARTIST = "CREATE TABLE IF NOT EXISTS artista ("
            + "id SERIAL PRIMARY KEY NOT NULL,"
            + "nome varchar(50) NOT NULL,"
            + "pais varchar(50) NOT NULL,"
            + "descricao varchar(150) NOT NULL); ";
    private static final String CREATE_MUSIC = "CREATE TABLE IF NOT EXISTS musica ("
            + "id SERIAL PRIMARY KEY NOT NULL,"
            + "titulo varchar(50) NOT NULL,"
            + "duracao varchar(50) NOT NULL,"
            + "idGenero varchar(50) NOT NULL,"
            + "letra text NOT NULL,"
            + "visualizacoes int NOT NULL,"
            + "idAlbum int NOT NULL,"
            + "spotify varchar(150),"
            + "deezer varchar(150),"
            + "appleMusic varchar(150));";
    private static final String CREATE_ARTIST_MUSIC = "CREATE TABLE IF NOT EXISTS artistMusic("
            + "id SERIAL PRIMARY KEY NOT NULL,"
            + "musicId int NOT NULL,"
            + "artistaId int NOT NULL,"
            + "CONSTRAINT fk_ArtMusicMusic foreign key (musicId) references musica(id),"
            + "CONSTRAINT fk_ArtMusicAlbum foreign key (artistaId) references artista(id));";
    private static final String CREATE_ALBUM = "CREATE TABLE IF NOT EXISTS album ("
            + "id SERIAL PRIMARY KEY NOT NULL,"
            + "nome varchar(50) NOT NULL UNIQUE,"
            + "ano INTEGER NOT NULL,"
            + "visualizacoes INTEGER NOT NULL);";  
    private static final String CREATE_GENERO = "CREATE TABLE IF NOT EXISTS genero("
            + "id SERIAL PRIMARY KEY NOT NULL,"
            + "nome varchar(50) NOT NULL);";
    private Connection con = null;
    
    public Connection getConnection() throws Exception{
        if(con == null){
            try{
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL,LOGIN,PASSWORD);
                PreparedStatement create_artist = con.prepareStatement(CREATE_ARTIST);
                create_artist.executeUpdate();
                create_artist = con.prepareStatement(CREATE_MUSIC);
                create_artist.executeUpdate();
                create_artist = con.prepareStatement(CREATE_ALBUM);
                create_artist.executeUpdate();
                create_artist = con.prepareStatement(CREATE_GENERO);
                create_artist.executeUpdate();
                create_artist = con.prepareStatement(CREATE_ARTIST_MUSIC);
                create_artist.executeUpdate();
            } catch(ClassNotFoundException e){
                throw new Exception("Driver não encontrado.",e);
            } catch(java.sql.SQLException e){
                throw new Exception("Erro ao conectar ao DB.",e);
            }
        }
        return con;
    }
    @Override
    public void close() throws Exception {
        if(con!= null){
            try{
                con.close();
                con = null;
            } catch(Exception e){
                System.out.println("Erro fechando a conexão");
                e.printStackTrace();
            }
        }
    }
}
