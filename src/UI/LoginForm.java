package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Bilet;
import BL.SpectacolManager;
import BL.BileteManager;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import java.lang.*;
import java.util.ArrayList;

import BL.UserService;

public class LoginForm extends JFrame {

	public int valid = -1;
	private JPanel login;
	private JPanel angajat;
	private JPanel admin;
	private JLabel nume;
	private JTextField numep;
	private JLabel parola;
	private JLabel par;
	private JTextField parolap;
	private JLabel spec;
	private JTextField specp;
	private JLabel rand;
	private JTextField randp;
	private JLabel numar;
	private JTextField numarp;

	private JLabel numea;
	private JTextField numeap;
	private JLabel usera;
	private JTextField userap;
	private JLabel parolaa;
	private JTextField parolaap;
	private JLabel titlu;
	private JTextField titlup;
	private JLabel regia;
	private JTextField regiap;
	private JLabel distributia;
	private JTextField distributiap;
	private JLabel data;
	private JTextField datap;
	private JLabel nrbilete;
	private JTextField nrbiletep;
	private JLabel cnp;
	private JTextField cnpp;
	private JLabel reset;
	private JTextField resetp;
	private JLabel cn;
	private JTextField cp;
	private JButton Login = new JButton("Login");
	private JButton Adauga = new JButton("Adauga");
	private JButton Vizualizare = new JButton("Vizualizare");
	private JButton Creeaza = new JButton("Creeaza");
	private JButton Viz = new JButton("Vizualizare");
	private JButton Ad = new JButton("Adauga");
	private JButton Resetare = new JButton("Resetare parola");
	private JComboBox<String> comboBox = new JComboBox<String>();
	private JList<Object> lista;
	private DefaultListModel<Object> listModel;

	// LoginForm inter = new LoginForm();

	public void Login() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		login = new JPanel();
		login.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(login);
		login.setLayout(null);

		nume = new JLabel("Nume");
		nume.setBounds(10, 12, 120, 10);
		login.add(nume);

		numep = new JTextField();
		numep.setBounds(90, 10, 120, 20);
		login.add(numep);

		parola = new JLabel("Parola");
		parola.setBounds(10, 40, 120, 10);
		login.add(parola);

		parolap = new JTextField();
		parolap.setBounds(90, 40, 120, 20);
		login.add(parolap);

