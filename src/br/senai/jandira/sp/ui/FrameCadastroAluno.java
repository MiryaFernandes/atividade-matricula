package br.senai.jandira.sp.ui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
import javax.swing.JOptionPane;

public class FrameCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtNome;
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
		
		JTextPane lblNome = new JTextPane();
		lblNome.setText("Nome:");
		lblNome.setBounds(24, 102, 54, 20);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(101, 102, 115, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
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
		btnSalvar.setBounds(77, 205, 109, 23);
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
		
		JButton btnMostrarAlunos = new JButton("Mostrar alunos");
		btnMostrarAlunos.setBounds(77, 239, 124, 23);
		contentPane.add(btnMostrarAlunos);
		
		
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
				
				System.out.println(comboPeriodo.getSelectedIndex());
				System.out.println(comboPeriodo.getSelectedItem());
				
			    //definir o horario que o aluno estuda
				aluno.setPeriodo(determinarPeriodo(comboPeriodo.getSelectedIndex()));
							
				
				turma.gravar(aluno, posicao);
				
				posicao++;
				
				modelAlunos.addElement(aluno.getNome());
				
				if (posicao > turma.getTamanho()) {
					btnSalvar.setEnabled(false);
					JOptionPane.showMessageDialog(null, "A turma já está cheia!", "Cheio!", posicao);
				}
								
			}
		});
		
		btnMostrarAlunos.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				for(Aluno aluno : turma.listarTodos()) {

					System.out.println(aluno.getMatricula());
					System.out.println(aluno.getPeriodo().getDescricao());
					System.out.println(aluno.getNome());
					System.out.println("--------------------------------");
				
			}
				
				listAluno.addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						Aluno aluno = turma.listarAluno(listAluno.getSelectedIndex());
						txtMatricula.setText(aluno.getMatricula());
						txtNome.setText(aluno.getNome());
						
						 comboPeriodo.setToolTipText(aluno.getNome());
						
					}
					
				});
				
	}
	    
	    private Periodo determinarPeriodo(int periodoSelecionado) {
	    	
	    	if (periodoSelecionado == 0) {
				
				return Periodo.MANHA;
				
			} else if (periodoSelecionado == 1) {
				
				return Periodo.TARDE;
				 
			} else if (periodoSelecionado == 2) {
				
				return Periodo.NOITE;
				 
			} else if (periodoSelecionado == 3) {
				
				return Periodo.SABADO;
				 
			} else {
				
				return Periodo.ONLINE;
				 
			}
	    	
	    }
	});
		
  }

	protected Periodo determinarPeriodo(int selectedIndex) {
		
		return null;
	}
}


