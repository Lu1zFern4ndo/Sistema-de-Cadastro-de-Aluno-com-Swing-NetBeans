/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TrabalhoConstantino;
import execeptions.excessaoPersonalizada;
import Models.Aluno;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.text.ParseException;
import TrabalhoConstantino.ListagemAlunosForm;
/**
 *
 * @author Luiz
 */
public class Main extends javax.swing.JPanel {
    public static List<Aluno> listaAlunos = new ArrayList<>();
    public Main() {
        initComponents();
    }
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                javax.swing.JFrame frame = new javax.swing.JFrame("Cadastro de alunos");
                TrabalhoConstantino.Main mainPanel = new TrabalhoConstantino.Main();
                frame.add(mainPanel);
                frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                
            }
        });
        
          
    }
   
    

       public static void adicionarAluno(int matricula, int idade, String nome, String cpf, String telefone, Date dataNascimento) throws excessaoPersonalizada {
        for (Aluno a : listaAlunos) {
            if (a.getMatricula() == matricula) {
                throw new excessaoPersonalizada("Matricula já existe: " + matricula + ".");
            }
        }
        listaAlunos.add(new Aluno(matricula, idade, nome,  cpf, telefone, dataNascimento));

    }
       public static Aluno procurarAluno(int matricula) {
        for (Aluno a : listaAlunos) {
            if (a.getMatricula() == matricula) {
                return a;
            } else {
                System.out.print("Matricula não encontrada");
            }
        }
        return null;
    }
       
       
       private String formatarData(Date data){
           if(data == null){
               return "";
           }
           java.text.SimpleDateFormat formatador = new java.text.SimpleDateFormat("dd/MM/yyyy");
           return formatador.format(data);
       }
       
       
       
       
       
       
       public void salvarAlunosCSV(){
           String nomeArquivo = "ListagemAlunos.txt";
           FileWriter escritor = null;
           PrintWriter impressora = null;
              
           try{
               escritor = new FileWriter(nomeArquivo);
               impressora = new PrintWriter(escritor);
               
               for(Aluno aluno: listaAlunos){
                   String linhaCSV = aluno.getMatricula() + ";" +
                                     aluno.getNome() + ";" +
                                     aluno.getIdade() + ";" + 
                                     formatarData(aluno.getDataNascimento()) + ";" +
                                     aluno.getTelefone() + ";" +
                                     aluno.getCpf();
                   impressora.println(linhaCSV);
               }
               javax.swing.JOptionPane.showMessageDialog(this, "Dados exportados com sucesso para o arquivo " + nomeArquivo, "Exportação CSV", javax.swing.JOptionPane.INFORMATION_MESSAGE);
               
           } catch (IOException e){
               javax.swing.JOptionPane.showMessageDialog(this, "Erro ao escrever no arquivo: " + e.getMessage(), "Erro de I/O", javax.swing.JOptionPane.ERROR_MESSAGE);
               
           } finally {
               if(impressora != null){
                   impressora.close();
               }
               try{
                   if(escritor != null){
                       escritor.close();
                   }
               } catch(IOException ex){
                
               }
           }
           
       }
       
       public int calcularIdade(Date dataNascimento){
           if(dataNascimento == null){
               return 0;
           }
           LocalDate dataNasc = dataNascimento.toInstant()
                                              .atZone(ZoneId.systemDefault())
                                              .toLocalDate();
           
           LocalDate hoje = LocalDate.now();
           Period periodo = Period.between(dataNasc, hoje);
           
           return periodo.getYears();
       }
       
       public static void inserirALunoEmPosicao(Aluno novoAluno, int posicao) throws excessaoPersonalizada{
           for(Aluno a: listaAlunos){
               if(a.getMatricula() == novoAluno.getMatricula()){
                   throw new excessaoPersonalizada("Matrícula já existe: " + novoAluno.getMatricula() + ".");
               }
           }
           if(posicao < 0 || posicao > listaAlunos.size()){
               throw new excessaoPersonalizada("Posição de inserção inválida. Deve ser entre 0 e " + listaAlunos.size());
           }
           listaAlunos.add(posicao, novoAluno);
       }
       
       
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        campoNome = new javax.swing.JTextField();
        campoMat = new javax.swing.JTextField();
        campoIdade = new javax.swing.JTextField();
        cadastrar = new javax.swing.JButton();
        campoCpf = new javax.swing.JFormattedTextField();
        campoTel = new javax.swing.JFormattedTextField();
        BuscaALuno = new javax.swing.JButton();
        removerAluno = new javax.swing.JButton();
        exportar = new javax.swing.JButton();
        maisVelho = new javax.swing.JButton();
        maisNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoData = new javax.swing.JFormattedTextField();
        jTextField1 = new javax.swing.JTextField();
        inserirAluno = new javax.swing.JButton();
        mostrarAlunos = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });

        campoMat.setCaretColor(new java.awt.Color(153, 153, 255));
        campoMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMatActionPerformed(evt);
            }
        });

        campoIdade.setEditable(false);

        cadastrar.setText("Cadastrar");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        try {
            campoCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            campoTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        BuscaALuno.setText("Buscar Aluno");
        BuscaALuno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaALunoActionPerformed(evt);
            }
        });

        removerAluno.setText("Remover Aluno");
        removerAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerAlunoActionPerformed(evt);
            }
        });

        exportar.setText("Exportar Alunos");
        exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarActionPerformed(evt);
            }
        });

        maisVelho.setText("Aluno mais velho");
        maisVelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maisVelhoActionPerformed(evt);
            }
        });

        maisNovo.setText("Aluno mais novo");
        maisNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maisNovoActionPerformed(evt);
            }
        });

        jLabel1.setText("Matricula:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Dt Nascimento:");

        jLabel4.setText("Idade:");

        jLabel5.setText("CPF:");

        jLabel6.setText("Telefone:");

        try {
            campoData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoDataFocusLost(evt);
            }
        });
        campoData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDataActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setText("                                                                                             Sistema de Cadastro de Aluno");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        inserirAluno.setText("Inserir Aluno");
        inserirAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirAlunoActionPerformed(evt);
            }
        });

        mostrarAlunos.setText("Exibir Alunos");
        mostrarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarAlunosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(28, 28, 28)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoNome)
                                    .addComponent(campoData)
                                    .addComponent(campoMat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(116, 116, 116)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoTel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addComponent(jLabel4)
                                .addGap(25, 25, 25)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(removerAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BuscaALuno)
                            .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inserirAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(maisNovo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maisVelho, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exportar, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(mostrarAlunos))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoMat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cadastrar)
                            .addComponent(exportar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(BuscaALuno)
                            .addComponent(maisVelho))
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoTel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(removerAluno)
                        .addComponent(maisNovo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inserirAluno)
                    .addComponent(mostrarAlunos))
                .addContainerGap(90, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMatActionPerformed
        
    }//GEN-LAST:event_campoMatActionPerformed

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
    try{ 
        java.text.SimpleDateFormat formatador = new java.text.SimpleDateFormat("dd/MM/yyyy");
        int matricula = Integer.parseInt(campoMat.getText().trim());
        campoIdade.setEditable(false);
        String nome = campoNome.getText();
        String cpf = campoCpf.getText();
        String telefone = campoTel.getText();
        String dataString = campoData.getText().trim();
        Date dataNascimento = formatador.parse(dataString);
        int idadeCalcular = calcularIdade(dataNascimento);
       dao.AlunoHibernateDAO hibernateDAO = new dao.AlunoHibernateDAO();
       Aluno novoAluno = new Aluno(matricula, idadeCalcular, nome, cpf, telefone, dataNascimento);
       hibernateDAO.salvarOuAtualizar(novoAluno);
       
        
        
        if(dataNascimento != null ){
            if(idadeCalcular <= 0 || idadeCalcular > 150){
                javax.swing.JOptionPane.showMessageDialog(this, "A data de nascimento é inválida para o cálculo da idade.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            adicionarAluno(matricula, idadeCalcular, nome, cpf, telefone, dataNascimento);
            salvarAlunosCSV();
            javax.swing.JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso");
            campoMat.setText(""); 
            campoNome.setText(""); 
            campoIdade.setText("");
            campoCpf.setText(""); 
            campoTel.setText(""); 
            campoData.setText("");
            
          
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione a data de nascimento.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
    } catch(java.text.ParseException e){
        javax.swing.JOptionPane.showMessageDialog(this, "Formato de Data Inválido. Use o formato DD/MM/YYYY.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        
    }catch(NumberFormatException e){
         javax.swing.JOptionPane.showMessageDialog(this, "Erro no formato da matricula.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
    } catch(excessaoPersonalizada e){
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Erro de MAtricula", javax.swing.JOptionPane.WARNING_MESSAGE);
    } catch (Exception e) { // <-- ADICIONAR ESTE BLOCO FINAL
        // Trata a exceção lançada pelo seu DAO de Hibernate
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Falha ao salvar no Banco de Dados: " + e.getMessage(), 
            "Erro de Persistência", 
            javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
        
   
    
    
    
    
 
    
    }//GEN-LAST:event_cadastrarActionPerformed

    private void BuscaALunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaALunoActionPerformed
        int quantidadeAlunos = listaAlunos.size();
        String matriculaString = javax.swing.JOptionPane.showInputDialog(this, "Digite a matricula do aluno que está buscando: ", javax.swing.JOptionPane.QUESTION_MESSAGE);
        if(matriculaString != null && !matriculaString.trim().isEmpty()){
            try{
                int matricula = Integer.parseInt(matriculaString.trim());
                Aluno alunoEncontrado = procurarAluno(matricula);
                if(alunoEncontrado != null){
                    String dadosAluno = "Matricula: " + alunoEncontrado.getMatricula() + "\n" + "Nome: " + alunoEncontrado.getNome() + "\n" +
                    "Cpf: " + alunoEncontrado.getCpf() + "\n" + "Idade: " + alunoEncontrado.getIdade() + "\n" +
                    "Data de Nascimento: " + alunoEncontrado.getDataNascimento() + "\n" + 
                    "Telefone: " + alunoEncontrado.getTelefone() + "\n" +
                    "Total de Alunos Cadastrados: " + quantidadeAlunos;
                    javax.swing.JOptionPane.showMessageDialog(this, dadosAluno, "Dados do Aluno Encontrado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String mensagemErro = "Matrícula " + matricula + " não encontrada." + "\n" + "Total de Alunos Cadastrados: " + quantidadeAlunos;
                    javax.swing.JOptionPane.showMessageDialog(this, mensagemErro, "Resultado da Busca", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e){
                javax.swing.JOptionPane.showMessageDialog(this, "A matrícula deve ser um número.", "Erro de Formato", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        
       
    }//GEN-LAST:event_BuscaALunoActionPerformed

    private void removerAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerAlunoActionPerformed
      String matriculaString;
        matriculaString = javax.swing.JOptionPane.showInputDialog(this, "Digite a matricula do aluno procurado.", "Remover Aluno", javax.swing.JOptionPane.QUESTION_MESSAGE);
      try {
        if(matriculaString != null && !matriculaString.trim().isEmpty()){
          int matricula = Integer.parseInt(matriculaString.trim());
          Aluno alunoRemover = procurarAluno(matricula);
      if(alunoRemover != null){
          dao.RemocaoAlunoDAO remocao = new dao.RemocaoAlunoDAO();
          listaAlunos = remocao.removerAluno(listaAlunos, alunoRemover);
          javax.swing.JOptionPane.showMessageDialog(this, "Aluno " + matricula + " removido com sucesso.", "Remoção Concluida", javax.swing.JOptionPane.INFORMATION_MESSAGE);
          
      } else {
           javax.swing.JOptionPane.showMessageDialog(this, "Matricula " + matricula + "não encontrada.", "Remoção Concluida", javax.swing.JOptionPane.WARNING_MESSAGE);     
      }
    }
      } catch (NumberFormatException e){
          javax.swing.JOptionPane.showMessageDialog(this, "A matrícula deve ser um número inteiro válido.", "Erro de Formato", javax.swing.JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_removerAlunoActionPerformed

    private void exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarActionPerformed
       if(listaAlunos.isEmpty()){
           javax.swing.JOptionPane.showMessageDialog(this, "A lista de alunos está vazia. Não há dados para exportar", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
           return;
       }
       salvarAlunosCSV();
    }//GEN-LAST:event_exportarActionPerformed

    private void maisVelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maisVelhoActionPerformed
        if(listaAlunos.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "A lista está vazia.", "Aviso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        Aluno alunoAtual = new Aluno();
        Date dataAtual = new Date();
        Aluno maisVelho = listaAlunos.get(0);
        Date dataE = maisVelho.getDataNascimento();
        for(int i = 1; i < listaAlunos.size(); i++){
        alunoAtual = listaAlunos.get(i);
        dataAtual = alunoAtual.getDataNascimento(); 
        }
        
        if(dataAtual.compareTo(dataE) < 0){
            dataE = dataAtual;
            maisVelho = alunoAtual;
        }
        String mensagem = "O aluno mais velho é: \n" +
                          "Nome: " + maisVelho.getNome() + "\n" +
                          "Data de Nasc.: " + formatarData(maisVelho.getDataNascimento()) + "\n" +
                          "Idade: " + calcularIdade(maisVelho.getDataNascimento()) + " anos.";
        
        javax.swing.JOptionPane.showMessageDialog(this, mensagem, "Resultado da Busca", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_maisVelhoActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void campoDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDataActionPerformed

    private void campoDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDataFocusLost
        String dataString = campoData.getText().trim();
        if(dataString.isEmpty()){
            campoIdade.setText("");
            return;
        }
        
        try{
            java.text.SimpleDateFormat formatador = new java.text.SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimento = formatador.parse(dataString);
            int idadeC = calcularIdade(dataNascimento);
            campoIdade.setText(String.valueOf(idadeC));
        } catch(java.text.ParseException e) {
            campoIdade.setText("Invalida");
            javax.swing.JOptionPane.showMessageDialog(this, "Formato de Data Inválido. Use DD/MM/YYYY.", "Erro de Formato", javax.swing.JOptionPane.ERROR_MESSAGE);      
        }   
    }//GEN-LAST:event_campoDataFocusLost

    private void maisNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maisNovoActionPerformed
        if(listaAlunos.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "A lista está vazia.", "Aviso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        Aluno alunoAtual = new Aluno();
        Date dataAtual = new Date();
        Aluno maisNovo = listaAlunos.get(0);
        Date dataE = maisNovo.getDataNascimento();
        for(int i = 1; i < listaAlunos.size(); i++){
        alunoAtual = listaAlunos.get(i);
        dataAtual = alunoAtual.getDataNascimento(); 
        }
        
        if(dataAtual.compareTo(dataE) > 0){
            dataE = dataAtual;
            maisNovo = alunoAtual;
        }
        String mensagem = "O aluno mais novo é: \n" +
                          "Nome: " + maisNovo.getNome() + "\n" +
                          "Data de Nasc.: " + formatarData(maisNovo.getDataNascimento()) + "\n" +
                          "Idade: " + calcularIdade(maisNovo.getDataNascimento()) + " anos.";
        
        javax.swing.JOptionPane.showMessageDialog(this, mensagem, "Resultado da Busca", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_maisNovoActionPerformed

    private void inserirAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirAlunoActionPerformed
        String posString = javax.swing.JOptionPane.showInputDialog(this, "Digite a posição onde o aluno deve ser inserido:", "Inserir em Posição", javax.swing.JOptionPane.QUESTION_MESSAGE );
        if(posString == null || posString.trim().isEmpty()){
            return;
        }
        try {
    int posicao = Integer.parseInt(posString.trim());
    int matricula = Integer.parseInt(campoMat.getText().trim());
    String nome = campoNome.getText();
    String cpf = campoCpf.getText();
    String telefone = campoTel.getText();
    String dataString = campoData.getText().trim();
    java.text.SimpleDateFormat formatador = new java.text.SimpleDateFormat("dd/MM/yyyy");
    formatador.setLenient(false);
    
    Date dataNascimento = formatador.parse(dataString); 
  
    int idadeCalculada = calcularIdade(dataNascimento); 
    
    if (idadeCalculada <= 0 || idadeCalculada > 150) {
         throw new excessaoPersonalizada("A data de nascimento resulta em uma idade inválida.");
    }
    
    Aluno novoAluno = new Aluno(matricula, idadeCalculada, nome, cpf, telefone, dataNascimento);
    dao.AlunoHibernateDAO hibernateDAO = new dao.AlunoHibernateDAO();
    hibernateDAO.salvarOuAtualizar(novoAluno);
    inserirALunoEmPosicao(novoAluno, posicao);
    salvarAlunosCSV();
    
    javax.swing.JOptionPane.showMessageDialog(this, "Aluno inserido na posição " + posicao + " com sucesso!");
    
    // Limpeza dos Campos
    campoMat.setText("");
    campoNome.setText("");
    campoIdade.setText("");
    campoCpf.setText("");
    campoTel.setText("");
    campoData.setText("");
    
} catch (NumberFormatException e) {
    javax.swing.JOptionPane.showMessageDialog(this, "A posição e a matrícula devem ser números válidos.", "Erro de Formato", javax.swing.JOptionPane.ERROR_MESSAGE);
} catch (excessaoPersonalizada e) {
    javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Erro de Inserção", javax.swing.JOptionPane.WARNING_MESSAGE);
} catch (ParseException e) { 
    javax.swing.JOptionPane.showMessageDialog(this, "Data de nascimento inválida. Use o formato DD/MM/YYYY.", "Erro de Data", javax.swing.JOptionPane.ERROR_MESSAGE);
} catch (Exception e) { // <-- CATCH OBRIGATÓRIO para o erro do Hibernate
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Falha ao salvar no Banco de Dados: " + e.getMessage(), 
            "Erro de Persistência", 
            javax.swing.JOptionPane.ERROR_MESSAGE
        );
}
    }//GEN-LAST:event_inserirAlunoActionPerformed

    private void mostrarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarAlunosActionPerformed
if (listaAlunos.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(
            this, 
            "A lista em memória está vazia. Cadastre alunos para exibir a listagem.", 
            "Aviso", 
            javax.swing.JOptionPane.INFORMATION_MESSAGE
        );
        return;
    }
    
    java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
    
    ListagemAlunosForm listaForm = new ListagemAlunosForm(
        parentFrame, 
        true, 
        listaAlunos 
    );
    
    listaForm.setVisible(true);
        
    }//GEN-LAST:event_mostrarAlunosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscaALuno;
    private javax.swing.JButton cadastrar;
    private javax.swing.JFormattedTextField campoCpf;
    private javax.swing.JFormattedTextField campoData;
    private javax.swing.JTextField campoIdade;
    private javax.swing.JTextField campoMat;
    private javax.swing.JTextField campoNome;
    private javax.swing.JFormattedTextField campoTel;
    private javax.swing.JButton exportar;
    private javax.swing.JButton inserirAluno;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton maisNovo;
    private javax.swing.JButton maisVelho;
    private javax.swing.JButton mostrarAlunos;
    private javax.swing.JButton removerAluno;
    // End of variables declaration//GEN-END:variables

}