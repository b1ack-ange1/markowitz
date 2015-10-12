package markowitz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Stock {
	private String nombre;
	private List<Double>cierreTemporal;
	private List<Double>indiceDiario;
	public List<Double> getIndiceDiario() {
		return indiceDiario;
	}

	public void setIndiceDiario(List<Double> indiceDiario) {
		this.indiceDiario = indiceDiario;
	}

	private Double promedio=0.0;
	private Double desviacionEstandar=0.0;
	
	public Stock(String nombre){
		//this.nombre = nombre;
		cierreTemporal = new ArrayList<Double>();
		indiceDiario = new ArrayList<Double>();
		File csv = new File(nombre);
		this.nombre = nombre.substring(7,nombre.length()-4);
		System.out.println(csv.getAbsolutePath());
		System.out.println(nombre);
		if(csv.exists()){
			try{
				String linea;
				BufferedReader br = new BufferedReader(new FileReader(csv));
				br.readLine();
				while((linea=br.readLine())!=null){
					String values[] = linea.split(",");
					cierreTemporal.add(Double.parseDouble(values[6]));
				}
				br.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			for(int i=1;i<cierreTemporal.size();i++){
				double hpr = Math.log(cierreTemporal.get(i)/cierreTemporal.get(i-1));
				System.out.println(hpr);
				indiceDiario.add(hpr);
			}
			for(Double d:indiceDiario){
				promedio+=d;
			}
			promedio/=indiceDiario.size();
		}
		else{
			System.out.println("Archivo de bolsa inexistente");
		}
	}

	public String getNombre() {
		return nombre.toUpperCase();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Double> getCierreTemporal() {
		return cierreTemporal;
	}

	public void setCierreTemporal(List<Double> cierreTemporal) {
		this.cierreTemporal = cierreTemporal;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

	public Double getDesviacionEstandar() {
		return desviacionEstandar;
	}

	public void setDesviacionEstandar(Double desviacionEstandar) {
		this.desviacionEstandar = desviacionEstandar;
	}
	
}
