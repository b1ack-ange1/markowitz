package markowitz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Stock {
	public List<Double> getXix() {
		return xix;
	}

	public void setXix(List<Double> xix) {
		this.xix = xix;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	private String nombre;
	private List<Double>cierreTemporal;
	private List<Double>indiceDiario;
	private List<Double>xix;
	public List<Double> getIndiceDiario() {
		return indiceDiario;
	}

	public void setIndiceDiario(List<Double> indiceDiario) {
		this.indiceDiario = indiceDiario;
	}

	private double promedio = 0.0;
	//private Double desviacionEstandar=0.0;
	
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
					BigDecimal bd = BigDecimal.valueOf(Double.parseDouble(values[6]));
					bd = bd.setScale(5);
					cierreTemporal.add(bd.doubleValue());
				}
				br.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			for(int i=1;i<cierreTemporal.size();i++){
				BigDecimal bd1 = BigDecimal.valueOf(Math.log(cierreTemporal.get(i)/cierreTemporal.get(i-1)));
				bd1 = bd1.setScale(4, BigDecimal.ROUND_HALF_UP);
			//	System.out.println(hpr);
				indiceDiario.add(bd1.doubleValue());
			}
			for(Double d:indiceDiario){
				promedio+=d;
			}
			//promedio.divide(promedio, indiceDiario.size());
			promedio /= indiceDiario.size();
			//System.out.println("Promedio : " + promedio);
			
			xix = new ArrayList<Double>();
			
			for(Double d:indiceDiario){
				xix.add(d-promedio);
				//System.out.println(d-promedio);
			}
			
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
	
}
