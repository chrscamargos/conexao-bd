import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

void main(){

//    janela
    JFrame tela = new JFrame();
    tela.setSize(500, 400);
    tela.setLayout(null);

//  --------------------------------

//    label do nome
    JLabel labelNome = new JLabel("Nome");
    labelNome.setBounds(20, 50, 150, 40);
    tela.add(labelNome);

//    campo de texto do nome
    JTextField nome = new JTextField();
    nome.setBounds(20, 80, 250, 40);
    tela.add(nome);

//    --------------------------------------

//    label do email
    JLabel labelEmail = new JLabel("E-mail");
    labelEmail.setBounds(20, 120, 150, 40);
    tela.add(labelEmail);

//    campo de texto do email
    JTextField email = new JTextField();
    email.setBounds(20, 150, 250, 40);
    tela.add(email);

//    ------------------------------------------------------

//    botão
    JButton enviar = new JButton("Enviar");
    enviar.setBounds(80, 200, 150, 40 );
    tela.add(enviar);

    enviar.addActionListener(e -> {
        String sql = "INSERT INTO usuario(nome, email) VALUES (?, ?)";
        String nomeCompleto = nome.getText();
        String emailUser = email.getText();

        try {
//            conexao com o banco
            Connection conexao =  Conexao.conectar();
            PreparedStatement ps = conexao.prepareStatement(sql);

//            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);

            ps.setString(1, nomeCompleto);
            ps.setString(2, emailUser);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso");
            ps.close();


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    });

    tela.setVisible(true);
}