		par = new JLabel("Tip Utilizator");
		par.setBounds(10, 80, 120, 10);
		login.add(par);

		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"admin", "angajat" }));
		comboBox.setBounds(90, 70, 100, 30);
		login.add(comboBox);

		Login.setBounds(30, 140, 100, 20);
		login.add(Login);

		cn = new JLabel("CNP");
		cn.setBounds(10, 200, 120, 10);
		login.add(cn);

		cp = new JTextField();
		cp.setBounds(90, 200, 140, 20);
		login.add(cp);

		reset = new JLabel("Parola noua");
		reset.setBounds(10, 230, 120, 10);
		login.add(reset);

		resetp = new JTextField();
		resetp.setBounds(90, 230, 160, 20);
		login.add(resetp);

		Resetare.setBounds(30, 170, 140, 20);
		login.add(Resetare);

		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int valid = -1;
					String selectedChoice = (String) comboBox.getSelectedItem();
					String num = numep.getText();
					String par = parolap.getText();

					// apelez in bl userservice
					UserService us = new UserService(num, selectedChoice, par,
							"");
					valid = us.Verific();
					if (valid == 1) {
						LoginForm inter = new LoginForm();
						inter.setVisible(true);
						inter.AngajatForm();
						
					}
					if (valid == 0) {
						LoginForm inter = new LoginForm();
						inter.setVisible(true);
						inter.AdminForm();
					}

				} catch (Exception exc) {
				}

			}
		});

		Resetare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String parola = "";
					String selectedChoice = (String) comboBox.getSelectedItem();
					String num = numep.getText();
					String par = parolap.getText();
					String cnp = cp.getText();
					
					// cond ma loghez nu imi cere parola
					UserService us = new UserService(num, selectedChoice, "",
							cnp);
					parola = us.Reseteaza();
					resetp.setText(parola);

				} catch (Exception exc) {
				}

			}
		});

	}

	public void AngajatForm() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);

		angajat = new JPanel();
		angajat.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(angajat);
		setContentPane(angajat);
		angajat.setLayout(null);

		spec = new JLabel("Spectacol");
		spec.setBounds(10, 12, 120, 10);
		angajat.add(spec);

		specp = new JTextField();
		specp.setBounds(90, 10, 120, 20);
		angajat.add(specp);

		rand = new JLabel("Rand");
		rand.setBounds(10, 40, 120, 10);
		angajat.add(rand);

		randp = new JTextField();
		randp.setBounds(90, 40, 120, 20);
		angajat.add(randp);

		numar = new JLabel("Numar");
		numar.setBounds(10, 70, 120, 10);
		angajat.add(numar);

		numarp = new JTextField();
		numarp.setBounds(90, 70, 120, 20);
		angajat.add(numarp);

		Adauga.setBounds(30, 130, 100, 20);
		angajat.add(Adauga);

		Vizualizare.setBounds(30, 170, 100, 20);
		angajat.add(Vizualizare);

		listModel = new DefaultListModel();
		lista = new JList<Object>(listModel);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setBounds(220, 16, 250, 300);
		angajat.add(lista);

		Adauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sp = (specp.getText());
					String nr = numarp.getText();
					String rd = randp.getText();
					BileteManager bm = new BileteManager(sp, rd, nr);
					bm.AdaugaBilete();
					// apelez in bl biletemanager

				} catch (Exception exc) {
				}
			}
		});

		Vizualizare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i;

					BileteManager spm = new BileteManager("", "", "");
					ArrayList list = new ArrayList();
					list = spm.getBilete();
					listModel.clear();
					for (i = 0; i < list.size(); i++) {
						System.out.println(list.get(i));
						listModel.addElement(list.get(i));
					}

					// apelez in bl biletemanager care gestioneza vizualizarea
				} catch (Exception exc) {
				}
			}
		});
	}

	public void AdminForm() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 400);
		admin = new JPanel();
		admin.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(admin);
		setContentPane(admin);
		admin.setLayout(null);

		numea = new JLabel("Nume");
		numea.setBounds(10, 12, 120, 10);
		admin.add(numea);

		numeap = new JTextField();
		numeap.setBounds(90, 10, 120, 20);
		admin.add(numeap);

		usera = new JLabel("User");
		usera.setBounds(10, 40, 120, 10);
		admin.add(usera);

		userap = new JTextField();
		userap.setBounds(90, 40, 120, 20);
		admin.add(userap);

		parolaa = new JLabel("Parola");
		parolaa.setBounds(10, 70, 120, 10);
		admin.add(parolaa);

		parolaap = new JTextField();
		parolaap.setBounds(90, 70, 120, 20);
		admin.add(parolaap);

		cnp = new JLabel("CNP");
		cnp.setBounds(10, 100, 120, 10);
		admin.add(cnp);
		cnpp = new JTextField();
		cnpp.setBounds(90, 100, 120, 20);
		admin.add(cnpp);

		Creeaza.setBounds(30, 130, 100, 20);
		admin.add(Creeaza);

		titlu = new JLabel("Titlu");
		titlu.setBounds(10, 160, 120, 10);
		admin.add(titlu);

		titlup = new JTextField();
		titlup.setBounds(90, 160, 120, 20);
		admin.add(titlup);

		regia = new JLabel("Regia");
		regia.setBounds(10, 190, 120, 10);
		admin.add(regia);

		regiap = new JTextField();
		regiap.setBounds(90, 190, 120, 20);
		admin.add(regiap);

		distributia = new JLabel("Distributia");
		distributia.setBounds(10, 220, 120, 10);
		admin.add(distributia);

		distributiap = new JTextField();
		distributiap.setBounds(90, 220, 120, 20);
		admin.add(distributiap);

		data = new JLabel("Data");
		data.setBounds(10, 250, 220, 10);
		admin.add(data);

		datap = new JTextField();
		datap.setBounds(90, 250, 120, 20);
		admin.add(datap);

		nrbilete = new JLabel("Nrbilete");
		nrbilete.setBounds(10, 280, 120, 10);
		admin.add(nrbilete);

		nrbiletep = new JTextField();
		nrbiletep.setBounds(90, 280, 120, 20);
		admin.add(nrbiletep);

		Ad.setBounds(30, 310, 100, 20);
		admin.add(Ad);

		Viz.setBounds(30, 340, 100, 20);
		admin.add(Viz);

		listModel = new DefaultListModel();
		lista = new JList<Object>(listModel);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setBounds(220, 16, 450, 300);
		admin.add(lista);

		Ad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String titlu = titlup.getText();
					String regia = regiap.getText();
					String distributia = distributiap.getText();
					String data = datap.getText();
					String nrbilete = nrbiletep.getText();
					SpectacolManager spm = new SpectacolManager(titlu, regia,
							distributia, data, nrbilete);
					spm.Adauga();
					// apelez in bl Spectacolmanager
				} catch (Exception exc) {
				}
			}
		});

		Viz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					// apelez in bl Spectacolmanager pentru vizualizare
					SpectacolManager spm = new SpectacolManager("", "", "", "",
							"");
					ArrayList list = new ArrayList();
					list = spm.getSpectacole();
					listModel.clear();
					int i;
					for (i = 0; i < list.size(); i++) {
						System.out.println(list.get(i));
						listModel.addElement(list.get(i));
					}
					// inter.refreshList(list);
				} catch (Exception exc) {
				}
			}
		});

		Creeaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cnp = cnpp.getText();
					String numa = numeap.getText();
					String usera = userap.getText();
					String par = parolaap.getText();
					// apelez in bl UserService
					UserService us = new UserService(numa, usera, par, cnp);
					us.Ceeaza();

				} catch (Exception exc) {
				}
			}
		});

	}

	public static void main(String[] args) {

		LoginForm inter = new LoginForm();

		inter.Login();
		inter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inter.setVisible(true);
	}
}
