package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tarefa;
import singleton.Conexao;

public class TarefaDao {
    private Connection connection;

    public TarefaDao() {
        connection = Conexao.getConexao().conectar();
    }

    public String salvar(Tarefa tarefa) {
        String sql = " INSERT INTO tasks (titulo) "+ 
                     "VALUES (?) ";
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, tarefa.getTitulo());
                ps.execute();
                ps.close();
                return "Task salva com sucesso!";
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "Houve um erro, tente novamente";
            }
    }
    public List<Tarefa> listar(){
        List<Tarefa> listaTarefa = new ArrayList<>();
        String sql = " SELECT * FROM tasks ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setCodigo(rs.getInt("codigo"));
                tarefa.setTitulo(rs.getString("titulo"));
                listaTarefa.add(tarefa);
                ps.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaTarefa;
    }
}
