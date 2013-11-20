package A03_1_jdbc.livroautor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private Connection con = null;
    private PreparedStatement stmtInserir;
    private PreparedStatement stmtConsultar;
    private PreparedStatement stmtListaLivroAutor;

    public LivroDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
        stmtInserir = con.prepareStatement("INSERT INTO livro(titulo) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
        stmtConsultar = con.prepareStatement("SELECT * FROM livro WHERE id = ?");
        stmtListaLivroAutor = con.prepareStatement("SELECT * FROM livro");
    }

    public LivroDAO(Connection con)  throws SQLException {
      this.con=con;
              stmtInserir = con.prepareStatement("INSERT INTO livro(titulo,ss) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
        stmtConsultar = con.prepareStatement("SELECT * FROM livro WHERE id = ?");
        stmtListaLivroAutor = con.prepareStatement("SELECT * FROM livro");
    }
    

    public void inserirLivro(Livro livro) {
        try {
            stmtInserir.setString(1, livro.getTitulo());
            stmtInserir.executeUpdate();

            this.gravarAutores(livro);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um livro no banco de dados. Origem="+ex.getMessage());
        }
    }

    public Livro consultarLivro(int id) throws SQLException {
        Livro livroLido = null;
        stmtConsultar.setLong(1, id);
        ResultSet rs = stmtConsultar.executeQuery();
        rs.next();
        livroLido = new Livro(rs.getString("titulo"), lerAutores(id));
        return livroLido;
    }

    private void gravarAutores(Livro livro) throws SQLException {
        String sql = "INSERT INTO livro_autor (idLivro, idAutor) VALUES ( ?, ?)";
        PreparedStatement stmt;
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, this.lerIdLivro());
        List<Autor> autores = livro.getAutores();
        for (Autor autor : autores) {
            stmt.setLong(2, autor.getId());
            stmt.executeUpdate();
        }
    }

    private List<Autor> lerAutores(long idLivro) throws SQLException {
        //Select para pegar os autores de um livro
        String sql = "SELECT autor.id,autor.nome"
                + " FROM autor"
                + " INNER JOIN livro_autor"
                + " 	ON autor.id = livro_autor.idAutor"
                + " WHERE livro_autor.idLivro = ? ";
        PreparedStatement stmt = null;
        List<Autor> autores = null;
        stmt = con.prepareStatement(sql);
        stmt.setLong(1, idLivro);
        ResultSet resultado = stmt.executeQuery();
        autores = new ArrayList<Autor>();
        while (resultado.next()) {
            Autor autorLido = new Autor(resultado.getString("nome"));
            autorLido.setId(resultado.getInt("id"));
            autores.add(autorLido);
        }

        return autores;
    }

    private int lerIdLivro() throws SQLException {
        ResultSet rs = stmtInserir.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    public List<Livro> listarLivroComAutores() throws SQLException {
        ResultSet rs = stmtListaLivroAutor.executeQuery();
        List<Livro> listaLivros = new ArrayList<Livro>();
        while (rs.next()) {
            List<Autor> listAutores = lerAutores(rs.getInt(1));
            Livro livro = new Livro(rs.getString(2), listAutores);
            livro.setId(rs.getInt(1));
            listaLivros.add(livro);
        }

        return listaLivros;
    }
}
