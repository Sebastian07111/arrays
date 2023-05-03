package arrays;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Procesos {
	ArrayList<Double> listaNotas,listaNotasFinales;
	ArrayList<String> listaEstudiante;
	int cantGanan=0,cantPierden=0,cantPuedenRecuperar=0,cantPierdenSinRecuperar=0;
	double promedioNotasFinales=0;
	
	public Procesos() {
		listaNotas=new ArrayList<Double>();
		listaEstudiante=new ArrayList<String>();
		listaNotasFinales=new ArrayList<Double>();
		iniciar();
	}
	
	private void iniciar() {
		ingresarDatos();
		imprimirListas();
		calcularDatos();
		imprimirResultados();
		imprimirEstudianteNota();
	}
	
	private void ingresarDatos() {
		String nombre="";
		
		int cantEstudiantes=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes"));
		double nota=0;
		for (int i = 0; i < cantEstudiantes; i++) {
			nombre=JOptionPane.showInputDialog("ingrese el nombre del estudiante");
			listaEstudiante.add(nombre);
				for (int j = 0; j < 3; j++) {
					nota= validarNota(j,nombre);
					listaNotas.add(nota);
				}
		}
	}
	private double validarNota(int j, String nombre) {
	    String mensaje = "Ingrese la nota " + (j + 1) + " de " + nombre;
	    double nota = -1;

	    do {
	        nota = Double.parseDouble(JOptionPane.showInputDialog(mensaje));

	        if (nota < 0 || nota > 5) {
	            JOptionPane.showMessageDialog(null, "La nota está fuera del rango");
	        }

	    } while (nota < 0 || nota > 5);

	    return nota;
	}

	private void imprimirListas() {
		System.out.println(listaEstudiante);
		System.out.println(listaNotas);
	}
	private void calcularDatos() {
		double sum=0;
		double prom=0;
		/*calcula el promedio de las notas
		 * recorre la lista total pero en el for extenerno
		 * recorre de 3 en 3 e inicializa el for interno con el valor i*/
		for (int i = 0; i < listaNotas.size(); i+=3) {
			for (int j = i; j < (i+3); j++) {
				sum+= listaNotas.get(j);
			}
			System.out.println("");
			prom=sum/3;
			listaNotasFinales.add(prom);
			sum=0;
		}
		System.out.println(listaNotasFinales);
		//calcular quienes ganan o quienes pierden la materia
		for (int i = 0; i < listaNotasFinales.size(); i++) {
			if(listaNotasFinales.get(i)>=3.5) {
				cantGanan++;
			}
			else
			{
				cantPierden++;
				if(listaNotasFinales.get(i)>2) {
					cantPuedenRecuperar++;
				}
				else {
					cantPierdenSinRecuperar++;
				}
			}
		}
		//calculo el promedio final de notas aprendidas
		int suma=0;
		for (int i = 0; i < listaNotasFinales.size(); i++) {
			suma+= listaNotasFinales.get(i);
		}
		promedioNotasFinales=suma/listaNotasFinales.size();
	}
	private void imprimirResultados() {
		System.out.println("Cantidad Total de estudiantes"+ listaEstudiante.size());
		System.out.println("Cantidad Total de notas ingresadas"+ listaNotas.size());
		System.out.println("Cantidad Ganan la materia"+cantGanan);
		System.out.println("cantidad Estudiantes Pierden la materia"+cantPierden);
		System.out.println("Cantidad Estudiantes que pueden recuperar"+cantPuedenRecuperar);
		System.out.println("cantidad Estudiantes que no pueden recuperar" + cantPierdenSinRecuperar);
		System.out.println("Promedio Notas finales: " + promedioNotasFinales);
	}
	private void imprimirEstudianteNota() {
	    for (int i = 0; i < listaEstudiante.size(); i++) {
	        System.out.println(listaEstudiante.get(i) + ":" + listaNotasFinales.get(i));
	    }
	}

}
