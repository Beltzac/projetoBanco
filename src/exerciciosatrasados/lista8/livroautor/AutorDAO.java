package A03_1_jdbc.livroautor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

    private Connection con;
    private PreparedStatement stmtInserir;
    private PreparedStatement stmtConsultar;
    private PreparedStatement stmtListar;

    public AutorDAO() throws Exception {
        con = ConnectionFactory.getConnection();
        stmtInserir = con.prepareStatement("INSERT INTO autor(nome) VALUES(?)");
        stmtConsultar = con.prepareStatement("SELECT * FROM autor WHERE id = ?");
        stmtListar = con.prepareStatement("SELECT * FROM autor");
    }

    public AutorDAO(Connection con) throws Exception {
        this.con = con;
        stmtInserir = con.prepareStatement("INSERT INTO autor(nome) VALUES(?)");
        stmtConsultar = con.prepareStatement("SELECT * FROM autor WHERE id = ?");
        stmtListar = con.prepareStatement("SELECT * FROM autor");
    }

    public void inserirAutor(Autor autor) throws Exception {
        stmtInserir.setString(1, autor.getNome());
        stmtInserir.executeUpdate();
    }

    public Autor consultarAutor(int id) throws Exception {
        Autor autorLido = null;
        stmtConsultar.setInt(1, id);
        ResultSet rs = stmtConsultar.executeQuery();
        rs.next();
        autorLido = new Autor(rs.getString("nome"));
        autorLido.setId(rs.getInt("id"));
        return autorLido;
    }

    public List<Autor> listarAutores() throws Exception {
        ResultSet rs = stmtListar.executeQuery();
        List<Autor> lista = new ArrayList();
        while(rs.next()){
            Autor autor = new Autor(rs.getString("nome"));
            autor.setId(rs.getInt("id"));
            lista.add(autor);
        }
        return lista;
    }

    public void finalize() throws Throwable{
        super.finalize();
        stmtInserir.close();
        stmtConsultar.close();
        stmtListar.close();
        con.close();
    }
}
