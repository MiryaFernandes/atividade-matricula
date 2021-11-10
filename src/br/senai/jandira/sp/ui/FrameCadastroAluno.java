package br.senai.jandira.sp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class FrameCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
    private int posicao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCadastroAluno frame = new FrameCadastroAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	  */
	    public FrameCadastroAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(101, 48, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextPane txtMatricula = new JTextPane();
		txtMatricula.setText("Matricula:");
		txtMatricula.setBounds(24, 48, 54, 20);
		contentPane.add(txtMatricula);
		
		JTextPane txtNome = new JTextPane();
		txtNome.setText("Nome:");
		txtNome.setBounds(24, 102, 38, 20);
		contentPane.add(txtNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(101, 102, 115, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane txtPeriodo = new JTextPane();
		txtPeriodo.setText("Periodo:");
		txtPeriodo.setBounds(24, 157, 54, 20);
		contentPane.add(txtPeriodo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Periodo.values()));
		comboBox.setBounds(99, 155, 115, 22);
		contentPane.add(comboBox);
	
		
		
		JComboBox comboPeriodo = new JComboBox();
		DefaultComboBoxModel<String> comboModelPeriodo = 
				new DefaultComboBoxModel<String>();
		
		//carregar o combo model com as descriçoes dos periodos
		for (Periodo periodo : Periodo.values()) {
			
			comboModelPeriodo.addElement(periodo.getDescricao());
			
		}
		
		
		JButton btnSalvar = new JButton("Salvar Aluno");
		btnSalvar.setBounds(78, 237, 109, 23);
		contentPane.add(btnSalvar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(281, 65, 162, 210);
		contentPane.add(scrollPane);
		
		JList listAluno = new JList();
		scrollPane.setViewportView(listAluno);
		
	
		
		JTextPane txtpnListaDeAlunos = new JTextPane();
		txtpnListaDeAlunos.setText("Lista de alunos:");
		txtpnListaDeAlunos.setBounds(281, 34, 86, 20);
		contentPane.add(txtpnListaDeAlunos);
		
		//criar o model que vai exibir os alunos na jlist
		DefaultListModel<String> modelAlunos =
				new DefaultListModel<String>();
		
		//definir o model alunos como sendo o nome do jlist
		listAluno.setModel(modelAlunos);
		
		
		//criar um contador para controlar a posiçao do aluno no vetor
		
		
		//criar uma turma de repositorio de alunos
		AlunoRepository turma = new AlunoRepository(3);		
		
		//colocar um listener no botao
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Aluno aluno = new Aluno();
				aluno.setNome(txtNome.getText());
				aluno.setMatricula(txtMatricula.getText());
				
				turma.gravar(aluno, posicao);
				
				posicao++;
				
				modelAlunos.addElement(aluno.getNome());
								
			}
		});
	}
}
