package vista;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Divicion;
import modelo.Multiplicacion;
import modelo.Resta;
import modelo.Suma;

/**
 * 
 * @author Jonathan Lozano
 *
 */
public class VistaOperaciones extends JFrame implements ActionListener {

	private JLabel lblN1 = new JLabel("Numero 1");
	private JLabel lblN2 = new JLabel("Numero 2");
	private JLabel lblResult = new JLabel();

	private JTextField txtN1 = new JTextField();
	private JTextField txtN2 = new JTextField();

	private JButton btnSuma = new JButton("+");
	private JButton btnResta = new JButton("-");
	private JButton btnMultiplicacion = new JButton("*");
	private JButton btnDivicion = new JButton("/");

	private Container cont = getContentPane();

	private Suma s = new Suma();
	private Resta r = new Resta();
	private Multiplicacion m = new Multiplicacion();
	private Divicion d = new Divicion();

	/**
	 * Constructo de la clase que crea una ventana y carga los controles
	 * mediante el metodo cargarControles()
	 */
	public VistaOperaciones() {
		super("Operaciones");
		setSize(360, 320);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControles();
	}

	/**
	 * Se agregan los controles a la ventana
	 */
	private void cargarControles() {
		cont.setLayout(null);

		lblN1.setBounds(10, 10, 340, 30);
		cont.add(lblN1);

		txtN1.setBounds(10, 40, 330, 30);
		cont.add(txtN1);

		lblN2.setBounds(10, 70, 330, 30);
		cont.add(lblN2);

		txtN2.setBounds(10, 100, 330, 30);
		cont.add(txtN2);

		btnSuma.setBounds(10, 140, 160, 30);
		btnSuma.addActionListener(this);
		cont.add(btnSuma);

		btnResta.setBounds(180, 140, 160, 30);
		btnResta.addActionListener(this);
		cont.add(btnResta);

		btnMultiplicacion.setBounds(10, 190, 160, 30);
		btnMultiplicacion.addActionListener(this);
		cont.add(btnMultiplicacion);

		btnDivicion.setBounds(180, 190, 160, 30);
		btnDivicion.addActionListener(this);
		cont.add(btnDivicion);

		lblResult.setBounds(10, 230, 120, 30);
		cont.add(lblResult);
	}

	/**
	 * Al presionar un boton se identifica que boton se presiona, en base al
	 * boton presionado se ejecuta una accion y se agrega una respuesta a una
	 * etiqueta
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int n1 = Integer.parseInt(txtN1.getText());
		int n2 = Integer.parseInt(txtN2.getText());

		if (e.getSource() == btnSuma) {
			lblResult.setText(String.format("%d + %d = %d", n1, n2, s.operaciones(n1, n2)));

		} else if (e.getSource() == btnResta) {
			lblResult.setText(String.format("%d - %d = %d", n1, n2, r.operaciones(n1, n2)));

		} else if (e.getSource() == btnMultiplicacion) {
			lblResult.setText(String.format("%d * %d = %d", n1, n2, m.operaciones(n1, n2)));

		} else if (e.getSource() == btnDivicion) {
			lblResult.setText(String.format("%d / %d = %d", n1, n2, d.operaciones(n1, n2)));
		}
	}

}
