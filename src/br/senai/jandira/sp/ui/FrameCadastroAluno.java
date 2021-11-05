package br.senai.jandira.sp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class FrameCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 483, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(101, 25, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnMatricula = new JTextPane();
		txtpnMatricula.setText("Matricula:");
		txtpnMatricula.setBounds(24, 25, 54, 20);
		contentPane.add(txtpnMatricula);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setText("Nome:");
		txtpnNome.setBounds(26, 73, 38, 20);
		contentPane.add(txtpnNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 73, 115, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane txtpnPeriodo = new JTextPane();
		txtpnPeriodo.setText("Periodo:");
		txtpnPeriodo.setBounds(24, 157, 54, 20);
		contentPane.add(txtpnPeriodo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione..", "Manh\u00E3", "Tarde", "Noite"}));
		comboBox.setBounds(99, 155, 115, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(78, 237, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(295, 54, 162, 234);
		contentPane.add(scrollPane);
		
;
		
		JTextPane txtpnListaDeAlunos = new JTextPane();
		txtpnListaDeAlunos.setText("Lista de alunos:");
		txtpnListaDeAlunos.setBounds(295, 25, 86, 20);
		contentPane.add(txtpnListaDeAlunos);
	}
}
