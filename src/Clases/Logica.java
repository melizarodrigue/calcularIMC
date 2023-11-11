package Clases;

import java.util.ArrayList;
import java.util.Iterator;

public class Logica {
	
	double imc;
	
	ArrayList<PersonaVO>listaPersona;
	
	public Logica() {
		listaPersona=new ArrayList<>();
	}
	
	public String RegistarPersona(PersonaVO persona) {
		String resultado = "Persona Registrada con Exito! \n";
				resultado+="Documento: "+persona.getDocumento()+"\n";
				resultado+="Nombre: "+persona.getNombre()+"\n";
				resultado+="Edad: "+persona.getEdad()+"\n";
				resultado+="Peso: "+persona.getPeso()+"\n";
				resultado+="Talla: "+persona.getTalla()+"\n";
				
				String imcMsj=calcularIMC(persona.getTalla(),persona.getPeso());
				
				resultado+=""+imcMsj+"\n";
				persona.setImc(this.imc);
				
				listaPersona.add(persona);
				
		return resultado;
	}
	
	public String calcularIMC(double Talla, double Peso) {
		imc = Peso / (Talla * Talla);
		String msj ="";
		
		if (imc < 18 ) {
			msj = "Anorexia";
		}else {
			if (imc >= 18 && imc <20) {
				msj = "Delgadez";
			}else {
				if (imc >= 20 && imc < 27) {
					msj = "Normalidad";
				}else {
					if (imc >= 27 && imc < 30) {
						msj = "Obesidad Grado 1";
					}else {
						if (imc >= 30 && imc < 35) {
							msj = "Obesidad grado 2";
						}else {
							if (imc >= 35 && imc < 40) {
								msj = "Obesdidad grado morbida";
							}
						}
					}
				}
			}
		}
		
		return "IMC: "+imc+"\n Su IMC indica que tiene: "+msj;
		}

public String consultarListaPersona() {
	String resultado = "";
	PersonaVO p = null;
	for (int i = 0; i < listaPersona.size(); i++) {
		p=listaPersona.get(i);
		resultado+="Documento: "+p.getDocumento()+"\n";
		resultado+="Nombre: "+p.getNombre()+"\n";
		resultado+="Edad: "+p.getEdad()+"\n";
		resultado+="Peso: "+p.getPeso()+"\n";
		resultado+="Talla: "+p.getTalla()+"\n";
		resultado+="IMC: "+p.getImc()+"\n";
		resultado+="*********************\n";
		}
	return resultado;
	}
	
	public String consultarPromedio() {
		String resultado = "";
		double suma = 0;
		for (int i = 0; i < listaPersona.size(); i++) {
			suma = suma + listaPersona.get(i).getImc();
		}
		
		double promedio = suma / listaPersona.size();
		resultado = "El promedio de IMC es: "+ promedio;
		return resultado;
	}
	}